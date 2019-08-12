/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Have the user guess a number & let them know if they guessed correctly or
 *                  incorrectly.
 *                  https://programmingbydoing.com/a/a-number-guessing-game.html
 *************************************************************************************************/
import java.util.Scanner;
import java.util.Random;

public class ANumberGuessingGame {
    public static void main(String[] args) {
        // Variables
        Random random = new Random();
        int secretNumber = random.nextInt(10 - 1 + 1) + 1;
        int guess = 0;

        // Instantiate Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.println("I'm thinking of a number from 1 to 10.");
        System.out.println("Your guess: ");
        guess = Integer.parseInt(scan.nextLine());

        // Notify the user if they guessed correctly
        if(guess == secretNumber) {
            System.out.format("That's right! My secret number was %d", secretNumber);
            System.out.format("!");
        }
        else {
            System.out.format("Sorry, but I was really thinking of %d", secretNumber);
            System.out.format(".");
        }
    }
}
