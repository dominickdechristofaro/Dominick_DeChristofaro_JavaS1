/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.15.2019
 *  Description:    Program that prompts the user for 3 integer values in ascending order.  Uses
 *                  the inputs to compute if the integers could be used to make the sides of a
 *                  right triangle.  Outputs the results to the user.
 *                  https://programmingbydoing.com/a/right-triangle-checker.html
 *************************************************************************************************/
import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        // Variables
        int side1 = -1;
        int side2 = -1;
        int side3 = -1;

        // Instantiate Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Instruct the user to input 3 integers, input must be in ascending order
        System.out.println("Enter three integers:");

        // User input for side1 of the triangle
        while(side1 < 1) {
            System.out.format("Side 1: ");
            side1 = Integer.parseInt(scanner.nextLine());
            if(side1 < 1) {
                System.out.println("You must enter a positive integer to start.");
            }
        }

        // User input for side2 of the triangle
        while(side2 < side1) {
            System.out.format("Side 2: ");
            side2 = Integer.parseInt(scanner.nextLine());
            if(side2 < side1) {
                System.out.println(side2 + " is smaller than " + side1 + ".  Try again.");
            }
        }

        // User input for side3 of the triangle
        while(side3 < side2) {
            System.out.format("Side 3: ");
            side3 = Integer.parseInt(scanner.nextLine());
            if(side3 < side2) {
                System.out.println(side3 + " is smaller than " + side2 + ".  Try again.");
            }
        }

        // Output the three sides input
        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);

        // Compute if the three sides input make a right triangle
        if(((side1 * side1) + (side2 * side2)) == (side3 * side3)) {
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        }
        else {
            System.out.println("NO!  These sides do not make a right triangle");
        }
    }
}
