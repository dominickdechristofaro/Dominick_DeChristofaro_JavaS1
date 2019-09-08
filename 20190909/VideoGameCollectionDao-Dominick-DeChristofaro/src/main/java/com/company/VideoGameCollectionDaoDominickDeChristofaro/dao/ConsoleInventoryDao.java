/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Interface for Console DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Console;
import java.util.List;

public interface ConsoleInventoryDao {
    // CRUD Methods
    Console addConsole(Console console);
    Console getConsole(int console_id);
    List<Console> getAllConsole();
    void updateConsole(Console console);
    void deleteConsole(int console_id);
}
