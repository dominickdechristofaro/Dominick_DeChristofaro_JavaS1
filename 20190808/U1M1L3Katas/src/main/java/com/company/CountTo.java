/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Output numbers to the terminal from 0 to userInput
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class CountTo {
    public static void main(String[] args) {

        // Variables
        int userInput = 0;

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.println("Please enter a number.");
        userInput = Integer.parseInt(scan.nextLine());

        // Print out all numbers between 0 and userInput
        for(int i = 0; i <= userInput; i++) {
            System.out.println(i);
        }
    }
}
