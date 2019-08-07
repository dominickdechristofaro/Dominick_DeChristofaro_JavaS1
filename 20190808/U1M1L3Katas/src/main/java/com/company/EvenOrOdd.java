/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Takes a users input and determines if the input is even or odd.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {

        // Variables
        int userInput = 0;

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for a number
        System.out.println("Please enter a number.");
        userInput = Integer.parseInt(scan.nextLine());

        // If number input has a modulus of 0 if divided by 2, output the number is even
        if(userInput % 2 == 0) {
            System.out.println("Number input is even.");
        }
        // else output the number is odd.
        else {
            System.out.println("Number input is odd.");
        }
    }
}
