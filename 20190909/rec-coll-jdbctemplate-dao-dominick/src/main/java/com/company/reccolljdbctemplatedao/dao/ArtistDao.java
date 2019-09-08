/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Interface for Artist DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Artist;
import java.util.List;

public interface ArtistDao {
    // CRUD methods
    Artist addArtist(Artist artist);
    Artist getArtist(int id);
    List<Artist> getAllArtists();
    void updateArtist(Artist artist);
    void deleteArtist(int id);
}
