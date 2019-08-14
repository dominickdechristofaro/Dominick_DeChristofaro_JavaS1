/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.14.2019
 ** Description:    U1M2L2: CoffeeMaker Class Example
 *************************************************************************************************/
package com.company;

public class CoffeeMaker {
    // Variables
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    // Constructors
    public CoffeeMaker() {

    }
    public CoffeeMaker(String manufacturerIn, String modelIn, int carafeSizeIn, int cupsLeftIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.carafeSize = carafeSizeIn;
        this.cupsLeft = cupsLeftIn;
        this.powered = poweredIn;
    }

    // Getters
    public String getManufacturer() {
        return this.manufacturer;
    }
    public String getModel() {
        return this.model;
    }
    public int getCarafeSize() {
        return this.carafeSize;
    }
    public int getCupsLeft() {
        return this.cupsLeft;
    }
    public boolean isPowered() {
        return this.powered;
    }

    // Setters
    public void setManufacturer(String manufacturerIn) {
        this.manufacturer = manufacturerIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setCarafeSize(int carafeSizeIn) {
        this.carafeSize = carafeSizeIn;
    }
    public void setCupsLeft(int cupsLeftIn) {
        this.cupsLeft = cupsLeftIn;
    }
    public void setPowered(boolean poweredIn) {
        this.powered = poweredIn;
    }

    // Methods
    public void brew() {

    }
    public void pourCoffee(int numCups) {

    }
}
