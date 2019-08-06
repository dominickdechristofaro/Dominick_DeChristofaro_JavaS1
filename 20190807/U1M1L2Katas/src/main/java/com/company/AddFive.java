/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Add 5 numbers inputted by the user.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class AddFive {
    public static void main(String[] args) {

        // Create a Scanner object to collect user input
        Scanner scan = new Scanner(System.in);

        // Input 5 numbers
        System.out.println("Please input 5 numbers.");
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());
        double num3 = Double.parseDouble(scan.nextLine());
        double num4 = Double.parseDouble(scan.nextLine());
        double num5 = Double.parseDouble(scan.nextLine());

        // Sum the numbers and print the sum
        double sum = num1 + num2 + num3 + num4 + num5;
        System.out.println("The sum of the 5 numbers input is " + sum);
    }
}
