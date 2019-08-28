package com.example.WeatherWebService.Controller;

import com.example.WeatherWebService.Model.Conditions;
import com.example.WeatherWebService.Model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherWebServiceController {

    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Temperature getTemperature(@PathVariable int zipcode) {
        if(zipcode < 0 || zipcode > 99999) {
            throw new IllegalArgumentException("zipcode must be between 00000 and 99999.");
        }

        Temperature temperature = new Temperature();
        temperature.setFahrenheit(78.6);
        temperature.setCelsius(25.8);

        return temperature;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Conditions getConditions(@PathVariable int zipcode) {
        if(zipcode < 0 || zipcode > 99999) {
            throw new IllegalArgumentException("zipcode must be between 00000 and 99999.");
        }
        Temperature temperature = new Temperature();
        temperature.setFahrenheit(86.4);
        temperature.setCelsius(30.2);

        Conditions conditions = new Conditions();
        conditions.setTemperature(temperature);
        conditions.setPrecipitation("Sunny");
        conditions.setSkies("Partly Cloudy");
        conditions.setWindDirection("North East");
        conditions.setWindSpeed(10);

        return conditions;
    }
}
