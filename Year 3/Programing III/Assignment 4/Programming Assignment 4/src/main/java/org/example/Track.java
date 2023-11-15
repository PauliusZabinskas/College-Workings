package org.example;

/**
 * Student name: Paulius Zabinskas
 * Student Number: 20120267
 */
public class Track {
    private String title;
    private String duration;

    public Track(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
