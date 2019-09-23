package com.company.DominickDeChristofaroU1Capstone.model;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesTaxRate {
    // Properties
    private String state;
    private BigDecimal rate;

    // Getters & Setters
    public String getState() {
        return this.state;
    }
    public void setState(String stateIn) {
        this.state = stateIn;
    }
    public BigDecimal getRate() {
        return this.rate;
    }
    public void setRate(BigDecimal rateIn) {
        this.rate = rateIn;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRate that = (SalesTaxRate) o;
        return state.equals(that.state) &&
                rate.equals(that.rate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }
}
