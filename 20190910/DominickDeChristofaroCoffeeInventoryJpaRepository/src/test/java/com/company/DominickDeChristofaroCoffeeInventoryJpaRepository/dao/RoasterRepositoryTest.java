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
public class RoasterRepositoryTest {
    // Properties
    @Autowired
    protected RoasterRepository roasterRepository;
    @Autowired
    protected CoffeeRepository coffeeRepository;

    private Coffee coffee1;
    private Coffee coffee2;
    private Roaster roaster1;
    private Roaster roaster2;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the database
        roasterRepository.deleteAll();

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
    }

    @Test
    public void addGetDeleteRoaster() {
        // Create a copy of the Roaster object
        Roaster roasterCopy = roasterRepository.findOne(roaster1.getId());

        // Test the add and get methods for coffee
        assertEquals(roasterCopy, roaster1);

        // Delete the coffee from the database
        roasterRepository.delete(roaster1);
        roasterCopy = roasterRepository.findOne(roaster1.getId());

        // Test the delete method works
        assertNull(roasterCopy);
    }

    @Test
    public void getAllCoffee() {
        // Get all the Roasters's in a list
        List<Roaster> roasterList = roasterRepository.findAll();

        // Test the findAll()
        assertEquals(2, roasterList.size());
    }

    @Test
    public void updateRoaster() {
        // Update roaster1
        roaster1.setName("Updated Name");
        roaster1.setCity("Atlanta");
        roaster1.setEmail("Test@gmail.com");
        roaster1.setNote("Updated Note");
        roaster1.setPhone("4233309876");
        roaster1.setPostalCode("00098");
        roaster1.setState("GA");
        roaster1.setStreet("667 Test Street");
        roasterRepository.save(roaster1);

        // Test the update
        Roaster roasterCopy = roasterRepository.findOne(roaster1.getId());
        assertEquals(roasterCopy, roaster1);
    }

    @Test
    public void deleteCoffee() {
        roasterRepository.delete(roaster2);
        Roaster roasterCopy = roasterRepository.findOne(roaster2.getId());
        assertNull(roasterCopy);
    }
}
