/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.09.2019
 ** Description:    Prompt the user for 5 words, store them in an array and print the
 *                  array elements to the screen.
 *************************************************************************************************/
import java.util.Scanner;

public class ArrayFun5Words {
    public static void main (String[] argc) {

        // Variables
        String[] StringArray = new String[5];

        // Instantiate Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for 5 words
        System.out.println("Please input 5 words:");
        for(int i = 0; i < StringArray.length; i++) {
            StringArray[i] = scan.nextLine();
        }

        // Output the array elements to the screen
        for(int i = 0; i < StringArray.length; i++) {
            System.out.format("Array Element %d: ", i + 1);
            System.out.println(StringArray[i]);
        }
    }
}
