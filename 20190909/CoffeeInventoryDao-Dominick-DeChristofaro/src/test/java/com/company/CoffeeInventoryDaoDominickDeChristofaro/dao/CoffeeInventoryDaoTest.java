/* ************************************************************************************************
 **  Author:         Dominick DeChristofaro
 **  Date:           09/08/2019
 **  Description:    Tests for Coffee DAO. CRUD methods and searching by roasterID and type.
 **************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.dao;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Coffee;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CoffeeInventoryDaoTest {
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
    public void addGetDeleteCoffee() {
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

        // Create and add a new Coffee object
        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Regular");
        coffee = coffeeDao.addCoffee(coffee);

        // Create a new Coffee variable to hold the identical Coffee
        Coffee coffeeCopy = coffeeDao.getCoffee(coffee.getCoffee_id());

        // Test addCoffee and getCoffee methods
        assertEquals(coffeeCopy, coffee);

        // Test deleteCoffee method
        coffeeDao.deleteCoffee(coffee.getCoffee_id());
        coffeeCopy = coffeeDao.getCoffee(coffee.getCoffee_id());
        assertNull(coffeeCopy);
    }

    @Test
    public void getAllCoffee() {
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

        // Create and add coffee1 to the database
        Coffee coffee1 = new Coffee();
        coffee1.setRoaster_id(roaster.getRoaster_id());
        coffee1.setName("Starbucks House Blend");
        coffee1.setCount(10);
        coffee1.setUnit_price(new BigDecimal("12.50"));
        coffee1.setDescription("Medium Brew Coffee");
        coffee1.setType("Regular");
        coffeeDao.addCoffee(coffee1);

        // Create and add coffee2 to the database
        Coffee coffee2 = new Coffee();
        coffee2.setRoaster_id(roaster.getRoaster_id());
        coffee2.setName("Carabou Coffee");
        coffee2.setCount(20);
        coffee2.setUnit_price(new BigDecimal("11.00"));
        coffee2.setDescription("Light Brew Coffee");
        coffee2.setType("Special");
        coffeeDao.addCoffee(coffee2);

        // Get all coffee entries from the database
        List<Coffee> coffeeList = coffeeDao.getAllCoffee();

        // Test that the getAllCoffee() method works correctly
        assertEquals(2, coffeeList.size());
    }

    @Test
    public void updateCoffee() {
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

        // Create and add coffee to the database
        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Regular");
        coffeeDao.addCoffee(coffee);

        // Update the values of coffee
        coffee.setName("Updated Name");
        coffee.setCount(12);
        coffee.setUnit_price(new BigDecimal("13.00"));
        coffee.setDescription("Light Roast");
        coffee.setType("Foreign");
        coffeeDao.updateCoffee(coffee);

        // Create a copy of the new coffee
        Coffee coffeeCopy = coffeeDao.getCoffee(coffee.getCoffee_id());

        // Test that coffee and coffeeCopy are equal
        assertEquals(coffee, coffeeCopy);
    }

    @Test
    public void getCoffeeByRoasterId() {
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

        // Create and add coffee to the database with roaster1 id
        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster1.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Regular");
        coffeeDao.addCoffee(coffee);

        // Create and add coffee to the database with roaster2 id
        coffee = new Coffee();
        coffee.setRoaster_id(roaster2.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Regular");
        coffeeDao.addCoffee(coffee);

        // Create and add coffee to the database with roaster2 id
        coffee = new Coffee();
        coffee.setRoaster_id(roaster2.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Regular");
        coffeeDao.addCoffee(coffee);

        // Create a list with all coffee's with roaster1 id
        List<Coffee> coffeeList = coffeeDao.getCoffeeByRoasterId(roaster1.getRoaster_id());
        assertEquals(1, coffeeList.size());

        coffeeList = coffeeDao.getCoffeeByRoasterId(roaster2.getRoaster_id());
        assertEquals(2, coffeeList.size());
    }

    @Test
    public void getCoffeeByType() {
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

        // Create and add coffee to the database with roaster id
        Coffee coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Regular");
        coffeeDao.addCoffee(coffee);

        // Create and add coffee to the database with roaster2 id
        coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Bold");
        coffeeDao.addCoffee(coffee);

        // Create and add coffee to the database with roaster2 id
        coffee = new Coffee();
        coffee.setRoaster_id(roaster.getRoaster_id());
        coffee.setName("Starbucks House Blend");
        coffee.setCount(10);
        coffee.setUnit_price(new BigDecimal("12.50"));
        coffee.setDescription("Medium Brew Coffee");
        coffee.setType("Bold");
        coffeeDao.addCoffee(coffee);

        // Create a list with all coffee's with roaster1 id
        List<Coffee> coffeeList = coffeeDao.getCoffeeByType("Regular");
        assertEquals(1, coffeeList.size());

        coffeeList = coffeeDao.getCoffeeByType("Bold");
        assertEquals(2, coffeeList.size());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {
        // Create and add a coffee to the database with an unknown
        // roasterID, should throw an error.
        Coffee coffee = new Coffee();
        coffee.setRoaster_id(999);
        coffee.setName("Reference Exception Test");
        coffee.setCount(12);
        coffee.setUnit_price(new BigDecimal("11.00"));
        coffee.setDescription("Test");
        coffee.setType("Test");
        coffee = coffeeDao.addCoffee(coffee);
    }
}
