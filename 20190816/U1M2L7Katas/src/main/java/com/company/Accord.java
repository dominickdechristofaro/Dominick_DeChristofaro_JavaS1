/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Example of an Accord Class that extends the Sedan Class.
 *************************************************************************************************/
package com.company;

public class Accord extends Sedan {
    // Variables
    private String year;
    private Engine engine;
    private Transmission transmission;

    // Constructors
    public Accord() {

    }
    public Accord(String yearIn, Engine engineIn, Transmission transmissionIn) {
        this.year = yearIn;
        this.engine = engineIn;
        this.transmission = transmissionIn;
    }

    // Getters
    public String getYear() {
        return this.year;
    }
    public Engine getEngine() {
        return this.engine;
    }
    public Transmission getTransmission() {
        return this.transmission;
    }

    // Setters
    public void setYear(String yearIn) {
        this.year = yearIn;
    }
    public void setEngine(Engine engineIn) {
        this.engine = engineIn;
    }
    public void setTransmission(Transmission transmissionIn) {
        this.transmission = transmissionIn;
    }
}
