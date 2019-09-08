/* ************************************************************************************************
 **  Author:         Dominick DeChristofaro
 **  Date:           09/08/2019
 **  Description:    Model for Coffee.
 **************************************************************************************************/
package com.company.CoffeeInventoryDaoDominickDeChristofaro.model;
import java.math.BigDecimal;
import java.util.Objects;

public class Coffee {
    // Properties
    private int coffee_id;
    private int roaster_id;
    private String name;
    private int count;
    private BigDecimal unit_price;
    private String description;
    private String type;

    // Getters & Setters
    public int getCoffee_id() {
        return this.coffee_id;
    }
    public void setCoffee_id(int coffee_idIn) {
        this.coffee_id = coffee_idIn;
    }
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
    public int getCount() {
        return this.count;
    }
    public void setCount(int countIn) {
        this.count = countIn;
    }
    public BigDecimal getUnit_price() {
        return this.unit_price;
    }
    public void setUnit_price(BigDecimal unit_priceIn) {
        this.unit_price = unit_priceIn;
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

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return coffee_id == coffee.coffee_id &&
                roaster_id == coffee.roaster_id &&
                count == coffee.count &&
                name.equals(coffee.name) &&
                unit_price.equals(coffee.unit_price) &&
                Objects.equals(description, coffee.description) &&
                Objects.equals(type, coffee.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(coffee_id, roaster_id, name, count, unit_price, description, type);
    }
}
