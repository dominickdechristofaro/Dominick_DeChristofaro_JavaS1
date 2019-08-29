package com.example.RESTCalculatorWebService.Model;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

public class Calculator {
    @NotNull(message = "You must input a value for 'operand1'.")
    @NumberFormat
    private Double operand1;
    @NotNull(message = "You must input a value for 'operand2'.")
    @NumberFormat
    private Double operand2;

    public Double getOperand1() {
        return this.operand1;
    }

    public void setOperand1(Double operand1In) {
        this.operand1 = operand1In;
    }

    public Double getOperand2() {
        return this.operand2;
    }

    public void setOperand2(Double operand2In) {
        this.operand2 = operand2In;
    }
}
