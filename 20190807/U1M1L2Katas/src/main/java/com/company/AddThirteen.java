/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/07/2019
 *  Description:    Add 13 to the value inputted by the user and print the result to the screen.
 ************************************************************************************************/
package com.company;
import java.util.Scanner;

public class AddThirteen {
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Input a number
        System.out.println("Please input a number.");
        double num = Double.parseDouble(scan.nextLine());

        // Add 13 to the number input and output the result
        double numPlus13 = num + 13;
        System.out.println("13 added to the number input is " + numPlus13);
    }
}
