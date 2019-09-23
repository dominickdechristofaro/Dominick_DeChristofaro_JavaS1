/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
 *  Description:    Implementation for Game DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_GAME_SQL =
            "INSERT INTO game (title, esrb_rating, description, price, studio, quantity) VALUES (?,?,?,?,?,?)";
    private static final String SELECT_GAME_SQL =
            "SELECT * FROM game WHERE game_id = ?";
    private static final String SELECT_ALL_GAME_SQL =
            "SELECT * FROM game";
    private static final String SELECT_GAME_BY_STUDIO_SQL =
            "SELECT * FROM game WHERE studio = ?";
    private static final String SELECT_GAME_BY_ESRB_RATING_SQL =
            "SELECT * FROM game WHERE esrb_rating = ?";
    private static final String SELECT_GAME_BY_TITLE_SQL =
            "SELECT * FROM game WHERE title = ?";
    private static final String UPDATE_GAME_SQL =
            "UPDATE game SET title = ?, esrb_rating = ?, description = ?, price = ?, studio = ?, quantity = ? WHERE game_id = ?";
    private static final String DELETE_GAME_SQL =
            "DELETE FROM game WHERE game_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Add a Game to the database.
     * @param game The Game to add to the database.
     * @return The Game added to the database with an auto-generated id.
     */
    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity());
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        game.setId(id);
        return game;
    }

    /**
     * Update a Game in the database.
     * @param game The Game to be updated in the database.
     */
    @Override
    @Transactional
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getTitle(),
                game.getEsrbRating(),
                game.getDescription(),
                game.getPrice(),
                game.getStudio(),
                game.getQuantity(),
                game.getId());
    }

    /**
     * Delete a Game from the database by id.
     * @param id The id of the Game to be deleted from the database.
     */
    @Override
    @Transactional
    public void deleteGame(Long id) {
        jdbcTemplate.update(DELETE_GAME_SQL, id);
    }

    /**
     * Get a Game from the database by id.
     * @param id The id of the Game to be retrieved from the database.
     * @return The Game with the id requested from the database.
     */
    @Override
    public Game getGame(Long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * A List of all Games in the database.
     * @return A List of all Games in the database.
     */
    @Override
    public List<Game> getAllGame() {
        return jdbcTemplate.query(SELECT_ALL_GAME_SQL, this::mapRowToGame);
    }

    /**
     * Get a List of all Games in the database by a specific studio.
     * @param studio The studio to query.
     * @return A List of all Games in the database by the queried studio.
     */
    @Override
    public List<Game> getGameByStudio(String studio) {
        return jdbcTemplate.query(SELECT_GAME_BY_STUDIO_SQL, this::mapRowToGame, studio);
    }

    /**
     * Get a List of all Games in the database with a specific esrbRating.
     * @param esrbRating The esrbRating to query.
     * @return A List of all Games in the database by the queried esrbRating.
     */
    @Override
    public List<Game> getGameByEsrbRating(String esrbRating) {
        return jdbcTemplate.query(SELECT_GAME_BY_ESRB_RATING_SQL, this::mapRowToGame, esrbRating);
    }

    /**
     * Get a List of all Games in the database with a specific title.
     * @param title The title to query.
     * @return A List of all Games in the database by a queried title.
     */
    @Override
    public List<Game> getGameByTitle(String title) {
        return jdbcTemplate.query(SELECT_GAME_BY_TITLE_SQL, this::mapRowToGame, title);
    }

    /**
     * Map a row of the database to a Game object.
     * @param resultSet The result set of parameters retrieved from the database.
     * @param rowNumber The row number retrieved from the database.
     * @return A Game object retrieved from the database
     * @throws SQLException Thrown in the object could not be retrieved from the database.
     */
    private Game mapRowToGame(ResultSet resultSet, int rowNumber) throws SQLException {
        Game game = new Game();
        game.setId(resultSet.getLong("game_id"));
        game.setTitle(resultSet.getString("title"));
        game.setEsrbRating(resultSet.getString("esrb_rating"));
        game.setDescription(resultSet.getString("description"));
        game.setPrice(resultSet.getBigDecimal("price"));
        game.setStudio(resultSet.getString("studio"));
        game.setQuantity(resultSet.getLong("quantity"));
        return game;
    }
}
