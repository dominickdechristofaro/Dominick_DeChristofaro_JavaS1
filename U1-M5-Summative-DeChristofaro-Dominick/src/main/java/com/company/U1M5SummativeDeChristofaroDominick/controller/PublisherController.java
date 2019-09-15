/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/10/2019
 *  Description:    REST Controller for Publisher API Mappings.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.controller;
import com.company.U1M5SummativeDeChristofaroDominick.dao.PublisherInventoryDaoJdbcTemplateImpl;
import com.company.U1M5SummativeDeChristofaroDominick.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PublisherController {
    // Properties
    @Autowired
    private PublisherInventoryDaoJdbcTemplateImpl publisherDao;

    // CRUD Controller Mappings
    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * REST Controller for adding a Publisher to the database.
     */
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherDao.addPublisher(publisher);
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for getting a single Publisher from the database by publisher_id.
     */
    public Publisher getPublisherById(@PathVariable int id) {
        return publisherDao.getPublisher(id);
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for getting a List of all Publisher's from the database.
     */
    public List<Publisher> getAllPublisher() {
        return publisherDao.getAllPublisher();
    }

    @RequestMapping(value = "/publisher", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for updating an existing Publisher in the database.
     */
    public void updatePublisher(@RequestBody Publisher publisher) {
        publisherDao.updatePublisher(publisher);
    }

    @RequestMapping(value = "/publisher/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    /**
     * REST Controller for deleting a Publisher in the database by publisher_id.
     */
    public void deletePublisher(@PathVariable int id) {
        publisherDao.deletePublisher(id);
    }
}
