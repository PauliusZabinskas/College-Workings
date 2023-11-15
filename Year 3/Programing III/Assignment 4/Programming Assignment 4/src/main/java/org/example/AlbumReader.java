package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Student name: Paulius Zabinskas
 * Student Number: 20120267
 */

public class AlbumReader {

    // Assuming music_library.txt is in the same directory as the project root
    public static final String LIBRARY_FILE_PATH = "music_library.txt";
    public static final String BASE_PATH = System.getProperty("user.dir");


    /**
     *
     * ReadAlbums function uses BufferedReader data type to read from music_library.txt file.
     * While there is next line, set text deliminator to be ",".
     * Each line contains parts (0-3), each separated by "," and saved as a String data type.
     * File data type is used to store relative path to covers & library.
     *
     * Use ReadTrackListing function to read tracks associated to album by indication in music_library.txt.
     * Create new album &
     * add new album to album list
     *
     * ReadTrackListing function uses BufferedReader data type to iterate over library/*.txt files
     * in a similar fation as ReadAlbums
     *
     */
    public List<Album> ReadAlbums() throws IOException {
        List<Album> albums = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LIBRARY_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(","); // the files are comma-separated
                String artist = details[0].trim();
                String albumName = details[1].trim();
                String coverImageRelativePath = details[2].trim();
                String trackListingRelativePath = details[3].trim();

                // Resolve the full paths based on the relative paths provided
                File coverImageFile = new File(BASE_PATH, coverImageRelativePath);
                File trackListingFile = new File(BASE_PATH, trackListingRelativePath);

                try{
                    List<Track> trackListing = ReadTrackListing(trackListingFile.getPath());
                    Album album = new Album(artist, albumName, coverImageFile.getPath(), trackListing);
                    albums.add(album);

                }catch (FileNotFoundException e)
                {
                    if (!coverImageFile.exists()) {
                        throw new FileNotFoundException("Track listing not found at: " + coverImageFile.getAbsolutePath());
                    }
                    if (!trackListingFile.exists()) {
                        throw new FileNotFoundException("Track listing not found at: " + trackListingFile.getAbsolutePath());
                    }
                }
            }
        }
        return albums;
    }


    private List<Track> ReadTrackListing(String trackListingFileName) throws IOException {
        List<Track> tracks = new ArrayList<>();
        File trackFile = new File(trackListingFileName);

        // Check if the file exists and is readable
        if (!trackFile.exists() || !trackFile.canRead()) {
            throw new FileNotFoundException("Could not find or read the track listing file at: " + trackFile.getAbsolutePath());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(trackFile))) {
            String trackLine;
            while ((trackLine = reader.readLine()) != null) {
                // Split the string using a comma
                String[] parts = trackLine.split(",\\s*"); // This regex splits on a comma followed by any amount of whitespace
                if (parts.length < 3) {
                    // If there are not enough parts, log an error and skip this line
                    System.err.println("Invalid track format: " + trackLine);
                    continue;
                }

                // Assuming that number of track files isn't important.
                // Assuming the title is the second element and duration the third
                String title = parts[1].replaceAll("\"", "").trim();
                String duration = parts[2].trim();
                tracks.add(new Track(title, duration));
            }
        }
        return tracks;
    }

}
