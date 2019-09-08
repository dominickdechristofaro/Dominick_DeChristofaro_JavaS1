/* ************************************************************************************************
 **  Author:         Dominick DeChristofaro
 **  Date:           09/08/2019
 **  Description:    Interface for Roaster DAO.
 **************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.dao;
import com.company.CoffeeInventoryDaoDominickDeChristofaro.model.Roaster;
import java.util.List;

public interface RoasterInventoryDao {
    // CRUD methods
    Roaster addRoaster(Roaster roaster);
    Roaster getRoaster(int roaster_id);
    List<Roaster> getAllRoaster();
    void updateRoaster(Roaster roaster);
    void deleteRoaster(int roaster_id);
}
