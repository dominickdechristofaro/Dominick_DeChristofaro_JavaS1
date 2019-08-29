package com.example.DayConverterWebService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayConverterWebServiceController {

    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String dayNumberConverter(@PathVariable int dayNumber) {
        if(dayNumber < 1 || dayNumber > 7) {
            throw new IllegalArgumentException("Input must be between 1 and 7.");
        }

        String dayNumberConverted;

        switch(dayNumber) {
            case 1:
                dayNumberConverted = "Monday";
                break;
            case 2:
                dayNumberConverted = "Tuesday";
                break;
            case 3:
                dayNumberConverted = "Wednesday";
                break;
            case 4:
                dayNumberConverted = "Thursday";
                break;
            case 5:
                dayNumberConverted = "Friday";
                break;
            case 6:
                dayNumberConverted = "Saturday";
                break;
            case 7:
                dayNumberConverted = "Sunday";
                break;
            default:
                dayNumberConverted = "Logic Error";
                break;

        }
        return dayNumberConverted;
    }
}
