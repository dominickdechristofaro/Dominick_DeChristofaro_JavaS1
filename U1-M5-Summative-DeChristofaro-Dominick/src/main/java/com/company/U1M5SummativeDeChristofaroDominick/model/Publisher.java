/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Publisher Model.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.model;
import java.util.Objects;

public class Publisher {
    // Properties
    private int publisher_id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;

    // Getters & Setters
    public int getPublisher_id() {
        return this.publisher_id;
    }
    public void setPublisher_id(int publisher_idIn) {
        this.publisher_id = publisher_idIn;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String nameIn) {
        this.name = nameIn;
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
        Publisher publisher = (Publisher) o;
        return publisher_id == publisher.publisher_id &&
                name.equals(publisher.name) &&
                street.equals(publisher.street) &&
                city.equals(publisher.city) &&
                state.equals(publisher.state) &&
                postal_code.equals(publisher.postal_code) &&
                phone.equals(publisher.phone) &&
                email.equals(publisher.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(publisher_id, name, street, city, state, postal_code, phone, email);
    }
}
