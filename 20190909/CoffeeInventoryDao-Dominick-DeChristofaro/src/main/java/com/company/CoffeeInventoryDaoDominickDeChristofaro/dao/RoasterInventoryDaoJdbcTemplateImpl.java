/* ************************************************************************************************
 **  Author:         Dominick DeChristofaro
 **  Date:           09/08/2019
 **  Description:    Implementation for Roaster DAO.
 **************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.dao;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoasterInventoryDaoJdbcTemplateImpl implements RoasterInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_ROASTER_SQL =
            "INSERT INTO Roaster (name, street, city, state, postal_code, phone, email, note) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SELECT_ROASTER_SQL =
            "SELECT * FROM Roaster WHERE roaster_id = ?";
    private static final String SELECT_ALL_ROASTER_SQL =
            "SELECT * FROM Roaster";
    private static final String UPDATE_ROASTER_SQL =
            "UPDATE Roaster SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ?, note = ? WHERE roaster_id = ?";
    private static final String DELETE_ROASTER_SQL =
            "DELETE FROM Roaster WHERE roaster_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public RoasterInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Roaster addRoaster(Roaster roaster) {
        jdbcTemplate.update(INSERT_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote());
        int roaster_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        roaster.setRoaster_id(roaster_id);
        return roaster;
    }

    @Override
    public Roaster getRoaster(int roaster_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ROASTER_SQL, this::mapRowToRoaster, roaster_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Roaster> getAllRoaster() {
        return jdbcTemplate.query(SELECT_ALL_ROASTER_SQL, this::mapRowToRoaster);
    }

    @Override
    @Transactional
    public void updateRoaster(Roaster roaster) {
        jdbcTemplate.update(UPDATE_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote(),
                roaster.getRoaster_id());
    }

    @Override
    @Transactional
    public void deleteRoaster(int roaster_id) {
        jdbcTemplate.update(DELETE_ROASTER_SQL, roaster_id);
    }

    // Additional Methods
    private Roaster mapRowToRoaster(ResultSet resultSet, int rowNumber) throws SQLException {
        Roaster roaster = new Roaster();
        roaster.setRoaster_id(resultSet.getInt("roaster_id"));
        roaster.setName(resultSet.getString("name"));
        roaster.setStreet(resultSet.getString("street"));
        roaster.setCity(resultSet.getString("city"));
        roaster.setState(resultSet.getString("state"));
        roaster.setPostal_code(resultSet.getString("postal_code"));
        roaster.setPhone(resultSet.getString("phone"));
        roaster.setEmail(resultSet.getString("email"));
        roaster.setNote(resultSet.getString("note"));
        return roaster;
    }
}
