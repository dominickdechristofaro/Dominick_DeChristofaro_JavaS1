/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Calculate how much luxury tax a hypothetical sports team will pay to sign
 *                  three players.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class LuxuryTaxCalculator {
    public static void main(String[] args) {
        // Define constants
        double SPENDING_LIMIT = 40000000.00;
        double LUXURY_TAX = 0.18;

        // Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        // Input the salary for Player 1
        System.out.println("Please input the salary for Player 1 (without $ or ,)");
        double player1Salary = Double.parseDouble(scan.nextLine());

        // Input the salary for Player 2
        System.out.println("Please input the salary for Player 2 (without $ or ,)");
        double player2Salary = Double.parseDouble(scan.nextLine());

        // Input the salary for Player 3
        System.out.println("Please input the salary for Player 3 (without $ or ,)");
        double player3Salary = Double.parseDouble(scan.nextLine());

        // Calculate and display the total salary for all 3 players
        double totalSalary = player1Salary + player2Salary + player3Salary;
        System.out.format("The total salary for all 3 players is $%.2f%n", totalSalary);

        // Determine if the team went over the spending limit and apply a luxury tax if required.
        if(totalSalary <= SPENDING_LIMIT) {
            System.out.format("The total cost of your team was less than $%.0f%n", SPENDING_LIMIT);
            System.out.println("No luxury tax was applied.");
        }
        else if(totalSalary > SPENDING_LIMIT) {
            System.out.format("The total cost of your team was greater than $%.0f.%n", SPENDING_LIMIT);
            System.out.format("A luxury tax of %.0f%% will be applied to the excess amount of $%.2f.%n", (LUXURY_TAX * 100.0), (totalSalary - SPENDING_LIMIT));
            double luxuryTaxCalculated = (totalSalary - SPENDING_LIMIT) * LUXURY_TAX;
            System.out.format("The calculated luxury tax is $%.2f%n", luxuryTaxCalculated);
        }

    }
}
