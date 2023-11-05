package org.example;

import org.junit.Test;
import java.io.*;
import java.util.List;

import static org.junit.Assert.*;

public class AlbumReaderTest {

    @Test
    public void testReadAlbumsNotEmpty() throws IOException {
        AlbumReader albumReader = new AlbumReader(); // Assuming default constructor uses a valid path
        List<Album> albums = albumReader.ReadAlbums();
        assertFalse("Album list should not be empty", albums.isEmpty());
    }

    @Test
    public void testReadAlbumsCorrectAlbums() throws IOException {
        AlbumReader albumReader = new AlbumReader(); // Assuming default constructor uses a valid path
        List<Album> albums = albumReader.ReadAlbums();

        // Verify the number of albums read
        int expectedNumberOfAlbums;
        assertEquals("Number of albums read is incorrect", expectedNumberOfAlbums, albums.size());

        // Verify each album's data
        for (int i = 0; i < expectedNumberOfAlbums; i++) {
            Album expectedAlbum = expectedAlbums.get(i);
            Album actualAlbum = albums.get(i);
            assertEquals("Artist name does not match", expectedAlbum.getArtist(), actualAlbum.getArtist());
            assertEquals("Album name does not match", expectedAlbum.getAlbumName(), actualAlbum.getAlbumName());
            assertEquals("Cover image path does not match", expectedAlbum.getCoverImageFilename(), actualAlbum.getCoverImageFilename());
            // ... and so on for the other attributes
        }
    }

    @Test
    public void testReadTrackListingNotEmpty() throws IOException {
        AlbumReader albumReader = new AlbumReader(); // Assuming default constructor uses a valid path
        List<Track> tracks = albumReader.ReadTrackListing("valid_track_listing_path.txt");
        assertFalse("Track list should not be empty", tracks.isEmpty());
    }

    @Test
    public void testReadTrackListingCorrectTracks() throws IOException {
        AlbumReader albumReader = new AlbumReader(); // Assuming default constructor uses a valid path
        List<Track> tracks = albumReader.ReadTrackListing("valid_track_listing_path.txt");

        // Verify the number of tracks read
        assertEquals("Number of tracks read is incorrect", expectedNumberOfTracks, tracks.size());

        // Verify each track's data
        for (int i = 0; i < expectedNumberOfTracks; i++) {
            Track expectedTrack = expectedTracks.get(i);
            Track actualTrack = tracks.get(i);
            assertEquals("Track title does not match", expectedTrack.getTitle(), actualTrack.getTitle());
            assertEquals("Track duration does not match", expectedTrack.getDuration(), actualTrack.getDuration());
        }
    }
}
