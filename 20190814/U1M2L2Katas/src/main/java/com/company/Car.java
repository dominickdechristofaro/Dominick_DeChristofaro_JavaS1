/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.14.2019
 ** Description:    U1M2L2: Car Class Example
 *************************************************************************************************/
package com.company;

public class Car {
    // Variables
    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmission;
    private int numDoors;
    private double mpg;
    private int milesDriven;

    // Constructors
    public Car() {

    }
    public Car(String makeIn, String modelIn, String typeIn, String colorIn, String engineIn, String transmissionIn, int numDoorsIn, double mpgIn, int milesDrivenIn) {
        this.make = makeIn;
        this.model = modelIn;
        this.type = typeIn;
        this.color = colorIn;
        this.engine = engineIn;
        this.transmission = transmissionIn;
        this.numDoors = numDoorsIn;
        this.mpg = mpgIn;
        this.milesDriven = milesDrivenIn;
    }

    // Getters
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public String getType() {
        return this.type;
    }
    public String getColor() {
        return this.color;
    }
    public String getEngine() {
        return this.engine;
    }
    public String getTransmission() {
        return this.transmission;
    }
    public int getNumDoors() {
        return this.numDoors;
    }
    public double getMpg() {
        return this.mpg;
    }
    public int getMilesDriven() {
        return this.milesDriven;
    }

    // Setters
    public void setMake(String makeIn) {
        this.make = makeIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setType(String typeIn) {
        this.type = typeIn;
    }
    public void setColor(String colorIn) {
        this.color = colorIn;
    }
    public void setEngine(String engineIn) {
        this.engine = engineIn;
    }
    public void setTransmission(String transmissionIn) {
        this.transmission = transmissionIn;
    }
    public void setNumDoors(int numDoorsIn) {
        this.numDoors = numDoorsIn;
    }
    public void setMpg(double mpgIn) {
        this.mpg = mpgIn;
    }
    public void setMilesDriven(int milesDrivenIn) {
        this.milesDriven = milesDrivenIn;
    }

    // Methods
    public void drive(int miles) {

    }
    public void honk() {

    }
}
