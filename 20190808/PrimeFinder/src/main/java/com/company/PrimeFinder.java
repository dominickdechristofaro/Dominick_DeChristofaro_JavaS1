/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Print all the prime numbers between 2 and the userInput
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {

        // Variables
        int userInput = 0;

        // Create Scanner object for userInput
        Scanner scan = new Scanner(System.in);

        // Prompt the user for a integer number
        System.out.println("Please enter an integer number greater than 1.");
        userInput = Integer.parseInt(scan.nextLine());

        // Check for prime numbers between 2 and userInput
        for(int i = 2; i <= userInput; i++) {
            boolean isPrime = true;
            for(int j = 2; j <= i/2; j++) {
                // if the modulus is ever equal to 0, i is not equal to 0 and break
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            // if none of the numbers tested has a modulus of 0, the number is prime and print the number
            if(isPrime == true) {
                System.out.println(i);
            }
        }
    }
}
