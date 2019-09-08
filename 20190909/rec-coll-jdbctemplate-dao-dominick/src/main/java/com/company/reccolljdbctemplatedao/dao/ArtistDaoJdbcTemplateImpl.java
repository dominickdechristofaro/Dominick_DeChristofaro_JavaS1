/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Implementation file for Artist DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArtistDaoJdbcTemplateImpl implements ArtistDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_ARTIST_SQL =
            "INSERT INTO Artist (name, instagram, twitter) VALUES (?,?,?)";
    private static final String SELECT_ARTIST_SQL =
            "SELECT * FROM Artist WHERE artist_id = ?";
    private static final String SELECT_ALL_ARTISTS_SQL =
            "SELECT * FROM Artist";
    private static final String DELETE_ARTIST_SQL =
            "DELETE FROM Artist WHERE artist_id = ?";
    private static final String UPDATE_ARTIST_SQL =
            "UPDATE Artist SET name = ?, instagram = ?, twitter = ? WHERE artist_id = ?";

    // Property
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public ArtistDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Artist addArtist(Artist artist) {
        jdbcTemplate.update(INSERT_ARTIST_SQL,
                artist.getName(),
                artist.getInstagram(),
                artist.getTwitter());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        artist.setArtist_id(id);
        return artist;
    }

    @Override
    public Artist getArtist(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ARTIST_SQL, this::mapRowToArtist, id);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Artist> getAllArtists() {
        return jdbcTemplate.query(SELECT_ALL_ARTISTS_SQL, this::mapRowToArtist);
    }

    @Override
    @Transactional
    public void updateArtist(Artist artist) {
        jdbcTemplate.update(UPDATE_ARTIST_SQL,
                artist.getName(),
                artist.getInstagram(),
                artist.getTwitter(),
                artist.getArtist_id());
    }

    @Override
    @Transactional
    public void deleteArtist(int id) {
        jdbcTemplate.update(DELETE_ARTIST_SQL, id);
    }

    private Artist mapRowToArtist(ResultSet resultSet, int rowNumber) throws SQLException {
        Artist artist = new Artist();
        artist.setArtist_id(resultSet.getInt("artist_id"));
        artist.setName(resultSet.getString("name"));
        artist.setInstagram(resultSet.getString("instagram"));
        artist.setTwitter(resultSet.getString("twitter"));
        return artist;
    }
}
