package com.example.comment.model.comment;


import com.example.util.common.BaseReqVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by LX-RL on 2018/5/23.
 */
@Data
public class insertCommentReq extends BaseReqVo implements Serializable {
    @NotBlank(message="记录ID不能为空")
    private Long recordId;
    private Long fromUserId;
    @NotBlank(message="被评论人ID不能为空")
    private Long toUserId;
    @NotBlank(message="评论内容不能为空")
    private String commentDesc;
    @NotBlank(message="评论类型不能为空")
    private Integer commentType;
    private String id;
    @NotBlank(message="系统名称不能为空")
    private String commentSys;
    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentSys() {
        return commentSys;
    }

    public void setCommentSys(String commentSys) {
        this.commentSys = commentSys;
    }
}
