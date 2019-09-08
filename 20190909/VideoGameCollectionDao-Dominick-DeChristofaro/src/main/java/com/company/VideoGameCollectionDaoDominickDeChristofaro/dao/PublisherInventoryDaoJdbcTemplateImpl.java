/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Implementation for Publisher DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Publisher;
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
            "INSERT INTO Publisher (name, website) VALUES (?,?)";
    private static final String SELECT_PUBLISHER_SQL =
            "SELECT * FROM Publisher WHERE publisher_id = ?";
    private static final String SELECT_ALL_PUBLISHER_SQL =
            "SELECT * FROM Publisher";
    private static final String UPDATE_PUBLISHER_SQL =
            "UPDATE Publisher SET name = ?, website = ? WHERE publisher_id = ?";
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
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getWebsite());
        int publisher_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        publisher.setPublisher_id(publisher_id);
        return publisher;
    }

    @Override
    public Publisher getPublisher(int publisher_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, publisher_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHER_SQL, this::mapRowToPublisher);
    }

    @Override
    @Transactional
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getWebsite(),
                publisher.getPublisher_id());
    }

    @Override
    @Transactional
    public void deletePublisher(int publisher_id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, publisher_id);
    }

    // Additional Methods
    private Publisher mapRowToPublisher(ResultSet resultSet, int rowNumber) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(resultSet.getInt("publisher_id"));
        publisher.setName(resultSet.getString("name"));
        publisher.setWebsite(resultSet.getString("website"));
        return publisher;
    }
}
