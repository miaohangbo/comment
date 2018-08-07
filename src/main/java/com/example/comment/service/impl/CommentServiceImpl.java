package com.example.comment.service.impl;

import com.example.comment.bean.CommentMongo;
import com.example.comment.dao.TourismCommentMapper;
import com.example.comment.model.comment.delCommentReq;
import com.example.comment.model.comment.getAdminCommentListReq;
import com.example.comment.model.comment.getCommentListReq;
import com.example.comment.model.comment.insertCommentReq;
import com.example.comment.service.CommentService;
import com.example.util.common.CommonResp;
import com.example.util.common.Pager;
import com.example.util.sensitive.WordFilter;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author mhb
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/89:53
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private TourismCommentMapper tourismCommentMapper;

    private String recordId = "recordId";
    private String parentId = "parentId";
    private String _id = "_id";
    private String commentStatus = "commentStatus";
    private String toUserid = "toUserid";
    private String createTime ="createTime";
   // private String commentSys = "commentSys";
    private int BATCH_READ_NUMBER = 300;

    public CommonResp insertComment(insertCommentReq vo) throws Exception {

        Integer commentType =  vo.getCommentType();

        CommentMongo comment = new CommentMongo();

        if(commentType==1){
            if (vo.getId()==null){
                return CommonResp.getErrorInstance("记录Id不能为空");
            }
            comment.setParentId(vo.getId());
        }else {
            comment.setParentId("-1");
        }


        boolean contains = WordFilter.isContains(vo.getCommentDesc());
        if(contains){
          return  CommonResp.getErrorInstance("评论包含敏感词汇");
        }
        comment.setCommentDesc(vo.getCommentDesc());
        comment.setCommentStatus(0);
        comment.setCreateTime(new Date());
        comment.setFromUserid(vo.getFromUserId());
        comment.setRecordId(vo.getRecordId());
        comment.setToUserid(vo.getToUserId());
        comment.setCommentType(commentType);
        comment.setCommentStatus(1);
        //tourismComment.setCommentSys(vo.getCommentSys());
        mongoTemplate.save(comment,vo.getCommentSys());
       // Integer result =  tourismCommentMapper.insert(tourismComment);
       /* if(result>0){
            return CommonResp.getInstance("1","成功");
        }*/
        return CommonResp.getInstance("1","成功");
    }

    @Override
    public CommonResp getCommentList(getCommentListReq vo) throws Exception {

        Pager pager = vo.getPager();
        Map<String, Object> map = new HashMap<String, Object>();
       Integer startRow= pager.getStartRow();
       Integer pageSize= pager.getPagesize();
        Long recourdId = vo.getRecourdId();
        String commentSys = vo.getCommentSys();
        map.put("recordId",recourdId);
        //mongodb  对文章评论查询
        Criteria criteria = Criteria.where(recordId).is(recourdId)
                .and(parentId).is("-1");
        Query query = new Query();
       query.addCriteria(criteria)
               // .with(Sort.by(new Order(Direction.DESC, createTime)))
                .limit(pageSize + 1)
                .skip(startRow);

        List<CommentMongo> list = mongoTemplate.find(query,CommentMongo.class,commentSys);
       if (list.size()>pageSize){
           pager.setTotalRows(startRow + pageSize + 1);
       }else {
           pager.setTotalRows(0);
       }
        //mongodb 的子平论
        Criteria criteriaSon = Criteria.where(recordId).is(recourdId)
                .and(parentId).ne(-1);
        Query querySon = new Query();
        querySon.addCriteria(criteriaSon);
               // .with(Sort.by(new Order(Direction.DESC, createTime)));

        List<CommentMongo> listSon = mongoTemplate.find(querySon,CommentMongo.class,commentSys);
        List<CommentMongo> returnDate = new ArrayList<CommentMongo>();
        for (CommentMongo commen:list){
            List<CommentMongo> tourismSubreviewDetail = new ArrayList<CommentMongo>();
            for (CommentMongo commenSon:listSon){
              //  List<TourismCommentMongo> tourismSubreviewDetailSon = new ArrayList<TourismCommentMongo>();
                if(commenSon.getParentId().equals(commen.get_id())){
                    List<CommentMongo> tourismCommentMongo = recursionChildren(commenSon, listSon);
                    //tourismSubreviewDetailSon.add(tourismCommentMongo);
                    commenSon.setCommentList(tourismCommentMongo);
                    tourismSubreviewDetail.add(commenSon);
                }
            }

            commen.setCommentList(tourismSubreviewDetail);
            returnDate.add(commen);
        }
        if(!CollectionUtils.isEmpty(returnDate)){
            return CommonResp.getInstance("1","成功",returnDate,pager);
        }
        return CommonResp.getInstance("-1","成功");
    }

    /**
     * 删除评论
     * @param vo
     * @return
     */
    public CommonResp delComment(delCommentReq vo) {

        //Criteria criteria = Criteria.where(_id).is(vo.getCommentId());
        Query query = Query.query(Criteria.where(_id).is(vo.getCommentId()));
        mongoTemplate.remove(query,CommentMongo.class,vo.getCommentSys());
        return  CommonResp.getInstance("1","成功");
    }

    @Override
    public CommonResp getAdminCommentList(getAdminCommentListReq vo) throws Exception {

        Pager pager = vo.getPager();
        Map<String, Object> map = new HashMap<String, Object>();
        Integer startRow= pager.getStartRow();
        Integer pageSize= pager.getPagesize();
        String commentSys = vo.getCommentSys();
       // map.put("recordId",recourdId);
        //mongodb  对文章评论查询
        Criteria criteria = Criteria.where(commentStatus).is(1);
        Query query = new Query();
        query.addCriteria(criteria)
                // .with(Sort.by(new Order(Direction.DESC, createTime)))
                .limit(pageSize + 1)
                .skip(startRow);

        List<CommentMongo> list = mongoTemplate.find(query,CommentMongo.class,commentSys);
        if (list.size()>pageSize){
            pager.setTotalRows(startRow + pageSize + 1);
        }else {
            pager.setTotalRows(0);
        }
        return CommonResp.getInstance("1","成功",list,pager);
    }

    public static  List<CommentMongo> recursionChildren(CommentMongo commonMongo, List<CommentMongo> list){
        /*如果一个节点的父id等于参数节点的id，则把这个节点写入参数节点的子节点list*/
        List<CommentMongo> children = new ArrayList<CommentMongo>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getParentId().equals(commonMongo.get_id())) {
                children.add(list.get(i));
                commonMongo.setCommentList(children);
            }
        }
        return children;
    }


}
