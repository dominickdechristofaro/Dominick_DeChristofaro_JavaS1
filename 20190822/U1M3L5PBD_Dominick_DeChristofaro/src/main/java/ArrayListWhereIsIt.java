/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:    https://programmingbydoing.com/a/arraylist-where-is-it.html
 *************************************************************************************************/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListWhereIsIt {
    public static void main(String[] args) {
        // Variables
        int userInput;
        int counter = 0;
        List<Integer> integerArrayList = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill the Arraylist with 10 random integers
        for(int i = 0; i < 10; i++) {
            integerArrayList.add(random.nextInt(50 - 1 + 1) + 1);
        }

        // Display the ArrayList to the terminal
        System.out.println("ArrayList: " + integerArrayList);

        // Prompt the user for an Integer value to find in the ArrayList
        System.out.print("Value to find: ");
        userInput = Integer.parseInt(scanner.nextLine());
        System.out.println(" ");

        // Iterate through the ArrayList looking for the userInput value
        for(int i = 0; i < integerArrayList.size(); i++) {
            if(userInput == integerArrayList.get(i)) {
                System.out.println(userInput + " is in slot " + i);
                counter++;
            }
        }

        // If the counter is 0 after iterating through the list, the userInput was not found
        if(counter == 0) {
            System.out.println(userInput + " is not in the ArrayList");
        }
    }
}
