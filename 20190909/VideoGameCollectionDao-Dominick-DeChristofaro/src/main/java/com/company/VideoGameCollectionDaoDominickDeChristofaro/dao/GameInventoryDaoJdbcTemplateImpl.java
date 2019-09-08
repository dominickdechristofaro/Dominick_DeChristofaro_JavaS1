/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Implementation for Game DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GameInventoryDaoJdbcTemplateImpl implements GameInventoryDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_GAME_SQL =
            "INSERT INTO Game (console_id, publisher_id, type_id) VALUES (?,?,?)";
    private static final String SELECT_GAME_SQL =
            "SELECT * FROM Game WHERE game_id = ?";
    private static final String SELECT_ALL_GAME_SQL =
            "SELECT * FROM Game";
    private static final String SELECT_GAME_BY_CONSOLE_SQL =
            "SELECT * FROM Game WHERE console_id = ?";
    private static final String SELECT_GAME_BY_PUBLISHER_SQL =
            "SELECT * FROM Game WHERE publisher_id = ?";
    private static final String SELECT_GAME_BY_TYPE_SQL =
            "SELECT * FROM Game WHERE type_id = ?";
    private static final String UPDATE_GAME_SQL =
            "UPDATE Game SET console_id = ?, publisher_id = ?, type_id = ? WHERE game_id = ?";
    private static final String DELETE_GAME_SQL =
            "DELETE FROM Game WHERE game_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public GameInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getConsole_id(),
                game.getPublisher_id(),
                game.getType_id());
        int game_id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGame_id(game_id);
        return game;
    }

    @Override
    public Game getGame(int game_id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_GAME_SQL, this::mapRowToGame, game_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGame() {
        return jdbcTemplate.query(SELECT_ALL_GAME_SQL, this::mapRowToGame);
    }

    @Override
    public List<Game> getGameByConsole(int console_id) {
        return jdbcTemplate.query(SELECT_GAME_BY_CONSOLE_SQL, this::mapRowToGame, console_id);
    }

    @Override
    public List<Game> getGameByPublisher(int publisher_id) {
        return jdbcTemplate.query(SELECT_GAME_BY_PUBLISHER_SQL, this::mapRowToGame, publisher_id);
    }

    @Override
    public List<Game> getGameByType(int type_id) {
        return jdbcTemplate.query(SELECT_GAME_BY_TYPE_SQL, this::mapRowToGame, type_id);
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getConsole_id(),
                game.getPublisher_id(),
                game.getType_id(),
                game.getGame_id());
    }

    @Override
    @Transactional
    public void deleteGame(int game_id) {
        jdbcTemplate.update(DELETE_GAME_SQL, game_id);
    }

    // Additional Methods
    private Game mapRowToGame(ResultSet resultSet, int rowNumber) throws SQLException {
        Game game = new Game();
        game.setGame_id(resultSet.getInt("game_id"));
        game.setConsole_id(resultSet.getInt("console_id"));
        game.setPublisher_id(resultSet.getInt("publisher_id"));
        game.setType_id(resultSet.getInt("type_id"));
        return game;
    }
}
