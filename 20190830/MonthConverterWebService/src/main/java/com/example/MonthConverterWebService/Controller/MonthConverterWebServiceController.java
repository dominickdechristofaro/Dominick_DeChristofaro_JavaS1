package com.example.MonthConverterWebService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterWebServiceController {

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String monthConverter(@PathVariable int monthNumber) {
        if(monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Input must be between 1 and 12.");
        }

        String monthNumberConverted;

        switch(monthNumber) {
            case 1:
                monthNumberConverted = "January";
                break;
            case 2:
                monthNumberConverted = "February";
                break;
            case 3:
                monthNumberConverted = "March";
                break;
            case 4:
                monthNumberConverted = "April";
                break;
            case 5:
                monthNumberConverted = "May";
                break;
            case 6:
                monthNumberConverted = "June";
                break;
            case 7:
                monthNumberConverted = "July";
                break;
            case 8:
                monthNumberConverted = "August";
                break;
            case 9:
                monthNumberConverted = "September";
                break;
            case 10:
                monthNumberConverted = "October";
                break;
            case 11:
                monthNumberConverted = "November";
                break;
            case 12:
                monthNumberConverted = "December";
                break;
            default:
                monthNumberConverted = "Logic Error";
                break;
        }
        return monthNumberConverted;
    }
}
