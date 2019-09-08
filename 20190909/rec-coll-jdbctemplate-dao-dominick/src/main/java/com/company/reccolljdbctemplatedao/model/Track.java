package com.company.reccolljdbctemplatedao.model;

import java.util.Objects;

public class Track {
    // Properties
    private int track_id;
    private int album_id;
    private String title;
    private int runtime;

    // Getters & Setters
    public int getTrack_id() {
        return this.track_id;
    }
    public void setTrack_id(int track_idIn) {
        this.track_id = track_idIn;
    }
    public int getAlbum_id() {
        return this.album_id;
    }
    public void setAlbum_id(int album_idIn) {
        this.album_id = album_idIn;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String titleIn) {
        this.title = titleIn;
    }
    public int getRuntime() {
        return this.runtime;
    }
    public void setRuntime(int runtimeIn) {
        this.runtime = runtimeIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return track_id == track.track_id &&
                album_id == track.album_id &&
                runtime == track.runtime &&
                title.equals(track.title);
    }
    @Override
    public int hashCode() {
        return Objects.hash(track_id, album_id, title, runtime);
    }
}
