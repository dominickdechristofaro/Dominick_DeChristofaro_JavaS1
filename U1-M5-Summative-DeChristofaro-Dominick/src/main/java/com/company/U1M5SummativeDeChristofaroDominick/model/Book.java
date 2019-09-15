/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Book Model.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {
    // Properties
    private int book_id;
    private String isbn;
    private LocalDate publish_date;
    private int author_id;
    private String title;
    private int publisher_id;
    private BigDecimal price;

    // Getters & Setters
    public int getBook_id() {
        return this.book_id;
    }
    public void setBook_id(int book_idIn) {
        this.book_id = book_idIn;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public void setIsbn(String isbnIn) {
        this.isbn = isbnIn;
    }
    public int getAuthor_id() {
        return this.author_id;
    }
    public void setAuthor_id(int author_idIn) {
        this.author_id = author_idIn;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String titleIn) {
        this.title = titleIn;
    }
    public int getPublisher_id() {
        return this.publisher_id;
    }
    public void setPublisher_id(int publisher_idIn) {
        this.publisher_id = publisher_idIn;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(BigDecimal priceIn) {
        this.price = priceIn;
    }
    public LocalDate getPublish_date() {
        return this.publish_date;
    }
    public void setPublish_date(LocalDate publish_dateIn) {
        this.publish_date = publish_dateIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id &&
                author_id == book.author_id &&
                publisher_id == book.publisher_id &&
                isbn.equals(book.isbn) &&
                publish_date.equals(book.publish_date) &&
                title.equals(book.title) &&
                price.equals(book.price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(book_id, isbn, publish_date, author_id, title, publisher_id, price);
    }
}
