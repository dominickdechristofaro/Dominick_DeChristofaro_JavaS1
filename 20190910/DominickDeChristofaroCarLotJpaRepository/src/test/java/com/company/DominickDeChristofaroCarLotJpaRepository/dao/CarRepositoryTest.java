package com.company.DominickDeChristofaroCarLotJpaRepository.dao;
import com.company.DominickDeChristofaroCarLotJpaRepository.dto.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRepositoryTest {
    @Autowired
    protected CarRepository carRepository;

    private Car car1;
    private Car car2;

    // setUp()
    public void setUP() throws Exception {
        // Clean up the database
        carRepository.deleteAll();

        // Create and add a Car object to the database
        car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Camry");
        car1.setYear("2000");
        car1.setColor("Red");

        // Create and add a Car object to the database
        car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear("2010");
        car2.setColor("Yellow");
    }

    @Test
    public void addGetDeleteCar() {
        // Create a copy of the Car object
        Car carCopy = carRepository.findOne(car1.getId());

        // Test the add and get methods for coffee
        assertEquals(carCopy, car1);

        // Delete the coffee from the database
        carRepository.delete(car1);
        carCopy = carRepository.findOne(car1.getId());

        // Test the delete method works
        assertNull(carCopy);
    }

    @Test
    public void updateCar() { ;
        car1.setMake("Motorcycle");
        car1.setModel("update");
        car1.setYear("2222");
        car1.setColor("Rainbow");
    }

    @Test
    public void deleteCoffee() {
        carRepository.delete(car1);
        Car carCopy = carRepository.findOne(car1.getId());
        assertNull(carCopy);
    }
}
