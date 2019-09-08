/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Interface for Track DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Track;
import java.util.List;

public interface TrackDao {
    // CRUD methods
    Track addTrack(Track track);
    Track getTrack(int id);
    List<Track> getAllTracks();
    void updateTrack(Track track);
    void deleteTrack(int id);
    List<Track> getTracksByAlbum(int album);
}
