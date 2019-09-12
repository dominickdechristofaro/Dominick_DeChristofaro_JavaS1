package com.company.reccolldao.service;
import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {
    // Properties
    private ServiceLayer service;
    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    // setUp()
    @Before
    public void setUp() throws Exception {
        setUpAlbumDaoMock();
        setUpArtistDaoMock();
        setUpLabelDaoMock();
        setUpTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);
    }

    @Test
    public void saveFindFindAllAlbum() {
        // Mock for an artist being added to the database.
        Artist artistInput = new Artist();
        artistInput.setName("Bon Jovi");
        artistInput.setInstagram("@BonJovi");
        artistInput.setTwitter("@BonJovi");
        Artist artistResponse = service.saveArtist(artistInput);

        // Mock for a label being added to the database.
        Label labelInput = new Label();
        labelInput.setName("Virgin");
        labelInput.setWebsite("www.virgin.com");
        Label labelResponse = service.saveLabel(labelInput);

        // Mock a track being added to the database.
        Track trackInput = new Track();
        trackInput.setAlbumId(1);
        trackInput.setTitle("The Best");
        trackInput.setRunTime(3);
        List<Track> trackList = new ArrayList<>();
        trackList.add(trackInput);

        // Mock an AlbumViewModel being added to the database
        AlbumViewModel albumViewModelInput = new AlbumViewModel();
        albumViewModelInput.setTitle("Greatest Hits");
        albumViewModelInput.setArtist(artistResponse);
        albumViewModelInput.setReleaseDate(LocalDate.of(1999,5,15));
        albumViewModelInput.setLabel(labelResponse);
        albumViewModelInput.setListPrice(new BigDecimal("14.99"));
        albumViewModelInput.setTracks(trackList);
        albumViewModelInput = service.saveAlbum(albumViewModelInput);

        // Make a copy of the AlbumViewModel
        AlbumViewModel albumViewModelResponse = service.findAlbum(albumViewModelInput.getId());

        // Test the saveAlbum() and findAlbum() methods
        assertEquals(albumViewModelResponse, albumViewModelInput);

        // Collect all Albums into a list
        List<AlbumViewModel> albumList = service.findAllAlbums();

        // Test the findAllAlbums() method
        assertEquals(1, albumList.size());
        assertEquals(albumViewModelInput, albumList.get(0));
    }

    @Test
    public void updateAlbum() {
        // Argument Captor for Album
        ArgumentCaptor<Album> albumCaptor = ArgumentCaptor.forClass(Album.class);
        doNothing().when(albumDao).updateAlbum(albumCaptor.capture());

        // Create a new Artist
        Artist artist = new Artist();
        artist.setId(45);

        // Create a new Label
        Label label = new Label();
        label.setId(10);

        // Create an AlbumViewModel
        AlbumViewModel albumViewModel = new AlbumViewModel();
        albumViewModel.setId(1);
        albumViewModel.setTitle("Greatest Hits vol 2");
        albumViewModel.setArtist(artist);
        albumViewModel.setReleaseDate(LocalDate.of(1999,4,17));
        albumViewModel.setLabel(label);
        albumViewModel.setListPrice(new BigDecimal("15.99"));


        Album album = albumCaptor.getValue();
        assertEquals(1,album.getId());
        assertEquals("Greatest Hits vol 2", album.getTitle());
        assertEquals(45, album.getArtistId());
        assertEquals(LocalDate.of(1999,4,17), album.getReleaseDate());
        assertEquals(10, album.getLabelId());
        assertEquals(new BigDecimal("15.99"), album.getListPrice());
    }

    @Test
    public void removeAlbumTest() {
        // Integer Captor
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        // Mock DAO's for deleteAlbum and deleteTrack
        doNothing().when(albumDao).deleteAlbum(integerCaptor.capture());

        // Remove an Album
        service.removeAlbum(1);

        // Test the removeAlbum() method
        verify(albumDao, times(1)).deleteAlbum(integerCaptor.getValue());
        assertEquals(1, integerCaptor.getValue().intValue());
    }

    @Test
    public void saveFindArtistTest() {
        // Add an artist to the database
        Artist artistInput = new Artist();
        artistInput.setName("Bon Jovi");
        artistInput.setInstagram("@BonJovi");
        artistInput.setTwitter("@BonJovi");
        artistInput = service.saveArtist(artistInput);

        // Find an artist in the database
        Artist artistResponse = service.findArtist(artistInput.getId());

        // Test the saveArtist() and findArtist() methods
        TestCase.assertEquals(artistInput, artistResponse);
    }

    @Test
    public void saveFindAllArtistTest() {
        // Add an artist to the database
        Artist artistInput = new Artist();
        artistInput.setName("Bon Jovi");
        artistInput.setInstagram("@BonJovi");
        artistInput.setTwitter("@BonJovi");
        artistInput = service.saveArtist(artistInput);

        // Create a list of all Artists
        List<Artist> aList = service.findAllArtists();

        // Test the saveArtist() and findAllArtists() method
        TestCase.assertEquals(1, aList.size());
        TestCase.assertEquals(artistInput, aList.get(0));
    }

    @Test
    public void updateArtistTest() {
        // Argument Captor
        ArgumentCaptor<Artist> artistCaptor = ArgumentCaptor.forClass(Artist.class);
        doNothing().when(artistDao).updateArtist(artistCaptor.capture());

        // Add a new Artist to the database
        Artist artistInput = new Artist();
        artistInput.setName("Bon Jovi");
        artistInput.setInstagram("@BonJovi");
        artistInput.setTwitter("@BonJovi");
        artistInput = service.saveArtist(artistInput);

        // Change the values of the item in the database
        artistInput.setName("Daft Punk");
        artistInput.setInstagram("@DaftPunk");
        artistInput.setTwitter("@HumanAfterAll");
        service.updateArtist(artistInput);

        // Test the updateArtist() method
        verify(artistDao, times(1)).updateArtist(artistCaptor.getValue());
        assertEquals(artistInput, artistCaptor.getValue());
    }

    @Test
    public void removeArtistTest() {
        // Argument Captor
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(artistDao).deleteArtist(integerCaptor.capture());

        // Remove an artist
        service.removeArtist(1);

        // Test the deleteArtist() method
        verify(artistDao, times(1)).deleteArtist(integerCaptor.getValue());
        assertEquals(1, integerCaptor.getValue().intValue());
    }

    @Test
    public void saveFindLabelTest() {
        // Save a Label
        Label labelInput = new Label();
        labelInput.setName("Virgin");
        labelInput.setWebsite("www.virgin.com");
        labelInput = service.saveLabel(labelInput);

        // Find a Label
        Label labelResponse = service.findLabel(labelInput.getId());

        // Test the saveLabel() and findLabel() methods
        TestCase.assertEquals(labelInput,labelResponse);
    }

    @Test
    public void saveFindAllLabelTest() {
        // Save a label
        Label labelInput = new Label();
        labelInput.setName("Virgin");
        labelInput.setWebsite("www.virgin.com");
        labelInput = service.saveLabel(labelInput);

        // Put all the labels into a list
        List<Label> labelList = service.findAllLabels();

        // Test the saveLabel() and findAllLabels() method
        TestCase.assertEquals(1, labelList.size());
        TestCase.assertEquals(labelInput, labelList.get(0));
    }

    @Test
    public void updateLabelTest() {
        // Argument Captor
        ArgumentCaptor<Label> labelCaptor = ArgumentCaptor.forClass(Label.class);
        doNothing().when(labelDao).updateLabel(labelCaptor.capture());

        // Add a new Label to the database
        Label labelInput = new Label();
        labelInput.setName("Virgin");
        labelInput.setWebsite("www.virgin.com");
        labelInput = service.saveLabel(labelInput);

        // Change the values of the item in the database
        labelInput.setName("Columbia");
        labelInput.setWebsite("www.columbia.com");
        service.updateLabel(labelInput);

        // Test the updateLabel() method
        verify(labelDao, times(1)).updateLabel(labelCaptor.getValue());
        assertEquals(labelInput, labelCaptor.getValue());
    }

    @Test
    public void removeLabelTest() {
        // Argument Captor
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(labelDao).deleteLabel(integerCaptor.capture());

        // Remove a label
        service.removeLabel(1);

        // Test the removeLabel() method
        verify(labelDao, times(1)).deleteLabel(integerCaptor.getValue());
        assertEquals(1, integerCaptor.getValue().intValue());
    }

    // Helper Methods
    private void setUpAlbumDaoMock() {
        // SetUp the AlbumDao Mock
        albumDao = mock(AlbumDaoJdbcTemplateImpl.class);

        // Create a response from the dao after returning from the db (albumResponse)
        Album albumResponse = new Album();
        albumResponse.setId(1);
        albumResponse.setArtistId(1);
        albumResponse.setLabelId(1);
        albumResponse.setTitle("Greatest Hits");
        albumResponse.setListPrice(new BigDecimal("14.99"));
        albumResponse.setReleaseDate(LocalDate.of(1999,5,15));

        // Create a input to the dao (albumInput)
        Album albumInput = new Album();
        albumInput.setArtistId(1);
        albumInput.setLabelId(1);
        albumInput.setTitle("Greatest Hits");
        albumInput.setListPrice(new BigDecimal("14.99"));
        albumInput.setReleaseDate(LocalDate.of(1999,5,15));

        // Add albumResponse to a list of Albums's
        List<Album> albumList = new ArrayList<>();
        albumList.add(albumResponse);

        // Mocking the behavior of addAlbum()
        doReturn(albumResponse).when(albumDao).addAlbum(albumInput);

        // Mocking the behavior of getAlbum()
        doReturn(albumResponse).when(albumDao).getAlbum(1);

        // Mocking the behavior of getAllAlbums()
        doReturn(albumList).when(albumDao).getAllAlbums();
    }

    private void setUpLabelDaoMock() {
        // SetUp the LabelDao Mock & Argument Captor
        labelDao = mock(LabelDaoJdbcTemplateImpl.class);

        // Create a response from the dao after returning from the db (labelResponse)
        Label labelResponse = new Label();
        labelResponse.setId(1);
        labelResponse.setName("Virgin");
        labelResponse.setWebsite("www.virgin.com");

        // Create a input to the dao (labelInput)
        Label labelInput = new Label();
        labelInput.setName("Virgin");
        labelInput.setWebsite("www.virgin.com");

        // Add labelResponse to a list of Label's
        List<Label> labelList = new ArrayList<>();
        labelList.add(labelResponse);

        // Mocking the behavior of addLabel()
        doReturn(labelResponse).when(labelDao).addLabel(labelInput);

        // Mocking the behavior of getLabel()
        doReturn(labelResponse).when(labelDao).getLabel(1);

        // Mocking the behavior of getAllLabels()
        doReturn(labelList).when(labelDao).getAllLabels();
    }

    private void setUpArtistDaoMock() {
        // SetUp the ArtistDao Mock
        artistDao = mock(ArtistDaoJdbcTemplateImpl.class);

        // Create a response from the dao after returning from the db
        Artist artistResponse = new Artist();
        artistResponse.setId(1);
        artistResponse.setName("Bon Jovi");
        artistResponse.setInstagram("@BonJovi");
        artistResponse.setTwitter("@BonJovi");

        // Create a input to the dao
        Artist artistInput = new Artist();
        artistInput.setName("Bon Jovi");
        artistInput.setInstagram("@BonJovi");
        artistInput.setTwitter("@BonJovi");

        // Add artistResponse to a list of Artist's
        List<Artist> artistList = new ArrayList<>();
        artistList.add(artistResponse);

        // Mocking the behavior of addArtist(), getArtist(), and getAllArtists()
        doReturn(artistResponse).when(artistDao).addArtist(artistInput);
        doReturn(artistResponse).when(artistDao).getArtist(1);
        doReturn(artistList).when(artistDao).getAllArtists();
    }

    private void setUpTrackDaoMock() {
        // SetUp the TrackDao Mock
        trackDao = mock(TrackDaoJdbcTemplateImpl.class);

        // Create a response from the dao after returning from the db
        Track trackResponse = new Track();
        trackResponse.setId(1);
        trackResponse.setAlbumId(1);
        trackResponse.setTitle("The Best");
        trackResponse.setRunTime(1);

        // Create a input to the dao
        Track trackInput = new Track();
        trackInput.setAlbumId(1);
        trackInput.setTitle("The Best");
        trackInput.setRunTime(3);

        // Add trackResponse to a list of Track's
        List<Track> trackList = new ArrayList<>();
        trackList.add(trackResponse);

        // Mocking the behavior of addTrack(), getTrack(), and getAllTracks()
        doReturn(trackResponse).when(trackDao).addTrack(trackInput);
        doReturn(trackResponse).when(trackDao).getTrack(1);
        doReturn(trackList).when(trackDao).getAllTracks();
        doReturn(trackList).when(trackDao).getTracksByAlbum(1);
    }
}
