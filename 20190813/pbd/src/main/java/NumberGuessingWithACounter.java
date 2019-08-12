/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    A simple guessing game where the user trys to guess a random integer between
 *                  1 and 10.  Continue guessing until the number is guessed correctly.
 *                  https://programmingbydoing.com/a/number-guessing-with-a-counter.html
 *************************************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {
        // Instantiate objects
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Variables
        int secretNumber = random.nextInt(10 - 1 + 1) + 1;
        int guess = 0;
        int guessCounter = 1;

        // Prompt the user to guess a number between 1 and 10
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        System.out.format("Your guess: ");
        guess = Integer.parseInt(scanner.nextLine());

        // Continue to allow the user to guess until they are correct
        while(guess != secretNumber) {
            System.out.println("That is incorrect. Guess again.");
            System.out.format("Your guess: ");
            guess = Integer.parseInt(scanner.nextLine());
            guessCounter++;
        }

        // Output that the user is correct and the number of tries
        System.out.println("That's right! You're a good guesser.");
        if(guessCounter == 1) {
            System.out.println("It only took you 1 try.");
        }
        else {
            System.out.println("It only took you " + guessCounter + " tries.");
        }
    }
}
