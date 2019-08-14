/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.14.2019
 ** Description:    U1M2L2: TV Class Example
 *************************************************************************************************/
package com.company;

public class TV {
    // Variables
    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    // Constructors
    public TV() {

    }
    public TV(String manufacturerIn, String modelIn, int screenSizeIn, String channelIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.screenSize = screenSizeIn;
        this.channel = channelIn;
        this.volume = volumeIn;
        this.powered = poweredIn;
    }

    // Getters
    public String getManufacturer() {
        return this.manufacturer;
    }
    public String getModel() {
        return this.model;
    }
    public int getScreenSize() {
        return this.screenSize;
    }
    public String getChannel() {
        return this.channel;
    }
    public int getVolume() {
        return this.volume;
    }
    public boolean isPowered() {
        return this.powered;
    }

    // Setters
    public void setManufacturer(String manufacturerIn) {
        this.manufacturer = manufacturerIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setScreenSize(int screenSizeIn) {
        this.screenSize = screenSizeIn;
    }
    public void setChannel(String channelIn) {
        this.channel = channelIn;
    }
    public void setVolume(int volumeIn) {
        this.volume = volumeIn;
    }
    public void setPowered(boolean poweredIn) {
        this.powered = poweredIn;
    }

    // Methods
    public void togglePower() {

    }
}
