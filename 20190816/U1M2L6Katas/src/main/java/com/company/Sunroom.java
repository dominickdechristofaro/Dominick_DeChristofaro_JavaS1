/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Models a Sunroom of a Home.
 *************************************************************************************************/
package com.company;

public class Sunroom {
    // Variables
    private int sqft;
    private int length;
    private int width;
    private String flooringType;
    private int numOfWindows;

    // Constructors
    public Sunroom() {

    }
    public Sunroom(int sqftIn, int lengthIn, int widthIn, String flooringTypeIn, int numOfWindowsIn) {
        this.sqft = sqftIn;
        this.length = lengthIn;
        this.width = widthIn;
        this.flooringType = flooringTypeIn;
        this.numOfWindows = numOfWindowsIn;
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
    public int getNumOfWindows() {
        return this.numOfWindows;
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
    public void setNumOfWindows(int numOfWindowsIn) {
        this.numOfWindows = numOfWindowsIn;
    }

    // Methods
    public void lightsOnOff() {

    }
    public void openWindows() {

    }
    public void closeDoor() {

    }
}
