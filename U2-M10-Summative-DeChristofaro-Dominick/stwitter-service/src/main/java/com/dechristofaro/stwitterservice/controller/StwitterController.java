package com.dechristofaro.stwitterservice.controller;
import com.dechristofaro.stwitterservice.servicelayer.StwitterServiceLayer;
import com.dechristofaro.stwitterservice.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class StwitterController {
    // Properties
    private StwitterServiceLayer stwitterServiceLayer;

    // Constructors
    @Autowired
    public StwitterController(StwitterServiceLayer stwitterServiceLayer) {
        this.stwitterServiceLayer = stwitterServiceLayer;
    }

    // Methods
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewModel addPost(@RequestBody @Valid PostViewModel postViewModel) {
        return stwitterServiceLayer.addPost(postViewModel);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPost(@PathVariable int id) {
        return stwitterServiceLayer.getPost(id);
    }

    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostByPosterName(@PathVariable String poster_name) {
        return stwitterServiceLayer.getPostByPosterName(poster_name);
    }
}
