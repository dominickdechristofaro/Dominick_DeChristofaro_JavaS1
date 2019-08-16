/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Models a bathroom in a home.
 *************************************************************************************************/
package com.company;

public class Bathroom {
    // Variables
    private int sqft;
    private int length;
    private int width;
    private String flooringType;
    private String toiletModel;
    private boolean isBathtub;

    // Constructors
    public Bathroom() {

    }
    public Bathroom(int sqftIn, int lengthIn, int widthIn, String flooringTypeIn, String toiletModelIn, boolean isBathtubIn) {
        this.sqft = sqftIn;
        this.length = lengthIn;
        this.width = widthIn;
        this.flooringType = flooringTypeIn;
        this.toiletModel = toiletModelIn;
        this.isBathtub = isBathtubIn;
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
    public String getToiletModel() {
        return this.toiletModel;
    }
    public boolean isBathtub() {
        return this.isBathtub;
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
    public void setToiletModel(String toiletModelIn) {
        this.toiletModel = toiletModelIn;
    }
    public void setBathtub(boolean bathtubIn) {
        this.isBathtub = bathtubIn;
    }

    // Methods
    public boolean sinkOnOff() {
        return true;
    }
    public boolean lightsOnOff() {
        return true;
    }
    public void flushToilet() {

    }
}
