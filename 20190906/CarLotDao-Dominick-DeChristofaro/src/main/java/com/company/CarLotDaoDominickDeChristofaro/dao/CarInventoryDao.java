/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Interface for the Car Inventory Data Access Object (DAO) that uses (CRUD)
 *                  methodology (Create, Read, Update, and Delete).  Also includes 2 additional
 *                  methods to search for cars by make and color.
 *************************************************************************************************/
package com.company.CarLotDaoDominickDeChristofaro.dao;
import com.company.CarLotDaoDominickDeChristofaro.model.Car;
import java.util.List;

public interface CarInventoryDao {

    // Implement Create, Read, Update, Delete (CRUD) methodology

    /**
     * C: Create methodology
     * Add a new Car to the database.
     *
     * @param car The Car to add to the database.
     * @return The Car that was added to the database.
     */
    Car addCar(Car car);

    /**
     * R: Read methodology.
     * Get a single Car from the database by the id of the Car.
     *
     * @param id The id of the Car to retrieve from the database.
     * @return A single Car of the id specified.
     */
    Car getCar(int id);

    /**
     * R: Read methodology.
     * Get all Cars from the database.
     *
     * @return A list of all the Cars in the database.
     */
    List<Car> getAllCars();

    /**
     * U: Update methodology.
     * Update a Car with the matching id of the car parameter passed.
     *
     * @param car The Car with the new properties.
     */
    void updateCar(Car car);

    /**
     * D: Delete methodology.
     * Deletes a Car with the matching id parameter from the database.
     *
     * @param id The id of the Car to delete from the database.
     */
    void deleteCar(int id);

    /**
     * List all the Cars by the specified make.
     *
     * @param make The make of Car the user is searching for.
     * @return A list of all Cars with the user input make.
     */
    List<Car> getCarsByMake(String make);

    /**
     * List all the Cars by the specified color.
     *
     * @param color The color of the Car the user is searching for.
     * @return A list of all Cars with the user input color.
     */
    List<Car> getCarsByColor(String color);
}
