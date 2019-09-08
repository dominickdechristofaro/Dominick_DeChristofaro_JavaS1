/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Track DAO Tests for CRUD methods.
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrackDaoTest {

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
    public void addGetDeleteTrack() {

        // Need to create a Label, Artist, and Album first
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

        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRuntime(180);
        track.setAlbum_id(album.getAlbum_id());
        track = trackDao.addTrack(track);

        Track track1 = trackDao.getTrack(track.getTrack_id());

        assertEquals(track, track1);

        trackDao.deleteTrack(track.getTrack_id());

        track1 = trackDao.getTrack(track.getTrack_id());

        assertNull(track1);
    }

    @Test
    public void updateTrack() {

        // Need to create a Label, Artist, and Album first
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

        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRuntime(180);
        track.setAlbum_id(album.getAlbum_id());
        track = trackDao.addTrack(track);

        track.setTitle("NEW TITLE");
        track.setRuntime(12);

        trackDao.updateTrack(track);

        Track track1 = trackDao.getTrack(track.getTrack_id());

        assertEquals(track1, track);

    }

    @Test
    public void getAllTracks() {

        // Need to create a Label, Artist, and Album first
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

        Album album1 = new Album();
        album1.setTitle("Lesser Hits");
        album1.setArtist_id(artist.getArtist_id());
        album1.setLabel_id(label.getLabel_id());
        album1.setRelease_date(LocalDate.of(2012, 6, 25));
        album1.setList_price(new BigDecimal("9.95"));

        album1 = albumDao.addAlbum(album1);


        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRuntime(180);
        track.setAlbum_id(album.getAlbum_id());
        track = trackDao.addTrack(track);

        track = new Track();
        track.setTitle("Just A Song");
        track.setRuntime(120);
        track.setAlbum_id(album1.getAlbum_id());
        track = trackDao.addTrack(track);

        List<Track> tList = trackDao.getAllTracks();

        assertEquals(tList.size(), 2);

    }

    @Test
    public void getTracksByAlbum() {

        // Need to create a Label, Artist, and Album first
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

        Album album1 = new Album();
        album1.setTitle("Lesser Hits");
        album1.setArtist_id(artist.getArtist_id());
        album1.setLabel_id(label.getLabel_id());
        album1.setRelease_date(LocalDate.of(2012, 6, 25));
        album1.setList_price(new BigDecimal("9.95"));

        album1 = albumDao.addAlbum(album1);


        Track track = new Track();
        track.setTitle("The Big Hit");
        track.setRuntime(180);
        track.setAlbum_id(album.getAlbum_id());
        track = trackDao.addTrack(track);

        track = new Track();
        track.setTitle("Just A Song");
        track.setRuntime(120);
        track.setAlbum_id(album1.getAlbum_id());
        track = trackDao.addTrack(track);

        track = new Track();
        track.setTitle("A Little Tune");
        track.setRuntime(100);
        track.setAlbum_id(album1.getAlbum_id());
        track = trackDao.addTrack(track);

        List<Track> tList = trackDao.getTracksByAlbum(album.getAlbum_id());
        assertEquals(tList.size(), 1);

        tList = trackDao.getTracksByAlbum(album1.getAlbum_id());
        assertEquals(tList.size(), 2);

    }
}