/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Book Inventory DAO Tests for CRUD Methods.
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookInventoryDaoTest {
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
     * Testing the addBook() CRUD method.
     */
    public void addGetDeleteBook() {
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

        // Create and add a new Book object
        Book book = new Book();
        book.setIsbn("123456789");
        book.setPublish_date(LocalDate.of(2019,1,10));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Test Book for the Ages");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        book = bookDao.addBook(book);

        // Create a new Book variable to hold the identical Book
        Book bookCopy = bookDao.getBook(book.getBook_id());

        // Test addBook and getBook methods
        assertEquals(bookCopy, book);
    }

    @Test
    /**
     * Test the getBook() CRUD method.
     */
    public void getBook() {
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

        // Create and add a new Book object
        Book book = new Book();
        book.setIsbn("123456789");
        book.setPublish_date(LocalDate.of(2019,1,10));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Test Book for the Ages");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        book = bookDao.addBook(book);

        // Create a new Book variable to hold the identical Book
        Book bookCopy = bookDao.getBook(book.getBook_id());

        // Test addBook and getBook methods
        assertEquals(bookCopy, book);
    }

    @Test
    /**
     * Testing the getAllBook() CRUD method.
     */
    public void getAllBook() {
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

        // Create and add a new Book object (book1)
        Book book1 = new Book();
        book1.setIsbn("123456789");
        book1.setPublish_date(LocalDate.of(2019,1,10));
        book1.setAuthor_id(author.getAuthor_id());
        book1.setTitle("Test Book for the Ages");
        book1.setPublisher_id(publisher.getPublisher_id());
        book1.setPrice(new BigDecimal("9.99"));
        book1 = bookDao.addBook(book1);

        // Create and add a new Book object (book2)
        Book book2 = new Book();
        book2.setIsbn("1112223344");
        book2.setPublish_date(LocalDate.of(2010,2,15));
        book2.setAuthor_id(author.getAuthor_id());
        book2.setTitle("Awesome Test Book 2");
        book2.setPublisher_id(publisher.getPublisher_id());
        book2.setPrice(new BigDecimal("4.67"));
        book2 = bookDao.addBook(book2);

        // Get all Book entries from the database
        List<Book> bookList = bookDao.getAllBook();

        // Test the getAllBook() method works correctly
        assertEquals(2, bookList.size());
    }

    @Test
    /**
     * Testing the getBookByAuthor() method.
     */
    public void getBookByAuthor() {
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

        // Create and add a new Book object (book1)
        Book book1 = new Book();
        book1.setIsbn("123456789");
        book1.setPublish_date(LocalDate.of(2019,1,10));
        book1.setAuthor_id(author1.getAuthor_id());
        book1.setTitle("Test Book for the Ages");
        book1.setPublisher_id(publisher.getPublisher_id());
        book1.setPrice(new BigDecimal("9.99"));
        book1 = bookDao.addBook(book1);

        // Create and add a new Book object (book2)
        Book book2 = new Book();
        book2.setIsbn("1112223344");
        book2.setPublish_date(LocalDate.of(2010,2,15));
        book2.setAuthor_id(author2.getAuthor_id());
        book2.setTitle("Awesome Test Book 2");
        book2.setPublisher_id(publisher.getPublisher_id());
        book2.setPrice(new BigDecimal("4.67"));
        book2 = bookDao.addBook(book2);

        // Create and add a new Book object (book3)
        Book book3 = new Book();
        book3.setIsbn("1112223344");
        book3.setPublish_date(LocalDate.of(2010,2,15));
        book3.setAuthor_id(author2.getAuthor_id());
        book3.setTitle("Awesome Test Book 2");
        book3.setPublisher_id(publisher.getPublisher_id());
        book3.setPrice(new BigDecimal("4.67"));
        book3 = bookDao.addBook(book3);

        // Create author1List with all Book's with author1 id.
        // Create author2List with all Book's with author2 id.
        List<Book> author1List = bookDao.getBookByAuthor(author1.getAuthor_id());
        List<Book> author2List = bookDao.getBookByAuthor(author2.getAuthor_id());

        // Test that there is 1 book with author1 id
        // Test that there is 2 book's with author2 id
        // This tests the functionality of the getBookByAuthor method
        assertEquals(1, author1List.size());
        assertEquals(2, author2List.size());
    }

    @Test
    /**
     * Testing the updateBook() CRUD method.
     */
    public void updateBook() {
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

        // Create and add a new Book object
        Book book = new Book();
        book.setIsbn("123456789");
        book.setPublish_date(LocalDate.of(2019,1,10));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Test Book for the Ages");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        book = bookDao.addBook(book);

        // Update the book object with new properties and add to the database
        book.setIsbn("1112223344");
        book.setPublish_date(LocalDate.of(2010,2,15));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Awesome Test Book 2");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("4.67"));
        bookDao.updateBook(book);

        // Create a copy of the new book
        Book bookCopy = bookDao.getBook(book.getBook_id());

        // Test that book and bookCopy are equal
        assertEquals(bookCopy, book);
    }

    @Test
    /**
     * Test the deleteBook() CRUD method.
     */
    public void deleteBook() {
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

        // Create and add a new Book object
        Book book = new Book();
        book.setIsbn("123456789");
        book.setPublish_date(LocalDate.of(2019,1,10));
        book.setAuthor_id(author.getAuthor_id());
        book.setTitle("Test Book for the Ages");
        book.setPublisher_id(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("9.99"));
        book = bookDao.addBook(book);

        // Test deleteBook method
        bookDao.deleteBook(book.getBook_id());
        Book bookCopy = bookDao.getBook(book.getBook_id());
        assertNull(bookCopy);
    }

    @Test(expected = DataIntegrityViolationException.class)
    /**
     * Testing that you cannot add a book to the database with an
     * invalid author_id or publisher_id.
     */
    public void addWithRefIntegrityException() {
        // Create and add a book to the database with a
        // publisher_id & author_id that hasn't been created
        // should throw a DataIntegrityViolationException error
        Book book = new Book();
        book.setIsbn("123456789");
        book.setPublish_date(LocalDate.of(2019,1,10));
        book.setAuthor_id(999);
        book.setTitle("Test Book for the Ages");
        book.setPublisher_id(999);
        book.setPrice(new BigDecimal("9.99"));
        book = bookDao.addBook(book);
    }
}
