/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Publisher Inventory DAO Tests for CRUD Methods.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.dao;
import com.company.U1M5SummativeDeChristofaroDominick.model.Author;
import com.company.U1M5SummativeDeChristofaroDominick.model.Book;
import com.company.U1M5SummativeDeChristofaroDominick.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherInventoryDaoTest {
    // Properties
    @Autowired
    protected AuthorInventoryDao authorDao;
    @Autowired
    protected BookInventoryDao bookDao;
    @Autowired
    protected PublisherInventoryDao publisherDao;

    // setUp()
    @Before
    /**
     * Clean's up the test database environment before every test is run.
     * Instantiates and adds test objects to the database.
     */
    public void setUp() throws Exception {
        // Clean up the Book table in the database
        List<Book> bookList = bookDao.getAllBook();
        bookList.forEach(book -> bookDao.deleteBook(book.getBook_id()));

        // Clean up the Author table in the database
        List<Author> authorList = authorDao.getAllAuthor();
        authorList.forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));

        // Clean up the Publisher table in the database
        List<Publisher> publisherList = publisherDao.getAllPublisher();
        publisherList.forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));
    }

    // CRUD Method Tests
    @Test
    /**
     * Testing the addPublisher() CRUD Methods.
     */
    public void addPublisher() {
        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Dominick DeChristofaro");
        publisher.setStreet("123 Test Lane");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostal_code("24567");
        publisher.setPhone("9999999999");
        publisher.setEmail("Publisher1@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        // Create a new Publisher variable to hold the identical Publisher
        Publisher publisherCopy = publisherDao.getPublisher(publisher.getPublisher_id());

        // Test addPublisher and getPublisher methods
        assertEquals(publisherCopy, publisher);
    }

    @Test
    /**
     * Test the getPublisher() CRUD method.
     */
    public void getPublisher() {
        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Dominick DeChristofaro");
        publisher.setStreet("123 Test Lane");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostal_code("24567");
        publisher.setPhone("9999999999");
        publisher.setEmail("Publisher1@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        // Create a new Publisher variable to hold the identical Publisher
        Publisher publisherCopy = publisherDao.getPublisher(publisher.getPublisher_id());

        // Test addPublisher and getPublisher methods
        assertEquals(publisherCopy, publisher);

        // Test deletePublisher method
        publisherDao.deletePublisher(publisher.getPublisher_id());
        publisherCopy = publisherDao.getPublisher(publisher.getPublisher_id());
        assertNull(publisherCopy);
    }

    @Test
    /**
     * Testing the getAllPublisher() CRUD Method.
     */
    public void getAllPublisher() {
        // Create and add a Publisher object (publisher1)
        Publisher publisher1 = new Publisher();
        publisher1.setName("Dominick DeChristofaro");
        publisher1.setStreet("123 Test Lane");
        publisher1.setCity("Atlanta");
        publisher1.setState("GA");
        publisher1.setPostal_code("24567");
        publisher1.setPhone("9999999999");
        publisher1.setEmail("Publisher1@gmail.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        // Create and add a Publisher object (publisher2)
        Publisher publisher2 = new Publisher();
        publisher2.setName("Michael Stuckey");
        publisher2.setStreet("456 Awesome Circle");
        publisher2.setCity("Asheville");
        publisher2.setState("NC");
        publisher2.setPostal_code("28804");
        publisher2.setPhone("2064229874");
        publisher2.setEmail("Publisher2@gmail.com");
        publisher2 = publisherDao.addPublisher(publisher2);

        // Get all Publisher entries from the database
        List<Publisher> publisherList = publisherDao.getAllPublisher();

        // Test the getAllPublisher() method works correctly
        assertEquals(2, publisherList.size());
    }

    @Test
    /**
     * Testing the updatePublisher() CRUD Method.
     */
    public void updatePublisher() {
        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Dominick DeChristofaro");
        publisher.setStreet("123 Test Lane");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostal_code("24567");
        publisher.setPhone("9999999999");
        publisher.setEmail("Publisher1@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        // Update the values of Console object
        publisher.setName("Michael Stuckey");
        publisher.setStreet("456 Awesome Circle");
        publisher.setCity("Asheville");
        publisher.setState("NC");
        publisher.setPostal_code("28804");
        publisher.setPhone("2064229874");
        publisher.setEmail("Publisher2@gmail.com");
        publisherDao.updatePublisher(publisher);

        // Create a copy of the new Console
        Publisher publisherCopy = publisherDao.getPublisher(publisher.getPublisher_id());

        // Test that console and consoleCopy are equal
        assertEquals(publisherCopy, publisher);
    }

    @Test
    /**
     * Test the deletePublisher() CRUD method.
     */
    public void deletePublisher() {
        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Dominick DeChristofaro");
        publisher.setStreet("123 Test Lane");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostal_code("24567");
        publisher.setPhone("9999999999");
        publisher.setEmail("Publisher1@gmail.com");
        publisher = publisherDao.addPublisher(publisher);

        // Test deletePublisher method
        publisherDao.deletePublisher(publisher.getPublisher_id());
        Publisher publisherCopy = publisherDao.getPublisher(publisher.getPublisher_id());
        assertNull(publisherCopy);
    }
}
