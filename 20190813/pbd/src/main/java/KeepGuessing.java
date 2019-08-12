/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Simple guessing game. User tries to guess a random number between 1 and 10.
 *                  Program continues until the user guesses correctly.
 *                  https://programmingbydoing.com/a/keep-guessing.html
 *************************************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        // Instantiate objects
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Variables
        int secretNumber = random.nextInt(10 - 1 + 1) + 1;
        int guess = 0;

        // Prompt the user to enter a number
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        System.out.format("Your guess: ");
        guess = Integer.parseInt(scanner.nextLine());

        // Prompt the user to continue guessing until they correctly guess the secret number
        while(guess != secretNumber) {
            System.out.println("That is incorrect. Guess again.");
            System.out.format("Your guess: ");
            guess = Integer.parseInt(scanner.nextLine());
        }

        // Notify the user they have guessed correctly
        System.out.println("That's right! You're a good guesser.");
    }
}
