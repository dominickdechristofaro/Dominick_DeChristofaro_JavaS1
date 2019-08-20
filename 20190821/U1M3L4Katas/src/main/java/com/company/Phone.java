/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Phone Class to be used with PhoneReader to demonstrate XML reading and output.
 *************************************************************************************************/
package com.company;

public class Phone {
    // Properties
    private String brand;
    private String model;
    private String processor;
    private int storage;
    private int price;

    // Default Constructor
    public Phone() {
    }

    /**
     *                      5-Parameter Constructor.
     * @param brand         A Phone brand.
     * @param model         A Phone model.
     * @param processor     A Phone processor model.
     * @param storage       A Phone storage.
     * @param price         A Phone's price.
     */
    public Phone(String brand, String model, String processor, int storage, int price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.storage = storage;
        this.price = price;
    }

    // Getters
    public String getBrand() {
        return this.brand;
    }
    public String getModel() {
        return this.model;
    }
    public String getProcessor() {
        return this.processor;
    }
    public int getStorage() {
        return this.storage;
    }
    public int getPrice() {
        return this.price;
    }

    // Setters
    public void setBrand(String brandIn) {
        this.brand = brandIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setProcessor(String processorIn) {
        this.processor = processorIn;
    }
    public void setStorage(int storageIn) {
        this.storage = storageIn;
    }
    public void setPrice(int priceIn) {
        this.price = priceIn;
    }
}
