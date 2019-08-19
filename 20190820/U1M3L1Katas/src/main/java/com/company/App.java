/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    ArrayList methods.
 *************************************************************************************************/
package com.company;
import java.util.ArrayList;

public class App {
    /**********************************************************************************************
     *                  Sum all the numbers in an ArrayList and return the value.
     * @param numbers   An ArrayList of Integer numbers.
     * @return          integer value corresponding to the summation of all values in the passed
     *                  ArrayList.
     *********************************************************************************************/
    public static int total(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    /**********************************************************************************************
     *                  Sum all the even indexed numbers in an ArrayList and return the value.
     * @param numbers   An ArrayList of numbers.
     * @return          The summation of all the even indexed numbers in the passed ArrayList
     *                  numbers.
     *********************************************************************************************/
    public static int totalEven(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }
        return sum;
    }

    /**********************************************************************************************
     *                  Swap the first and last elements of a ArrayList of Strings.
     * @param strings   An ArrayList of various Strings.
     * @return          An array List with the first and last elements of the passed
     *                  ArrayList swapped.
     *********************************************************************************************/
    public static ArrayList<String> swapFirstAndLast(ArrayList<String> strings) {
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
     *                  Reverse the passed ArrayList.
     * @param numbers   An ArrayList of integer numbers.
     * @return          The reverse of the passed ArrayList.
     *********************************************************************************************/
    public static ArrayList<Integer> reverse(ArrayList<Integer> numbers) {
        // Create a new ArrayList to hold the reversed ArrayList
        ArrayList<Integer> reversed = new ArrayList<>();

        // Iterate over the passed ArrayList
        for (int i = 0; i < numbers.size(); i++) {
            // Reverse the passed ArrayList
            reversed.add(i, numbers.get(numbers.size() - (i + 1)));
        }

        // Return the reversed ArrayList
        return reversed;
    }

    /**********************************************************************************************
     *                  Pass an ArrayList of numbers and return a new ArrayList made of integers
     *                  that are less than 5 from the original passed ArrayList.
     * @param numbers   An ArrayList of Integers.
     * @return          A new ArrayList of Integers made up of Integers that are less than 5 from
     *                  the original passed ArrayList.
     *********************************************************************************************/
    public static ArrayList<Integer> lessThanFive(ArrayList<Integer> numbers) {

        // Instantiate a new ArrayList to hold numbers less than 5
        ArrayList<Integer> lessThan = new ArrayList<>();

        // Iterate through the ArrayList parameter, numbers
        for (int i = 0; i < numbers.size(); i++) {
            // If the current element in ArrayList is less than 5, add it to the ArrayList, lessThan
            if (numbers.get(i) < 5) {
                lessThan.add(numbers.get(i));
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
     *                  Divide an ArrayList into a 2D ArrayList of numbers smaller than 5 and
     *                  numbers greater than or equal to 5.
     * @param numbers   An ArrayList of Integers.
     * @return          A 2D ArrayList divided into numbers less than 5 and numbers greater
     *                  than or equal to five.
     *********************************************************************************************/
    public static ArrayList<ArrayList<Integer>> splitAtFive(ArrayList<Integer> numbers) {
        // Instantiate ArrayLists to use throughout the method
        ArrayList<ArrayList<Integer>> returnedArray = new ArrayList<>();
        ArrayList<Integer> numLessThanFive = new ArrayList<>();
        ArrayList<Integer> numMoreThanFive = new ArrayList<>();

        // Iterate through the parameter to determine if the number is less than 5 or greater
        // than or equal to 5.
        for (int i = 0; i < numbers.size(); i++) {
            // If the current number is less than 5, add it to numLessThanFive ArrayList
            if (numbers.get(i) < 5) {
                numLessThanFive.add(numbers.get(i));
            }
            // If the current number is greater than or equal to 5, add it to numMoreThanFive ArrayList
            else {
                numMoreThanFive.add(numbers.get(i));
            }
        }

        // Assign the arrays to the appropiate place on the 2D ArrayList
        returnedArray.add(0, numLessThanFive);
        returnedArray.add(1, numMoreThanFive);

        // return the 2D ArrayList
        return returnedArray;
    }

    /**********************************************************************************************
     *                  Given an ArrayList of Strings, return a new ArrayList where the inner
     *                  ArrayList contains the even indexed strings, and the outer ArrayList
     *                  contains the odds ArrayList.
     * @param strings   An ArrayList of Strings.
     * @return          A 2D ArrayList of Strings divided into even and odd indexed Strings from
     *                  the argument passed.
     *********************************************************************************************/
    public static ArrayList<ArrayList<String>> evensAndOdds(ArrayList<String> strings) {
        // Instantiate ArrayLists to use throughout the method
        ArrayList<ArrayList<String>> returnedArray = new ArrayList<>();
        ArrayList<String> evens = new ArrayList<>();
        ArrayList<String> odds = new ArrayList<>();

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
