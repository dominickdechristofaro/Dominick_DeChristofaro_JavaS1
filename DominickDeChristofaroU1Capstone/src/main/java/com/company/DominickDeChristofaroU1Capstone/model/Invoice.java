package com.company.DominickDeChristofaroU1Capstone.model;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {
    // Properties
    private Long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String itemType;
    private Long itemId;
    private BigDecimal unitPrice;
    private Long quantity;
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
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipcode.equals(invoice.zipcode) &&
                itemType.equals(invoice.itemType) &&
                itemId.equals(invoice.itemId) &&
                unitPrice.equals(invoice.unitPrice) &&
                quantity.equals(invoice.quantity) &&
                subtotal.equals(invoice.subtotal) &&
                tax.equals(invoice.tax) &&
                processingFee.equals(invoice.processingFee) &&
                total.equals(invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipcode, itemType, itemId, unitPrice, quantity, subtotal, tax, processingFee, total);
    }
}
