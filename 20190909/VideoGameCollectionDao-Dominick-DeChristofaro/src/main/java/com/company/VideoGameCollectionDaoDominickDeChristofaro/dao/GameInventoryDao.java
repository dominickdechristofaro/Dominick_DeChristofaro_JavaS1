/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Interface for Game DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Game;
import java.util.List;

public interface GameInventoryDao {
    // CRUD Methods
    Game addGame(Game game);
    Game getGame(int game_id);
    List<Game> getAllGame();
    List<Game> getGameByConsole(int console_id);
    List<Game> getGameByPublisher(int publisher_id);
    List<Game> getGameByType(int type_id);
    void updateGame(Game game);
    void deleteGame(int game_id);
}
