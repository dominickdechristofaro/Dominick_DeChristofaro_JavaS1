/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    Car Inventory Main method to run the Car Inventory application.
 *************************************************************************************************/
public class CarInventoryApp {
    public static void main(String[] args) {
        // Variables
        boolean runProgram = true;
        int userInputInteger = 0;
        Menu menu = new Menu();
        CarInventory carInventory = new CarInventory();

        // Welcome Message
        System.out.println("Welcome to the Car Inventory Program!");

        // Program Flow (Continue to run until 5 is input by the user)
        while(runProgram) {
            // Query the user for a selection
            userInputInteger = menu.carInventoryMenu();

            // Run method based on user selection
            switch(userInputInteger) {
                case 1:
                    carInventory.addCar();
                    break;
                case 2:
                    carInventory.deleteCar();
                    break;
                case 3:
                    carInventory.printCars(carInventory.getCarInventory());
                    break;
                case 4:
                    carInventory.searchCars();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    runProgram = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please choose 1 - 5");
                    break;
            }
        }
    }
}
