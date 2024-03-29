/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.09.2019
 ** Description:    Prompt the user to enter an integer and display the month of the year
 *                  that corresponds with the integer input using if/else if/else conditionals.
 *************************************************************************************************/
import java.util.Scanner;

public class MonthConverterIf {
    public static void main(String[] argc) {

        // Variables
        int userInput = 0;

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter a number between 1 and 12
        System.out.println("Please enter an integer between 1 and 12:");
        userInput = Integer.parseInt(scan.nextLine());

        // Output the month that corresponds with the integer entered
        if(userInput == 1) {
            System.out.println("January");
        }
        else if(userInput == 2) {
            System.out.println("February");
        }
        else if(userInput == 3) {
            System.out.println("March");
        }
        else if(userInput == 4) {
            System.out.println("April");
        }
        else if(userInput == 5) {
            System.out.println("May");
        }
        else if(userInput == 6) {
            System.out.println("June");
        }
        else if(userInput == 7) {
            System.out.println("July");
        }
        else if(userInput == 8) {
            System.out.println("August");
        }
        else if(userInput == 9) {
            System.out.println("September");
        }
        else if(userInput == 10) {
            System.out.println("October");
        }
        else if(userInput == 11) {
            System.out.println("November");
        }
        else if(userInput == 12) {
            System.out.println("December");
        }
        // If a invalid number is entered, display the following error message
        else {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }

    }
}
