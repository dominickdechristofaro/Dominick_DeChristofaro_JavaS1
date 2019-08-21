/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:    Create an ArrayList of 10 random integers between 1 and 50. Then prompt the
 *                  user for an integer to query and if the integer input is contained in the list
 *                  let the user know.
 *                  https://programmingbydoing.com/a/finding-a-value-in-an-arraylist.html
 *************************************************************************************************/
import java.util.*;

public class FindingAValueInAnArrayList {
    public static void main(String[] args) {
        // Variables
        int randomNum;
        int userInput;
        int temp;
        List<Integer> integerArrayList = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill the ArrayList with 10 random integer values between 1 and 50
        for(int i = 0; i < 10; i++) {
            randomNum = random.nextInt(50 - 1 + 1) + 1;
            integerArrayList.add(randomNum);
        }

        // Display the contents of the ArrayList to the screen
        System.out.println("ArrayList: " + integerArrayList);

        // Ask the user for an integer number
        System.out.print("Value to find: ");
        userInput = Integer.parseInt(scanner.nextLine());

        // Create an iterator for the integerArrayList
        Iterator iterator = integerArrayList.iterator();

        // Iterate through integerArrayList looking for the value
        while(iterator.hasNext()) {
            temp = (Integer)iterator.next();
            if(userInput == temp) {
                System.out.println(temp + " is in the ArrayList.");
            }
        }
    }
}
