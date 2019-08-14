/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.15.2019
 ** Description:    A simple loop that adds numbers that the user inputs and outputs the total
 *                  at the end of the program.
 *                  https://programmingbydoing.com/a/adding-values-in-a-loop.html
 *************************************************************************************************/
import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        // Variables
        int userInput = -1;
        int sum = 0;

        // Instantiate Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Loop for integers to add to sum until the user enters 0.
        System.out.println("I will add up the numbers you give me.");
        while(userInput != 0) {
            System.out.format("Number: ");
            userInput = Integer.parseInt(scanner.nextLine());
            sum += userInput;
            System.out.println("The total so far is " + sum);
        }

        // Output the final summation
        System.out.println(" ");
        System.out.format("The total is %d", sum);
    }
}
