/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Model for the Console object.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.model;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {
    // Properties

    // No Javax Validation
    private Long id;

    @NotNull(message = "You must input a model.")
    @Size(min = 1, max = 50, message = "The model must be between 1 and 50 characters.")
    private String model;

    @NotNull(message = "You must input a manufacturer.")
    @Size(min = 1, max = 50, message = "The manufacturer must be between 1 and 50 characters.")
    private String manufacturer;

    // No Javax Validation
    private String memoryAmount;

    // No Javax Validation
    private String processor;

    @NotNull(message = "You must input a positive number for price.")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    private BigDecimal price;

    @NotNull(message = "You must input a quantity.")
    @PositiveOrZero(message = "The quantity must be zero or a positive number.")
    @Digits(integer = 11, fraction = 0)
    private Long quantity;

    // Getters & Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long idIn) {
        this.id = idIn;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String modelIn) {
        this.model = modelIn;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturerIn) {
        this.manufacturer = manufacturerIn;
    }

    public String getMemoryAmount() {
        return this.memoryAmount;
    }

    public void setMemoryAmount(String memoryAmountIn) {
        this.memoryAmount = memoryAmountIn;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processorIn) {
        this.processor = processorIn;
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
        Console console = (Console) o;
        return Objects.equals(id, console.id) &&
                model.equals(console.model) &&
                manufacturer.equals(console.manufacturer) &&
                Objects.equals(memoryAmount, console.memoryAmount) &&
                Objects.equals(processor, console.processor) &&
                price.equals(console.price) &&
                quantity.equals(console.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
