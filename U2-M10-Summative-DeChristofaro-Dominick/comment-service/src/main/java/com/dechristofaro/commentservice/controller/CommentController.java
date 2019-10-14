package com.dechristofaro.commentservice.controller;
import com.dechristofaro.commentservice.dao.CommentDao;
import com.dechristofaro.commentservice.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class CommentController {
    // Properties
    private CommentDao commentDao;

    // Constructors
    @Autowired
    public CommentController(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    // Methods
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment addComment(@RequestBody @Valid Comment comment) {
        return commentDao.addComment(comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Comment getComment(@PathVariable int id) {
        Comment comment = commentDao.getComment(id);

        if (comment != null) {
            return comment;
        } else {
            throw new IllegalArgumentException("There is no Comment with id: " + id);
        }
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getAllComment() {
        return commentDao.getAllComment();
    }

    @RequestMapping(value = "/comment/post/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> getCommentByPostId(@PathVariable int id) {
        return commentDao.getCommentByPostId(id);
    }

    // NEED TO FIX
    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateComment(@RequestBody @Valid Comment comment) {
        Comment commentFromDB = commentDao.getComment(comment.getCommentId());
        // NEEDS TO QUERY POST DB TO DETERMINE IF POSTID PASSED IS VALID

        if (commentFromDB != null) {
            commentDao.updateComment(comment);
        } else {
            throw new IllegalArgumentException("There is no Comment with id: " + comment.getCommentId());
        }
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteComment(@PathVariable int id) {
        Comment comment = commentDao.getComment(id);

        if (comment != null) {
            commentDao.deleteComment(id);
        } else {
            throw new IllegalArgumentException("There is no Comment with id: " + id);
        }
    }
}
