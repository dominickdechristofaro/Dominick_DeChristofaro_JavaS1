/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Tests for Type DAO.
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
public class TypeInventoryDaoTest {
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
    public void addGetDeleteType() {
        // Create and add a new Type object
        Type type = new Type();
        type.setName("Action");
        type.setDescription("High energy action based games");
        type = typeDao.addType(type);

        // Create a new Type variable to hold the identical Type
        Type typeCopy = typeDao.getType(type.getType_id());

        // Test addType and getType methods
        assertEquals(typeCopy, type);

        // Test deleteType method
        typeDao.deleteType(type.getType_id());
        typeCopy = typeDao.getType(type.getType_id());
        assertNull(typeCopy);
    }

    @Test
    public void getAllType() {
        // Create and add a Type object (type1)
        Type type1 = new Type();
        type1.setName("Action");
        type1.setDescription("High energy action based games");
        type1 = typeDao.addType(type1);

        // Create and add a Type object (type2)
        Type type2 = new Type();
        type2.setName("Music");
        type2.setDescription("Music based video game");
        type2 = typeDao.addType(type2);

        // Get all Type entries from the database
        List<Type> typeList = typeDao.getAllType();

        // Test the getAllType() method works correctly
        assertEquals(2, typeList.size());
    }

    @Test
    public void updateType() {
        // Create and add a Type object
        Type type = new Type();
        type.setName("Action");
        type.setDescription("High energy action based games");
        type = typeDao.addType(type);

        // Update the values of Type object
        type.setName("Music");
        type.setDescription("Music based video game");
        typeDao.updateType(type);

        // Create a copy of the new Type
        Type typeCopy = typeDao.getType(type.getType_id());

        // Test that type and typeCopy are equal
        assertEquals(type, typeCopy);
    }
}
