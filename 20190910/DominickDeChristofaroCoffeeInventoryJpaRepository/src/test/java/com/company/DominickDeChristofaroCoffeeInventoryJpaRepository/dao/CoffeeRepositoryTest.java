package com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dao;
import com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dto.Coffee;
import com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dto.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeRepositoryTest {
    // Properties
    @Autowired
    protected CoffeeRepository coffeeRepository;
    @Autowired
    protected RoasterRepository roasterRepository;

    private Roaster roaster1;
    private Roaster roaster2;
    private Coffee coffee1;
    private Coffee coffee2;
    private Coffee coffee3;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the database
        coffeeRepository.deleteAll();
        roasterRepository.deleteAll();

        // Create and add a Roaster object to the database
        roaster1 = new Roaster();
        roaster1.setName("Default Roaster");
        roaster1.setStreet("123 Test Lane");
        roaster1.setCity("Crossville");
        roaster1.setState("TN");
        roaster1.setPostalCode("38555");
        roaster1.setPhone("9312005591");
        roaster1.setEmail("defaultRoaster@gmail.com");
        roaster1.setNote("Default Roaster Note");
        roasterRepository.save(roaster1);

        // Create a new Roaster object and add it to the database
        roaster2 = new Roaster();
        roaster2.setName("Michael Stuckey");
        roaster2.setStreet("456 Test Lane");
        roaster2.setCity("Atlanta");
        roaster2.setState("GA");
        roaster2.setPostalCode("95738");
        roaster2.setPhone("2064229874");
        roaster2.setEmail("michaelstuckey@gmail.com");
        roaster2.setNote("Default Roaster 2");
        roasterRepository.save(roaster2);

        // Create and add a Coffee object to the database
        coffee1 = new Coffee();
        coffee1.setRoasterId(roaster1.getId());
        coffee1.setName("Default Coffee Name");
        coffee1.setCount(10);
        coffee1.setUnitPrice(new BigDecimal("12.50"));
        coffee1.setDescription("Medium Brew Coffee");
        coffee1.setType("Regular");
        coffeeRepository.save(coffee1);

        // Create and add a Coffee object to the database
        coffee2 = new Coffee();
        coffee2.setRoasterId(roaster2.getId());
        coffee2.setName("2nd Coffee Name");
        coffee2.setCount(20);
        coffee2.setUnitPrice(new BigDecimal("15.50"));
        coffee2.setDescription("Light Brew Coffee");
        coffee2.setType("Medium");
        coffeeRepository.save(coffee2);

        // Create and add a Coffee object to the database
        coffee3 = new Coffee();
        coffee3.setRoasterId(roaster2.getId());
        coffee3.setName("3rd Coffee Name");
        coffee3.setCount(20);
        coffee3.setUnitPrice(new BigDecimal("17.50"));
        coffee3.setDescription("Dark Brew Coffee");
        coffee3.setType("Medium");
        coffeeRepository.save(coffee3);
    }

    @Test
    public void addGetDeleteCoffee() {
        // Create a copy of the Coffee object
        Coffee coffeeCopy = coffeeRepository.findOne(coffee1.getId());

        // Test the add and get methods for coffee
        assertEquals(coffee1, coffeeCopy);

        // Delete the coffee from the database
        coffeeRepository.delete(coffee1);
        coffeeCopy = coffeeRepository.findOne(coffee1.getId());

        // Test the delete method works
        assertNull(coffeeCopy);
    }

    @Test
    public void getAllCoffee() {
        // Get all the Coffee's in a list
        List<Coffee> coffeeList = coffeeRepository.findAll();

        // Test the findAll()
        assertEquals(3, coffeeList.size());

    }

    @Test
    public void getCoffeeByRoaster() {
        // Get all the Coffee's in a list
        List<Coffee> coffeeList1 = coffeeRepository.findCoffeeByRoasterId(roaster1.getId());
        List<Coffee> coffeeList2 = coffeeRepository.findCoffeeByRoasterId(roaster2.getId());

        // Test the findCoffeeByRoasterId()
        assertEquals(1, coffeeList1.size());
        assertEquals(2, coffeeList2.size());
    }

    @Test
    public void getCoffeeByType() {
        // Get all the Coffee's by Type in a list
        List<Coffee> coffeeList1 = coffeeRepository.findCoffeeByType("Regular");
        List<Coffee> coffeeList2 = coffeeRepository.findCoffeeByType("Medium");

        // Test the findCoffeeByType()
        assertEquals(1, coffeeList1.size());
        assertEquals(2, coffeeList2.size());
    }

    @Test
    public void getCoffeeByRoasterAndType() {
        // Get all the Coffee's by Roaster and Type in a list
        List<Coffee> coffeeList1 = coffeeRepository.findCoffeeByRoasterIdAndType(roaster1.getId(), "Regular");
        List<Coffee> coffeeList2 = coffeeRepository.findCoffeeByRoasterIdAndType(roaster2.getId(), "Medium");

        // Test the findCoffeeByType()
        assertEquals(1, coffeeList1.size());
        assertEquals(2, coffeeList2.size());
    }

    @Test
    public void updateCoffee() {
        // Update coffee1
        coffee1.setName("Updated Name");
        coffee1.setRoasterId(roaster2.getId());
        coffee1.setType("Update");
        coffee1.setDescription("Updated Description");
        coffee1.setCount(77);
        coffee1.setUnitPrice(new BigDecimal("66.54"));
        coffeeRepository.save(coffee1);

        Coffee coffeeCopy = coffeeRepository.findOne(coffee1.getId());
        assertEquals(coffeeCopy, coffee1);
    }

    @Test
    public void deleteCoffee() {
        coffeeRepository.delete(coffee3);
        Coffee coffeeCopy = coffeeRepository.findOne(coffee3.getId());
        assertNull(coffeeCopy);
    }
}