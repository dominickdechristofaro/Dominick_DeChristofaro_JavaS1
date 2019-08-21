/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:    Generate an 1000 element ArrayList of integers of random numbers between 10
 *                  and 100.  Display the ArrayList on the screen.
 *                  https://programmingbydoing.com/a/basic-arraylists-3.html
 *************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {
        // Variables
        int randomNum;

        // Instantiate an array List
        List<Integer> basicArrayList = new ArrayList<>();

        // Create a random object
        Random random = new Random();

        // Add 1000 integers to the array list
        for(int i = 0; i < 1000; i++) {
            randomNum = random.nextInt(100 - 10 + 1) + 10;
            basicArrayList.add(randomNum);
        }

        // Output the ArrayList to the terminal
        System.out.println(basicArrayList);
    }
}
