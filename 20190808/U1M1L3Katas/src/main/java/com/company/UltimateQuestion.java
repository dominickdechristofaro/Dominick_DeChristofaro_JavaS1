/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Prompt the user for any number between 1 and 100.  Continue to ask the user
 *                  for input until the user inputs 42.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class UltimateQuestion {
    public static void main(String[] args) {

        // Variables
        int userInput = 0;

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter a integer between 1 and 100
        System.out.println("Please enter an integer between 1 and 100");
        userInput = Integer.parseInt(scan.nextLine());

        // Check if the userInput was 42, if not, continue to ask the user for a number between 1 and 100
        while(userInput != 42) {
            System.out.println("That's not the number I was looking for, please enter a different number between 1 and 100");
            userInput = Integer.parseInt(scan.nextLine());
        }

        // Output that the user input the correct number
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
