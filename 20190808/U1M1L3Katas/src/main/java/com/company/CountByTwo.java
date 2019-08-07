/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Output all numbers to the terminal between 0 and userInput only if the number
 *                  is a multiple of 2.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class CountByTwo {
    public static void main(String[] args) {

        // Variables
        int userInput = 0;

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for a number
        System.out.println("Please enter a number.");
        userInput = Integer.parseInt(scan.nextLine());

        // If the number input is less than 2
        if(userInput < 2) {
            System.out.println(0);
        }

        // If the number input is greater than 2
        else if(userInput >= 2) {
            System.out.println(0);
            for(int i = 2; i <= userInput; i = i + 2) {
                System.out.println(i);
            }
        }
    }
}
