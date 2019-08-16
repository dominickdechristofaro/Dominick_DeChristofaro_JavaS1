/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Models a Home with a Bathroom, Kitchen, Patio, Basement, and Sunroom.
 *************************************************************************************************/
package com.company;

public class Home {
    // Variables
    private int totalSQFT;
    private String flooringType;
    private Bathroom bathroom;
    private Kitchen kitchen;
    private Patio patio;
    private Basement basement;
    private Sunroom sunroom;

    // Constructors
    public Home() {

    }
    public Home(int totalSQFTIn, String flooringTypeIn, Bathroom bathroomIn, Kitchen kitchenIn, Patio patioIn, Sunroom sunroomIn, Basement basementIn) {
        this.totalSQFT = totalSQFTIn;
        this.flooringType = flooringTypeIn;
        this.bathroom = bathroomIn;
        this.kitchen = kitchenIn;
        this.patio = patioIn;
        this.basement = basementIn;
        this.sunroom = sunroomIn;
    }

    // Getters
    public int getTotalSQFT() {
        return this.totalSQFT;
    }
    public String getFlooringType() {
        return this.flooringType;
    }
    public Bathroom getBathroom() {
        return this.bathroom;
    }
    public Kitchen getKitchen() {
        return this.kitchen;
    }
    public Patio getPatio() {
        return this.patio;
    }
    public Basement getBasement() {
        return this.basement;
    }
    public Sunroom getSunroom() {
        return this.sunroom;
    }

    // Setters
    public void setTotalSQFT(int totalSQFTIn) {
        this.totalSQFT = totalSQFTIn;
    }
    public void setFlooringType(String flooringTypeIn) {
        this.flooringType = flooringTypeIn;
    }
    public void setBathroom(Bathroom bathroomIn) {
        this.bathroom = bathroomIn;
    }
    public void setKitchen(Kitchen kitchenIn) {
        this.kitchen = kitchenIn;
    }
    public void setPatio(Patio patioIn) {
        this.patio = patioIn;
    }
    public void setBasement(Basement basementIn) {
        this.basement = basementIn;
    }
    public void setSunroom(Sunroom sunroomIn) {
        this.sunroom = sunroomIn;
    }

    // Methods
    public void springCleaning() {

    }
    public void lockDoors() {

    }
}
