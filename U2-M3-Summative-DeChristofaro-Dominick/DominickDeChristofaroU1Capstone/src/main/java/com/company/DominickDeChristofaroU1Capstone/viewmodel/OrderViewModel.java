/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    The OrderViewModel utilized for our endpoints available to the user.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.viewmodel;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class OrderViewModel {
    // Properties
    // No Javax Validation
    private Long id;

    @NotNull(message = "You must input a name.")
    @Size(min = 1, max = 80, message = "The name must be between 1 and 80 characters.")
    private String name;

    @NotNull(message = "You must input a street.")
    @Size(min = 1, max = 30, message = "The street must be between 1 and 30 characters.")
    private String street;

    @NotNull(message = "You must input a city.")
    @Size(min = 1, max = 30, message = "The city must be between 1 and 30 characters.")
    private String city;

    @NotNull(message = "You must input a state.")
    @Size(min = 1, max = 30, message = "The state must be between 1 and 30 characters.")
    private String state;

    @NotNull(message = "You must input a zipcode.")
    @Size(min = 5, max = 5, message = "The zipcode must be exactly 5 characters.")
    private String zipcode;

    @NotNull(message = "You must input an itemType.")
    @Size(min = 1, max = 20, message = "The itemType must be between 1 and 20 characters.")
    private String itemType;

    @NotNull(message = "You must input an itemId.")
    @Positive(message = "The itemId must be a positive number.")
    @Digits(integer = 11, fraction = 0)
    private Long itemId;

    // No Javax Validation
    private BigDecimal unitPrice;

    @NotNull(message = "You must input a quantity.")
    @Positive(message = "You quantity must be a positive number.")
    @Digits(integer = 11, fraction = 0)
    private Long quantity;

    // No Javax Validation
    private BigDecimal subtotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;

    // Getters & Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long idIn) {
        this.id = idIn;
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

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcodeIn) {
        this.zipcode = zipcodeIn;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemTypeIn) {
        this.itemType = itemTypeIn;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemIdIn) {
        this.itemId = itemIdIn;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPriceIn) {
        this.unitPrice = unitPriceIn;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantityIn) {
        this.quantity = quantityIn;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotalIn) {
        this.subtotal = subtotalIn;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public void setTax(BigDecimal taxIn) {
        this.tax = taxIn;
    }

    public BigDecimal getProcessingFee() {
        return this.processingFee;
    }

    public void setProcessingFee(BigDecimal processingFeeIn) {
        this.processingFee = processingFeeIn;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal totalIn) {
        this.total = totalIn;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderViewModel that = (OrderViewModel) o;
        return Objects.equals(id, that.id) &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipcode.equals(that.zipcode) &&
                itemType.equals(that.itemType) &&
                itemId.equals(that.itemId) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                quantity.equals(that.quantity) &&
                Objects.equals(subtotal, that.subtotal) &&
                Objects.equals(tax, that.tax) &&
                Objects.equals(processingFee, that.processingFee) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, itemType, itemId, unitPrice, quantity, subtotal, tax, processingFee, total);
    }
}
