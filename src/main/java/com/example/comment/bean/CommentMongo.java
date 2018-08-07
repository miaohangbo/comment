package com.example.comment.bean;






import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CommentMongo implements Serializable {

    private String _id;
    private Long recordId;

    private Long fromUserid;

    private Long toUserid;

    private String commentDesc;

    private Date createTime;

    private Date updateTime;

    private Integer commentType;

    private Integer commentStatus;

    private String parentId;

    private String commentSys;

    //用户头像，用户姓名-前台需要得参数
    private String  imgUrl;
    private String  nickName;
    private List<CommentMongo> CommentList;


    public List<CommentMongo> getCommentList() {
        return CommentList;
    }

    public void setCommentList(List<CommentMongo> CommentList) {
            CommentList = CommentList;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(Long fromUserid) {
        this.fromUserid = fromUserid;
    }

    public Long getToUserid() {
        return toUserid;
    }

    public void setToUserid(Long toUserid) {
        this.toUserid = toUserid;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc == null ? null : commentDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCommentSys() {
        return commentSys;
    }

    public void setCommentSys(String commentSys) {
        this.commentSys = commentSys;
    }
}