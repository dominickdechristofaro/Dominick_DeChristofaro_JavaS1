package com.dechristofaro.commentservice.dao;
import com.dechristofaro.commentservice.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcTemplateImpl implements CommentDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_COMMENT_SQL =
            "INSERT INTO comment (post_id, create_date, commenter_name, comment) VALUES (?,?,?,?)";
    private static final String SELECT_COMMENT_SQL =
            "SELECT * FROM comment WHERE comment_id = ?";
    private static final String SELECT_ALL_COMMENT_SQL =
            "SELECT * FROM comment";
    private static final String SELECT_COMMENT_BY_POST_ID_SQL =
            "SELECT * FROM comment WHERE post_id = ?";
    private static final String UPDATE_COMMENT_SQL =
            "UPDATE comment SET post_id = ?, create_date = ?, commenter_name = ?, comment = ? WHERE comment_id = ?";
    private static final String DELETE_COMMENT_SQL =
            "DELETE FROM comment WHERE comment_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public CommentDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(INSERT_COMMENT_SQL,
                comment.getPostId(),
                comment.getCommentDate(),
                comment.getCommenterName(),
                comment.getCommentContent());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        comment.setCommentId(id);
        return comment;
    }

    @Override
    public Comment getComment(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COMMENT_SQL, this::mapRowToComment, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Comment> getAllComment() {
        return jdbcTemplate.query(SELECT_ALL_COMMENT_SQL, this::mapRowToComment);
    }

    @Override
    public List<Comment> getCommentByPostId(int postId) {
        return jdbcTemplate.query(SELECT_COMMENT_BY_POST_ID_SQL, this::mapRowToComment, postId);
    }

    @Override
    @Transactional
    public void updateComment(Comment comment) {
        jdbcTemplate.update(UPDATE_COMMENT_SQL,
                comment.getPostId(),
                comment.getCommentDate(),
                comment.getCommenterName(),
                comment.getCommentContent(),
                comment.getCommentId());
    }

    @Override
    @Transactional
    public void deleteComment(int id) {
        jdbcTemplate.update(DELETE_COMMENT_SQL, id);
    }

    // Helper Methods
    private Comment mapRowToComment(ResultSet resultSet, int rowNumber) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(resultSet.getInt("comment_id"));
        comment.setPostId(resultSet.getInt("post_id"));
        comment.setCommentDate(resultSet.getDate("create_date").toLocalDate());
        comment.setCommenterName(resultSet.getString("commenter_name"));
        comment.setCommentContent(resultSet.getString("comment"));
        return comment;
    }
}
