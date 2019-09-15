/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Author Model.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.model;
import java.util.Objects;

public class Author {
    // Properties
    private int author_id;
    private String first_name;
    private String last_name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;

    // Getters & Setters
    public int getAuthor_id() {
        return this.author_id;
    }
    public void setAuthor_id(int author_idIn) {
        this.author_id = author_idIn;
    }
    public String getFirst_name() {
        return this.first_name;
    }
    public void setFirst_name(String first_nameIn) {
        this.first_name = first_nameIn;
    }
    public String getLast_name() {
        return this.last_name;
    }
    public void setLast_name(String last_nameIn) {
        this.last_name = last_nameIn;
    }
    public String getStreet() {
        return this.street;
    }
    public void setStreet(String streetIn) {
        this.street = streetIn;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String cityIn) {
        this.city = cityIn;
    }
    public String getState() {
        return this.state;
    }
    public void setState(String stateIn) {
        this.state = stateIn;
    }
    public String getPostal_code() {
        return this.postal_code;
    }
    public void setPostal_code(String postal_codeIn) {
        this.postal_code = postal_codeIn;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phoneIn) {
        this.phone = phoneIn;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String emailIn) {
        this.email = emailIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return author_id == author.author_id &&
                first_name.equals(author.first_name) &&
                last_name.equals(author.last_name) &&
                street.equals(author.street) &&
                city.equals(author.city) &&
                state.equals(author.state) &&
                postal_code.equals(author.postal_code) &&
                phone.equals(author.phone) &&
                email.equals(author.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(author_id, first_name, last_name, street, city, state, postal_code, phone, email);
    }
}
