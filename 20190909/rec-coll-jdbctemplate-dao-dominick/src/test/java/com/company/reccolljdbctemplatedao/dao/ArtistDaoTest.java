/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Artist DAO Tests for CRUD methods.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Album;
import com.company.reccolljdbctemplatedao.model.Artist;
import com.company.reccolljdbctemplatedao.model.Label;
import com.company.reccolljdbctemplatedao.model.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArtistDaoTest {

    @Autowired
    private TrackDao trackDao;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private ArtistDao artistDao;
    @Autowired
    private LabelDao labelDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Track> tList = trackDao.getAllTracks();
        for (Track t : tList) {
            trackDao.deleteTrack(t.getTrack_id());
        }

        List<Album> aList = albumDao.getAllAlbums();

        for (Album a : aList) {
            albumDao.deleteAlbum(a.getAlbum_id());
        }

        List<Artist> artistList = artistDao.getAllArtists();

        for (Artist a : artistList) {
            artistDao.deleteArtist(a.getArtist_id());
        }

        List<Label> lList = labelDao.getAllLabels();

        for (Label l : lList) {
            labelDao.deleteLabel(l.getLabel_id());
        }

    }

    @Test
    public void addGetDeleteArtist() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        Artist artist1 = artistDao.getArtist(artist.getArtist_id());

        assertEquals(artist1, artist);

        artistDao.deleteArtist(artist.getArtist_id());

        artist1 = artistDao.getArtist(artist.getArtist_id());

        assertNull(artist1);
    }

    @Test
    public void updateArtist() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        artist.setName("Pop Star");
        artist.setInstagram("@PopStar");
        artist.setTwitter("@ThePopstar");

        artistDao.updateArtist(artist);

        Artist artist1 = artistDao.getArtist(artist.getArtist_id());

        assertEquals(artist1, artist);
    }

    @Test
    public void getAllArtists() {

        Artist artist = new Artist();
        artist.setName("Rock Star");
        artist.setInstagram("@RockStart");
        artist.setTwitter(("@TheRockStar"));

        artist = artistDao.addArtist(artist);

        artist = new Artist();
        artist.setName("Super Star");
        artist.setInstagram("@SuperStart");
        artist.setTwitter(("@TheSuperStar"));

        artist = artistDao.addArtist(artist);

        List<Artist> aList = artistDao.getAllArtists();
        assertEquals(aList.size(), 2);

    }

}