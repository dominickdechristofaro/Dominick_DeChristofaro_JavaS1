package com.dechristofaro.stwitterservice.servicelayer;

import com.dechristofaro.stwitterservice.model.Comment;
import com.dechristofaro.stwitterservice.model.Post;
import com.dechristofaro.stwitterservice.util.feign.CommentServiceFeignClient;
import com.dechristofaro.stwitterservice.util.feign.PostServiceFeignClient;
import com.dechristofaro.stwitterservice.viewmodel.PostViewModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;

public class StwitterServiceLayerTest {
    // Properties
    private StwitterServiceLayer stwitterServiceLayer;
    private PostServiceFeignClient postServiceFeignClient;
    private CommentServiceFeignClient commentServiceFeignClient;

    // SetUp()
    @Before
    public void setUp() throws Exception {
        setUpPostServiceFeignClientMock();
        setUpCommentServiceFeignClientMock();
    }

    // Tests
    @Test
    public void addPost() {
        // Create a PostViewModel object
        List<String> comments = new ArrayList<>();
        PostViewModel postViewModel = new PostViewModel("Post 1", LocalDate.now(), "Dominick", comments);
        postViewModel = stwitterServiceLayer.addPost(postViewModel);

        // Copy the PostViewModel object added to the database
        PostViewModel postViewModelCopy = stwitterServiceLayer.getPost(postViewModel.getPostId());

        // Test the addPost() method
        Mockito.verify(postServiceFeignClient, times(1)).getPost(postViewModel.getPostId());
        TestCase.assertEquals(postViewModel, postViewModelCopy);
    }

    @Test
    public void getPost() {
        // Create a PostViewModel object
        List<String> comments = new ArrayList<>();
        PostViewModel postViewModel = new PostViewModel("Post 1", LocalDate.now(), "Dominick", comments);
        postViewModel = stwitterServiceLayer.addPost(postViewModel);

        // Copy the PostViewModel object added to the database
        PostViewModel postViewModelCopy = stwitterServiceLayer.getPost(postViewModel.getPostId());

        // Test the addPost() method
        Mockito.verify(postServiceFeignClient, times(1)).getPost(postViewModel.getPostId());
        TestCase.assertEquals(postViewModel, postViewModelCopy);
    }

    @Test
    public void getPostByPosterName() {
    }

    // PostServiceFeignClient Mock Input/Responses
    private void setUpPostServiceFeignClientMock() {
        // Set up the PostServiceFeignClient Mock
        postServiceFeignClient = Mockito.mock(PostServiceFeignClient.class);

        // Post Input/Responses
        Post postInput1 = new Post(LocalDate.now(), "Dominick", "Post 1");
        Post postInput2 = new Post(LocalDate.now(), "Michael", "Post 2");
        Post postInput3 = new Post(LocalDate.now(), "Michael", "Post 3");
        Post postResponse1 = new Post(1, LocalDate.now(), "Dominick", "Post 1");
        Post postResponse2 = new Post(2, LocalDate.now(), "Michael", "Post 2");
        Post postResponse3 = new Post(3, LocalDate.now(), "Michael", "Post 3");

        // Post List By PosterNames
        List<Post> dominickPostList = new ArrayList<>();
        List<Post> michaelPostList = new ArrayList<>();
        dominickPostList.add(postResponse1);
        michaelPostList.add(postResponse2);
        michaelPostList.add(postResponse3);

        // Mocking addPost() Feign Client Method
        Mockito.doReturn(postResponse1).when(postServiceFeignClient).addPost(postInput1);
        Mockito.doReturn(postResponse2).when(postServiceFeignClient).addPost(postInput2);
        Mockito.doReturn(postResponse3).when(postServiceFeignClient).addPost(postInput3);

        // Mocking getPost() Feign Client Method
        Mockito.doReturn(postResponse1).when(postServiceFeignClient).getPost(1);
        Mockito.doReturn(postResponse2).when(postServiceFeignClient).getPost(2);
        Mockito.doReturn(postResponse3).when(postServiceFeignClient).getPost(3);

        // Mocking getPostByPosterName() Feign Client Method
        Mockito.doReturn(dominickPostList).when(postServiceFeignClient).getPostByPosterName("Dominick");
        Mockito.doReturn(michaelPostList).when(postServiceFeignClient).getPostByPosterName("Michael");
    }

    // CommentServiceFeignClient Mock Input/Responses
    private void setUpCommentServiceFeignClientMock() {
        // Set up the CommentServiceFeignClient Mock
        commentServiceFeignClient = Mockito.mock(CommentServiceFeignClient.class);

        // Comment Input/Responses
        Comment commentInput1 = new Comment(1, LocalDate.now(), "Dominick", "Comment 1");
        Comment commentInput2 = new Comment(2, LocalDate.now(), "Michael", "Comment 2");
        Comment commentInput3 = new Comment(2, LocalDate.now(), "Amanda", "Comment 3");
        Comment commentResponse1 = new Comment(1, 1, LocalDate.now(), "Dominick", "Comment 1");
        Comment commentResponse2 = new Comment(2, 2, LocalDate.now(), "Michael", "Comment 2");
        Comment commentResponse3 = new Comment(3, 2, LocalDate.now(), "Amanda", "Comment 3");

        // CommentsByPostId
        List<Comment> post1CommentList = new ArrayList<>();
        List<Comment> post2CommentList = new ArrayList<>();
        post1CommentList.add(commentResponse1);
        post2CommentList.add(commentResponse2);
        post2CommentList.add(commentResponse3);

        // Mocking addComment() Feign Client Method
        Mockito.doReturn(commentResponse1).when(commentServiceFeignClient).addComment(commentInput1);
        Mockito.doReturn(commentResponse2).when(commentServiceFeignClient).addComment(commentInput2);
        Mockito.doReturn(commentResponse3).when(commentServiceFeignClient).addComment(commentInput3);

        // Mocking getComment() Feign Client Method
        Mockito.doReturn(commentResponse1).when(commentServiceFeignClient).getComment(1);
        Mockito.doReturn(commentResponse2).when(commentServiceFeignClient).getComment(2);
        Mockito.doReturn(commentResponse3).when(commentServiceFeignClient).getComment(3);

        // Mocking getCommentByPostId() Feign Client Method
        Mockito.doReturn(post1CommentList).when(commentServiceFeignClient).getCommentByPostId(1);
        Mockito.doReturn(post2CommentList).when(commentServiceFeignClient).getCommentByPostId(2);
    }
}
