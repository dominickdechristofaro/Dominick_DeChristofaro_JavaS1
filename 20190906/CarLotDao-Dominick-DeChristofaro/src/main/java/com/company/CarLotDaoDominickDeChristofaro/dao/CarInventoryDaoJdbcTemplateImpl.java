/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    The Car Inventory Data Access Object (DAO) methods use (CRUD)
 *                  methodology (Create, Read, Update, and Delete).  Also includes 2 additional
 *                  methods to search for cars by make and color.
 *************************************************************************************************/

package com.company.CarLotDaoDominickDeChristofaro.dao;
import com.company.CarLotDaoDominickDeChristofaro.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarInventoryDaoJdbcTemplateImpl implements CarInventoryDao {

    // Prepared SQL Statements (Constants)
    private static final String INSERT_CAR_SQL =
            "INSERT INTO Car (make, model, year, color) VALUES (?,?,?,?)";
    private static final String SELECT_CAR_SQL =
            "SELECT * FROM Car WHERE id = ?";
    private static final String SELECT_ALL_CARS_SQL =
            "SELECT * FROM Car";
    private static final String DELETE_CAR_SQL =
            "DELETE FROM Car WHERE id = ?";
    private static final String UPDATE_CAR_SQL =
            "UPDATE Car SET make = ?, model = ?, year = ?, color = ? WHERE id = ?";
    private static final String SELECT_CARS_BY_MAKE_SQL =
            "SELECT * FROM Car WHERE make = ?";
    private static final String SELECT_CARS_BY_COLOR_SQL =
            "SELECT * FROM Car WHERE color = ?";

    // Property
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public CarInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * C: Create methodology
     * Add a new Car to the database.
     *
     * @param car The Car to add to the database.
     * @return The Car that was added to the database.
     */
    @Override
    @Transactional
    public Car addCar(Car car) {
        jdbcTemplate.update(INSERT_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

        car.setId(id);
        return car;
    }

    /**
     * R: Read methodology.
     * Get a single Car from the database by the id of the Car.
     *
     * @param id The id of the Car to retrieve from the database.
     * @return A single Car of the id specified.
     */
    @Override
    public Car getCar(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_CAR_SQL, this::mapRowToCar, id);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the execption and return null
            return null;
        }
    }

    /**
     * R: Read methodology.
     * Get all Cars from the database.
     *
     * @return A list of all the Cars in the database.
     */
    @Override
    public List<Car> getAllCars() {
        return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
    }

    /**
     * U: Update methodology.
     * Update a Car with the matching id of the car parameter passed.
     *
     * @param car The Car with the new properties.
     */
    @Override
    @Transactional
    public void updateCar(Car car) {
        jdbcTemplate.update(UPDATE_CAR_SQL,
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getId());
    }

    /**
     * D: Delete methodology.
     * Deletes a Car with the matching id parameter from the database.
     *
     * @param id The id of the Car to delete from the database.
     */
    @Override
    @Transactional
    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_CAR_SQL, id);
    }

    /**
     * List all the Cars by the specified make.
     *
     * @param make The make of Car the user is searching for.
     * @return A list of all Cars with the user input make.
     */
    @Override
    public List<Car> getCarsByMake(String make) {
        return jdbcTemplate.query(SELECT_CARS_BY_MAKE_SQL, this::mapRowToCar, make);
    }

    /**
     * List all the Cars by the specified color.
     *
     * @param color The color of the Car the user is searching for.
     * @return A list of all Cars with the user input color.
     */
    @Override
    public List<Car> getCarsByColor(String color) {
        return jdbcTemplate.query(SELECT_CARS_BY_COLOR_SQL, this::mapRowToCar, color);
    }

    private Car mapRowToCar(ResultSet resultSet, int rowNumber) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setMake(resultSet.getString("make"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getString("year"));
        car.setColor(resultSet.getString("color"));
        return car;
    }
}
