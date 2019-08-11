/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.09.2019
 ** Description:    Declare the array {1, 2, 3, 4, 5}, create a second array of equal length,
 *                  fill the new array with values from the original array but in reverse order.
 *                  print the contents of both arrays to the screen.
 *************************************************************************************************/

public class ArrayFunReverseIt {
    public static void main(String[] argc) {

        // Variables
        int[] inputArray = new int[] {1, 2, 3, 4, 5};
        int[] reversedArray = new int[inputArray.length];
        int j = 0; // second array index variable

        // Reverse loop through the input array and assign the values to the
        // new array
        for(int i = inputArray.length; i > 0; i--) {
            reversedArray[j] = inputArray[i - 1];
            j++;
        }

        // Output the input array to the screen
        System.out.format("Input Array: ");
        for(int k = 0; k < inputArray.length; k++) {
            System.out.format("%d ", inputArray[k]);
        }
        System.out.println("");

        // Output the reversed array to the screen
        System.out.format("Reversed Array: ");
        for(int l = 0; l < reversedArray.length; l++) {
            System.out.format("%d ", reversedArray[l]);
        }
        System.out.println("");
    }
}
