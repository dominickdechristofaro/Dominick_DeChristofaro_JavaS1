/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Models a Kitchen in a Home.
 *************************************************************************************************/
package com.company;

public class Kitchen extends Home {
    // Variables
    private int sqft;
    private int length;
    private int width;
    private String flooringType;
    private String counterType;
    private String refrigeratorModel;

    // Constructors
    public Kitchen() {

    }
    public Kitchen(int sqftIn, int lengthIn, int widthIn, String flooringTypeIn, String counterTypeIn, String refrigeratorModelIn) {
        this.sqft = sqftIn;
        this.length = lengthIn;
        this.width = widthIn;
        this.flooringType = flooringTypeIn;
        this.counterType = counterTypeIn;
        this.refrigeratorModel = refrigeratorModelIn;
    }

    // Getters
    public int getSqft() {
        return this.sqft;
    }
    public int getLength() {
        return this.length;
    }
    public int getWidth() {
        return this.width;
    }
    public String getFlooringType() {
        return this.flooringType;
    }
    public String getCounterType() {
        return this.counterType;
    }
    public String getRefrigeratorModel() {
        return this.refrigeratorModel;
    }

    // Setters
    public void setSqft(int sqftIn) {
        this.sqft = sqftIn;
    }
    public void setLength(int lengthIn) {
        this.length = lengthIn;
    }
    public void setWidth(int widthIn) {
        this.width = widthIn;
    }
    public void setFlooringType(String flooringTypeIn) {
        this.flooringType = flooringTypeIn;
    }
    public void setCounterType(String counterTypeIn) {
        this.counterType = counterTypeIn;
    }
    public void setRefrigeratorModel(String refrigeratorModelIn) {
        this.refrigeratorModel = refrigeratorModelIn;
    }

    // Methods
    public boolean lightsOnOff() {
        return true;
    }
    public void restockFridge() {

    }
    public void cleanOven() {

    }
}
