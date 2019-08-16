/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Models a Basement in a Home
 *************************************************************************************************/
package com.company;

public class Basement {
    // Variables
    private int sqft;
    private int length;
    private int width;
    private String flooringType;
    private boolean isFinished;
    private int numOfLights;

    // Constructors
    public Basement() {

    }
    public Basement(int sqftIn, int lengthIn, int widthIn, String flooringTypeIn, boolean isFinishedIn, int numOfLightsIn) {
        this.sqft = sqftIn;
        this.length = lengthIn;
        this.width = widthIn;
        this.flooringType = flooringTypeIn;
        this.isFinished = isFinishedIn;
        this.numOfLights = numOfLightsIn;
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
    public boolean isFinished() {
        return this.isFinished;
    }
    public int getNumOfLights() {
        return this.numOfLights;
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
    public void setFinished(boolean finishedIn) {
        this.isFinished = finishedIn;
    }
    public void setNumOfLights(int numOfLightsIn) {
        this.numOfLights = numOfLightsIn;
    }

    // Methods
    public void lightsOnOff() {

    }
}
