/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.15.2019
 *  Description:    Simulate die rolls and continue until a double is rolled.  Use a do-while loop.
 *                  https://programmingbydoing.com/a/shorter-double-dice.html
 *************************************************************************************************/
import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        // Variables
        int die1 = -1;
        int die2 = -2;
        int sum = 0;

        // Instantiate Random to generate random integers
        Random random = new Random();

        // Roll die until a double is rolled & output the results
        System.out.println("HERE COME THE DICE!");
            do {
                die1 = random.nextInt((6 - 1 + 1) + 1);
                die2 = random.nextInt((6 - 1 + 1) + 1);
                sum = die1 + die2;
                System.out.println("Roll #1: " + die1);
                System.out.println("Roll #2: " + die2);
                System.out.println("The total is " + sum + "!");
            } while (die1 != die2);
    }
}
