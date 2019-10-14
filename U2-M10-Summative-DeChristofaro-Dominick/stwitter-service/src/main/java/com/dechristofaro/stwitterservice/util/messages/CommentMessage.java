package com.dechristofaro.stwitterservice.util.messages;

import java.time.LocalDate;
import java.util.Objects;

public class CommentMessage {
    // Properties
    private int commentId;
    private int postId;
    private LocalDate commentDate;
    private String commenterName;
    private String commentContent;

    // Constructors
    public CommentMessage() {

    }

    public CommentMessage(int commentId, int postId, LocalDate commentDate, String commenterName, String commentContent) {
        this.commentId = commentId;
        this.postId = postId;
        this.commentDate = commentDate;
        this.commenterName = commenterName;
        this.commentContent = commentContent;
    }

    // Getters
    public int getCommentId() {
        return this.commentId;
    }

    public int getPostId() {
        return this.postId;
    }

    public LocalDate getCommentDate() {
        return this.commentDate;
    }

    public String getCommenterName() {
        return this.commenterName;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    // Setters
    public void setCommentId(int commentIdIn) {
        this.commentId = commentIdIn;
    }

    public void setPostId(int postIdIn) {
        this.postId = postIdIn;
    }

    public void setCommentDate(LocalDate commentDateIn) {
        this.commentDate = commentDateIn;
    }

    public void setCommenterName(String commenterNameIn) {
        this.commenterName = commenterNameIn;
    }

    public void setCommentContent(String commentContentIn) {
        this.commentContent = commentContentIn;
    }

    // equals(), hashCode(), toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentMessage that = (CommentMessage) o;
        return commentId == that.commentId &&
                postId == that.postId &&
                commentDate.equals(that.commentDate) &&
                commenterName.equals(that.commenterName) &&
                Objects.equals(commentContent, that.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, commentDate, commenterName, commentContent);
    }

    @Override
    public String toString() {
        return "CommentMessage{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commentDate=" + commentDate +
                ", commenterName='" + commenterName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
