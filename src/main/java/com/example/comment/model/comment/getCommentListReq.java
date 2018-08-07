package com.example.comment.model.comment;


import com.example.util.common.BaseReqVo;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by LX-RL on 2018/5/24.
 */
public class getCommentListReq extends BaseReqVo implements Serializable {
    @NotBlank(message="记录ID不能为空")
    private Long recourdId;
    @NotBlank(message="系统名称不能为空")
    private String commentSys;
    public Long getRecourdId() {
        return recourdId;
    }

    public void setRecourdId(Long recourdId) {
        this.recourdId = recourdId;
    }

    public String getCommentSys() {
        return commentSys;
    }

    public void setCommentSys(String commentSys) {
        this.commentSys = commentSys;
    }
}
