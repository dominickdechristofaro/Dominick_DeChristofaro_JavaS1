/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Publisher Data Access Object (DAO) Implementation.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.dao;
import com.company.U1M5SummativeDeChristofaroDominick.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherInventoryDaoJdbcTemplateImpl implements PublisherInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_PUBLISHER_SQL =
            "INSERT INTO Publisher (name, street, city, state, postal_code, phone, email) VALUES (?,?,?,?,?,?,?)";
    private static final String SELECT_PUBLISHER_SQL =
            "SELECT * FROM Publisher WHERE publisher_id = ?";
    private static final String SELECT_ALL_PUBLISHER_SQL =
            "SELECT * FROM Publisher";
    private static final String UPDATE_PUBLISHER_SQL =
            "UPDATE Publisher SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? WHERE publisher_id = ?";
    private static final String DELETE_PUBLISHER_SQL =
            "DELETE FROM Publisher WHERE publisher_id = ?";


    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public PublisherInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    /**
     * Add a Publisher to the database.
     *
     * @param publisher The Publisher you would like to add to the database.
     * @return The Publisher added to the database.
     */
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail());
        int publisher_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        publisher.setPublisher_id(publisher_id);
        return publisher;
    }

    @Override
    /**
     * Get a single Publisher from the database.
     *
     * @param publisher_id The id of the Publisher you would like to get from the database.
     * @return The Publisher requested from the database.
     */
    public Publisher getPublisher(int publisher_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, publisher_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    /**
     * A List of all Publisher's from the database.
     *
     * @return A List of all Publisher's from the database.
     */
    public List<Publisher> getAllPublisher() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHER_SQL, this::mapRowToPublisher);
    }

    @Override
    @Transactional
    /**
     * Update a Publisher in the database.
     *
     * @param publisher A Publisher object with a valid publisher_id with new
     *                  updated properties for the database.
     */
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getPublisher_id());
    }

    @Override
    @Transactional
    /**
     * Delete a publisher from the database.
     *
     * @param publisher_id The Publisher id that you would like deleted from the database.
     */
    public void deletePublisher(int publisher_id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisher_id);
    }

    // Object Relational Mapper (ORM) Method

    /**
     * Map a row from the relational database to the Publisher DAO.
     *
     * @param resultSet The column names in the relational database.
     * @param rowNumber The row number in the relational database.
     * @return The Publisher requested to map to the DAO from the relational database.
     * @throws SQLException Thrown if the row in the relational database has no properties to map.
     */
    private Publisher mapRowToPublisher(ResultSet resultSet, int rowNumber) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(resultSet.getInt("publisher_id"));
        publisher.setName(resultSet.getString("name"));
        publisher.setStreet(resultSet.getString("street"));
        publisher.setCity(resultSet.getString("city"));
        publisher.setState(resultSet.getString("state"));
        publisher.setPostal_code(resultSet.getString("postal_code"));
        publisher.setPhone(resultSet.getString("phone"));
        publisher.setEmail(resultSet.getString("email"));
        return publisher;
    }
}
