package com.dechristofaro.commentservice.dao;
import com.dechristofaro.commentservice.model.Comment;
import java.util.List;

public interface CommentDao {
    Comment addComment(Comment comment);
    Comment getComment(int id);
    List<Comment> getAllComment();
    List<Comment> getCommentByPostId(int postId);
    void updateComment(Comment comment);
    void deleteComment(int id);
}
