/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Print out the numbers 1 through 100 with the following exceptions:
 *                      If the number is a multiple of 3, print "FIZZ" instead of the number.
 *                      If the number is a multiple of 5, print "BUZZ" instead of the number.
 *                      If the number is a multiple of 3 & 5, print "FIZZBUZZ" instead of the number.
 *********************************************************************************************************************/
package com.company;

public class FizzBuzz {
    public static void main(String[] args) {

        // For loop to loop 100 times
        for(int i = 1; i <= 100; i++) {
            // If the number is a multiple of 3 and 5, print "FIZZBUZZ" to the console
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("FIZZBUZZ");
            }
            // If the number is only a multiple of 3, print "FIZZ" to the console
            else if(i % 3 == 0) {
                System.out.println("FIZZ");
            }
            // If the number is only a multiple of 5, print "BUZZ" to the console
            else if(i % 5 == 0) {
                System.out.println("BUZZ");
            }
            // If the number is not a multiple of either 3 or 5, print the number to the console
            else {
                System.out.println(i);
            }
        }
    }
}
