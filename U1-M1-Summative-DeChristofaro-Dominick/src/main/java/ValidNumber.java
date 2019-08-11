/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.09.2019
 ** Description:    Prompt the user for an integer between 1 and 10. If the input is between 1
 *                  and 10, display the number, if not, re-prompt the user for valid input.
 *************************************************************************************************/
import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] argc) {

        // Variables
        int userInput = 0;

        // Instantiate a Scanner Object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for an integer between 1 and 10
        System.out.println("Please input an integer between 1 and 10:");
        userInput = Integer.parseInt(scan.nextLine());

        // If userInput is less than 1 or greater than 10, re-prompt the user for valid input.
        while(userInput < 1 || userInput > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            userInput = Integer.parseInt(scan.nextLine());
        }

        // Output the number
        System.out.println(userInput);
    }
}
