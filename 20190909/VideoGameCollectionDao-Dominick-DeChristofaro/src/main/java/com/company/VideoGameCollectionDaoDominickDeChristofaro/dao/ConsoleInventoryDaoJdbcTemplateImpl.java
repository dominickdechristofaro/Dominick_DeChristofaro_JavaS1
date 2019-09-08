/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Implementation for Console DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleInventoryDaoJdbcTemplateImpl implements ConsoleInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_CONSOLE_SQL =
            "INSERT INTO Console (name, year) VALUES (?,?)";
    private static final String SELECT_CONSOLE_SQL =
            "SELECT * FROM Console WHERE console_id = ?";
    private static final String SELECT_ALL_CONSOLE_SQL =
            "SELECT * FROM Console";
    private static final String UPDATE_CONSOLE_SQL =
            "UPDATE Console SET name = ?, year = ? WHERE console_id = ?";
    private static final String DELETE_CONSOLE_SQL =
            "DELETE FROM Console WHERE console_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public ConsoleInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getName(),
                console.getYear());
        int console_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        console.setConsole_id(console_id);
        return console;
    }

    @Override
    public Console getConsole(int console_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, console_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Console> getAllConsole() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLE_SQL, this::mapRowToConsole);
    }

    @Override
    @Transactional
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getName(),
                console.getYear(),
                console.getConsole_id());
    }

    @Override
    @Transactional
    public void deleteConsole(int console_id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, console_id);
    }

    // Additional Methods
    private Console mapRowToConsole(ResultSet resultSet, int rowNumber) throws SQLException {
        Console console = new Console();
        console.setConsole_id(resultSet.getInt("console_id"));
        console.setName(resultSet.getString("name"));
        console.setYear(resultSet.getString("year"));
        return console;
    }
}
