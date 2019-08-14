/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.14.2019
 ** Description:    U1M2L2: ComputerMouse Class Example
 *************************************************************************************************/
package com.company;

public class ComputerMouse {
    // Variables
    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    // Constructors
    public ComputerMouse() {

    }
    public ComputerMouse(String manufacturerIn, String modelIn, int xPositionIn, int yPositionIn, int[] lastClickedLocationIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.xPosition = xPositionIn;
        this.yPosition = yPositionIn;
        this.lastClickedLocation = lastClickedLocationIn;
    }

    // Getters
    public String getManufacturer() {
        return this.manufacturer;
    }
    public String getModel() {
        return this.model;
    }
    public int getxPosition() {
        return this.xPosition;
    }
    public int getyPosition() {
        return this.yPosition;
    }
    public int[] getLastClickedLocation() {
        return this.lastClickedLocation;
    }

    // Setters
    public void setManufacturer(String manufacturerIn) {
        this.manufacturer = manufacturerIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setxPosition(int xPositionIn) {
        this.xPosition = xPositionIn;
    }
    public void setyPosition(int yPositionIn) {
        this.yPosition = yPositionIn;
    }
    public void setLastClickedLocation(int[] lastClickedLocationIn) {
        this.lastClickedLocation = lastClickedLocationIn;
    }

    // Methods
    public void move(int deltaX, int deltaY) {

    }
    public void click() {

    }
}
