/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Engine Class for various Car types.
 *************************************************************************************************/
package com.company;

public class Engine {
    // Variable
    private String model;
    private int liter;

    // Constructors
    public Engine() {

    }
    public Engine(String modelIn, int literIn) {
        this.model = modelIn;
        this.liter = literIn;
    }

    // Getters
    public String getModel() {
        return this.model;
    }
    public int getLiter() {
        return this.liter;
    }

    // Setters
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setLiter(int literIn) {
        this.liter = literIn;
    }
}
