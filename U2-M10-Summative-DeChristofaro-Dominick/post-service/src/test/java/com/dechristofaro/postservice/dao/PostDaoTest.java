package com.dechristofaro.postservice.dao;
import com.dechristofaro.postservice.model.Post;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoTest {
    // Properties
    @Autowired
    private PostDao postDao;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the post table in the database
        List<Post> postList = postDao.getAllPost();
        postList.forEach(post -> postDao.deletePost(post.getPostId()));
    }

    // Tests
    @Test
    public void addPost() {
        // Create a new Post and add it to the database
        Post post = new Post(LocalDate.now(), "Dominick", "Test Post");
        post = postDao.addPost(post);

        // Create a copy of the newly added Post
        Post postCopy = postDao.getPost(post.getPostId());

        // Test addPost() method
        TestCase.assertEquals(post, postCopy);
    }

    @Test
    public void getPost() {
        // Create a new Post and add it to the database
        Post post = new Post(LocalDate.now(), "Dominick", "Test Post");
        post = postDao.addPost(post);

        // Create a copy of the newly added Post
        Post postCopy = postDao.getPost(post.getPostId());

        // Test getPost() method
        TestCase.assertEquals(post, postCopy);
    }

    @Test
    public void getAllPost() {
        // Create post1 and add it to the database
        Post post1 = new Post(LocalDate.now(), "Dominick", "Test Post 1");
        post1 = postDao.addPost(post1);

        // Create post2 and add it to the database
        Post post2 = new Post(LocalDate.now(), "Michael", "Test Post 2");
        post2 = postDao.addPost(post2);

        // Collect all Post's in the database into a list
        List<Post> postList = postDao.getAllPost();

        // Test getAllPost() method
        TestCase.assertEquals(2, postList.size());
        TestCase.assertEquals(post1, postList.get(0));
        TestCase.assertEquals(post2, postList.get(1));
    }

    @Test
    public void getPostByPosterName() {
        // Create post1 and add it to the database
        Post post1 = new Post(LocalDate.now(), "Dominick", "Test Post 1");
        post1 = postDao.addPost(post1);

        // Create post2 and add it to the database
        Post post2 = new Post(LocalDate.now(), "Michael", "Test Post 2");
        post2 = postDao.addPost(post2);

        // Create post3 and add it to the database
        Post post3 = new Post(LocalDate.now(), "Michael", "Test Post 3");
        post3 = postDao.addPost(post3);

        // Collect all Post's in the database from "Dominick" and "Michael" into 2 List's
        List<Post> dominickPostList = postDao.getPostByPosterName("Dominick");
        List<Post> michaelPostList = postDao.getPostByPosterName("Michael");

        // Test getPostByPosterName() method
        TestCase.assertEquals(1, dominickPostList.size());
        TestCase.assertEquals(2, michaelPostList.size());
        TestCase.assertEquals(post1, dominickPostList.get(0));
        TestCase.assertEquals(post2, michaelPostList.get(0));
        TestCase.assertEquals(post3, michaelPostList.get(1));
    }

    @Test
    public void updatePost() {
        // Create a new Post and add it to the database
        Post post = new Post(LocalDate.now(), "Dominick", "Test Post");
        post = postDao.addPost(post);

        // Update the Post in the database
        post.setPosterName("Michael");
        post.setContent("Updated Content");
        postDao.updatePost(post);

        // Make a copy of the Post object
        Post postCopy = postDao.getPost(post.getPostId());

        // Test updatePost() method
        TestCase.assertEquals(post, postCopy);
    }

    @Test
    public void deletePost() {
        // Create a new Post and add it to the database
        Post post = new Post(LocalDate.now(), "Dominick", "Test Post");
        post = postDao.addPost(post);

        // Delete the Post in the database
        postDao.deletePost(post.getPostId());

        // Test deletePost() method
        Post postCopy = postDao.getPost(post.getPostId());
        TestCase.assertNull(postCopy);
    }
}
