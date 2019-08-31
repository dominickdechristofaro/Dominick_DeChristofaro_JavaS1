package com.company.CityWebService.Controller;

import com.company.CityWebService.Model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class CityWebServiceController {
    Map<String, City> cities = new HashMap<>();

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<City> getCities() {
        return cities.values();
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity(@RequestBody @Valid City city) {
        City newCity = new City();
        if(cities.containsKey(city.getName().toLowerCase().replace(' ', '_'))) {
            throw new IllegalArgumentException("This city already exists in the list. City names must be unique.");
        } else {
            newCity.setName(city.getName().toLowerCase().replace(' ', '_'));
            newCity.setState(city.getState().toLowerCase().replace(' ', '_'));
            newCity.setPopulation(city.getPopulation());
            newCity.setCapital(city.isCapital());
            cities.put(newCity.getName(), newCity);
        }
        return newCity;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCity(@PathVariable String name) {
        if(cities.containsKey(name)) {
            cities.remove(name);
        } else {
            throw new IllegalArgumentException("The city you input is not in the list. " +
                "Please ensure that there are no spaces in your query. Substitute underscore " +
                "for spaces. Use all lower case characters.");
        }
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public City getCity(@PathVariable String name) {
         if(!cities.containsKey(name)) {
             throw new IllegalArgumentException("The city you input is not in the list. " +
                     "Please ensure that there are no spaces in your query. Substitute underscore " +
                     "for spaces. Use all lower case characters.");
         }
         return cities.get(name);
    }
}
