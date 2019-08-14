/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.15.2019
 *  Description:    Take the square root of the user input.  Protect the user from inputing a
 *                  negative value.
 *                  https://programmingbydoing.com/a/safe-square-root.html
 *************************************************************************************************/
import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        // Variables
        double userInput = -1.0;
        double squareRoot = 0;

        // Instantiate Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an integer number
        System.out.println("SQUARE ROOT!");
        while(userInput < 0) {
            System.out.format("Enter a number: ");
            userInput = Double.parseDouble(scanner.nextLine());
            if(userInput < 0) {
                System.out.println("You can't take the square root of a negative number, silly.");
            }
        }

        // Calculate the square root of the input
        squareRoot = Math.sqrt(userInput);

        // Output the result
        System.out.println("The square root of " + (int)userInput + " is " + squareRoot + ".");
    }
}
