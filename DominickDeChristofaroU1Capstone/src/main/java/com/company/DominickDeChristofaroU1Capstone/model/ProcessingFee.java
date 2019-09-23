package com.company.DominickDeChristofaroU1Capstone.model;
import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {
    // Properties
    private String productType;
    private BigDecimal fee;

    // Getters & Setters
    public String getProductType() {
        return this.productType;
    }
    public void setProductType(String productTypeIn) {
        this.productType = productTypeIn;
    }
    public BigDecimal getFee() {
        return this.fee;
    }
    public void setFee(BigDecimal feeIn) {
        this.fee = feeIn;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return productType.equals(that.productType) &&
                Objects.equals(fee, that.fee);
    }
    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }
}
