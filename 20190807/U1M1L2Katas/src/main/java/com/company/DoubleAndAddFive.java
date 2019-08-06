/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Double the number inputted by the user and then add 5.
 *                  Print the result to the screen.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class DoubleAndAddFive {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Input a number
        System.out.println("Please input a number.");
        double num = Double.parseDouble(scan.nextLine());

        // Double the number input by the user then add 5
        // Display the results to the screen
        double numDoubledPlus5 = ((num * 2) + 5);
        System.out.println("The number input is doubled and then 5 is added to it.");
        System.out.println("The result of this calculation is " + numDoubledPlus5);
    }
}
