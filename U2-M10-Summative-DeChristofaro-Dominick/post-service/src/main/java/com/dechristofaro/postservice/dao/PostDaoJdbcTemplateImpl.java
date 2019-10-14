/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/10/2019
 *  Description:    Post Data Access Object JDBC Template Implementation for the post-service micro-app.
 **************************************************************************************************/
package com.dechristofaro.postservice.dao;
import com.dechristofaro.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplateImpl implements PostDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_POST_SQL =
            "INSERT INTO post (post_date, poster_name, post) VALUES (?,?,?)";
    private static final String SELECT_POST_SQL =
            "SELECT * FROM post WHERE post_id = ?";
    private static final String SELECT_ALL_POST_SQL =
            "SELECT * FROM post";
    private static final String SELECT_POST_BY_POSTER_NAME_SQL =
            "SELECT * FROM post WHERE poster_name = ?";
    private static final String UPDATE_POST_SQL =
            "UPDATE post SET post_date = ?, poster_name = ?, post = ? WHERE post_id = ?";
    private static final String DELETE_POST_SQL =
            "DELETE FROM post WHERE post_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public PostDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Post addPost(Post post) {
        jdbcTemplate.update(INSERT_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getContent());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        post.setPostId(id);
        return post;
    }

    @Override
    public Post getPost(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_POST_SQL, this::mapRowToPost, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> getAllPost() {
        return jdbcTemplate.query(SELECT_ALL_POST_SQL, this::mapRowToPost);
    }

    @Override
    public List<Post> getPostByPosterName(String posterName) {
        return jdbcTemplate.query(SELECT_POST_BY_POSTER_NAME_SQL, this::mapRowToPost, posterName);
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        jdbcTemplate.update(UPDATE_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getContent(),
                post.getPostId());
    }

    @Override
    @Transactional
    public void deletePost(int id) {
        jdbcTemplate.update(DELETE_POST_SQL, id);
    }

    // Helper Methods
    private Post mapRowToPost(ResultSet resultSet, int rowNumber) throws SQLException {
        Post post = new Post();
        post.setPostId(resultSet.getInt("post_id"));
        post.setPostDate(resultSet.getDate("post_date").toLocalDate());
        post.setPosterName(resultSet.getString("poster_name"));
        post.setContent(resultSet.getString("post"));
        return post;
    }
}
