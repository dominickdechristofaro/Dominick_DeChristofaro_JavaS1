/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Television class to show JSON read and output functionality.
 *************************************************************************************************/
package com.company;

public class Television {
    // Properties
    private String brand;
    private String model;
    private int price;
    private int screenSize;

    // Constructors
    Television() {

    }

    /**
     *                      4-parameter constructor.
     * @param brand         A Television's brand.
     * @param model         A Television's model.
     * @param price         A Television's price.
     * @param screenSize    A Television's screen size.
     */
    public Television(String brand, String model, int price, int screenSize) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.screenSize = screenSize;
    }

    // Getters
    public String getBrand() {
        return this.brand;
    }
    public String getModel() {
        return this.model;
    }
    public int getPrice() {
        return this.price;
    }
    public int getScreenSize() {
        return this.screenSize;
    }

    // Setters
    public void setBrand(String brandIn) {
        this.brand = brandIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setPrice(int priceIn) {
        this.price = priceIn;
    }
    public void setScreenSize(int screenSizeIn) {
        this.screenSize = screenSizeIn;
    }
}
