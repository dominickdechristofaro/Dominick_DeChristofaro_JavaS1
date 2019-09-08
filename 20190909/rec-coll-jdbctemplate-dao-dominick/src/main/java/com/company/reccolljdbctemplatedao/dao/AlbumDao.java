/* *************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Interface for the album DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Album;
import java.util.List;

public interface AlbumDao {
    // CRUD methods
    Album addAlbum(Album album);
    Album getAlbum(int id);
    List<Album> getAllAlbums();
    void updateAlbum(Album album);
    void deleteAlbum(int id);
}
