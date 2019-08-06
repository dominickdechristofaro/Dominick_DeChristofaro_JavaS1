/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Add 5 to the number inputted by the user and then double it.
 *                  Print the result to the screen.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class AddFiveAndDouble {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Input a number
        System.out.println("Please input a number.");
        double num = Double.parseDouble(scan.nextLine());

        // Add 5 to the number input and then double it.
        // output the value to the terminal
        double numPlus5Doubled = ((num + 5) * 2);
        System.out.println("5 added to the number you input and then doubled is " + numPlus5Doubled);
    }
}
