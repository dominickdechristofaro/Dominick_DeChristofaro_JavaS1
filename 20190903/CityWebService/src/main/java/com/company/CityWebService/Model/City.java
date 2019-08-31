package com.company.CityWebService.Model;

import javax.validation.constraints.NotNull;

public class City {
    // Properties
    @NotNull(message = "You must enter a city name.")
    private String name;
    @NotNull(message = "You must enter the cities state.")
    private String state;
    @NotNull(message = "You must enter the cities population.")
    private Integer population;
    private boolean capital = false;

    // Getters
    public String getName() {
        return this.name;
    }
    public String getState() {
        return this.state;
    }
    public Integer getPopulation() {
        return this.population;
    }
    public boolean isCapital() {
        return this.capital;
    }

    // Setters
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public void setState(String stateIn) {
        this.state = stateIn;
    }
    public void setPopulation(Integer populationIn) {
        this.population = populationIn;
    }
    public void setCapital(boolean capitalIn) {
        this.capital = capitalIn;
    }
}
