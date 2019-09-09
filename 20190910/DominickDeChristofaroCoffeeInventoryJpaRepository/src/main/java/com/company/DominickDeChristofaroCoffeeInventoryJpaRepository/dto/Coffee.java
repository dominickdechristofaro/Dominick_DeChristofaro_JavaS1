package com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="Coffee")
public class Coffee {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int roasterId;
    private String name;
    private int count;
    private BigDecimal unitPrice;
    private String description;
    private String type;

    // Getters & Setters
    public int getId() {
        return this.id;
    }
    public void setId(int idIn) {
        this.id = idIn;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public int getCount() {
        return this.count;
    }
    public void setCount(int countIn) {
        this.count = countIn;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String descriptionIn) {
        this.description = descriptionIn;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String typeIn) {
        this.type = typeIn;
    }
    public int getRoasterId() {
        return this.roasterId;
    }
    public void setRoasterId(int roasterIdIn) {
        this.roasterId = roasterIdIn;
    }
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPriceIn) {
        this.unitPrice = unitPriceIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return id == coffee.id &&
                roasterId == coffee.roasterId &&
                count == coffee.count &&
                name.equals(coffee.name) &&
                unitPrice.equals(coffee.unitPrice) &&
                Objects.equals(description, coffee.description) &&
                Objects.equals(type, coffee.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, roasterId, name, count, unitPrice, description, type);
    }
}
