/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    Main and Search menu for the Car Inventory Application
 *************************************************************************************************/
public class Menu {

    /**
     *              The main car inventory menu
     * @return      Integer value of the user's selection
     */
    public int carInventoryMenu() {
        HelperFunctions hf = new HelperFunctions();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Please make a selection:");
        System.out.println("1. Add a car to inventory");
        System.out.println("2. Delete a car from inventory");
        System.out.println("3. List all the cars in inventory");
        System.out.println("4. Search for a car");
        System.out.println("5. Terminate the program");
        System.out.println("-------------------------------------------------------------------");
        return hf.userInputInteger();
    }

    /**
     *              The Car Search Menu
     * @return      An integer that the user selects (Between 1 and 5).
     */
    public int carSearchMenu() {
        HelperFunctions hf = new HelperFunctions();
        System.out.println("What parameter would you like to search by?");
        System.out.println("1. Make");
        System.out.println("2. Model");
        System.out.println("3. Year");
        System.out.println("4. Color");
        System.out.println("5. Less than certain mileage");
        return hf.userInputInteger();
    }


}
