/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.15.2019
 *  Description:    A simple guessing game with a visual output.  The user is to guess where the
 *                  ball is hidden.  Program alerts the user if they guessed correctly or incorrectly.
 *                  https://programmingbydoing.com/a/three-card-monte.html
 *************************************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        // Variables
        int secretNumber = 0;
        int userInput = 0;

        // Instantiate Objects
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate the secret number
        secretNumber = random.nextInt((3 - 1 + 1) + 1);

        // Output game and instruct the user to make a guess
        System.out.println("What cup has the ball?");
        System.out.println(" ");
        System.out.println("  #      #      #");
        System.out.println(" ###    ###    ###");
        System.out.println("#####  #####  #####");
        System.out.println("  1      2      3  ");
        System.out.println(" ");
        System.out.format("Guess: ");
        userInput = Integer.parseInt(scanner.nextLine());

        // Alert the user if the guessed correctly or incorrectly
        if(secretNumber == userInput) {
            System.out.println("Congratulations! You guessed correctly!");
        }
        else {
            System.out.println("The ball was under Cup #" + secretNumber + ". Better luck next time!");
        }

        // Output visual representation of where the ball was hidden
        if(secretNumber == 1) {
            System.out.println(" ");
            System.out.println("         #      #  ");
            System.out.println("        ###    ### ");
            System.out.println("  O    #####  #####");
            System.out.println("  1      2      3  ");
            System.out.println(" ");
        }
        else if(secretNumber == 2) {
            System.out.println(" ");
            System.out.println("  #             #  ");
            System.out.println(" ###           ### ");
            System.out.println("#####    O    #####");
            System.out.println("  1      2      3  ");
            System.out.println(" ");
        }
        else {
            System.out.println(" ");
            System.out.println("  #      #         ");
            System.out.println(" ###    ###        ");
            System.out.println("#####  #####    O  ");
            System.out.println("  1      2      3  ");
            System.out.println(" ");
        }
    }
}
