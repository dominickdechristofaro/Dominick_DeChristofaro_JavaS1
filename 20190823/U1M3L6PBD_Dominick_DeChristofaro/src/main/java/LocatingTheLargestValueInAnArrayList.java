/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    Create a ArrayList to hold 10 random integer values between 1 and 100.  Use
 *                  linear search techniques to locate the largest integer value and it's slot in
 *                  the ArrayList.  Output the largest value and the slot to the terminal.
 *                  https://programmingbydoing.com/a/locating-the-largest-value-in-an-arraylist.html
 *************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocatingTheLargestValueInAnArrayList {
    public static void main(String[] args) {
        // Variables
        int randomNum;
        int largestNum;
        int largestNumSlot;
        Random random = new Random();
        List<Integer> integerArrayList = new ArrayList<>();

        // Fill integerArrayList with 10 random numbers from 1 to 100
        for(int i = 0; i < 10; i++) {
            integerArrayList.add(random.nextInt(100 - 1 + 1) + 1);
        }

        // Display the values of integerArrayList
        System.out.println("ArrayList: " + integerArrayList);
        System.out.println(" ");

        // Use linear search to find and display the largest value in integerArrayList
        largestNum = integerArrayList.get(0);
        largestNumSlot = 0;
        for(int i = 1; i < integerArrayList.size(); i++) {
            if(integerArrayList.get(i) > largestNum) {
                largestNum = integerArrayList.get(i);
                largestNumSlot = i;
            }
        }

        // Output the largest number in integerArrayList
        System.out.println("The largest value is " + largestNum + ", which is in slot " + largestNumSlot);
    }
}
