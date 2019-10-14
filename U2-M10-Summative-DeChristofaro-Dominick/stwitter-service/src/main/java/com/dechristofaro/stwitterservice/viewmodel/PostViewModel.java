package com.dechristofaro.stwitterservice.viewmodel;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {
    // Properties
    private int postId;
    private String content;
    private LocalDate postDate;
    private String posterName;
    private List<String> comments;

    // Constructors
    public PostViewModel() {

    }

    public PostViewModel(String content, LocalDate postDate, String posterName) {
        this.content = content;
        this.postDate = postDate;
        this.posterName = posterName;
    }

    public PostViewModel(String content, LocalDate postDate, String posterName, List<String> comments) {
        this.content = content;
        this.postDate = postDate;
        this.posterName = posterName;
        this.comments = comments;
    }

    public PostViewModel(int postId, String content, LocalDate postDate, String posterName, List<String> comments) {
        this.postId = postId;
        this.content = content;
        this.postDate = postDate;
        this.posterName = posterName;
        this.comments = comments;
    }

    // Getters
    public int getPostId() {
        return this.postId;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDate getPostDate() {
        return this.postDate;
    }

    public String getPosterName() {
        return this.posterName;
    }

    public List<String> getComments() {
        return this.comments;
    }

    // Setters
    public void setPostId(int postIdIn) {
        this.postId = postIdIn;
    }

    public void setContent(String contentIn) {
        this.content = contentIn;
    }

    public void setPostDate(LocalDate postDateIn) {
        this.postDate = postDateIn;
    }

    public void setPosterName(String posterNameIn) {
        this.posterName = posterNameIn;
    }

    public void setComments(List<String> commentsIn) {
        this.comments = commentsIn;
    }

    // equals(), hashCode(), and toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return postId == that.postId &&
                Objects.equals(content, that.content) &&
                postDate.equals(that.postDate) &&
                posterName.equals(that.posterName) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, content, postDate, posterName, comments);
    }

    @Override
    public String toString() {
        return "PostViewModel{" +
                "postId=" + postId +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", comments=" + comments +
                '}';
    }
}
