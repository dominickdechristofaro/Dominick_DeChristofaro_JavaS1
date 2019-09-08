/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Implementation for the Album DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlbumDaoJdbcTemplateImpl implements AlbumDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_ALBUM_SQL =
            "INSERT INTO Album (title, artist_id, release_date, label_id, list_price) VALUES (?,?,?,?,?)";
    private static final String SELECT_ALBUM_SQL =
            "SELECT * FROM Album WHERE album_id = ?";
    private static final String SELECT_ALL_ALBUMS_SQL =
            "SELECT * FROM Album";
    private static final String DELETE_ALBUM_SQL =
            "DELETE FROM Album WHERE album_id = ?";
    private static final String UPDATE_ALBUM_SQL =
            "UPDATE Album SET title = ?, artist_id = ?, release_date = ?, label_id = ?, list_price = ? WHERE album_id = ?";

    // Property
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public AlbumDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD Methods
    @Override
    @Transactional
    public Album addAlbum(Album album) {
        jdbcTemplate.update(INSERT_ALBUM_SQL,
                album.getTitle(),
                album.getArtist_id(),
                album.getRelease_date(),
                album.getLabel_id(),
                album.getList_price());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        album.setAlbum_id(id);
        return album;
    }

    @Override
    public Album getAlbum(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ALBUM_SQL, this::mapRowToAlbum, id);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        return jdbcTemplate.query(SELECT_ALL_ALBUMS_SQL, this::mapRowToAlbum);
    }

    @Override
    @Transactional
    public void updateAlbum(Album album) {
        jdbcTemplate.update(UPDATE_ALBUM_SQL,
                album.getTitle(),
                album.getArtist_id(),
                album.getRelease_date(),
                album.getLabel_id(),
                album.getList_price(),
                album.getAlbum_id());
    }

    @Override
    @Transactional
    public void deleteAlbum(int id) {
        jdbcTemplate.update(DELETE_ALBUM_SQL, id);
    }

    // Additional Methods
    private Album mapRowToAlbum(ResultSet resultSet, int rowNumber) throws SQLException {
        Album album = new Album();
        album.setAlbum_id(resultSet.getInt("album_id"));
        album.setTitle(resultSet.getString("title"));
        album.setArtist_id(resultSet.getInt("artist_id"));
        album.setRelease_date(resultSet.getDate("release_date").toLocalDate());
        album.setLabel_id(resultSet.getInt("label_id"));
        album.setList_price(resultSet.getBigDecimal("list_price"));
        return album;
    }
}
