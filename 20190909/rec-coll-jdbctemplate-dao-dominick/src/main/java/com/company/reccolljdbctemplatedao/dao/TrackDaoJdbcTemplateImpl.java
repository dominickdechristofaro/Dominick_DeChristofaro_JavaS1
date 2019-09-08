/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Implementation for Track DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TrackDaoJdbcTemplateImpl implements TrackDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_TRACK_SQL =
            "INSERT INTO Track (album_id, title, runtime) VALUES (?,?,?)";
    private static final String SELECT_TRACK_SQL =
            "SELECT * FROM Track WHERE track_id = ?";
    private static final String SELECT_ALL_TRACKS_SQL =
            "SELECT * FROM Track";
    private static final String SELECT_TRACKS_BY_ALBUM_SQL =
            "SELECT * FROM Track WHERE album_id = ?";
    private static final String DELETE_TRACK_SQL =
            "DELETE FROM Track WHERE track_id = ?";
    private static final String UPDATE_TRACK_SQL =
            "UPDATE Track SET album_id = ?, title = ?, runtime = ? WHERE track_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public TrackDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Track addTrack(Track track) {
        jdbcTemplate.update(INSERT_TRACK_SQL,
                track.getAlbum_id(),
                track.getTitle(),
                track.getRuntime());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        track.setTrack_id(id);
        return track;
    }

    @Override
    public Track getTrack(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TRACK_SQL, this::mapRowToTrack, id);
        } catch (EmptyResultDataAccessException e) {
            // If nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Track> getAllTracks() {
        return jdbcTemplate.query(SELECT_ALL_TRACKS_SQL, this::mapRowToTrack);
    }

    @Override
    public List<Track> getTracksByAlbum(int album) {
        return jdbcTemplate.query(SELECT_TRACKS_BY_ALBUM_SQL, this::mapRowToTrack, album);
    }

    @Override
    @Transactional
    public void updateTrack(Track track) {
        jdbcTemplate.update(UPDATE_TRACK_SQL,
                track.getAlbum_id(),
                track.getTitle(),
                track.getRuntime(),
                track.getTrack_id());
    }

    @Override
    @Transactional
    public void deleteTrack(int id) {
        jdbcTemplate.update(DELETE_TRACK_SQL, id);
    }

    private Track mapRowToTrack(ResultSet resultSet, int rowNumber) throws SQLException {
        Track track = new Track();
        track.setTrack_id(resultSet.getInt("track_id"));
        track.setAlbum_id(resultSet.getInt("album_id"));
        track.setTitle(resultSet.getString("title"));
        track.setRuntime(resultSet.getInt("runtime"));
        return track;
    }
}
