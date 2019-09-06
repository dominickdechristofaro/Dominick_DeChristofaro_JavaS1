/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Tests for the Car Inventory DAO API.
 *************************************************************************************************/
package com.company.CarLotDaoDominickDeChristofaro.dao;
import com.company.CarLotDaoDominickDeChristofaro.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarInventoryDaoTest {

    @Autowired
    protected CarInventoryDao dao;

    @Before
    public void setUp() throws Exception {
        // clean out the test database before every test is run
        List<Car> carList = dao.getAllCars();
        carList.forEach(car -> dao.deleteCar(car.getId()));
    }

    @Test
    public void addGetDeleteCar() {
        // Create a new Car object
        Car car = new Car();
        car.setMake("Honda");
        car.setModel("Civic");
        car.setYear("2019");
        car.setColor("Silver");

        // Add the newly created car to the database
        // Will return with the auto-generated id associated with it.
        car = dao.addCar(car);

        // Create a new variable to hold a car object that
        // has the same properties as the original car object
        Car car2 = dao.getCar(car.getId());

        // Compares the values of car and car2 to see if they are equal
        // Test for the addCar and getCar functions
        assertEquals(car, car2);

        // Delete Car from the database by id
        dao.deleteCar(car.getId());

        // Get car from the database and assign it to car2
        car2 = dao.getCar(car.getId());

        // Test for the delete method.  car2 should equal null.
        assertNull(car2);
    }

    @Test
    public void getAllCars() {
        // Create a new Car for the database
        Car car1 = new Car();
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setYear("2019");
        car1.setColor("Blue");

        // Create a second new Car for the database
        Car car2 = new Car();
        car2.setMake("Toyota");
        car2.setModel("Camery");
        car2.setYear("2000");
        car2.setColor("Red");

        // Add car1 and car2 to the database
        dao.addCar(car1);
        dao.addCar(car2);

        // Get all Car objects withing the database into a single list
        List<Car> carList = dao.getAllCars();

        // Test that the method functioned correctly
        assertEquals(2, carList.size());
    }

    @Test
    public void updateMotorcycle() {
        // Create a new Car object
        Car car1 = new Car();
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setYear("2019");
        car1.setColor("Blue");

        // Add the Car to the database
        car1 = dao.addCar(car1);

        // Create an updated car
        car1.setMake("Toyota");
        car1.setModel("Camery");
        car1.setYear("2015");
        car1.setColor("Yellow");

        dao.updateCar(car1);

        // Create a new variable with the same properties as car1
        Car car2 = dao.getCar(car1.getId());

        // Check if car2 has the same properties as car1
        assertEquals(car1, car2);
    }

    @Test
    public void getCarByMake() {
        // Create a new Car for the database
        Car car1 = new Car();
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setYear("2019");
        car1.setColor("Blue");

        // Create a second new Car for the database
        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear("2000");
        car2.setColor("Red");

        // Add both the new cars to the database
        dao.addCar(car1);
        dao.addCar(car2);

        // Get all the Car objects with the queried make from the database
        // into a single list
        List<Car> carList = dao.getCarsByMake("Honda");

        // Test the getCarByMake method
        assertEquals(2, carList.size());
    }

    @Test
    public void getCarByColor() {
        // Create a new Car for the database
        Car car1 = new Car();
        car1.setMake("Honda");
        car1.setModel("Civic");
        car1.setYear("2019");
        car1.setColor("Blue");

        // Create a second new Car for the database
        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear("2000");
        car2.setColor("Blue");

        // Add both the new cars to the database
        dao.addCar(car1);
        dao.addCar(car2);

        // Get all the Car objects with the queried make from the database
        // into a single list
        List<Car> carList = dao.getCarsByColor("Blue");

        // Test the getCarByMake method
        assertEquals(2, carList.size());
    }
}
