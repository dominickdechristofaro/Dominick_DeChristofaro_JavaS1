/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:    Models a Television.
 *************************************************************************************************/
public class Television {
    // Properties
    private String brand;
    private String model;
    private int price;
    private int screenSize;

    // Default Constructor
    public Television() {
    }

    /**
     *                      4-Parameter Constructor.
     * @param brand         Brand of the Television.
     * @param model         Model of the Television.
     * @param price         Price of the Television.
     * @param screenSize    Screen size of the Television.
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
