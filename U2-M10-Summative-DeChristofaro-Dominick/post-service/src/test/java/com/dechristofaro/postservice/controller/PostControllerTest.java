package com.dechristofaro.postservice.controller;
import com.dechristofaro.postservice.dao.PostDao;
import com.dechristofaro.postservice.model.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class PostControllerTest {
    // Properties
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostDao postDao;

    private ObjectMapper mapper = new ObjectMapper();

    // Tests
    @Test
    public void addPostShouldReturnCreatedPost() throws Exception {
        // Create an inputPost object
        Post inputPost = new Post(LocalDate.now(), "Dominick", "Test Content");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Create a responsePost object
        Post responsePost = new Post(1, LocalDate.now(), "Dominick", "Test Content");
        String responseJson = mapper.writeValueAsString(responsePost);

        // Mock the postDao
        Mockito.when(postDao.addPost(inputPost)).thenReturn(responsePost);

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addPostMissingPostDateShouldReturn422() throws Exception {
        // Build a Post without the postDate property
        Post inputPost = new Post();
        inputPost.setPosterName("Dominick");
        inputPost.setContent("Test Post");

        // Convert Input to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputPost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addPostPostDateInPastShouldReturn422() throws Exception {
        // Build a Post without the postDate property
        Post inputPost = new Post(LocalDate.of(2018,10,10), "Dominick", "Test Content");

        // Convert Input to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputPost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addPostPostDateInFutureShouldReturn422() throws Exception {
        // Build a Post without the postDate property
        Post inputPost = new Post(LocalDate.of(2099,10,12), "Dominick", "Test Content");

        // Convert Input to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputPost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addPostMissingPosterNameShouldReturn422() throws Exception {
        // Build a Post without the postDate property
        Post inputPost = new Post();
        inputPost.setPostDate(LocalDate.now());
        inputPost.setContent("Test Post");

        // Convert Input to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputPost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addPostPosterNameSizeEquals0ShouldReturn422() throws Exception {
        // Build a Post without the postDate property
        Post inputPost = new Post(LocalDate.now(), "", "Test Content");

        // Convert Input to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputPost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addPostPosterNameSizeEquals51ShouldReturn422() throws Exception {
        // Build a Post without the postDate property
        Post inputPost = new Post(LocalDate.now(), "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "Test Content");

        // Convert Input to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputPost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addPostPosterNameSizeEquals1ShouldReturnCreatedPost() throws Exception {
        // Build a inputPost with poserName size = 1
        Post inputPost = new Post(LocalDate.now(), "D", "Test Content");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Build a responsePost
        Post responsePost = new Post(1, LocalDate.now(), "D", "Test Content");
        String responseJson = mapper.writeValueAsString(responsePost);

        // Mock the postDao
        Mockito.when(postDao.addPost(inputPost)).thenReturn(responsePost);

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addPostPosterNameSizeEquals50ShouldReturnCreatedPost() throws Exception {
        // Build an inputPost with a posterName size = 50
        Post inputPost = new Post(LocalDate.now(), "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "Test Content");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Build a responsePost
        Post responsePost = new Post(1, LocalDate.now(), "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "Test Content");
        String responseJson = mapper.writeValueAsString(responsePost);

        // Mock the postDao
        Mockito.when(postDao.addPost(inputPost)).thenReturn(responsePost);

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addPostContentSize255ShouldReturnCreatedPost() throws Exception {
        // Build an inputPost with content size = 255
        Post inputPost = new Post(LocalDate.now(), "Dominick", "XXXXXXXXjerpgonsdrpogknaproginapodrgnpaorngpoadngadjrngpiarjngpiangpairgnaidrgpaiorngapierbgapirgbaoerigubaprigjnarglkjahsdgpijabnrpginadifgjhaberpijgbadoirgnapdrijbglakerjbgoiserngoieruypbgearoiughaprgnpiserubgpiwerubgepadgoihdfgpiohadrpoighapdirgpargddd");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Build a responsePost
        Post responsePost = new Post(1, LocalDate.now(), "Dominick", "XXXXXXXXjerpgonsdrpogknaproginapodrgnpaorngpoadngadjrngpiarjngpiangpairgnaidrgpaiorngapierbgapirgbaoerigubaprigjnarglkjahsdgpijabnrpginadifgjhaberpijgbadoirgnapdrijbglakerjbgoiserngoieruypbgearoiughaprgnpiserubgpiwerubgepadgoihdfgpiohadrpoighapdirgpargddd");
        String responseJson = mapper.writeValueAsString(responsePost);

        // Mock the postDao
        Mockito.when(postDao.addPost(inputPost)).thenReturn(responsePost);

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addPostContentSize256ShouldReturn422() throws Exception {
        // Build a Post with content size = 256
        Post inputPost = new Post(LocalDate.now(), "Dominick", "XXXXXXXXjerpgonsdrpogknaproginapodrgnpaorngpoadngadjrngpiarjngpiangpairgnaidrgpaiorngapierbgapirgbaoerigubaprigjnarglkjahsdgpijabnrpginadifgjhaberpijgbadoirgnapdrijbglakerjbgoiserngoieruypbgearoiughaprgnpiserubgpiwerubgepadgoihdfgpiohadrpoighapdirgpargddds");

        // Convert Input to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputPost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void getPostShouldReturnPostById() throws Exception {
        // Build a responsePost
        Post responsePost = new Post(1, LocalDate.now(), "Dominick", "Test Content");
        String responseJson = mapper.writeValueAsString(responsePost);

        // Mock the postDao
        Mockito.when(postDao.getPost(1)).thenReturn(responsePost);

        // Mock the MVC
        this.mockMvc.perform(get("/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void getPostWithInvalidIdShouldReturn404() throws Exception {
        // Mock the MVC
        this.mockMvc.perform(get("/post/1/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllPostShouldReturnPostList() throws Exception {
        // Build Posts
        Post post1 = new Post(1, LocalDate.now(), "Dominick", "Test Content 1");
        Post post2 = new Post(2, LocalDate.now(), "Michael", "Test Content 2");

        // Add Posts to a list
        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);

        // Convert the postList to a JSON String
        String responseJson;
        try {
            responseJson = mapper.writeValueAsString(postList);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the postDao
        Mockito.when(postDao.getAllPost()).thenReturn(postList);

        // Mock the MVC
        this.mockMvc.perform(get("/post"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void getPostByPosterNameShouldReturnPostList() throws Exception {
        // Build Posts
        Post post1 = new Post(1, LocalDate.now(), "Dominick", "Test Content 1");
        Post post2 = new Post(2, LocalDate.now(), "Michael", "Test Content 2");
        Post post3 = new Post(3, LocalDate.now(), "Michael", "Test Content 3");

        // Make 2 Lists (dominickPostList & michaelPostList)
        List<Post> dominickPostList = new ArrayList<>();
        List<Post> michaelPostList = new ArrayList<>();
        dominickPostList.add(post1);
        michaelPostList.add(post2);
        michaelPostList.add(post3);

        // Convert dominickPostList and michaelPostList to JSON Strings
        String dominickResponseJson;
        String michaelResponseJson;

        try {
            dominickResponseJson = mapper.writeValueAsString(dominickPostList);
            michaelResponseJson = mapper.writeValueAsString(michaelPostList);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the postDao
        Mockito.when(postDao.getPostByPosterName("Dominick")).thenReturn(dominickPostList);
        Mockito.when(postDao.getPostByPosterName("Michael")).thenReturn(michaelPostList);

        // Mock the MVC
        this.mockMvc.perform(get("/post/poster/Dominick"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(dominickResponseJson));

        this.mockMvc.perform(get("/post/poster/Michael"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(michaelResponseJson));
    }

    @Test
    public void updatePostShouldReturnVoid() throws Exception {
        // Create an inputPost object
        Post inputPost = new Post(1, LocalDate.now(), "Dominick", "Test Content");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Mock the postDao
        Mockito.when(postDao.getPost(1)).thenReturn(inputPost);

        // MVC Mock
        this.mockMvc.perform(put("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updatePostMissingPostIdShouldReturn404() throws Exception {
        // Build an update Post without the postDate property
        Post updatePost = new Post();
        updatePost.setPostDate(LocalDate.now());
        updatePost.setPosterName("Updated Name");
        updatePost.setContent("Updated Content");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updatePost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void updatePostMissingCreateDateShouldReturn422() throws Exception {
        // Build an update Post without the postDate property
        Post updatePost = new Post();
        updatePost.setPostId(1);
        updatePost.setPosterName("Updated Name");
        updatePost.setContent("Updated Content");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updatePost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updatePostCreateDateInFutureShouldReturn422() throws Exception {
        // Build an update Post without the postDate property
        Post updatePost = new Post();
        updatePost.setPostId(1);
        updatePost.setPostDate(LocalDate.of(2099, 10, 10));
        updatePost.setPosterName("Updated Name");
        updatePost.setContent("Updated Content");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updatePost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updatePostCreateDateInPastShouldReturn422() throws Exception {
        // Build an update Post without the postDate property
        Post updatePost = new Post();
        updatePost.setPostId(1);
        updatePost.setPostDate(LocalDate.of(2000,10,10));
        updatePost.setPosterName("Updated Name");
        updatePost.setContent("Updated Content");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updatePost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updatePostPosterNameSize0ShouldReturn422() throws Exception {
        // Build an update Post without the postDate property
        Post updatePost = new Post();
        updatePost.setPostId(1);
        updatePost.setPostDate(LocalDate.now());
        updatePost.setPosterName("");
        updatePost.setContent("Updated Content");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updatePost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updatePostPosterNameSize51ShouldReturn422() throws Exception {
        // Build an update Post without the postDate property
        Post updatePost = new Post();
        updatePost.setPostId(1);
        updatePost.setPostDate(LocalDate.now());
        updatePost.setPosterName("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        updatePost.setContent("Updated Content");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updatePost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updatePostPosterNameSize1ShouldReturnVoid() throws Exception {
        // Create an inputPost object
        Post inputPost = new Post(1, LocalDate.now(), "D", "Test Content");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Mock the postDao
        Mockito.when(postDao.getPost(1)).thenReturn(inputPost);

        // MVC Mock
        this.mockMvc.perform(put("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updatePostPosterNameSize50ShouldReturnVoid() throws Exception {
        // Create an inputPost object
        Post inputPost = new Post(1, LocalDate.now(), "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "Test Content");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Mock the postDao
        Mockito.when(postDao.getPost(1)).thenReturn(inputPost);

        // MVC Mock
        this.mockMvc.perform(put("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updatePostContentSize255ShouldReturnVoid() throws Exception {
        // Create an inputPost object
        Post inputPost = new Post(1, LocalDate.now(), "Dominick", "XXXXXXXXjerpgonsdrpogknaproginapodrgnpaorngpoadngadjrngpiarjngpiangpairgnaidrgpaiorngapierbgapirgbaoerigubaprigjnarglkjahsdgpijabnrpginadifgjhaberpijgbadoirgnapdrijbglakerjbgoiserngoieruypbgearoiughaprgnpiserubgpiwerubgepadgoihdfgpiohadrpoighapdirgpargddd");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Mock the postDao
        Mockito.when(postDao.getPost(1)).thenReturn(inputPost);

        // MVC Mock
        this.mockMvc.perform(put("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updatePostContentSize256ShouldReturn422() throws Exception {
        // Build an update Post without the postDate property
        Post updatePost = new Post();
        updatePost.setPostId(1);
        updatePost.setPostDate(LocalDate.now());
        updatePost.setPosterName("Updated Name");
        updatePost.setContent("XXXXXXXXjerpgonsdrpogknaproginapodrgnpaorngpoadngadjrngpiarjngpiangpairgnaidrgpaiorngapierbgapirgbaoerigubaprigjnarglkjahsdgpijabnrpginadifgjhaberpijgbadoirgnapdrijbglakerjbgoiserngoieruypbgearoiughaprgnpiserubgpiwerubgepadgoihdfgpiohadrpoighapdirgpargddds");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updatePost);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    public void updatePostWithInvalidIdShouldReturn404() throws Exception {
        // Create an inputPost object
        Post inputPost = new Post(1, LocalDate.now(), "Dominick", "Test Content");
        String inputJson = mapper.writeValueAsString(inputPost);

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deletePostShouldReturnVoid() throws Exception {
        // Create an inputPost object
        Post inputPost = new Post(1, LocalDate.now(), "Dominick", "Test Content");

        // Mock the postDao
        Mockito.when(postDao.getPost(1)).thenReturn(inputPost);

        // Mock the MVC
        this.mockMvc.perform(delete("/post/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deletePostWithInvalidIdShouldReturn404() throws Exception {
        // Mock the MVC
        this.mockMvc.perform(delete("/post/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
