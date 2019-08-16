/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Example of a Class (Car) that implements a Vehicle interface.
 *************************************************************************************************/
package com.company;
import com.company.interfaces.Vehicle;

public class Car implements Vehicle {
    // Variables
    private String make;
    private String model;
    private int milesTraveled;

    // Constructors
    public Car() {

    }
    public Car(String makeIn, String modelIn, int milesTraveledIn) {
        this.make = makeIn;
        this.model = modelIn;
        this.milesTraveled = milesTraveledIn;
    }

    // Getters
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public int getMilesTraveled() {
        return this.milesTraveled;
    }

    // Setters
    public void setMake(String makeIn) {
        this.make = makeIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setMilesTraveled(int milesTraveledIn) {
        this.milesTraveled = milesTraveledIn;
    }

    // Methods
    public void drive(int miles) {

    }
    public void displayMilesTraveled() {

    }
}
