/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    Car Inventory Class to organize all our cars in an ArrayList.  Can add a car
 *                  to inventory. Delete a car from inventory. List all cars in inventory, and
 *                  search for a specific parameter in our car objects and display all matches.
 *************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarInventory {
    // Properties
    ArrayList<Car> carInventory;

    // Constructors
    public CarInventory() {
        // Create a new ArrayList to store our cars in inventory
        this.carInventory = new ArrayList<>();

        // Add 8 cars to the inventory to begin.
        carInventory.add(new Car("Toyota", "Camry", 2000, "Blue", 10000));
        carInventory.add(new Car( "Honda", "Civic", 2005, "Silver", 20500));
        carInventory.add(new Car( "Honda", "Accord", 2018, "Yellow", 120500));
        carInventory.add(new Car( "Honda", "Rav4", 2015, "Black", 50500));
        carInventory.add(new Car( "Honda", "Civic", 2003, "Gold", 150500));
        carInventory.add(new Car( "Jeep", "Wrangler", 2009, "Rust", 35000));
        carInventory.add(new Car( "Telsa", "Roadster", 2018, "Black", 5000));
        carInventory.add(new Car( "Ford", "Mustang", 1964, "Red", 250000));
    }

    // Getters
    public ArrayList<Car> getCarInventory() {
        return this.carInventory;
    }

    // Setters
    public void setCarInventory(ArrayList<Car> carInventoryIn) {
        this.carInventory = carInventoryIn;
    }

    /**
     * Add a car to our car inventory ArrayList.
     */
    public void addCar() {
        HelperFunctions hf = new HelperFunctions();

        // Prompt for a Make
        System.out.print("Please input a car make: ");
        String make = hf.userInputString();

        // Prompt for a Model
        System.out.print("Please input a car model: ");
        String model = hf.userInputString();

        // Prompt for a Year
        System.out.print("Please input the manufacturer year of the car: ");
        int year = hf.userInputInteger();

        // Prompt for a Color
        System.out.print("Please input the car color: ");
        String color = hf.userInputString();

        // Prompt for a Mileage
        System.out.print("Please input the car mileage: ");
        int miles = hf.userInputInteger();

        // Construct the new car
        Car carTemp = new Car(make, model, year, color, miles);

        // Add the car to the carInventory
        carInventory.add(carTemp);

        // Alert the user that the car creation process is complete
        System.out.println("------You have added the following car to your car inventory-------");
        System.out.println("Car ID: " + carTemp.getIDNumber());
        System.out.println("Make  : " + carTemp.getMake());
        System.out.println("Model : " + carTemp.getModel());
        System.out.println("Year  : " + carTemp.getYear());
        System.out.println("Color : " + carTemp.getColor());
        System.out.println("Miles : " + carTemp.getMiles());
    }

    /**
     * Delete a car from the car inventory by utilizing the Car IDNumber.
     */
    public void deleteCar() {
        if(carInventory.size() <= 0) {
            System.out.println("Your car inventory is empty!");
        } else {
            HelperFunctions hf = new HelperFunctions();
            System.out.print("Please input the car ID that you would like to delete: ");
            int userInputInteger = hf.userInputInteger();
            int carID = -1;
            for (int i = 0; i < carInventory.size(); i++) {
                if (userInputInteger == carInventory.get(i).getIDNumber()) {
                    carID = carInventory.get(i).getIDNumber();
                    carInventory.remove(i);
                    break;
                }
            }
            if(carID >= 0) {
                System.out.println("You have successfully deleted carID: " + carID);
            } else {
                System.out.println("Car ID: " + userInputInteger + " does not exist in inventory.");
            }
        }
    }

    /**
     * Print all the cars in the carInventory List or the query of cars.
     * @param carList   An ArrayList of type Car.
     */
    public void printCars(List<Car> carList) {
        if(carInventory.size() > 0) {
            System.out.println("|------------------------Car Inventory List-----------------------|");
            System.out.println("|  Car ID  |   Make   |   Model  |   Year   |   Color  |   Miles  |");
            System.out.println("|----------|----------|----------|----------|----------|----------|");
            for (int i = 0; i < carList.size(); i++) {
                System.out.printf("|%-10s", carList.get(i).getIDNumber());
                System.out.printf("|%-10s", carList.get(i).getMake());
                System.out.printf("|%-10s", carList.get(i).getModel());
                System.out.printf("|%-10s", carList.get(i).getYear());
                System.out.printf("|%-10s", carList.get(i).getColor());
                System.out.printf("|%-10s|%n", carList.get(i).getMiles());
            }
        } else {
            System.out.println("Your car inventory is empty!");
        }
    }

    /**
     * Query the car inventory by a specific parameter.
     */
    public void searchCars() {
        Menu menu = new Menu();
        HelperFunctions hf = new HelperFunctions();
        List<Car> queryList;
        int userInputInteger = menu.carSearchMenu();
        int userInputInteger2;
        String userInputString;

        switch(userInputInteger) {
            case 1:
                System.out.print("Input make to search for: ");
                userInputString = hf.userInputString();
                queryList = carInventory.stream().filter(car -> car.getMake().equalsIgnoreCase(userInputString)).collect(Collectors.toList());
                printCars(queryList);
                break;
            case 2:
                System.out.print("Input model to search for: ");
                userInputString = hf.userInputString();
                queryList = carInventory.stream().filter(car -> car.getModel().equalsIgnoreCase(userInputString)).collect(Collectors.toList());
                printCars(queryList);
                break;
            case 3:
                System.out.print("Input year to search for: ");
                userInputInteger2 = hf.userInputInteger();
                queryList = carInventory.stream().filter(car -> car.getYear() == userInputInteger2).collect(Collectors.toList());
                printCars(queryList);
                break;
            case 4:
                System.out.print("Input color to search for: ");
                userInputString = hf.userInputString();
                queryList = carInventory.stream().filter(car -> car.getColor().equalsIgnoreCase(userInputString)).collect(Collectors.toList());
                printCars(queryList);
                break;
            case 5:
                System.out.print("What is the maximum mileage a car may have? ");
                userInputInteger2 = hf.userInputInteger();
                queryList = carInventory.stream().filter(car -> car.getMiles() <= userInputInteger2).collect(Collectors.toList());
                printCars(queryList);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
}
