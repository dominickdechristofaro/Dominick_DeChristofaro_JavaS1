/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Multiply 3 numbers inputted by the user.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class MultiplyThree {
    public static void main(String[] args) {

        // Create a new Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Input 3 numbers
        System.out.println("Please input 3 numbers.");
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());
        double num3 = Double.parseDouble(scan.nextLine());

        // Multiple all the numbers input together and display the result
        double multiplied = num1 * num2 * num3;
        System.out.println("The 3 numbers multiplied together is " + multiplied);
    }
}