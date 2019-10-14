package com.dechristofaro.postservice.controller;
import com.dechristofaro.postservice.dao.PostDao;
import com.dechristofaro.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class PostController {
    // Properties
    private PostDao postDao;

    // Constructors
    @Autowired
    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    // Methods
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post addPost(@RequestBody @Valid Post post) {
        return postDao.addPost(post);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        Post post = postDao.getPost(id);

        if (post != null) {
            return post;
        } else {
            throw new IllegalArgumentException("There is no Post with id: " + id);
        }
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getAllPost() {
        return postDao.getAllPost();
    }

    @RequestMapping(value = "/post/poster/{posterName}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getPostByPosterName(@PathVariable String posterName) {
        return postDao.getPostByPosterName(posterName);
    }

    @RequestMapping(value = "/post", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePost(@RequestBody @Valid Post post) {
        Post postFromDB = postDao.getPost(post.getPostId());

        if (postFromDB != null) {
            postDao.updatePost(post);
        } else {
            throw new IllegalArgumentException("There is no Post with id: " + post.getPostId());
        }
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteConsole(@PathVariable int id) {
        Post post = postDao.getPost(id);

        if (post != null) {
            postDao.deletePost(id);
        } else {
            throw new IllegalArgumentException("There is no Post with id: " + id);
        }
    }
}
