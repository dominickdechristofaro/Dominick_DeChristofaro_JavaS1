/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.14.2019
 ** Description:    U1M2L2: Radio Class Example
 *************************************************************************************************/
package com.company;
public class Radio {
    // Variables
    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;

    // Constructors
    public Radio() {

    }
    public Radio(String manufacturerIn, String modelIn, int numSpeakerIn, String stationIn, int volumeIn, boolean poweredIn) {
        this.manufacturer = manufacturerIn;
        this.model = modelIn;
        this.numSpeaker = numSpeakerIn;
        this.station = stationIn;
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
    public int getNumSpeakers() {
        return this.numSpeaker;
    }
    public String getStation() {
        return this.station;
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
    public void setNumSpeakers(int numSpeakerIn) {
        this.numSpeaker = numSpeakerIn;
    }
    public void setStation(String stationIn) {
        this.station = stationIn;
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
