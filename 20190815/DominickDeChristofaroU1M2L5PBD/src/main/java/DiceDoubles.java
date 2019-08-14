/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.15.2019
 *  Description:    Rolls a pair of dice continually until you roll a double.
 *                  https://programmingbydoing.com/a/dice-doubles.html
 *************************************************************************************************/
import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {
        // Variables
        int die1 = -1;
        int die2 = -2;
        int sum = 0;

        // Instantiate Random to generate random numbers
        Random random = new Random();

        // Generate random numbers until a double is rolled
        System.out.println("HERE COMES THE DICE!");
        while(die1 != die2) {
            System.out.println(" ");

            // Randomize both die
            die1 = random.nextInt(((6 - 1) + 1) + 1);
            die2 = random.nextInt(((6 - 1) + 1) + 1);

            // Sum the dice roll
            sum = die1 + die2;

            // Output the results of the dice roll
            System.out.println("Roll #1: " + die1);
            System.out.println("Roll #2: " + die2);
            System.out.println("The total is " + sum + "!");
        }
    }
}
