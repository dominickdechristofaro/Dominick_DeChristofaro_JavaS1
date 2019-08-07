/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Input a number and output a count from 0 to that number but only if the number is a
 *                  multiple of 13.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class CountByThirteen {
    public static void main(String[] args) {

        // Variables
        int userInput = 0;

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for a number
        System.out.println("Please input a number.");
        userInput = Integer.parseInt(scan.nextLine());

        // If the userInput is less than 13, only print 0
        if (userInput < 13) {
            System.out.println(0);
        }
        // If the userInput is greater than 13, print every number
        // that is a multiple of 13 below userInput
        else if (userInput >= 13) {
            System.out.println(0);
            for (int i = 13; i <= userInput; i = i + 13) {
                System.out.println(i);
            }
        }
    }
}