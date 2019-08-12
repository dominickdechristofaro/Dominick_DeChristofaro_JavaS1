/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Simulate a guessing game where the user has 7 tries to guess a secret randomly
 *                  generated integer between 1 and 100.  Inform the user between each guess if
 *                  they are higher or lower than the secret number.
 *                  https://programmingbydoing.com/a/hi-lo-with-limited-tries.html
 *************************************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {
    public static void main(String[] args) {
        // Instantiate Objects
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // Variables
        int secretNumber = random.nextInt(100 - 1 + 1) + 1;
        int guess = 0;
        int guessCounter = 1;

        // Inform the user to guess a number between 1 and 100 and that they have 7 guesses
        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.");

        // Have the user guess as long as they have not guessed the secret number and the guess
        // couter is less than 8.  Inform the user if they are too high or too low.
        while(guessCounter < 8 && secretNumber != guess) {
            System.out.format("Guess #%d", guessCounter);
            System.out.format(": ");
            guess = Integer.parseInt(scan.nextLine());
            // If the user guess is lower than the secret number
            if(secretNumber > guess) {
                System.out.println("Sorry, you are too low.");
            }
            // If the user guess is higher than the secret number
            else if(secretNumber < guess) {
                System.out.println("Sorry, you are too high.");
            }
            // If the user guess is equal to the secret number
            else if(secretNumber ==  guess) {
                System.out.println("You guessed it! What are the odds?!?");
            }
            // Increase the guess counter
            guessCounter++;
        }

        // Tell the user they did not guess correctly within 7 tries
        if(guess != secretNumber) {
            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
        }
    }
}
