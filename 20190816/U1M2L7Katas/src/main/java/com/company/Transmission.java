/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Transmission classes for use in Car type classes.
 *************************************************************************************************/
package com.company;

public class Transmission {
    // Variables
    private String type;
    private int cylinders;

    // Constructors
    public Transmission() {

    }
    public Transmission(String typeIn, int cylindersIn) {
        this.type = typeIn;
        this.cylinders = cylindersIn;
    }

    // Getters
    public String getType() {
        return this.type;
    }
    public int getCylinders() {
        return this.cylinders;
    }

    // Setters
    public void setType(String typeIn) {
        this.type = typeIn;
    }
    public void setCylinders(int cylindersIn) {
        this.cylinders = cylindersIn;
    }
}
