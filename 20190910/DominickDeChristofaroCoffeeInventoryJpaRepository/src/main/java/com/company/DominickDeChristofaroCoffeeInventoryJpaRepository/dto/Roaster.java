package com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="Roaster")
public class Roaster {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;
    private String note;
    @OneToMany(mappedBy = "roasterId" ,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Coffee> coffees;

    // Getters & Setters
    public int getId() {
        return this.id;
    }
    public void setId(int idIn) {
        this.id = idIn;
    }
    public Set<Coffee> getCoffees() {
        return this.coffees;
    }
    public void setCoffees(Set<Coffee> coffeesIn) {
        this.coffees = coffeesIn;
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
    public String getPostalCode() {
        return this.postalCode;
    }
    public void setPostalCode(String postalCodeIn) {
        this.postalCode = postalCodeIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return id == roaster.id &&
                name.equals(roaster.name) &&
                street.equals(roaster.street) &&
                city.equals(roaster.city) &&
                state.equals(roaster.state) &&
                postalCode.equals(roaster.postalCode) &&
                phone.equals(roaster.phone) &&
                email.equals(roaster.email) &&
                Objects.equals(note, roaster.note) &&
                Objects.equals(coffees, roaster.coffees);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, postalCode, phone, email, note, coffees);
    }
}
