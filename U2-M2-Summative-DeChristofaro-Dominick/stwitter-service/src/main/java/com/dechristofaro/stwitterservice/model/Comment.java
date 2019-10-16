package com.dechristofaro.stwitterservice.model;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Comment {
    // Properties
    private int commentId;

    @NotNull(message = "You must include the postID as an integer number.")
    private int postId;

    @NotNull(message = "The commentDate must not be null, it must be the present date.")
    @FutureOrPresent(message = "The commentDate must not be in the past, it must be the present date.")
    @PastOrPresent(message = "The commentDate must not be in the future, it must be the present date.")
    private LocalDate commentDate;

    @NotNull(message = "You must include the commenterName.")
    @Size(min = 1, max = 50, message = "The commenterName must be between 1 and 50 characters.")
    private String commenterName;

    @Size(message = "The commentContent cannot exceed 255 characters in length.")
    private String commentContent;

    // Constructors
    public Comment() {

    }

    public Comment(int postId, LocalDate commentDate, String commenterName, String commentContent) {
        this.postId = postId;
        this.commentDate = commentDate;
        this.commenterName = commenterName;
        this.commentContent = commentContent;
    }

    public Comment(int commentId, int postId, LocalDate commentDate, String commenterName, String commentContent) {
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
        Comment comment = (Comment) o;
        return commentId == comment.commentId &&
                postId == comment.postId &&
                commentDate.equals(comment.commentDate) &&
                commenterName.equals(comment.commenterName) &&
                Objects.equals(commentContent, comment.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, commentDate, commenterName, commentContent);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commentDate=" + commentDate +
                ", commenterName='" + commenterName + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
