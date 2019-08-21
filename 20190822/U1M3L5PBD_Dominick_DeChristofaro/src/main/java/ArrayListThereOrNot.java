/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:    Creates an Arraylist with 10 Integer values between 1 and 50.  Prompts the user
 *                  to query the ArrayList for an Integer value to see if it is in the list.  If
 *                  the value input is in the list, alert the user.  If the value is not in the
 *                  ArrayList, alert the user.
 *                  https://programmingbydoing.com/a/arraylist-there-or-not.html
 *************************************************************************************************/
import java.util.*;

public class ArrayListThereOrNot {
    public static void main(String[] args) {
        // Variables
        int userInput;
        int counter = 0;
        List<Integer> integerArrayList = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill integerArrayList with 10 random integers between 1 and 50
        for(int i = 0; i < 10; i++) {
            integerArrayList.add(random.nextInt(50 - 1 + 1) + 1);
        }

        // Instantiate an Iterator for the ArrayList
        Iterator iterator = integerArrayList.iterator();

        // Display the ArrayList contents to the terminal
        System.out.println("ArrayList: " + integerArrayList);

        // Prompt the user for an integer to query in the ArrayList
        System.out.print("Value to find: ");
        userInput = Integer.parseInt(scanner.nextLine());
        System.out.println(" ");

        // Alert the user if the number input is or is not contained in the ArrayList
        while(iterator.hasNext()) {
            if(userInput == (Integer)iterator.next()) {
                System.out.println(userInput + " is in the ArrayList.");
                counter++;
            }
        }

        // If the counter is 0, the userInput was not in the ArrayList
        if(counter == 0) {
            System.out.println(userInput + " is not in the ArrayList.");
        }
    }
}
