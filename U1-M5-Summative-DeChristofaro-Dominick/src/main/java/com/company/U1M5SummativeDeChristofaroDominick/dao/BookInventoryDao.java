/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Book Data Access Object (DAO) Interface.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.dao;
import com.company.U1M5SummativeDeChristofaroDominick.model.Book;
import java.util.List;

public interface BookInventoryDao {
    /**
     * Add a Book to the database.
     *
     * @param book The Book to add to the database.
     * @return The Book added to the database.
     */
    Book addBook(Book book);

    /**
     * Get a single Book from the database.
     *
     * @param book_id The id of the Book to retrieve from the database.
     * @return The Book requested from the database.
     */
    Book getBook(int book_id);

    /**
     * A List of all the Book's in the database.
     *
     * @return A List of all the Book's in the database.
     */
    List<Book> getAllBook();

    /**
     * Get a List of Book's by the author_id.
     *
     * @param author_id The Author Id you would like to search for.
     * @return A List of all the Book's with the author_id requested from the database.
     */
    List<Book> getBookByAuthor(int author_id);

    /**
     * Update a Book in the database.
     *
     * @param book The new Book object you would like to update in the database.
     */
    void updateBook(Book book);

    /**
     * Delete a Book from the database.
     *
     * @param book_id The id of the Book you would like to delete from the database.
     */
    void deleteBook(int book_id);
}
