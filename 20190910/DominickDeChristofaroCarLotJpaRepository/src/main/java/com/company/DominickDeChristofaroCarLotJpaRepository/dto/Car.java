package com.company.DominickDeChristofaroCarLotJpaRepository.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="Car")
public class Car {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String make;
    private String model;
    private String year;
    private String color;

    // Getters & Setters
    public int getId() {
        return this.id;
    }
    public void setId(int idIn) {
        this.id = idIn;
    }
    public String getMake() {
        return this.make;
    }
    public void setMake(String makeIn) {
        this.make = makeIn;
    }
    public String getModel() {
        return this.model;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public String getYear() {
        return this.year;
    }
    public void setYear(String yearIn) {
        this.year = yearIn;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String colorIn) {
        this.color = colorIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                make.equals(car.make) &&
                model.equals(car.model) &&
                year.equals(car.year) &&
                color.equals(car.color);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, year, color);
    }
}
