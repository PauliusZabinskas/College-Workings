package org.example;

import java.util.List;

/**
 * Student name: Paulius Zabinskas
 * Student Number: 20120267
 */
public class Album {
    private String artist;
    private String albumName;
    private String coverImageFilename;
    private List<Track> trackListing;


    public Album(String artist, String albumName, String coverImageFilename, List<Track> trackListing) {
        this.artist = artist;
        this.albumName = albumName;
        this.coverImageFilename = coverImageFilename;
        this.trackListing = trackListing;
    }
    public Album(){}

    // Getters and setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getCoverImageFilename() {
        return coverImageFilename;
    }

    public void setCoverImageFilename(String coverImageFilename) {
        this.coverImageFilename = coverImageFilename;
    }

    public List<Track> getTrackListing() {
        return trackListing;
    }

    public void setTrackListing(List<Track> trackListing) {
        this.trackListing = trackListing;
    }

    @Override
    public String toString() {
        return "Album{" +
                "artist='" + artist + '\'' +
                ", albumName='" + albumName + '\'' +
                ", coverImageFilename='" + coverImageFilename + '\'' +
                ", trackListing=" + trackListing +
                '}';
    }
}
