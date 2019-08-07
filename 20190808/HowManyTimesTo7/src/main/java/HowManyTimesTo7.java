/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Calculate the number of 7's rolled by a pair of die (Individual values of 1 - 6).
 *                  The pair of die have summative values of 2 - 12.
 *                  Allow the user to input the number of times the pair of die should be rolled.
 *                  Output the individual die rolls, the sum of the die rolls.
 *                  After all the die rolls have completed, output the number of rolls to reach the first 7
 *                  and the total number of 7's rolled while executing the program.
 *********************************************************************************************************************/

import java.util.Random;
import java.util.Scanner;

public class HowManyTimesTo7 {
    public static void main(String[] argc) {

        // Variables
        int numOfRolls = 0;                     // number of times the dice are rolled
        Random r = new Random();                // Instantiate a random object to generate random integers
        int lowInteger = 1;                     // A low bounding number for the die
        int highInteger = 7;                    // A high bounding number for the die (n - 1)
        int die1 = 0;                           // Hold die #1 random roll value
        int die2 = 0;                           // Hold die #2 random roll value
        int dieSum = 0;                         // Hold the summation of the die rolls
        int numOfRollsToFirst7 = 0;             // Hold the value for the number of rolls to reach the first 7
        int totalNumOf7Rolled = 0;              // Hold the total number of 7's rolled in 100 rolls
        Scanner scan = new Scanner(System.in);  // Instantiate a Scanner object to hold user input
        int numOfDieRolls = 0;

        // Prompt the user for the number of times to roll the die
        System.out.println("How many times would you like to roll the die? (Integer greater than 0)");
        numOfDieRolls = Integer.parseInt(scan.nextLine());

        // Display the template for the data
        System.out.println("Roll num: die1 die2 dieSum");

        // Loop for 100 die rolls
        // Possible values for a single die (1 - 6)
        // Possible values for a pair of die (2 - 12)
        for(int i = 0; i < numOfDieRolls; i++) {
            die1 = r.nextInt(highInteger - lowInteger) + lowInteger;
            die2 = r.nextInt(highInteger - lowInteger) + lowInteger;
            dieSum = die1 + die2;
            numOfRolls++;
            System.out.println("Roll num " + numOfRolls + ":  " + die1 + "  " + die2 + "  " + dieSum);

            // If the summation of the die is 7 do the following calculations
            if(dieSum == 7) {
                // If it is the first time a 7 is rolled, document the number of rolls to reach the first 7
                if(numOfRollsToFirst7 == 0) {
                    numOfRollsToFirst7 = numOfRolls;
                }
                // Always increment the number of times a 7 is rolled and print information to the user
                totalNumOf7Rolled++;
                System.out.println("You have rolled " + totalNumOf7Rolled + " 7's");
            }
        }

        // Print out the total number of 7's rolled in 100 rolls
        // Print out the number of rolls to reach the first 7 rolled.
        System.out.println(" ");
        System.out.println("It took " + numOfRollsToFirst7 + " rolls for the first 7 to be rolled.");
        System.out.println("You rolled " + totalNumOf7Rolled + " 7's in " + numOfDieRolls + " rolls.");
    }
}
