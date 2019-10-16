/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Service Layer Interface for all API's.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.service;
import com.company.DominickDeChristofaroU1Capstone.model.Console;
import com.company.DominickDeChristofaroU1Capstone.model.Game;
import com.company.DominickDeChristofaroU1Capstone.model.TShirt;
import com.company.DominickDeChristofaroU1Capstone.viewmodel.OrderViewModel;
import java.util.List;

public interface ServiceLayer {
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

    /**
     * Add a Game to the database.
     * @param game The Game to add to the database.
     * @return The Game added to the database with an auto-generated id.
     */
    Game addGame(Game game);

    /**
     * Update a Game in the database.
     * @param game The Game to be updated in the database.
     */
    void updateGame(Game game);

    /**
     * Delete a Game from the database by id.
     * @param id The id of the Game to be deleted from the database.
     */
    void deleteGame(Long id);

    /**
     * Get a Game from the database by id.
     * @param id The id of the Game to be retrieved from the database.
     * @return The Game with the id requested from the database.
     */
    Game getGame(Long id);

    /**
     * A List of all Games in the database.
     * @return A List of all Games in the database.
     */
    List<Game> getAllGame();

    /**
     * Get a List of all Games in the database by a specific studio.
     * @param studio The studio to query.
     * @return A List of all Games in the database by the queried studio.
     */
    List<Game> getGameByStudio(String studio);

    /**
     * Get a List of all Games in the database with a specific esrbRating.
     * @param esrbRating The esrbRating to query.
     * @return A List of all Games in the database by the queried esrbRating.
     */
    List<Game> getGameByEsrbRating(String esrbRating);

    /**
     * Get a List of all Games in the database with a specific title.
     * @param title The title to query.
     * @return A List of all Games in the database by a queried title.
     */
    List<Game> getGameByTitle(String title);

    /**
     * Add a TShirt to the database.
     * @param tShirt The TShirt to add to the database.
     * @return The TShirt added to the database.
     */
    TShirt addTShirt(TShirt tShirt);

    /**
     * Update a TShirt in the database.
     * @param tShirt The TShirt to update in the database.
     */
    void updateTShirt(TShirt tShirt);

    /**
     * Delete a TShirt in the database.
     * @param id The id of the TShirt to delete in the database.
     */
    void deleteTShirt(Long id);

    /**
     * Get a TShirt from the database by id.
     * @param id The id of the TShirt to retrieve from the database.
     * @return The TShirt that the user requested from the database.
     */
    TShirt getTShirt(Long id);

    /**
     * A List of all TShirts in the database.
     * @return A List of all TShirts in the database.
     */
    List<TShirt> getAllTShirt();

    /**
     * A List of all TShirts in the database by a specific color.
     * @param color The color of TShirts to be queried from the database.
     * @return A List of TShirts of queried color.
     */
    List<TShirt> getTShirtByColor(String color);

    /**
     * A List of all TShirts in the database by a specific size.
     * @param size The size of TShirts to be queried from the database.
     * @return A List of TShirts of queried size.
     */
    List<TShirt> getTShirtBySize(String size);

    /**
     * Order is analogous to an OrderViewModel.  The method shall perform the following:
     * It will lookup the sales tax rate based on the state code provided in the order.
     * It will validate that the item type based on the itemId.
     * It will validate that the game store has the necessary quantity to complete the order.
     * It will calculate the sales tax based on the quantity, item type and sales tax rate provided in the order.
     * It will calculate the processing fee based on the quantity of items ordered.
     * It will calculate the subtotal of the order (including tax and processing fees).
     * It will compose an invoice object and add it to an invoice database.
     * It will return a complete OrderViewModel.
     * @param order The order to be placed.
     * @return An OrderViewModel after an invoice has been added to the database.
     */
    OrderViewModel addOrder(OrderViewModel order);
}
