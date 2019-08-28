package com.example.WeatherWebService.Model;

public class Temperature {
    private double fahrenheit;
    private double celsius;

    public double getFahrenheit() {
        return this.fahrenheit;
    }

    public void setFahrenheit(double fahrenheitIn) {
        this.fahrenheit = fahrenheitIn;
    }

    public double getCelsius() {
        return this.celsius;
    }

    public void setCelsius(double celsiusIn) {
        this.celsius = celsiusIn;
    }
}
