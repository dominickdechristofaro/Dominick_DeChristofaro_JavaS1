/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
 *  Description:    Implementation for Console DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_CONSOLE_SQL =
            "INSERT INTO console (model, manufacturer, memory_amount, processor, price, quantity) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_CONSOLE_SQL =
            "SELECT * FROM console WHERE console_id = ?";
    private static final String SELECT_ALL_CONSOLE_SQL =
            "SELECT * FROM console";
    private static final String SELECT_CONSOLE_BY_MANUFACTURER_SQL =
            "SELECT * FROM console WHERE manufacturer = ?";
    private static final String UPDATE_CONSOLE_SQL =
            "UPDATE console SET model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? WHERE console_id = ?";
    private static final String DELETE_CONSOLE_SQL =
            "DELETE FROM console WHERE console_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Add a Console to the database.
     * @param console The Console to be added to the database.
     * @return The Console added to the database with an id.
     */
    @Override
    @Transactional
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity());
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        console.setId(id);
        return console;
    }

    /**
     * Update a Console in the database.
     * @param console The Console to be updated in the database.
     */
    @Override
    @Transactional
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getId());
    }

    /**
     * Delete a Console in the database.
     * @param id The id of the Console to be deleted from the database.
     */
    @Override
    @Transactional
    public void deleteConsole(Long id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);
    }

    /**
     * Get a single Console from the database by id.
     * @param id The id of the Console to retrieve from the database.
     * @return The Console requested from the database.
     */
    @Override
    public Console getConsole(Long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Get all Consoles in the database.
     * @return A List of all Consoles in the database.
     */
    @Override
    public List<Console> getAllConsole() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLE_SQL, this::mapRowToConsole);
    }

    /**
     * Get all Consoles in the database by manufacturer.
     * @param manufacturer The manufacturer to query in the database.
     * @return A list of all Consoles with the manufacturer queried.
     */
    @Override
    public List<Console> getConsoleByManufacturer(String manufacturer) {
        return jdbcTemplate.query(SELECT_CONSOLE_BY_MANUFACTURER_SQL, this::mapRowToConsole, manufacturer);
    }

    /**
     * Map a row of the database to a Console object.
     * @param resultSet The result set of parameters retrieved from the database.
     * @param rowNumber The row number retrieved from the database.
     * @return A Console object retrieved from the database
     * @throws SQLException Thrown in the object could not be retrieved from the database.
     */
    private Console mapRowToConsole(ResultSet resultSet, int rowNumber) throws SQLException {
        Console console = new Console();
        console.setId(resultSet.getLong("console_id"));
        console.setModel(resultSet.getString("model"));
        console.setManufacturer(resultSet.getString("manufacturer"));
        console.setMemoryAmount(resultSet.getString("memory_amount"));
        console.setProcessor(resultSet.getString("processor"));
        console.setPrice(resultSet.getBigDecimal("price"));
        console.setQuantity(resultSet.getLong("quantity"));
        return console;
    }
}
