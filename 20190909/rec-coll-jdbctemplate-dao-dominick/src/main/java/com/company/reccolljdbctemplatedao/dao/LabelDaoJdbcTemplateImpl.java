/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Implementation for Label DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LabelDaoJdbcTemplateImpl implements LabelDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_LABEL_SQL =
            "INSERT INTO Label (name, website) VALUES (?,?)";
    private static final String SELECT_LABEL_SQL =
            "SELECT * FROM Label WHERE label_id = ?";
    private static final String SELECT_ALL_LABELS_SQL =
            "SELECT * FROM Label";
    private static final String DELETE_LABEL_SQL =
            "DELETE FROM Label WHERE label_id = ?";
    private static final String UPDATE_LABEL_SQL =
            "UPDATE Label SET name = ?, website = ? WHERE label_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public LabelDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Label addLabel(Label label) {
        jdbcTemplate.update(INSERT_LABEL_SQL,
                label.getName(),
                label.getWebsite());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        label.setLabel_id(id);
        return label;
    }

    @Override
    public Label getLabel(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_LABEL_SQL, this::mapRowToLabel, id);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Label> getAllLabels() {
        return jdbcTemplate.query(SELECT_ALL_LABELS_SQL, this::mapRowToLabel);
    }

    @Override
    @Transactional
    public void updateLabel(Label label) {
        jdbcTemplate.update(UPDATE_LABEL_SQL,
                label.getName(),
                label.getWebsite(),
                label.getLabel_id());
    }

    @Override
    @Transactional
    public void deleteLabel(int id) {
        jdbcTemplate.update(DELETE_LABEL_SQL, id);
    }

    private Label mapRowToLabel(ResultSet resultSet, int rowNumber) throws SQLException {
        Label label = new Label();
        label.setLabel_id(resultSet.getInt("label_id"));
        label.setName(resultSet.getString("name"));
        label.setWebsite(resultSet.getString("website"));
        return label;
    }
}
