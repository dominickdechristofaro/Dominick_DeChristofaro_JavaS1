/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Book Data Access Object (DAO) Implementation.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.dao;
import com.company.U1M5SummativeDeChristofaroDominick.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookInventoryDaoJdbcTemplateImpl implements BookInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_BOOK_SQL =
            "INSERT INTO Book (isbn, publish_date, author_id, title, publisher_id, price) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_BOOK_SQL =
            "SELECT * FROM Book WHERE book_id = ?";
    private static final String SELECT_ALL_BOOK_SQL =
            "SELECT * FROM Book";
    private static final String SELECT_BOOK_BY_AUTHOR_SQL =
            "SELECT * FROM Book WHERE author_id = ?";
    private static final String UPDATE_BOOK_SQL =
            "UPDATE Book SET isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? WHERE book_id = ?";
    private static final String DELETE_BOOK_SQL =
            "DELETE FROM Book WHERE book_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public BookInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    /**
     * Add a Book to the database.
     *
     * @param book The Book to add to the database.
     * @return The Book added to the database.
     */
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisher_id(),
                book.getPrice());
        int book_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        book.setBook_id(book_id);
        return book;
    }

    @Override
    /**
     * Get a single Book from the database.
     *
     * @param book_id The id of the Book to retrieve from the database.
     * @return The Book requested from the database.
     */
    public Book getBook(int book_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, book_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    /**
     * A List of all the Book's in the database.
     *
     * @return A List of all the Book's in the database.
     */
    public List<Book> getAllBook() {
        return jdbcTemplate.query(SELECT_ALL_BOOK_SQL, this::mapRowToBook);
    }

    @Override
    /**
     * Get a List of Book's by the author_id.
     *
     * @param author_id The Author Id you would like to search for.
     * @return A List of all the Book's with the author_id requested from the database.
     */
    public List<Book> getBookByAuthor(int author_id) {
        return jdbcTemplate.query(SELECT_BOOK_BY_AUTHOR_SQL, this::mapRowToBook, author_id);
    }

    @Override
    @Transactional
    /**
     * Update a Book in the database.
     *
     * @param book The new Book object you would like to update in the database.
     */
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublisher_id(),
                book.getPrice(),
                book.getBook_id());
    }

    @Override
    @Transactional
    /**
     * Delete a Book from the database.
     *
     * @param book_id The id of the Book you would like to delete from the database.
     */
    public void deleteBook(int book_id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, book_id);
    }

    // Object Relational Mapper Method

    /**
     * Map a row in the Relational Database to the Author DAO.
     *
     * @param resultSet The set of column names in the relational database.
     * @param rowNumber The row numbers of the relational database.
     * @return The Book object mapped by the row requested in the relational database.
     * @throws SQLException Thrown if the object is not present in the database.
     */
    private Book mapRowToBook(ResultSet resultSet, int rowNumber) throws SQLException {
        Book book = new Book();
        book.setBook_id(resultSet.getInt("book_id"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPublish_date(resultSet.getDate("publish_date").toLocalDate());
        book.setAuthor_id(resultSet.getInt("author_id"));
        book.setTitle(resultSet.getString("title"));
        book.setPublisher_id(resultSet.getInt("publisher_id"));
        book.setPrice(resultSet.getBigDecimal("price"));
        return book;
    }
}
