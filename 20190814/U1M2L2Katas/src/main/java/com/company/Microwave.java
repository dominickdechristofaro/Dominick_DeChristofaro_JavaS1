/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.14.2019
 ** Description:    U1M2L2: Microwave Class Example
 *************************************************************************************************/
package com.company;

public class Microwave {
    // Variables
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    // Constructors
    public Microwave() {

    }
    public Microwave(String manufacturerIn, String modelIn, int secondsLeftIn, String timeIn, boolean runningIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.secondsLeft = secondsLeftIn;
        this.time = timeIn;
        this.running = runningIn;
    }

    // Getters
    public String getManufacturer() {
        return this.manufacturer;
    }
    public String getModel() {
        return this.model;
    }
    public int getSecondsLeft() {
        return this.secondsLeft;
    }
    public String getTime() {
        return this.time;
    }
    public boolean isRunning() {
        return this.running;
    }

    // Setters
    public void setManufacturer(String manufacturerIn) {
        this.manufacturer = manufacturerIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setSecondsLeft(int secondsLeftIn) {
        this.secondsLeft = secondsLeftIn;
    }
    public void setTime(String timeIn) {
        this.time = timeIn;
    }
    public void setRunning(boolean runningIn) {
        this.running = runningIn;
    }

    // Methods
    public void start(int secondsLeft) {

    }
    public void stop() {

    }
    public void clear() {

    }
}
