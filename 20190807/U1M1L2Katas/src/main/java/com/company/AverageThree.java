/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Find the average of 3 numbers inputted by the user.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class AverageThree {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Input 3 numbers
        System.out.println("Please input 3 numbers.");
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());
        double num3 = Double.parseDouble(scan.nextLine());

        // Average the 3 numbers input and display the result
        double average = ((num1 + num2 + num3) / 3);
        System.out.format("The average of the 3 numbers input is %.2f%n", average);

    }
}
