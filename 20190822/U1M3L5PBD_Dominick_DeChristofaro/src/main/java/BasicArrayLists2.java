/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:    Adds 10 random numbers to an ArrayList and display the list.
 *                  https://programmingbydoing.com/a/basic-arraylists-2.html
 *************************************************************************************************/
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {
    public static void main(String[] args) {
        // Instantiate an ArrayList
        List<Integer> basicArrayList = new ArrayList<>();
        Random random = new Random();
        int randomNum;

        // Loop through the ArrayList adding random integer values
        for(int i = 0; i < 10; i++) {
            randomNum = random.nextInt(100 - 1 + 1) + 1;
            basicArrayList.add(randomNum);
        }

        // Print the ArrayList
        System.out.println("ArrayList: " + basicArrayList);
    }
}
