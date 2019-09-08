/* ************************************************************************************************
**  Author:         Dominick DeChristofaro
**  Date:           09/08/2019
**  Description:    Interface for Coffee DAO.
**************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.dao;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Coffee;
import java.util.List;

public interface CoffeeInventoryDao {
    // CRUD Methods
    Coffee addCoffee(Coffee coffee);
    Coffee getCoffee(int coffee_id);
    List<Coffee> getAllCoffee();
    List<Coffee> getCoffeeByRoasterId(int roaster_id);
    List<Coffee> getCoffeeByType(String type);
    void updateCoffee(Coffee coffee);
    void deleteCoffee(int coffee_id);
}
