/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Ice cream as it might be modeled in the point-of-sale system in an
 *                  ice cream shop.
 *************************************************************************************************/
import java.util.Scanner;

public class IceCreamShop {
    /**********************************************************************************************
     * Variables
     *********************************************************************************************/
    private double iceCreamScoopCost;
    private double toppingCost;
    private String[] iceCreamFlavors;

    /**********************************************************************************************
     * Default constructor that forces you to set prices and flavors of ice cream when
     * an IceCreamShop object is instantiated.
     *********************************************************************************************/
    public IceCreamShop() {
        setIceCreamScoopCost();
        setToppingCost();
        setIceCreamFlavors();
    }

    /**********************************************************************************************
     * Getters
     *********************************************************************************************/
    public double getIceCreamScoopCost() {
        return this.iceCreamScoopCost;
    }
    public double getToppingCost() {
        return this.toppingCost;
    }
    public String[] getIceCreamFlavors() {
        return this.iceCreamFlavors;
    }
    public String getIceCreamFlavor(int index) {
        return this.iceCreamFlavors[index];
    }

    /**********************************************************************************************
     * Setters
     *********************************************************************************************/
    public void setIceCreamScoopCost() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much will a scoop of Ice Cream cost?");
        this.iceCreamScoopCost = Double.parseDouble(scanner.nextLine());
    }
    public void setToppingCost() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much will toppings cost?");
        this.toppingCost = Double.parseDouble(scanner.nextLine());
    }
    public void setIceCreamFlavors() {
        Scanner scanner = new Scanner(System.in);
        String[] flavors = new String[3];
        System.out.println("What 3 flavors will you serve?");
        for(int i = 0; i < flavors.length; i++) {
            flavors[i] = scanner.nextLine();
        }
        this.iceCreamFlavors = flavors;
    }

    /**********************************************************************************************
     * Calculates the cost of an ice cream sale given the userInput number of Scoops
     * and userInput number of toppings of ice cream.  Reports the total cost and type of
     * ice cream selected.
     *********************************************************************************************/
    public void pointOfSale() {
        // Variables
        int numOfScoops;
        int numOfToppings;
        int flavorChoice;
        double cost;

        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the flavor of Ice Cream they would like
        System.out.println("Which flavor of Ice Cream would you like?");
        for(int i = 0; i < getIceCreamFlavors().length; i++) {
            System.out.println(i + 1 + ". " + getIceCreamFlavor(i));
        }
        flavorChoice = Integer.parseInt(scanner.nextLine());
        System.out.println(" ");

        // Prompt the user for hte number of Scoops they would like
        System.out.println("How many scoops of Ice Cream would you like?");
        numOfScoops = Integer.parseInt(scanner.nextLine());
        System.out.println(" ");

        // Prompt the user for the number of toppings they would like
        System.out.println("How many toppings would you like?");
        numOfToppings = Integer.parseInt(scanner.nextLine());

        // Calculate the total cost for the ice cream
        cost = (getToppingCost() * numOfToppings) + (getIceCreamScoopCost() * numOfScoops);

        // Return the cost
        System.out.println("You choose to have " + numOfScoops + " scoops of " + getIceCreamFlavor(flavorChoice - 1) + " ice cream with " + numOfToppings + " toppings!");
        System.out.format("Your total cost is \u0024%.2f", cost);
    }
}
