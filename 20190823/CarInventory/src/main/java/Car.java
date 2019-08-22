/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    Models a Car for our Car inventory.
 *************************************************************************************************/
public class Car {
    // Properties
    private String make;
    private String model;
    private int year;
    private String color;
    private int miles;
    private int IDNumber;
    private static int carID = 0;

    // Constructors
    public Car() {
    }
    public Car(String make, String model, int year, String color, int miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.miles = miles;
        this.IDNumber = carID;
        carID++;
    }

    // Getters
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public int getYear() {
        return this.year;
    }
    public String getColor() {
        return this.color;
    }
    public int getMiles() {
        return this.miles;
    }
    public int getCarID() {
        return carID;
    }
    public int getIDNumber() {
        return this.IDNumber;
    }

    // Setters
    public void setMake(String makeIn) {
        this.make = makeIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setYear(int yearIn) {
        this.year = yearIn;
    }
    public void setColor(String colorIn) {
        this.color = colorIn;
    }
    public void setMiles(int milesIn) {
        this.miles = milesIn;
    }
    public void setIDNumber(int IDNumberIn) {
        this.IDNumber = IDNumberIn;
    }
}