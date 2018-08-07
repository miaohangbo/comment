package com.example.comment.model.comment;

import com.example.util.common.BaseReqVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author mhb
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/1814:22
 */
@Data
public class delCommentReq extends BaseReqVo implements Serializable {
    private String commentId;
    @NotBlank(message="评论系统不能为空")
    private String commentSys;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentSys() {
        return commentSys;
    }

    public void setCommentSys(String commentSys) {
        this.commentSys = commentSys;
    }
}
