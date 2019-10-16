/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/10/2019
 *  Description:    Post Data Access Object Interface for post-service micro-app.
 **************************************************************************************************/
package com.dechristofaro.postservice.dao;
import com.dechristofaro.postservice.model.Post;
import java.util.List;

public interface PostDao {
    Post addPost(Post post);
    Post getPost(int id);
    List<Post> getAllPost();
    List<Post> getPostByPosterName(String posterName);
    void updatePost(Post post);
    void deletePost(int id);
}
