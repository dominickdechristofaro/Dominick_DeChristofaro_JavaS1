/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/10/2019
 *  Description:    REST Controller for Book API Mappings.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.controller;
import com.company.U1M5SummativeDeChristofaroDominick.dao.BookInventoryDaoJdbcTemplateImpl;
import com.company.U1M5SummativeDeChristofaroDominick.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {
    // Properties
    @Autowired
    private BookInventoryDaoJdbcTemplateImpl bookDao;

    // CRUD Controller Mappings
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * REST Controller for adding a Book to the database.
     */
    public Book addBook(@RequestBody Book book) {
        return bookDao.addBook(book);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for getting a single Book from the database by book_id.
     */
    public Book getBookById(@PathVariable int id) {
        return bookDao.getBook(id);
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for getting a List of all Book's from the database.
     */
    public List<Book> getAllBook() {
        return bookDao.getAllBook();
    }

    @RequestMapping(value = "/book/author/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for getting a List of all Book's from the database with an identical author_id.
     */
    public List<Book> getBookByAuthor(@PathVariable int id) {
        return bookDao.getBookByAuthor(id);
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for updating an existing Book in the database.
     */
    public void updateBook(@RequestBody Book book) {
        bookDao.updateBook(book);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for deleting a Book from the database by book_id.
     */
    public void deleteBook(@PathVariable int id) {
        bookDao.deleteBook(id);
    }
}
