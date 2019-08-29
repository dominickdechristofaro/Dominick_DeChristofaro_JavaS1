package com.example.RESTCalculatorWebService.Controller;

import com.example.RESTCalculatorWebService.Model.Calculator;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestCalculatorWebServiceController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double addCalculator(@RequestBody @Valid Calculator calculator) throws InvalidFormatException {
        return calculator.getOperand1() + calculator.getOperand2();
    }

    @RequestMapping(value = "/mult", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double multiplyCalculator(@RequestBody @Valid Calculator calculator) throws InvalidFormatException {
        return calculator.getOperand1() * calculator.getOperand2();
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double subtractCalculator(@RequestBody @Valid Calculator calculator) throws InvalidFormatException {
        return calculator.getOperand1() - calculator.getOperand2();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public double divideCalculator(@RequestBody @Valid Calculator calculator) throws InvalidFormatException {
        if(calculator.getOperand2() == 0) {
            throw new ArithmeticException("operand2 cannot be 0");
        }
        return calculator.getOperand1() / calculator.getOperand2();
    }
}
