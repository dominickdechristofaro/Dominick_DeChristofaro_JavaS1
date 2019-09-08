/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Tests for Console DAO.
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
public class ConsoleInventoryDaoTest {
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
    public void addGetDeleteConsole() {
        // Create and add a new Console object
        Console console = new Console();
        console.setName("PlayStation 4");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        // Create a new Console variable to hold the identical Console
        Console consoleCopy = consoleDao.getConsole(console.getConsole_id());

        // Test addConsole and getConsole methods
        assertEquals(consoleCopy, console);

        // Test deleteConsole method
        consoleDao.deleteConsole(console.getConsole_id());
        consoleCopy = consoleDao.getConsole(console.getConsole_id());
        assertNull(consoleCopy);
    }

    @Test
    public void getAllConsole() {
        // Create and add a Console object (console1)
        Console console1 = new Console();
        console1.setName("PlayStation 4");
        console1.setYear("2015");
        console1 = consoleDao.addConsole(console1);

        // Create and add a Console object (console2)
        Console console2 = new Console();
        console2.setName("Switch");
        console2.setYear("2016");
        console2 = consoleDao.addConsole(console2);

        // Get all Console entries from the database
        List<Console> consoleList = consoleDao.getAllConsole();

        // Test the getAllConsole() method works correctly
        assertEquals(2, consoleList.size());
    }

    @Test
    public void updateConsole() {
        // Create and add a Console object
        Console console = new Console();
        console.setName("PlayStation 4");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        // Update the values of Console object
        console.setName("PlayStation 5");
        console.setYear("2020");
        consoleDao.updateConsole(console);

        // Create a copy of the new Console
        Console consoleCopy = consoleDao.getConsole(console.getConsole_id());

        // Test that console and consoleCopy are equal
        assertEquals(console, consoleCopy);
    }
}
