/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Model for the TShirt object.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.model;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {
    // Properties
    // No Javax Validation
    private Long id;

    @NotNull(message = "You must input a size.")
    @Size(min = 1, max = 20, message = "The size must be between 1 and 20 characters.")
    private String size;

    @NotNull(message = "You must input a color.")
    @Size(min = 1, max = 20, message = "The color must be between 1 and 20 characters.")
    private String color;

    @NotNull(message = "You must input a description.")
    @Size(min = 1, max = 255, message = "The description must be between 1 and 255 characters.")
    private String description;

    @NotNull(message = "You must input a price.")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    private BigDecimal price;

    @NotNull(message = "You must input a quantity.")
    @PositiveOrZero(message = "The quantity must be zero or greater.")
    @Digits(integer = 11, fraction = 0)
    private Long quantity;

    // Getters & Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long idIn) {
        this.id = idIn;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String sizeIn) {
        this.size = sizeIn;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String colorIn) {
        this.color = colorIn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String descriptionIn) {
        this.description = descriptionIn;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal priceIn) {
        this.price = priceIn;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantityIn) {
        this.quantity = quantityIn;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return Objects.equals(id, tShirt.id) &&
                size.equals(tShirt.size) &&
                color.equals(tShirt.color) &&
                description.equals(tShirt.description) &&
                price.equals(tShirt.price) &&
                quantity.equals(tShirt.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }
}
