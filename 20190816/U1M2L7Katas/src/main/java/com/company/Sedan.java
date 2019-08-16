/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Example of a Sedan that extends the Car class.
 *************************************************************************************************/
package com.company;

public class Sedan extends Car {
    // Variables
    private int numDoors;
    private boolean poweredWindows;

    // Constructors
    public Sedan() {

    }
    public Sedan(int numDoorsIn, boolean poweredWindowsIn) {
        this.numDoors = numDoorsIn;
        this.poweredWindows = poweredWindowsIn;
    }

    // Getters
    public int getNumDoors() {
        return this.numDoors;
    }
    public boolean isPoweredWindows() {
        return this.poweredWindows;
    }

    // Setters
    public void setNumDoors(int numDoorsIn) {
        this.numDoors = numDoorsIn;
    }
    public void setPoweredWindows(boolean poweredWindowsIn) {
        this.poweredWindows = poweredWindowsIn;
    }
}
