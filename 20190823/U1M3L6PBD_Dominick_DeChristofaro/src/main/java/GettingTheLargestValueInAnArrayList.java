/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    Create an ArrayList to hold 10 random integers between 1 and 100, then display
 *                  the largest integer value within the ArrayList.
 *                  https://programmingbydoing.com/a/getting-the-largest-value-in-an-arraylist.html
 *************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GettingTheLargestValueInAnArrayList {
    public static void main(String[] args) {
        // Variables
        int randomNum;
        int largestNum;
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
        for(int i = 1; i < integerArrayList.size(); i++) {
            if(integerArrayList.get(i) > largestNum) {
                largestNum = integerArrayList.get(i);
            }
        }

        // Output the largest number in integerArrayList
        System.out.println("The largest value is " + largestNum);
    }
}
