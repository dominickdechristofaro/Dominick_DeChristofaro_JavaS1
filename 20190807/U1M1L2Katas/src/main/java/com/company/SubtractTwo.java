/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Subtract the second number from the first number inputted by the user.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class SubtractTwo {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Input 2 numbers
        System.out.println("Input 2 numbers.");
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        // Subtract the second number from the first and display the result.
        int subtract = num1 - num2;
        System.out.println("The second number subtracted from the first is " + subtract);
    }
}
