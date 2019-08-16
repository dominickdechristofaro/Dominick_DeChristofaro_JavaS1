/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Models a Patio in a Home.
 *************************************************************************************************/
package com.company;

public class Patio extends Home {
    // Variables
    private int sqft;
    private int length;
    private int width;
    private String flooringType;
    private String deckingMaterial;

    // Constructors
    public Patio() {

    }
    public Patio(int sqftIn, int lengthIn, int widthIn, String flooringTypeIn, String deckingMaterialIn) {
        this.sqft = sqftIn;
        this.length = lengthIn;
        this.width = widthIn;
        this.flooringType = flooringTypeIn;
        this.deckingMaterial = deckingMaterialIn;
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
    public String getDeckingMaterial() {
        return this.deckingMaterial;
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
    public void setDeckingMaterial(String deckingMaterialIn) {
        this.deckingMaterial = deckingMaterialIn;
    }

    // Methods
    public boolean lightsOnOff() {
        return true;
    }
    public void replaceLightbulb() {

    }
    public void newUmbrella() {

    }
}
