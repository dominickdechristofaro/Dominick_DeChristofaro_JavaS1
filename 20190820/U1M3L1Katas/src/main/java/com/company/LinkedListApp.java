/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    LinkedList methods.
 *************************************************************************************************/
package com.company;
import java.util.LinkedList;

public class LinkedListApp {
    /**********************************************************************************************
     *                  Sum all the numbers in an LinkedList and return the value.
     * @param numbers   A LinkedList of Integer numbers.
     * @return          Integer value corresponding to the summation of all values in the passed
     *                  LinkedList.
     *********************************************************************************************/
    public static int total(LinkedList<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    /**********************************************************************************************
     *                  Sum all the even indexed numbers in a LinkedList and return the value.
     * @param numbers   An LinkedList of numbers.
     * @return          The summation of all the even indexed numbers in the passed LinkedList
     *                  numbers.
     *********************************************************************************************/
    public static int totalEven(LinkedList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }
        return sum;
    }

    /**********************************************************************************************
     *                  Swap the first and last elements of a LinkedList of Strings.
     * @param strings   A LinkedList of various Strings.
     * @return          A LinkedList with the first and last elements of the passed
     *                  LinkedList swapped.
     *********************************************************************************************/
    public static LinkedList<String> swapFirstAndLast(LinkedList<String> strings) {
        // Get the first and last elements in the ArrayList
        String first = strings.get(0);
        String last = strings.get(strings.size() - 1);

        // Remove the first and last elements of the list
        strings.remove(0);
        strings.remove(strings.get(strings.size() - 1));

        // Assign the variable last to the front of the ArrayList
        strings.add(0, last);

        // Assign the variable first to the end of the ArrayList
        strings.add(strings.size(), first);

        // Return the ArrayList
        return strings;
    }

    /**********************************************************************************************
     *                  Reverse the passed LinkedList.
     * @param numbers   A LinkedList of integer numbers.
     * @return          The reverse of the passed LinkedList.
     *********************************************************************************************/
    public static LinkedList<Integer> reverse(LinkedList<Integer> numbers) {
        // Create a new ArrayList to hold the reversed ArrayList
        LinkedList<Integer> reversed = new LinkedList<>();

        // Iterate over the passed ArrayList
        for (int i = 0; i < numbers.size(); i++) {
            // Reverse the passed ArrayList
            reversed.add(i, numbers.get(numbers.size() - (i + 1)));
        }

        // Return the reversed ArrayList
        return reversed;
    }

    /**********************************************************************************************
     *                  Pass an LinkedList of numbers and return a new LinkedList made of integers
     *                  that are less than 5 from the original passed LinkedList.
     * @param numbers   A LinkedList of Integers.
     * @return          A new LinkedList of Integers made up of Integers that are less than 5 from
     *                  the original passed LinkedList.
     *********************************************************************************************/
    public static LinkedList<Integer> lessThanFive(LinkedList<Integer> numbers) {

        // Instantiate a new ArrayList to hold numbers less than 5
        LinkedList<Integer> lessThan = new LinkedList<>();

        // Iterate through the ArrayList parameter, numbers
        for (Integer number : numbers) {
            // If the current element in ArrayList is less than 5, add it to the ArrayList, lessThan
            if (number < 5) {
                lessThan.add(number);
            }
        }

        // If the size of lessThan is 0, return null
        if (lessThan.size() == 0) {
            return null;
        }
        // If the size of lessThan is greater than 0, return the ArrayList
        else {
            return lessThan;
        }
    }

    /**********************************************************************************************
     *                  Divide a LinkedList into a 2D LinkedList of numbers smaller than 5 and
     *                  numbers greater than or equal to 5.
     * @param numbers   An LinkedList of Integers.
     * @return          A 2D LinkedList divided into numbers less than 5 and numbers greater
     *                  than or equal to five.
     *********************************************************************************************/
    public static LinkedList<LinkedList<Integer>> splitAtFive(LinkedList<Integer> numbers) {
        // Instantiate ArrayLists to use throughout the method
        LinkedList<LinkedList<Integer>> returnedArray = new LinkedList<>();
        LinkedList<Integer> numLessThanFive = new LinkedList<>();
        LinkedList<Integer> numMoreThanFive = new LinkedList<>();

        // Iterate through the parameter to determine if the number is less than 5 or greater
        // than or equal to 5.
        for (Integer number : numbers) {
            // If the current number is less than 5, add it to numLessThanFive ArrayList
            if (number < 5) {
                numLessThanFive.add(number);
            }
            // If the current number is greater than or equal to 5, add it to numMoreThanFive ArrayList
            else {
                numMoreThanFive.add(number);
            }
        }

        // Assign the arrays to the appropiate place on the 2D ArrayList
        returnedArray.add(0, numLessThanFive);
        returnedArray.add(1, numMoreThanFive);

        // return the 2D ArrayList
        return returnedArray;
    }

    /**********************************************************************************************
     *                  Given an LinkedList of Strings, return a new LinkedList where the inner
     *                  LinkedList contains the even indexed strings, and the outer LinkedList
     *                  contains the odds LinkedList.
     * @param strings   A LinkedList of Strings.
     * @return          A 2D LinkedList of Strings divided into even and odd indexed Strings from
     *                  the argument passed.
     *********************************************************************************************/
    public static LinkedList<LinkedList<String>> evensAndOdds(LinkedList<String> strings) {
        // Instantiate ArrayLists to use throughout the method
        LinkedList<LinkedList<String>> returnedArray = new LinkedList<>();
        LinkedList<String> evens = new LinkedList<>();
        LinkedList<String> odds = new LinkedList<>();

        // Iterate through the parameter to assign the index to the correct ArrayList
        for (int i = 0; i < strings.size(); i++) {
            // If the index is even, assign the value to ArrayList evens
            if (i % 2 == 0) {
                evens.add(strings.get(i));
            }
            // If the index is odd, assign the value to ArrayList odds
            else {
                odds.add(strings.get(i));
            }
        }

        // Assign the arrays to the appropriate place on the 2D ArrayList
        returnedArray.add(0, evens);
        returnedArray.add(1, odds);

        // return the 2D ArrayList
        return returnedArray;
    }
}
