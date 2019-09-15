/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Author Inventory DAO Tests for CRUD Methods.
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
public class AuthorInventoryDaoTest {
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
     * Testing the addAuthor() CRUD method.
     */
    public void addGetDeleteAuthor() {
        // Create and add a new Author object
        Author author = new Author();
        author.setFirst_name("Dominick");
        author.setLast_name("DeChristofaro");
        author.setStreet("123 Test Lane");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("24567");
        author.setPhone("9999999999");
        author.setEmail("Author1@gmail.com");
        author = authorDao.addAuthor(author);

        // Create a new Author variable to hold the identical Author
        Author authorCopy = authorDao.getAuthor(author.getAuthor_id());

        // Test addAuthor and getAuthor methods
        assertEquals(authorCopy, author);
    }

    @Test
    /**
     * Testing the getAuthor() CRUD method.
     */
    public void getAuthor() {
        // Create and add a new Author object
        Author author = new Author();
        author.setFirst_name("Dominick");
        author.setLast_name("DeChristofaro");
        author.setStreet("123 Test Lane");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("24567");
        author.setPhone("9999999999");
        author.setEmail("Author1@gmail.com");
        author = authorDao.addAuthor(author);

        // Create a new Author variable to hold the identical Author
        Author authorCopy = authorDao.getAuthor(author.getAuthor_id());

        // Test addAuthor and getAuthor methods
        assertEquals(authorCopy, author);
    }

    @Test
    /**
     * Testing the getAllAuthor() CRUD method.
     */
    public void getAllAuthor() {
        // Create and add a Author object (author1)
        Author author1 = new Author();
        author1.setFirst_name("Dominick");
        author1.setLast_name("DeChristofaro");
        author1.setStreet("123 Test Lane");
        author1.setCity("Atlanta");
        author1.setState("GA");
        author1.setPostal_code("24567");
        author1.setPhone("9999999999");
        author1.setEmail("Author1@gmail.com");
        author1 = authorDao.addAuthor(author1);

        // Create and add a Author object (author2)
        Author author2 = new Author();
        author2.setFirst_name("Michael");
        author2.setLast_name("Stuckey");
        author2.setStreet("456 Awesome Circle");
        author2.setCity("Asheville");
        author2.setState("NC");
        author2.setPostal_code("28804");
        author2.setPhone("2064229874");
        author2.setEmail("Author2@gmail.com");
        author2 = authorDao.addAuthor(author2);

        // Get all Author entries from the database
        List<Author> authorList = authorDao.getAllAuthor();

        // Test the getAllAuthor() method works correctly
        assertEquals(2, authorList.size());
    }

    @Test
    /**
     * Testing the updateAuthor() CRUD method.
     */
    public void updateAuthor() {
        // Create and add a new Author object
        Author author = new Author();
        author.setFirst_name("Dominick");
        author.setLast_name("DeChristofaro");
        author.setStreet("123 Test Lane");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("24567");
        author.setPhone("9999999999");
        author.setEmail("Author1@gmail.com");
        author = authorDao.addAuthor(author);

        // Update the values of Console object
        author.setFirst_name("Michael");
        author.setLast_name("Stuckey");
        author.setStreet("456 Awesome Circle");
        author.setCity("Asheville");
        author.setState("NC");
        author.setPostal_code("28804");
        author.setPhone("2064229874");
        author.setEmail("Author2@gmail.com");
        authorDao.updateAuthor(author);

        // Create a copy of the new Console
        Author authorCopy = authorDao.getAuthor(author.getAuthor_id());

        // Test that console and consoleCopy are equal
        assertEquals(authorCopy, author);
    }

    @Test
    /**
     * Testing the deleteAuthor() CRUD method.
     */
    public void deleteAuthor() {
        // Create and add a new Author object
        Author author = new Author();
        author.setFirst_name("Dominick");
        author.setLast_name("DeChristofaro");
        author.setStreet("123 Test Lane");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostal_code("24567");
        author.setPhone("9999999999");
        author.setEmail("Author1@gmail.com");
        author = authorDao.addAuthor(author);

        // Test deleteAuthor method
        authorDao.deleteAuthor(author.getAuthor_id());
        Author authorCopy = authorDao.getAuthor(author.getAuthor_id());
        assertNull(authorCopy);
    }
}
