/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Tests for Publisher DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Console;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Game;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Publisher;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Type;
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
    protected ConsoleInventoryDao consoleDao;
    @Autowired
    protected GameInventoryDao gameDao;
    @Autowired
    protected PublisherInventoryDao publisherDao;
    @Autowired
    protected TypeInventoryDao typeDao;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the Game table in the database
        List<Game> gameList = gameDao.getAllGame();
        gameList.forEach(game -> gameDao.deleteGame(game.getGame_id()));

        // Clean up the Console table in the database
        List<Console> consoleList = consoleDao.getAllConsole();
        consoleList.forEach(console -> consoleDao.deleteConsole(console.getConsole_id()));

        // Clean up the Publisher table in the database
        List<Publisher> publisherList = publisherDao.getAllPublisher();
        publisherList.forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));

        // Clean up the Type table in the database
        List<Type> typeList = typeDao.getAllType();
        typeList.forEach(type -> typeDao.deleteType(type.getType_id()));
    }

    // CRUD Method Tests
    @Test
    public void addGetDeletePublisher() {
        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Activision");
        publisher.setWebsite("www.activision.com");
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
    public void getAllPublisher() {
        // Create and add a Publisher object (publisher1)
        Publisher publisher1 = new Publisher();
        publisher1.setName("Activision");
        publisher1.setWebsite("www.activision.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        // Create and add a Publisher object (publisher2)
        Publisher publisher2 = new Publisher();
        publisher2.setName("Nintendo");
        publisher2.setWebsite("www.nintendo.com");
        publisher2 = publisherDao.addPublisher(publisher2);

        // Get all Publisher entries from the database
        List<Publisher> publisherList = publisherDao.getAllPublisher();

        // Test the getAllPublisher() method works correctly
        assertEquals(2, publisherList.size());
    }

    @Test
    public void updatePublisher() {
        // Create and add a Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Activision");
        publisher.setWebsite("www.activision.com");
        publisher = publisherDao.addPublisher(publisher);

        // Update the values of Publisher object
        publisher.setName("Nintendo");
        publisher.setWebsite("www.nintendo.com");
        publisherDao.updatePublisher(publisher);

        // Create a copy of the new Publisher
        Publisher publisherCopy = publisherDao.getPublisher(publisher.getPublisher_id());

        // Test that publisher and publisherCopy are equal
        assertEquals(publisher, publisherCopy);
    }
}
