package com.example.comment.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.annotation.Api;
import com.example.comment.model.comment.delCommentReq;
import com.example.comment.model.comment.getAdminCommentListReq;
import com.example.comment.model.comment.getCommentListReq;
import com.example.comment.model.comment.insertCommentReq;
import com.example.comment.service.CommentService;
import com.example.util.common.CommonResp;
import com.example.util.common.FrameUtil;
import com.example.util.spring.SpringBeanUtil;
import com.lx.user.api.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/recomment")
public class commentController{
    private static final Logger LOGGER = LoggerFactory
            .getLogger(commentController.class);
    @Autowired
    private CommentService commentService;

    /**
     *
     * @param request
     * @param vo 新增评论
     * @return
     * @throws Exception
     */
    @Api
    @RequestMapping(value ={"/insertComment"}, method= RequestMethod.POST)
    @ResponseBody
    public CommonResp insertComment(HttpServletRequest request, insertCommentReq vo) throws Exception {
        Long userid = FrameUtil.getUserid(vo.getToken());
        SpringBeanUtil.getBean("tokenService");
        vo.setFromUserId(userid);
        return commentService.insertComment(vo);
    }

    /**
     *
     * @param request
     * @param vo ,获取评论列表
     * @return
     * @throws Exception
     */
    @Api
    @RequestMapping(value ={"/getCommentList"}, method= RequestMethod.POST)
    @ResponseBody
    public CommonResp getCommentList(HttpServletRequest request, getCommentListReq vo) throws Exception {

        return commentService.getCommentList(vo);
    }
    @Api
    @RequestMapping(value ={"/delComment"}, method= RequestMethod.POST)
    @ResponseBody
    public CommonResp delComment(HttpServletRequest request, delCommentReq vo) throws Exception {

        return commentService.delComment(vo);
    }

    /**
     *
     * @param request
     * @param vo ,后台管理获取评论列表
     * @return
     * @throws Exception
     */
    @Api
    @RequestMapping(value ={"/getAdminCommentList"}, method= RequestMethod.POST)
    @ResponseBody
    public CommonResp getAdminCommentList(HttpServletRequest request, getAdminCommentListReq vo) throws Exception {

        return commentService.getAdminCommentList(vo);
    }
}