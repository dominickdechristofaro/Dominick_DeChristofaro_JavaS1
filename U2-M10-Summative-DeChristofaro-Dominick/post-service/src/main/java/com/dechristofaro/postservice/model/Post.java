/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/10/2019
 *  Description:    Post model for the Post-service micro-app.
 **************************************************************************************************/
package com.dechristofaro.postservice.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Post {
    // Properties
    private int postId;

    @NotNull(message = "The postDate cannot be null and must be the current date.")
    @FutureOrPresent(message = "The postDate cannot be in past and must be the current date.")
    @PastOrPresent(message = "The postDate cannot be in the future and must be the current date.")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate postDate;

    @NotNull(message = "The posterName cannot be null.")
    @Size(min = 1, max = 50, message = "The posterName must be between 1 and 50 characters.")
    private String posterName;

    @Size(max = 255, message = "The maximum size for a post is 255 characters long.")
    private String content;

    // Constructors
    public Post() {

    }

    public Post(LocalDate postDate, String posterName, String content) {
        this.postDate = postDate;
        this.posterName = posterName;
        this.content = content;
    }

    public Post(int postId, LocalDate postDate, String posterName, String content) {
        this.postId = postId;
        this.postDate = postDate;
        this.posterName = posterName;
        this.content = content;
    }

    // Getters
    public int getPostId() {
        return this.postId;
    }

    public LocalDate getPostDate() {
        return this.postDate;
    }

    public String getPosterName() {
        return this.posterName;
    }

    public String getContent() {
        return this.content;
    }

    // Setters
    public void setPostId(int postIdIn) {
        this.postId = postIdIn;
    }

    public void setPostDate(LocalDate postDateIn) {
        this.postDate = postDateIn;
    }

    public void setPosterName(String posterNameIn) {
        this.posterName = posterNameIn;
    }

    public void setContent(String contentIn) {
        this.content = contentIn;
    }

    // equals(), hashCode() and toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId &&
                postDate.equals(post.postDate) &&
                posterName.equals(post.posterName) &&
                Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postDate, posterName, content);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
