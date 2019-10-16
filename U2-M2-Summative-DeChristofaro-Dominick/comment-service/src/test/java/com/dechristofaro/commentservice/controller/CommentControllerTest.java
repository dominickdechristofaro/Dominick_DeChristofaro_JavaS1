package com.dechristofaro.commentservice.controller;
import com.dechristofaro.commentservice.dao.CommentDao;
import com.dechristofaro.commentservice.model.Comment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.pool.TypePool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
@WebMvcTest(CommentController.class)
public class CommentControllerTest {
    // Properties
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentDao commentDao;

    private ObjectMapper mapper = new ObjectMapper();

    // Tests
    @Test
    public void addCommentShouldReturnCreatedComment() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1, LocalDate.now(), "Dominick", "Test Comment");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Create a responseComment object
        Comment responseComment = new Comment(1,1, LocalDate.now(), "Dominick", "Test Comment");
        String responseJson = mapper.writeValueAsString(responseComment);

        // Mock the postDao
        Mockito.when(commentDao.addComment(inputComment)).thenReturn(responseComment);

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addCommentMissingPostIdShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setCommentDate(LocalDate.now());
        inputComment.setCommenterName("Dominick");
        inputComment.setCommentContent("Comment Content");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addCommentMissingCommentDateShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCommenterName("Dominick");
        inputComment.setCommentContent("Comment Content");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addCommentCommentDateInFutureShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCommentDate(LocalDate.of(2099,10,10));
        inputComment.setCommenterName("Dominick");
        inputComment.setCommentContent("Comment Content");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addCommentCommentDateInPastShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCommentDate(LocalDate.of(2000,10,10));
        inputComment.setCommenterName("Dominick");
        inputComment.setCommentContent("Comment Content");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addCommentMissingCommenterNameShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCommentDate(LocalDate.now());
        inputComment.setCommentContent("Comment Content");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addCommentCommenterNameSize0ShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCommentDate(LocalDate.now());
        inputComment.setCommenterName("");
        inputComment.setCommentContent("Comment Content");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addCommentCommenterNameSize1ShouldReturnCreatedComment() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1, LocalDate.now(), "D", "Test Comment");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Create a responseComment object
        Comment responseComment = new Comment(1,1, LocalDate.now(), "D", "Test Comment");
        String responseJson = mapper.writeValueAsString(responseComment);

        // Mock the postDao
        Mockito.when(commentDao.addComment(inputComment)).thenReturn(responseComment);

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addCommentCommenterNameSize50ShouldReturnCreatedComment() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1, LocalDate.now(), "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "Test Comment");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Create a responseComment object
        Comment responseComment = new Comment(1,1, LocalDate.now(), "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "Test Comment");
        String responseJson = mapper.writeValueAsString(responseComment);

        // Mock the postDao
        Mockito.when(commentDao.addComment(inputComment)).thenReturn(responseComment);

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addCommentCommenterNameSize51ShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCommentDate(LocalDate.now());
        inputComment.setCommenterName("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        inputComment.setCommentContent("Comment Content");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addCommentCommentContentSize255ShouldReturnCreatedComment() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1, LocalDate.now(), "Dominick", "piuharbgilbadroigyhvbadgpbiadhbgiouahoieUGvbapieugbahklrsbguadsibglahrbgliadjbgoiadrjbgilsdufbgliasjbgpiauerjndglidfuhbvlkadjbfgiuadrjbfngoisdfvn;oadjsbgaildjbfgpsidfubgadklfjbalvdjkfzxbvoiuerjdfbgladifzbvadlfigbaidrlfubouairhgaenjfjfjfjfjfjfjfjfjfjfjfjfj");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Create a responseComment object
        Comment responseComment = new Comment(1,1, LocalDate.now(), "Dominick", "piuharbgilbadroigyhvbadgpbiadhbgiouahoieUGvbapieugbahklrsbguadsibglahrbgliadjbgoiadrjbgilsdufbgliasjbgpiauerjndglidfuhbvlkadjbfgiuadrjbfngoisdfvn;oadjsbgaildjbfgpsidfubgadklfjbalvdjkfzxbvoiuerjdfbgladifzbvadlfigbaidrlfubouairhgaenjfjfjfjfjfjfjfjfjfjfjfjfj");
        String responseJson = mapper.writeValueAsString(responseComment);

        // Mock the postDao
        Mockito.when(commentDao.addComment(inputComment)).thenReturn(responseComment);

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addCommentCommentContentSize256ShouldReturn422() throws Exception {
        // Build a Comment without the postId property
        Comment inputComment = new Comment();
        inputComment.setPostId(1);
        inputComment.setCommentDate(LocalDate.now());
        inputComment.setCommenterName("Dominick");
        inputComment.setCommentContent("piuharbgilbadroigyhvbadgpbiadhbgiouahoieUGvbapieugbahklrsbguadsibglahrbgliadjbgoiadrjbgilsdufbgliasjbgpiauerjndglidfuhbvlkadjbfgiuadrjbfngoisdfvn;oadjsbgaildjbfgpsidfubgadklfjbalvdjkfzxbvoiuerjdfbgladifzbvadlfigbaidrlfubouairhgaenjfjfjfjfjfjfjfjfjfjfjfjfja");

        // Convert inputComment to JSON String
        String inputJson;
        try {
            inputJson = mapper.writeValueAsString(inputComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(post("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void getCommentShouldReturnCommentById() throws Exception {
        // Build responseComment
        Comment responseComment = new Comment(1, 1, LocalDate.now(), "Dominick", "Test Comment");
        String responseJson = mapper.writeValueAsString(responseComment);

        // Mock the commentDao
        Mockito.when(commentDao.getComment(1)).thenReturn(responseComment);

        // Mock the MVC
        this.mockMvc.perform(get("/comment/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void getCommentWithInvalidIdShouldReturn404() throws Exception {
        // Mock the MVC
        this.mockMvc.perform(get("/comment/1/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllCommentShouldReturnCommentList() throws Exception {
        // Build Comments
        Comment comment1 = new Comment(1, 1, LocalDate.now(), "Dominick", "Comment 1");
        Comment comment2 = new Comment(2, 1, LocalDate.now(), "Michael", "Comment 2");

        // Add Comments to a List
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);

        // Convert commentList to a JSON String
        String responseJson;
        try {
            responseJson = mapper.writeValueAsString(commentList);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the commentDao
        Mockito.when(commentDao.getAllComment()).thenReturn(commentList);

        // Mock the MVC
        this.mockMvc.perform(get("/comment"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void getCommentByPostIdShouldReturnCommentList() throws Exception {
        // Build Comments
        Comment comment1 = new Comment(1, 1, LocalDate.now(), "Dominick", "Comment 1");
        Comment comment2 = new Comment(2, 2, LocalDate.now(), "Michael", "Comment 2");
        Comment comment3 = new Comment(3, 2, LocalDate.now(), "Amanda", "Comment 3");

        // Add Comments with postId = 1 to a List
        List<Comment> commentListPostId1 = new ArrayList<>();
        commentListPostId1.add(comment1);

        // Add Comments with postID = 2 to a List
        List<Comment> commentListPostId2 = new ArrayList<>();
        commentListPostId2.add(comment2);
        commentListPostId2.add(comment3);

        // Convert the commentListPostId1 to a JSON String
        String postId1ResponseJson;
        try {
            postId1ResponseJson = mapper.writeValueAsString(commentListPostId1);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Convert the commentListPostId2 to a JSON String
        String postId2ResponseJson;
        try {
            postId2ResponseJson = mapper.writeValueAsString(commentListPostId2);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the commentDao
        Mockito.when(commentDao.getCommentByPostId(1)).thenReturn(commentListPostId1);
        Mockito.when(commentDao.getCommentByPostId(2)).thenReturn(commentListPostId2);

        // Mock the MVC
        this.mockMvc.perform(get("/comment/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(postId1ResponseJson));

        this.mockMvc.perform(get("/comment/post/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(postId2ResponseJson));
    }

    @Test
    public void updateCommentShouldReturnVoid() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1,1, LocalDate.now(), "Dominick", "Comment 1");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Mock the commentDao
        Mockito.when(commentDao.getComment(1)).thenReturn(inputComment);

        // MVC Mock
        this.mockMvc.perform(put("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateCommentMissingCommentIdShouldReturn404() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setPostId(1);
        updateComment.setCommentDate(LocalDate.now());
        updateComment.setCommenterName("Dominick");
        updateComment.setCommentContent("Update");

        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateCommentMissingPostIdShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setCommentDate(LocalDate.now());
        updateComment.setCommenterName("Dominick");
        updateComment.setCommentContent("Update");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentMissingCommentDateShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setPostId(1);
        updateComment.setCommenterName("Dominick");
        updateComment.setCommentContent("Update");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentCommentDatePastShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setPostId(1);
        updateComment.setCommentDate(LocalDate.of(2000,10,10));
        updateComment.setCommenterName("Dominick");
        updateComment.setCommentContent("Update");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentCommentDateFutureShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setPostId(1);
        updateComment.setCommentDate(LocalDate.of(2099,10,10));
        updateComment.setCommenterName("Dominick");
        updateComment.setCommentContent("Update");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentMissingCommenterNameShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setPostId(1);
        updateComment.setCommentDate(LocalDate.now());
        updateComment.setCommentContent("Update");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentCommenterNameSize0ShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setPostId(1);
        updateComment.setCommentDate(LocalDate.now());
        updateComment.setCommenterName("");
        updateComment.setCommentContent("Update");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentCommenterNameSize51ShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setPostId(1);
        updateComment.setCommentDate(LocalDate.now());
        updateComment.setCommenterName("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        updateComment.setCommentContent("Update");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentCommenterNameSize1ShouldReturnVoid() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1,1, LocalDate.now(), "D", "Comment 1");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Mock the commentDao
        Mockito.when(commentDao.getComment(1)).thenReturn(inputComment);

        // MVC Mock
        this.mockMvc.perform(put("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateCommentCommenterNameSize50ShouldReturnVoid() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1,1, LocalDate.now(), "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "Comment 1");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Mock the commentDao
        Mockito.when(commentDao.getComment(1)).thenReturn(inputComment);

        // MVC Mock
        this.mockMvc.perform(put("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateCommentCommentContentSize255ShouldReturnVoid() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1,1, LocalDate.now(), "Dominick", "iouahgoibadfoigubaeirotuhaoiegboaidughblaidhgisuergkuayergfaourbgkdjfhvgksjdhrbgoisurhdfbkvasdhjvfbkuahsdjfbkauesdghjfbkuahsbdfkvuzdfhbvkausdhvjfkauwhsgfbkvausdhjbvkaufhgfbvaksdiubxvkasdhubflkjahdsfiojbadslfjbadflgjbadflijgbalfkjgbvalifjgbvkauhdfjbgakvjfk");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Mock the commentDao
        Mockito.when(commentDao.getComment(1)).thenReturn(inputComment);

        // MVC Mock
        this.mockMvc.perform(put("/comment")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateCommentCommentContentSize256ShouldReturn422() throws Exception {
        // Build an update Comment without the PostId
        Comment updateComment = new Comment();
        updateComment.setCommentId(1);
        updateComment.setPostId(1);
        updateComment.setCommentDate(LocalDate.now());
        updateComment.setCommenterName("Dominick");
        updateComment.setCommentContent("iouahgoibadfoigubaeirotuhaoiegboaidughblaidhgisuergkuayergfaourbgkdjfhvgksjdhrbgoisurhdfbkvasdhjvfbkuahsdjfbkauesdghjfbkuahsbdfkvuzdfhbvkausdhvjfkauwhsgfbkvausdhjbvkaufhgfbvaksdiubxvkasdhubflkjahdsfiojbadslfjbadflgjbadflijgbalfkjgbvalifjgbvkauhdfjbgakvjfka");

        // Convert Input to JSON String
        String updateJson;
        try {
            updateJson = mapper.writeValueAsString(updateComment);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot convert to JSON");
        }

        // Mock the MVC
        this.mockMvc.perform(put("/comment")
                .content(updateJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateCommentWithInvalidCommentIdShouldReturn404() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1,1, LocalDate.now(), "D", "Comment 1");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Mock the MVC
        this.mockMvc.perform(put("/post")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteCommentShouldReturnVoid() throws Exception {
        // Create an inputComment object
        Comment inputComment = new Comment(1,1, LocalDate.now(), "D", "Comment 1");
        String inputJson = mapper.writeValueAsString(inputComment);

        // Mock the commentDao
        Mockito.when(commentDao.getComment(1)).thenReturn(inputComment);

        // Mock the MVC
        this.mockMvc.perform(delete("/comment/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCommentwithInvalidIdShouldReturn404() throws Exception {
        // Mock the MVC
        this.mockMvc.perform(delete("/comment/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
