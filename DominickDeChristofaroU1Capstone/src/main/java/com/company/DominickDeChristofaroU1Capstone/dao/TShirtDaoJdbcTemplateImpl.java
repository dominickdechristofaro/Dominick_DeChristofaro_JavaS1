/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
 *  Description:    Interface for TShirt DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_T_SHIRT_SQL =
            "INSERT INTO t_shirt (size, color, description, price, quantity) VALUES (?,?,?,?,?)";
    private static final String SELECT_T_SHIRT_SQL =
            "SELECT * FROM t_shirt WHERE t_shirt_id = ?";
    private static final String SELECT_ALL_T_SHIRT_SQL =
            "SELECT * FROM t_shirt";
    private static final String SELECT_T_SHIRT_BY_COLOR_SQL =
            "SELECT * FROM t_shirt WHERE color = ?";
    private static final String SELECT_T_SHIRT_BY_SIZE_SQL =
            "SELECT * FROM t_shirt WHERE size = ?";
    private static final String UPDATE_T_SHIRT_SQL =
            "UPDATE t_shirt SET size = ?, color = ?, description = ?, price = ?, quantity = ? WHERE t_shirt_id = ?";
    private static final String DELETE_T_SHIRT_SQL =
            "DELETE FROM t_shirt WHERE t_shirt_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Transactional Methods
    @Override
    @Transactional
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(INSERT_T_SHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        tShirt.setId(id);
        return tShirt;
    }

    @Override
    @Transactional
    public void updateTShirt(TShirt tShirt) {
        jdbcTemplate.update(UPDATE_T_SHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity(),
                tShirt.getId());
    }

    @Override
    @Transactional
    public void deleteTShirt(Long id) {
        jdbcTemplate.update(DELETE_T_SHIRT_SQL, id);
    }

    // Getter Methods
    @Override
    public TShirt getTShirt(Long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTShirt, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTShirt() {
        return jdbcTemplate.query(SELECT_ALL_T_SHIRT_SQL, this::mapRowToTShirt);
    }

    @Override
    public List<TShirt> getTShirtByColor(String color) {
        return jdbcTemplate.query(SELECT_T_SHIRT_BY_COLOR_SQL, this::mapRowToTShirt, color);
    }

    @Override
    public List<TShirt> getTShirtBySize(String size) {
        return jdbcTemplate.query(SELECT_T_SHIRT_BY_SIZE_SQL, this::mapRowToTShirt, size);
    }

    // Helper Methods
    private TShirt mapRowToTShirt(ResultSet resultSet, int rowNumber) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.setId(resultSet.getLong("t_shirt_id"));
        tShirt.setSize(resultSet.getString("size"));
        tShirt.setColor(resultSet.getString("color"));
        tShirt.setDescription(resultSet.getString("description"));
        tShirt.setPrice(resultSet.getBigDecimal("price"));
        tShirt.setQuantity(resultSet.getLong("quantity"));
        return tShirt;
    }
}
