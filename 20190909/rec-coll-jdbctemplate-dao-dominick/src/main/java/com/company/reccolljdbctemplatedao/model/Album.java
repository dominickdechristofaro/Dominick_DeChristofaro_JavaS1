package com.company.reccolljdbctemplatedao.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Album {
    // Properties
    private int album_id;
    private String title;
    private int artist_id;
    private LocalDate release_date;
    private int label_id;
    private BigDecimal list_price;

    // Getters & Setters
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
    public int getArtist_id() {
        return this.artist_id;
    }
    public void setArtist_id(int artist_idIn) {
        this.artist_id = artist_idIn;
    }
    public LocalDate getRelease_date() {
        return this.release_date;
    }
    public void setRelease_date(LocalDate release_dateIn) {
        this.release_date = release_dateIn;
    }
    public int getLabel_id() {
        return this.label_id;
    }
    public void setLabel_id(int label_idIn) {
        this.label_id = label_idIn;
    }
    public BigDecimal getList_price() {
        return this.list_price;
    }
    public void setList_price(BigDecimal list_priceIn) {
        this.list_price = list_priceIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return album_id == album.album_id &&
                artist_id == album.artist_id &&
                label_id == album.label_id &&
                title.equals(album.title) &&
                release_date.equals(album.release_date) &&
                list_price.equals(album.list_price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(album_id, title, artist_id, release_date, label_id, list_price);
    }
}
