/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Tests for Game DAO.
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameInventoryDaoTest {
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

    // CRUD Methods
    @Test
    public void addGetDeleteGame() {
        // Create and add a new Console object
        Console console = new Console();
        console.setName("PlayStation 4");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Activision");
        publisher.setWebsite("www.activision.com");
        publisher = publisherDao.addPublisher(publisher);

        // Create and add a new Type object
        Type type = new Type();
        type.setName("Action");
        type.setDescription("High energy action based games");
        type = typeDao.addType(type);

        // Create and add a new Game object
        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        // Create a new Game variable to hold the identical Game
        Game gameCopy = gameDao.getGame(game.getGame_id());

        // Test addGame and getGame methods
        assertEquals(gameCopy, game);

        // Test deleteGame method
        gameDao.deleteGame(game.getGame_id());
        gameCopy = gameDao.getGame(game.getGame_id());
        assertNull(gameCopy);
    }

    @Test
    public void getAllGame() {
        // Create and add a new Console object
        Console console = new Console();
        console.setName("PlayStation 4");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Activision");
        publisher.setWebsite("www.activision.com");
        publisher = publisherDao.addPublisher(publisher);

        // Create and add a new Type object
        Type type = new Type();
        type.setName("Action");
        type.setDescription("High energy action based games");
        type = typeDao.addType(type);

        // Create and add a new Game object (game1)
        Game game1 = new Game();
        game1.setConsole_id(console.getConsole_id());
        game1.setPublisher_id(publisher.getPublisher_id());
        game1.setType_id(type.getType_id());
        game1 = gameDao.addGame(game1);

        // Create and add a new Game object (game2)
        Game game2 = new Game();
        game2.setConsole_id(console.getConsole_id());
        game2.setPublisher_id(publisher.getPublisher_id());
        game2.setType_id(type.getType_id());
        game2 = gameDao.addGame(game2);

        // Get all game entries from the database
        List<Game> gameList = gameDao.getAllGame();

        // Test that the getAllGame() method works correctly
        assertEquals(2, gameList.size());
    }

    @Test
    public void getGameByConsole() {
        // Create and add a new Console object (console1)
        Console console1 = new Console();
        console1.setName("PlayStation 4");
        console1.setYear("2015");
        console1 = consoleDao.addConsole(console1);

        // Add a second type of Console (console2)
        Console console2 = new Console();
        console2.setName("Switch");
        console2.setYear("2016");
        console2 = consoleDao.addConsole(console2);

        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Activision");
        publisher.setWebsite("www.activision.com");
        publisher = publisherDao.addPublisher(publisher);

        // Create and add a new Type object
        Type type = new Type();
        type.setName("Action");
        type.setDescription("High energy action based games");
        type = typeDao.addType(type);

        // Create and add a new Game object with console1
        Game game = new Game();
        game.setConsole_id(console1.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        // Create and add a new Game object with console2
        game = new Game();
        game.setConsole_id(console2.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        // Create and add a new Game object with console2
        game = new Game();
        game.setConsole_id(console2.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        // Create a list with all game's with console1 id
        List<Game> gameList = gameDao.getGameByConsole(console1.getConsole_id());
        assertEquals(1, gameList.size());

        gameList = gameDao.getGameByConsole(console2.getConsole_id());
        assertEquals(2, gameList.size());
    }

    @Test
    public void getGameByPublisher() {
        // Create and add a new Console object
        Console console = new Console();
        console.setName("PlayStation 4");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        // Create and add a new Publisher object (publisher1)
        Publisher publisher1 = new Publisher();
        publisher1.setName("Activision");
        publisher1.setWebsite("www.activision.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        // Create and add a new Publisher object (publisher2)
        Publisher publisher2 = new Publisher();
        publisher2.setName("Nintendo");
        publisher2.setWebsite("www.nintendo.com");
        publisher2 = publisherDao.addPublisher(publisher2);

        // Create and add a new Type object
        Type type = new Type();
        type.setName("Action");
        type.setDescription("High energy action based games");
        type = typeDao.addType(type);

        // Create and add a new Game object with publisher1
        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher1.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        // Create and add a new Game object with publisher2
        game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher2.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        // Create and add a new Game object with publisher2
        game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher2.getPublisher_id());
        game.setType_id(type.getType_id());
        game = gameDao.addGame(game);

        // Create and test a list with all game's with publisher1 id's
        List<Game> gameList = gameDao.getGameByPublisher(publisher1.getPublisher_id());
        assertEquals(1, gameList.size());

        // Create and test a list with all game's with publisher2 id's
        gameList = gameDao.getGameByPublisher(publisher2.getPublisher_id());
        assertEquals(2, gameList.size());
    }

    @Test
    public void getGameByType() {
        // Create and add a new Console object
        Console console = new Console();
        console.setName("PlayStation 4");
        console.setYear("2015");
        console = consoleDao.addConsole(console);

        // Create and add a new Publisher object
        Publisher publisher = new Publisher();
        publisher.setName("Activision");
        publisher.setWebsite("www.activision.com");
        publisher = publisherDao.addPublisher(publisher);

        // Create and add a new Type object (type1)
        Type type1 = new Type();
        type1.setName("Action");
        type1.setDescription("High energy action based games");
        type1 = typeDao.addType(type1);

        // Create and add a new Type object (type2)
        Type type2 = new Type();
        type2.setName("Music");
        type2.setDescription("Music game with rhythm");
        type2 = typeDao.addType(type2);

        // Create and add a new Game object with type1
        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type1.getType_id());
        game = gameDao.addGame(game);

        // Create and add a new Game object with type2
        game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type2.getType_id());
        game = gameDao.addGame(game);

        // Create and add a new Game object with type2
        game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type2.getType_id());
        game = gameDao.addGame(game);

        // Create and test a list with all game's with type1 id's
        List<Game> gameList = gameDao.getGameByType(type1.getType_id());
        assertEquals(1, gameList.size());

        // Create and test a list with all game's with publisher2 id's
        gameList = gameDao.getGameByType(type2.getType_id());
        assertEquals(2, gameList.size());
    }

    @Test
    public void updateGame() {
        // Create and add a new Console object (console1)
        Console console1 = new Console();
        console1.setName("PlayStation 4");
        console1.setYear("2015");
        console1 = consoleDao.addConsole(console1);

        // Add a second type of Console (console2)
        Console console2 = new Console();
        console2.setName("Switch");
        console2.setYear("2016");
        console2 = consoleDao.addConsole(console2);

        // Create and add a new Publisher object (publisher1)
        Publisher publisher1 = new Publisher();
        publisher1.setName("Activision");
        publisher1.setWebsite("www.activision.com");
        publisher1 = publisherDao.addPublisher(publisher1);

        // Create and add a new Publisher object (publisher2)
        Publisher publisher2 = new Publisher();
        publisher2.setName("Nintendo");
        publisher2.setWebsite("www.nintendo.com");
        publisher2 = publisherDao.addPublisher(publisher2);

        // Create and add a new Type object (type1)
        Type type1 = new Type();
        type1.setName("Action");
        type1.setDescription("High energy action based games");
        type1 = typeDao.addType(type1);

        // Create and add a new Type object (type2)
        Type type2 = new Type();
        type2.setName("Music");
        type2.setDescription("Music game with rhythm");
        type2 = typeDao.addType(type2);

        // Create and add a game to the database
        Game game = new Game();
        game.setConsole_id(console1.getConsole_id());
        game.setPublisher_id(publisher1.getPublisher_id());
        game.setType_id(type1.getType_id());
        gameDao.addGame(game);

        // Update the values of game
        game.setConsole_id(console2.getConsole_id());
        game.setPublisher_id(publisher2.getPublisher_id());
        game.setType_id(type2.getType_id());
        gameDao.updateGame(game);

        // Create a copy of the new game
        Game gameCopy = gameDao.getGame(game.getGame_id());

        // Test that game and gameCopy are equal
        assertEquals(game, gameCopy);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {
        // Create and add a game to the database with an unknown
        // ConsoleID, PublisherID, and TypeID, should throw an error
        Game game = new Game();
        game.setConsole_id(999);
        game.setPublisher_id(999);
        game.setType_id(999);
        game = gameDao.addGame(game);
    }
}
