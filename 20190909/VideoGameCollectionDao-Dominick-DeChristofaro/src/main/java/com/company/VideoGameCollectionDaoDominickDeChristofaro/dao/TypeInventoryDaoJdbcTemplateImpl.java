/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Implementation for Type DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TypeInventoryDaoJdbcTemplateImpl implements TypeInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_TYPE_SQL =
            "INSERT INTO Type (name, description) VALUES (?,?)";
    private static final String SELECT_TYPE_SQL =
            "SELECT * FROM Type WHERE type_id = ?";
    private static final String SELECT_ALL_TYPE_SQL =
            "SELECT * FROM Type";
    private static final String UPDATE_TYPE_SQL =
            "UPDATE Type SET name = ?, description = ? WHERE type_id = ?";
    private static final String DELETE_TYPE_SQL =
            "DELETE FROM Type WHERE type_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public TypeInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Type addType(Type type) {
        jdbcTemplate.update(INSERT_TYPE_SQL,
                type.getName(),
                type.getDescription());
        int type_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        type.setType_id(type_id);
        return type;
    }

    @Override
    public Type getType(int type_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TYPE_SQL, this::mapRowToType, type_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Type> getAllType() {
        return jdbcTemplate.query(SELECT_ALL_TYPE_SQL, this::mapRowToType);
    }

    @Override
    @Transactional
    public void updateType(Type type) {
        jdbcTemplate.update(UPDATE_TYPE_SQL,
                type.getName(),
                type.getDescription(),
                type.getType_id());
    }

    @Override
    @Transactional
    public void deleteType(int type_id) {
        jdbcTemplate.update(DELETE_TYPE_SQL, type_id);
    }

    // Additional Methods
    private Type mapRowToType(ResultSet resultSet, int rowNumber) throws SQLException {
        Type type = new Type();
        type.setType_id(resultSet.getInt("type_id"));
        type.setName(resultSet.getString("name"));
        type.setDescription(resultSet.getString("description"));
        return type;
    }
}
