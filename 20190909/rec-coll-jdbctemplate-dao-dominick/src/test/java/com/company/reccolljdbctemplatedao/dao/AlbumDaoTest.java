/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Album DAO Tests for CRUD methods.
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AlbumDaoTest {

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
    public void addGetDeleteAlbum() {

        // Need to create a Label and an Artist first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtist_id(artist.getArtist_id());
        album.setLabel_id(label.getLabel_id());
        album.setRelease_date(LocalDate.of(2010, 1, 5));
        album.setList_price(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        Album album1 = albumDao.getAlbum(album.getAlbum_id());

        assertEquals(album1, album);

        albumDao.deleteAlbum(album.getAlbum_id());

        album1 = albumDao.getAlbum(album.getAlbum_id());

        assertNull(album1);

    }

    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtist_id(54);
        album.setLabel_id(91);
        album.setRelease_date(LocalDate.of(2010, 1, 5));
        album.setList_price(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

    }

    @Test
    public void getAllAlbums() {

        // Need to create a Label and an Artist first
        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtist_id(artist.getArtist_id());
        album.setLabel_id(label.getLabel_id());
        album.setRelease_date(LocalDate.of(2010, 1, 5));
        album.setList_price(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        album = new Album();
        album.setTitle("Leftovers");
        album.setArtist_id(artist.getArtist_id());
        album.setLabel_id(label.getLabel_id());
        album.setRelease_date(LocalDate.of(2012, 4, 5));
        album.setList_price(new BigDecimal("18.95"));

        album = albumDao.addAlbum(album);

        List<Album> aList = albumDao.getAllAlbums();

        assertEquals(aList.size(), 2);

    }

    @Test
    public void updateAlbum() {

        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.aandm.com");
        label = labelDao.addLabel(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistDao.addArtist(artist);

        Album album = new Album();
        album.setTitle("Greatest Hits");
        album.setArtist_id(artist.getArtist_id());
        album.setLabel_id(label.getLabel_id());
        album.setRelease_date(LocalDate.of(2010, 1, 1));
        album.setList_price(new BigDecimal("21.95"));

        album = albumDao.addAlbum(album);

        album.setTitle("NEW TITLE");
        album.setRelease_date(LocalDate.of(2000, 7, 7));
        album.setList_price(new BigDecimal("15.68"));

        albumDao.updateAlbum(album);

        Album album1 = albumDao.getAlbum(album.getAlbum_id());
        assertEquals(album1, album);

    }

}