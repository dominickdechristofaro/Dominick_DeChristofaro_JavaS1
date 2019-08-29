package com.example.WeatherWebService.Model;

public class Conditions {
    private Temperature temperature;
    private int windSpeed;
    private String windDirection;
    private String skies;
    private String precipitation;

    public Temperature getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Temperature temperatureIn) {
        this.temperature = temperatureIn;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(int windSpeedIn) {
        this.windSpeed = windSpeedIn;
    }

    public String getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(String windDirectionIn) {
        this.windDirection = windDirectionIn;
    }

    public String getSkies() {
        return this.skies;
    }

    public void setSkies(String skiesIn) {
        this.skies = skiesIn;
    }

    public String getPrecipitation() {
        return this.precipitation;
    }

    public void setPrecipitation(String precipitationIn) {
        this.precipitation = precipitationIn;
    }
}
