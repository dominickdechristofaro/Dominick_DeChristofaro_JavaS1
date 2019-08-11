/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.09.2019
 ** Description:    Read 5 integers from the user, input them into an array and print
 *                  the array elements to the screen.
 *************************************************************************************************/
import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] argc) {

        // Variables
        int[] intArray = new int[5];

        // Instantiate Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to input 5 integers
        System.out.println("Please input 5 integer values:");
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(scan.nextLine());
        }

        // Output the array elements to the screen
        System.out.format("Array Elements: ");
        for(int i = 0; i < intArray.length; i++) {
            System.out.format("%d ", intArray[i]);
        }
    }
}
