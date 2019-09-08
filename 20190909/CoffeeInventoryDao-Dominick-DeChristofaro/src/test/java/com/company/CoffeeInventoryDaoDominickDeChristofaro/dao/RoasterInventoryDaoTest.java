/* ************************************************************************************************
 **  Author:         Dominick DeChristofaro
 **  Date:           09/08/2019
 **  Description:    Tests for Roaster DAO.
 **************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.dao;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Coffee;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Roaster;
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
public class RoasterInventoryDaoTest {
    // Properties
    @Autowired
    protected CoffeeInventoryDao coffeeDao;
    @Autowired
    protected RoasterInventoryDao roasterDao;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the Coffee table in the database
        List<Coffee> coffeeList = coffeeDao.getAllCoffee();
        coffeeList.forEach(coffee -> coffeeDao.deleteCoffee(coffee.getCoffee_id()));

        // Clean up the Roaster table in the database
        List<Roaster> roasterList = roasterDao.getAllRoaster();
        roasterList.forEach(roaster -> roasterDao.deleteRoaster(roaster.getRoaster_id()));
    }

    // CRUD Method Tests
    @Test
    public void addGetDeleteRoaster() {
        // Create and add a new Roaster object
        Roaster roaster = new Roaster();
        roaster.setName("Roaster 1");
        roaster.setStreet("123 Test Lane");
        roaster.setCity("Crossvile");
        roaster.setState("TN");
        roaster.setPostal_code("38555");
        roaster.setPhone("9312005591");
        roaster.setEmail("roaster1@gmail.com");
        roaster.setNote("Test Note for Roaster 1");
        roaster = roasterDao.addRoaster(roaster);

        // Create a new Roaster variable to hold the idential Roaster
        Roaster roasterCopy = roasterDao.getRoaster(roaster.getRoaster_id());

        // Test addRoaster and getRoaster methods
        assertEquals(roasterCopy, roaster);

        // Test deleteRoaster method
        roasterDao.deleteRoaster(roaster.getRoaster_id());
        roasterCopy = roasterDao.getRoaster(roaster.getRoaster_id());
        assertNull(roasterCopy);
    }

    @Test
    public void getAllRoaster() {
        // Create and add roaster1 object
        Roaster roaster1 = new Roaster();
        roaster1.setName("Roaster 1");
        roaster1.setStreet("123 Test Lane");
        roaster1.setCity("Crossvile");
        roaster1.setState("TN");
        roaster1.setPostal_code("38555");
        roaster1.setPhone("9312005591");
        roaster1.setEmail("roaster1@gmail.com");
        roaster1.setNote("Test Note for Roaster 1");
        roaster1 = roasterDao.addRoaster(roaster1);

        // Create and add roaster2 object
        Roaster roaster2 = new Roaster();
        roaster2.setName("Roaster 2");
        roaster2.setStreet("456 Example Circle");
        roaster2.setCity("Atlanta");
        roaster2.setState("GA");
        roaster2.setPostal_code("37591");
        roaster2.setPhone("2064229874");
        roaster2.setEmail("roaster2@gmail.com");
        roaster2.setNote("Test Note for Roaster 2");
        roaster2 = roasterDao.addRoaster(roaster2);

        // Get all roaster entries from the database
        List<Roaster> roasterList = roasterDao.getAllRoaster();

        // Test that the getAllRoaster() method works correctly
        assertEquals(2, roasterList.size());
    }

    @Test
    public void updateRoaster() {
        // Create and add roaster object
        Roaster roaster = new Roaster();
        roaster.setName("Roaster");
        roaster.setStreet("123 Test Lane");
        roaster.setCity("Crossvile");
        roaster.setState("TN");
        roaster.setPostal_code("38555");
        roaster.setPhone("9312005591");
        roaster.setEmail("roaster@gmail.com");
        roaster.setNote("Test Note for Roaster");
        roaster = roasterDao.addRoaster(roaster);

        // Update the values of roaster
        roaster.setName("Updated Roaster");
        roaster.setStreet("456 Example Circle");
        roaster.setCity("Atlanta");
        roaster.setState("GA");
        roaster.setPostal_code("37591");
        roaster.setPhone("2064229874");
        roaster.setEmail("UpdatedRoaster@gmail.com");
        roaster.setNote("Test Note for Updated Roaster");
        roasterDao.updateRoaster(roaster);

        // Create a copy of the new Roaster
        Roaster roasterCopy = roasterDao.getRoaster(roaster.getRoaster_id());

        // Test that roaster and roasterCoy are equal
        assertEquals(roaster, roasterCopy);
    }
}
