/* ************************************************************************************************
 **  Author:         Dominick DeChristofaro
 **  Date:           09/08/2019
 **  Description:    Model for Roaster.
 **************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.model;
import java.util.Objects;

public class Roaster {
    // Properties
    private int roaster_id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;
    private String note;

    // Getters & Setters
    public int getRoaster_id() {
        return this.roaster_id;
    }
    public void setRoaster_id(int roaster_idIn) {
        this.roaster_id = roaster_idIn;
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
    public String getNote() {
        return this.note;
    }
    public void setNote(String noteIn) {
        this.note = noteIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return roaster_id == roaster.roaster_id &&
                name.equals(roaster.name) &&
                street.equals(roaster.street) &&
                city.equals(roaster.city) &&
                state.equals(roaster.state) &&
                postal_code.equals(roaster.postal_code) &&
                phone.equals(roaster.phone) &&
                email.equals(roaster.email) &&
                Objects.equals(note, roaster.note);
    }
    @Override
    public int hashCode() {
        return Objects.hash(roaster_id, name, street, city, state, postal_code, phone, email, note);
    }
}
