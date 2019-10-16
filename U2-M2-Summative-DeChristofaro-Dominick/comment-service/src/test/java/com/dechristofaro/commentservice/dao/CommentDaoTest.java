package com.dechristofaro.commentservice.dao;
import com.dechristofaro.commentservice.model.Comment;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {
    // Properties
    @Autowired
    private CommentDao commentDao;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the comment table in the database
        List<Comment> commentList = commentDao.getAllComment();
        commentList.forEach(comment -> commentDao.deleteComment(comment.getCommentId()));
    }

    // Tests
    @Test
    public void addComment() {
        // Create a new Comment and add it to the database
        Comment comment = new Comment(1, LocalDate.of(2019,10,11), "Dominick", "Comment Test");
        comment = commentDao.addComment(comment);

        // Create a copy of the newly added Comment
        Comment commentCopy = commentDao.getComment(comment.getCommentId());

        // Test addComment() method
        TestCase.assertEquals(comment, commentCopy);
    }

    @Test
    public void getComment() {
        // Create a new Comment and add it to the database
        Comment comment = new Comment(1, LocalDate.of(2019,10,11), "Dominick", "Comment Test");
        comment = commentDao.addComment(comment);

        // Create a copy of the newly added Comment
        Comment commentCopy = commentDao.getComment(comment.getCommentId());

        // Test getComment() method
        TestCase.assertEquals(comment, commentCopy);
    }

    @Test
    public void getAllComment() {
        // Create comment1 and add it to the database
        Comment comment1 = new Comment(1, LocalDate.of(2019,10,11), "Dominick", "Comment Test 1");
        comment1 = commentDao.addComment(comment1);

        // Create comment2 and add it to the database
        Comment comment2 = new Comment(1, LocalDate.of(2019,10,11), "Michael", "Comment Test 2");
        comment2 = commentDao.addComment(comment2);

        // Collect all Comment's in the database into a list
        List<Comment> commentList = commentDao.getAllComment();

        // Test getAllComment() method
        TestCase.assertEquals(2, commentList.size());
        TestCase.assertEquals(comment1, commentList.get(0));
        TestCase.assertEquals(comment2, commentList.get(1));
    }

    @Test
    public void getCommentByPostId() {
        // Create comment1 and add it to the database
        Comment comment1 = new Comment(1, LocalDate.of(2019,10,11), "Dominick", "Comment Test 1");
        comment1 = commentDao.addComment(comment1);

        // Create comment2 and add it to the database
        Comment comment2 = new Comment(2, LocalDate.of(2019,10,11), "Michael", "Comment Test 2");
        comment2 = commentDao.addComment(comment2);

        // Create comment3 and add it to the database
        Comment comment3 = new Comment(2, LocalDate.of(2019,10,11), "Amanda", "Comment Test 3");
        comment3 = commentDao.addComment(comment3);

        // Create commentListPostId1
        List<Comment> commentListPostId1 = commentDao.getCommentByPostId(1);

        // Create commentListPostId2
        List<Comment> commentListPostId2 = commentDao.getCommentByPostId(2);

        // Test getCommentByPostId() method
        TestCase.assertEquals(1, commentListPostId1.size());
        TestCase.assertEquals(comment1, commentListPostId1.get(0));
        TestCase.assertEquals(2, commentListPostId2.size());
        TestCase.assertEquals(comment2, commentListPostId2.get(0));
        TestCase.assertEquals(comment3, commentListPostId2.get(1));
    }

    @Test
    public void updateComment() {
        // Create a new Comment and add it to the database
        Comment comment = new Comment(1, LocalDate.of(2019,10,11), "Dominick", "Comment Test");
        comment = commentDao.addComment(comment);

        // Update the Comment in the database
        comment.setCommenterName("Michael");
        comment.setCommentContent("Updated Content");
        commentDao.updateComment(comment);

        // Make a copy of the Comment object
        Comment commentCopy = commentDao.getComment(comment.getCommentId());

        // Test updateComment() method
        TestCase.assertEquals(comment, commentCopy);
    }

    @Test
    public void deleteComment() {
        // Create a new Comment and add it to the database
        Comment comment = new Comment(1, LocalDate.of(2019,10,11), "Dominick", "Comment Test");
        comment = commentDao.addComment(comment);

        // Delete the Comment in the database
        commentDao.deleteComment(comment.getCommentId());

        // Test deleteComment() method
        Comment commentCopy = commentDao.getComment(comment.getCommentId());
        TestCase.assertNull(commentCopy);
    }
}
