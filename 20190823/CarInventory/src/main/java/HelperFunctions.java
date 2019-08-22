/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    userInput helper methods for Integers and Strings.  The Integer input method
 *                  catches error handling from the user.
 *************************************************************************************************/
import java.util.Scanner;
public class HelperFunctions {

    /**
     *              Parse and return userInput for Strings
     * @return      String
     */
    public String userInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     *              Parse and return userInput for Integers
     * @return      Integer
     */
    public int userInputInteger() {
        Scanner scanner = new Scanner(System.in);
        int userInputInteger;
        try {
            userInputInteger = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return userInputInteger();
        } finally {
            System.out.println(" ");
        }
        return userInputInteger;
    }
}
