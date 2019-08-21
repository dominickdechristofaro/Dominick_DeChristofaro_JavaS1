/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:    Create a 10 element ArrayList of random integer values.  Copy the individual
 *                  values of the original ArrayList into a new ArrayList.  Change the last element
 *                  in the first ArrayList to a -7. Display the contents of both ArrayLists
 *                  https://programmingbydoing.com/a/copying-arraylists.html
 *************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {
        // Variables
        int randomNum;

        // Instantiate 2 ArrayLists
        List<Integer> integerArrayList1 = new ArrayList<>();
        List<Integer> integerArrayList2 = new ArrayList<>();

        // Instantiate a Random object
        Random random = new Random();

        // Place 10 random numbers in the ArrayList
        for(int i = 0; i < 10; i++) {
            randomNum = random.nextInt(100 - 1 + 1) + 1;
            integerArrayList1.add(randomNum);
        }

        // Copy the contents of integerArrayList1 into integerArrayList2
        for(int i = 0; i < integerArrayList1.size(); i++) {
            integerArrayList2.add(integerArrayList1.get(i));
        }

        // Change the last element in integerArrayList1 to a -7
        integerArrayList1.set(9, -7);

        // Output the contents of both ArrayLists
        System.out.println("ArrayList 1: " + integerArrayList1);
        System.out.println("ArrayList 2: " + integerArrayList2);
    }
}
