/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
 *  Description:    Interface for Game DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.Game;
import java.util.List;

public interface GameDao {
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
}
