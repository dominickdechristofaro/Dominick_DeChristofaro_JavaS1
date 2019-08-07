/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Asks a user for a number between 15 and 32 (not inclusive).
 *                  If the user provides valid input, output the input to the console.
 *                  If the user provides invalid input, reprompt the user for valid input.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class RangeChecker {
    public static void main(String[] args) {

        // Variables
        double userInput = 0.0;

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for a number between 15 and 32 (not inclusive)
        System.out.println("Please enter a number between 15 and 32 (non-inclusive)");
        userInput = Double.parseDouble(scan.nextLine());

        // Continue to prompt the user for input until they input a number between 15 and 32 (non-inclusive)
        while(userInput <= 15 || userInput >= 32) {
            System.out.println("Invalid input, please enter a number between 15 and 32 (non-inclusive)");
            userInput = Double.parseDouble(scan.nextLine());
        }

        // Output the number input to the console
        System.out.println(userInput);
    }
}
