package com.dechristofaro.stwitterservice.util.feign;
import com.dechristofaro.stwitterservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceFeignClient {
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    Comment addComment(@RequestBody @Valid Comment comment);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    Comment getComment(@PathVariable int id);

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    List<Comment> getAllComment();

    @RequestMapping(value = "/comment/post/{id}", method = RequestMethod.GET)
    List<Comment> getCommentByPostId(@PathVariable int id);

    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    void updateComment(@RequestBody @Valid Comment comment);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    void deleteComment(@PathVariable int id);
}
