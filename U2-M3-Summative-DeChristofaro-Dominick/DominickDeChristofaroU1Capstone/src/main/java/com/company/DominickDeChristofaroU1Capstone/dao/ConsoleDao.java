/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Interface for Console DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.Console;
import java.util.List;

public interface ConsoleDao {
    /**
     * Add a Console to the database.
     * @param console The Console to be added to the database.
     * @return The Console added to the database with an id.
     */
    Console addConsole(Console console);

    /**
     * Update a Console in the database.
     * @param console The Console to be updated in the database.
     */
    void updateConsole(Console console);

    /**
     * Delete a Console in the database.
     * @param id The id of the Console to be deleted from the database.
     */
    void deleteConsole(Long id);

    /**
     * Get a single Console from the database by id.
     * @param id The id of the Console to retrieve from the database.
     * @return The Console requested from the database.
     */
    Console getConsole(Long id);

    /**
     * Get all Consoles in the database.
     * @return A List of all Consoles in the database.
     */
    List<Console> getAllConsole();

    /**
     * Get all Consoles in the database by manufacturer.
     * @param manufacturer The manufacturer to query in the database.
     * @return A list of all Consoles with the manufacturer queried.
     */
    List<Console> getConsoleByManufacturer(String manufacturer);
}
