package com.dechristofaro.stwitterservice.servicelayer;
import com.dechristofaro.stwitterservice.model.Comment;
import com.dechristofaro.stwitterservice.model.Post;
import com.dechristofaro.stwitterservice.util.feign.CommentServiceFeignClient;
import com.dechristofaro.stwitterservice.util.feign.PostServiceFeignClient;
import com.dechristofaro.stwitterservice.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class StwitterServiceLayer {
    // Properties
    private CommentServiceFeignClient commentServiceFeignClient;
    private PostServiceFeignClient postServiceFeignClient;

    // Constructors
    @Autowired
    public StwitterServiceLayer(CommentServiceFeignClient commentServiceFeignClient, PostServiceFeignClient postServiceFeignClient) {
        this.commentServiceFeignClient = commentServiceFeignClient;
        this.postServiceFeignClient = postServiceFeignClient;
    }

    // Methods
    @Transactional
    public PostViewModel addPost(PostViewModel postViewModel) {
        // Build Post Object from the postViewModel
        Post post = new Post(LocalDate.now(), postViewModel.getPosterName(), postViewModel.getContent());

        // Send the Post object through the postFeignClient
        post = postServiceFeignClient.addPost(post);

        // Set the Id for the postViewModel
        postViewModel.setPostId(post.getPostId());

        // Return the PostViewModel
        return postViewModel;
    }

    public PostViewModel getPost(int postId) {
        // Get the Post content from post-service
        Post post = postServiceFeignClient.getPost(postId);

        // Get the Comments from the comment-service
        List<Comment> commentList = commentServiceFeignClient.getCommentByPostId(postId);

        // Build a List of Comments from the comments
        List<String> comments = new ArrayList<>();
        commentList.forEach(comment -> comments.add(comment.getCommentContent()));

        // Build the postViewModel
        PostViewModel postViewModel = new PostViewModel(post.getPostId(), post.getContent(), post.getPostDate(), post.getPosterName(), comments);
        return postViewModel;
    }

    public List<PostViewModel> getPostByPosterName(String posterName) {
        // Create a List of PostViewModel
        List<PostViewModel> postViewModelList = new ArrayList<>();

        // Get the List of posts by the PosterName
        List<Post> postList = postServiceFeignClient.getPostByPosterName(posterName);

        // Build the postViewModelList
        postList.forEach(post -> {
            PostViewModel postViewModel = new PostViewModel();
            postViewModel.setPostId(post.getPostId());
            postViewModel.setPostDate(post.getPostDate());
            postViewModel.setPosterName(post.getPosterName());
            postViewModel.setContent(post.getContent());
            List<String> comments = new ArrayList<>();
            List<Comment> commentList = commentServiceFeignClient.getCommentByPostId(post.getPostId());
            commentList.forEach(comment -> comments.add(comment.getCommentContent()));
            postViewModel.setComments(comments);
            postViewModelList.add(postViewModel);
        });

        // Return the postViewModelList
        return postViewModelList;
    }

}
