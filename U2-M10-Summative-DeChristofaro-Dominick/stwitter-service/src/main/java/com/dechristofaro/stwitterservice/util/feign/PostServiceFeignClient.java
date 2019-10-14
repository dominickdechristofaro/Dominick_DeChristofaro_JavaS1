package com.dechristofaro.stwitterservice.util.feign;
import com.dechristofaro.stwitterservice.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceFeignClient {
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    Post addPost(@RequestBody @Valid Post post);

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    Post getPost(@PathVariable int id);

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    List<Post> getAllPost();

    @RequestMapping(value = "/post/poster/{posterName}", method = RequestMethod.GET)
    List<Post> getPostByPosterName(@PathVariable String posterName);

    @RequestMapping(value = "/post", method = RequestMethod.PUT)
    void updatePost(@RequestBody @Valid Post post);

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    void deletePost(@PathVariable int id);
}
