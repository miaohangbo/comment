package com.example.comment.service;

import com.example.comment.bean.Comment;
import com.example.comment.model.comment.delCommentReq;
import com.example.comment.model.comment.getAdminCommentListReq;
import com.example.comment.model.comment.getCommentListReq;
import com.example.comment.model.comment.insertCommentReq;
import com.example.util.common.CommonResp;

import java.util.List;

/**
 * @author mhb
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/89:56
 */
public interface CommentService {
    public CommonResp insertComment(insertCommentReq vo) throws Exception;

    public CommonResp getCommentList(getCommentListReq vo)throws Exception;

    CommonResp delComment(delCommentReq vo);

    public CommonResp getAdminCommentList(getAdminCommentListReq vo)throws Exception;
}
