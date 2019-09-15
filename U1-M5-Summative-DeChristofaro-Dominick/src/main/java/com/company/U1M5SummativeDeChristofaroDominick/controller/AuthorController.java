/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/10/2019
 *  Description:    REST Controller for Author API Mappings.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.controller;
import com.company.U1M5SummativeDeChristofaroDominick.dao.AuthorInventoryDaoJdbcTemplateImpl;
import com.company.U1M5SummativeDeChristofaroDominick.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AuthorController {
    // Properties
    @Autowired
    private AuthorInventoryDaoJdbcTemplateImpl authorDao;

    // CRUD Controller Mappings
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * REST Controller method for adding an Author to the database.
     */
    public Author addAuthor(@RequestBody Author author) {
        return authorDao.addAuthor(author);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller mapping for getting a single Author from the database by ID.
     */
    public Author getAuthorById(@PathVariable int id) {
        return authorDao.getAuthor(id);
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller mapping for getting a List of all Authors from the database.
     */
    public List<Author> getAllAuthor() {
        return authorDao.getAllAuthor();
    }

    @RequestMapping(value = "/author", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller mapping for updating an Author in the database.
     */
    public void updateAuthor(@RequestBody Author author) {
        authorDao.updateAuthor(author);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    /**
     * Rest Controller mapping for deleting an Author from the database by author_id.
     */
    public void deleteAuthor(@PathVariable int id) {
        authorDao.deleteAuthor(id);
    }
}
