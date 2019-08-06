/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Given a driveway's length and width, calculate the total cost of the
 *                  driveway, including subtotals for cement and footer costs.
 *************************************************************************************************/
package com.company;
import java.util.Scanner;

public class RectPavingCompany {
    public static void main(String[] args) {

        // Input Constants
        double cementCostPerSQFT = 12.50;
        double footerCostPerFT = 8.25;

        // Create a new Scanner object to read in user input.
        Scanner scan = new Scanner(System.in);

        // VERSION 1

        // Input the width of the driveway.
        System.out.println("Please input the width of the driveway as an integer (in feet).");
        int width = Integer.parseInt(scan.nextLine());

        // Input the length of the driveway.
        System.out.println("Please input the length of the driveway as an integer (in feet).");
        int length = Integer.parseInt(scan.nextLine());

        // Calculate and display the area of the driveway
        int area = width * length;
        System.out.println("The area of the driveway is " + area + " sqft.");

        // Calculate and display the perimeter of the driveway
        int perimeter = ((2 * width) + (2 * length));
        System.out.println("The perimeter of the driveway is " + perimeter + " ft.");

        // Calculate and display the total cost of the driveway and the subtotals.
        double cementCost = cementCostPerSQFT * area;
        double footerCost = footerCostPerFT * perimeter;
        double drivewayCost = cementCost + footerCost;
        System.out.format("The total cost of the cement is $%.2f%n", cementCost);
        System.out.format("The total cost of the footers is $%.2f%n", footerCost);
        System.out.format("The total cost of the driveway is $%.2f%n", drivewayCost);

        // VERSION 2

        // Input the cost of the cement.
        System.out.println("Please input the cost of the cement in USD($) to 2 decimal places.");
        cementCostPerSQFT = Double.parseDouble(scan.nextLine());

        // Input the cost of the footers.
        System.out.println("Please input the cost of the footers in USD($) to 2 decimal places.");
        footerCostPerFT = Double.parseDouble(scan.nextLine());

        // Calculate and display the total cost of the driveway and the subtotals.
        cementCost = cementCostPerSQFT * area;
        footerCost = footerCostPerFT * perimeter;
        drivewayCost = cementCost + footerCost;
        System.out.format("The total cost of the cement is $%.2f%n", cementCost);
        System.out.format("The total cost of the footers is $%.2f%n", footerCost);
        System.out.format("The total cost of the driveway is $%.2f%n", drivewayCost);
    }
}
