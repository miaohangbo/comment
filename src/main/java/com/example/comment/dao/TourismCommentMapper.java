package com.example.comment.dao;



import com.example.comment.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface TourismCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> getListByTourismId(Map<String, Object> map);

    List<Comment> getListByParentId(Map<String, Object> map);

    List<Comment> getListByTourismIdAll(Map<String, Object> map);

    Long  getListCountByTourismId(Map<String, Object> map);
}