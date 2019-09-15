/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Author Data Access Object (DAO) Implementation.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.dao;
import com.company.U1M5SummativeDeChristofaroDominick.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorInventoryDaoJdbcTemplateImpl implements AuthorInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_AUTHOR_SQL =
            "INSERT INTO Author (first_name, last_name, street, city, state, postal_code, phone, email) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SELECT_AUTHOR_SQL =
            "SELECT * FROM Author WHERE author_id = ?";
    private static final String SELECT_ALL_AUTHOR_SQL =
            "SELECT * FROM Author";
    private static final String UPDATE_AUTHOR_SQL =
            "UPDATE Author SET first_name = ?, last_name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? WHERE author_id = ?";
    private static final String DELETE_AUTHOR_SQL =
            "DELETE FROM Author WHERE author_id = ?";


    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors (Bean)
    @Autowired
    public AuthorInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    /**
     * Add an Author to the database.
     *
     * @param author The Author you would like to add to the database.
     * @return The Author you added to the database.
     */
    public Author addAuthor(Author author) {
        jdbcTemplate.update(INSERT_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostal_code(),
                author.getPhone(),
                author.getEmail());
        int author_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        author.setAuthor_id(author_id);
        return author;
    }

    @Override
    /**
     * Get a single Author from the database.
     *
     * @param author_id The id of the Author you would like to retrieve from the database.
     * @return The Author requested from the database.
     */
    public Author getAuthor(int author_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL, this::mapRowToAuthor, author_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    /**
     * A List of all the Author's in the database.
     *
     * @return A List of all the Author's in the database.
     */
    public List<Author> getAllAuthor() {
        return jdbcTemplate.query(SELECT_ALL_AUTHOR_SQL, this::mapRowToAuthor);
    }

    @Override
    @Transactional
    /**
     * Update an Author in the database.
     *
     * @param author An Author object you would like to update in the database.
     */
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostal_code(),
                author.getPhone(),
                author.getEmail(),
                author.getAuthor_id());
    }

    @Override
    @Transactional
    /**
     * Delete an Author from the database.
     *
     * @param author_id The id of the Author you would like to delete.
     */
    public void deleteAuthor(int author_id) {
        jdbcTemplate.update(DELETE_AUTHOR_SQL, author_id);
    }

    // Object Relational Mapper Method
    /**
     * Method that maps a row in the relational database to the Author DAO.
     *
     * @param resultSet The set of column names in the relational database.
     * @param rowNumber The row number in the relational database.
     * @return The Author object mapped to a specific row in the relational database.
     * @throws SQLException The data is not in the database.
     */
    private Author mapRowToAuthor(ResultSet resultSet, int rowNumber) throws SQLException {
        Author author = new Author();
        author.setAuthor_id(resultSet.getInt("author_id"));
        author.setFirst_name(resultSet.getString("first_name"));
        author.setLast_name(resultSet.getString("last_name"));
        author.setStreet(resultSet.getString("street"));
        author.setCity(resultSet.getString("city"));
        author.setState(resultSet.getString("state"));
        author.setPostal_code(resultSet.getString("postal_code"));
        author.setPhone(resultSet.getString("phone"));
        author.setEmail(resultSet.getString("email"));
        return author;
    }
}
