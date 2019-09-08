package com.company.reccolljdbctemplatedao.model;

import java.util.Objects;

public class Artist {
    // Properties
    private int artist_id;
    private String name;
    private String instagram;
    private String twitter;

    // Getters & Setters
    public int getArtist_id() {
        return this.artist_id;
    }
    public void setArtist_id(int artist_idIn) {
        this.artist_id = artist_idIn;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public String getInstagram() {
        return this.instagram;
    }
    public void setInstagram(String instagramIn) {
        this.instagram = instagramIn;
    }
    public String getTwitter() {
        return this.twitter;
    }
    public void setTwitter(String twitterIn) {
        this.twitter = twitterIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artist_id == artist.artist_id &&
                name.equals(artist.name) &&
                Objects.equals(instagram, artist.instagram) &&
                Objects.equals(twitter, artist.twitter);
    }
    @Override
    public int hashCode() {
        return Objects.hash(artist_id, name, instagram, twitter);
    }
}
