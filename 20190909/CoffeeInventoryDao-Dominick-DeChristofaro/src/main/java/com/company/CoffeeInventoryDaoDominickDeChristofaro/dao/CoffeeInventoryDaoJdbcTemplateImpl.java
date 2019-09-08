/* ************************************************************************************************
 **  Author:         Dominick DeChristofaro
 **  Date:           09/08/2019
 **  Description:    Implementation for Coffee DAO.  Includes CRUD methods and searching by
 **                  roaster_id and type.
 **************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.dao;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoffeeInventoryDaoJdbcTemplateImpl implements CoffeeInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_COFFEE_SQL =
            "INSERT INTO Coffee (roaster_id, name, count, unit_price, description, type) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_COFFEE_SQL =
            "SELECT * FROM Coffee WHERE coffee_id = ?";
    private static final String SELECT_ALL_COFFEE_SQL =
            "SELECT * FROM Coffee";
    private static final String SELECT_COFFEE_BY_ROASTER_ID =
            "SELECT * FROM Coffee WHERE roaster_id = ?";
    private static final String SELECT_COFFEE_BY_TYPE =
            "SELECT * FROM Coffee WHERE type = ?";
    private static final String UPDATE_COFFEE_SQL =
            "UPDATE Coffee SET roaster_id = ?, name = ?, count = ?, unit_price = ?, description = ?, type = ? WHERE coffee_id = ?";
    private static final String DELETE_COFFEE_SQL =
            "DELETE FROM Coffee WHERE coffee_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public CoffeeInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Coffee addCoffee(Coffee coffee) {
        jdbcTemplate.update(INSERT_COFFEE_SQL,
                coffee.getRoaster_id(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType());
        int coffee_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        coffee.setCoffee_id(coffee_id);
        return coffee;
    }

    @Override
    public Coffee getCoffee(int coffee_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL, this::mapRowToCoffee, coffee_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return jdbcTemplate.query(SELECT_ALL_COFFEE_SQL, this::mapRowToCoffee);
    }

    @Override
    public List<Coffee> getCoffeeByRoasterId(int roaster_id) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_ROASTER_ID, this::mapRowToCoffee, roaster_id);
    }

    @Override
    public List<Coffee> getCoffeeByType(String type) {
        return jdbcTemplate.query(SELECT_COFFEE_BY_TYPE, this::mapRowToCoffee, type);
    }

    @Override
    @Transactional
    public void updateCoffee(Coffee coffee) {
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getRoaster_id(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getCoffee_id());
    }

    @Override
    @Transactional
    public void deleteCoffee(int coffee_id) {
        jdbcTemplate.update(DELETE_COFFEE_SQL, coffee_id);
    }

    // Additional Methods
    private Coffee mapRowToCoffee(ResultSet resultSet, int rowNumber) throws SQLException {
        Coffee coffee = new Coffee();
        coffee.setCoffee_id(resultSet.getInt("coffee_id"));
        coffee.setRoaster_id(resultSet.getInt("roaster_id"));
        coffee.setName(resultSet.getString("name"));
        coffee.setCount(resultSet.getInt("count"));
        coffee.setUnit_price(resultSet.getBigDecimal("unit_price"));
        coffee.setDescription(resultSet.getString("description"));
        coffee.setType(resultSet.getString("type"));
        return coffee;
    }
}
