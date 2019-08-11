/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.09.2019
 ** Description:    U1M1L6: Array Katas
 *************************************************************************************************/
package com.company;

public class App {
    /**********************************************************************************************
     *  Signature:      total(int[])
     *  Parameters:     intArray:   An array of integers
     *  Return Type:    integer
     *  Description:    Accepts an array of integers and returns the sum of all the integers in
     *                  the array.
     *********************************************************************************************/
    public static int total(int[] intArray) {
        // initialize the summation variable
        int sum = 0;

        // loop through the array adding all the values together
        for(int i = 0; i < intArray.length; i++) {
            sum = sum + intArray[i];
        }

        // return the summation
        return sum;
    }

    /**********************************************************************************************
     *  Signature:      totalOdd(int[])
     *  Parameters:     intArray:   An array of integers
     *  Return Type:    integer
     *  Description:    Pass an array of integers and sum only the odd indexes of the array.
     *                  Return the summation.
     *********************************************************************************************/
    public static int totalOdd(int[] intArray) {
        // initialize the summation variable
        int sum = 0;

        // loop through the array only adding odd numbered indexes
        for(int i = 1; i < intArray.length; i = i + 2) {
            sum = sum + intArray[i];
        }

        // return the summation
        return sum;
    }

    /**********************************************************************************************
     *  Signature:      totalEven(int[])
     *  Parameters:     intArray:   An array of integers
     *  Return Type:    integer
     *  Description:    Pass through an array of integers and sum every even numbered index in the
     *                  array.  Return the summation of the even numbered indexes.
     *********************************************************************************************/
    public static int totalEven(int[] intArray) {
        // Initialize the summation
        int sum = 0;

        // Loop through the array adding only odd numbered indexes
        for(int i = 0; i < intArray.length; i = i + 2) {
            sum = sum + intArray[i];
        }

        // Return the summation
        return sum;
    }

    /**********************************************************************************************
     *  Signature:      secondLargestNumber(int[])
     *  Parameters:     intArray:   Array of integer numbers
     *  Return Type:    int
     *  Description:    Passes an array of integers as parameters and returns the second largest
     *                  integer in the arrray.
     *********************************************************************************************/
    public static int secondLargestNumber(int[] intArray) {
        // Variable Declarations
        int largest = 0;
        int secondLargest = 0;

        // Initialize the largest and second largest variables from the first 2 array elements
        if(intArray[0] > intArray[1]) {
            largest = intArray[0];
            secondLargest = intArray[1];
        }
        else {
            largest = intArray[1];
            secondLargest = intArray[0];
        }

        // Loop through all element in the array assigning values for largest and second largest
        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] > largest) {
                secondLargest = largest;
                largest = intArray[i];
            }
            else if(intArray[i] < largest && intArray[i] > secondLargest) {
                secondLargest = intArray[i];
            }
        }

        // Return the second largest value
        return secondLargest;
    }

    /**********************************************************************************************
     *  Signature:      swapFirstAndLast(String[])
     *  Parameters:     StringArray:    An array of strings
     *  Return Type:    String[]
     *  Description:    Accepts an array of strings and swaps the first and last string in the array.
     *                  returns the array of strings.
     *********************************************************************************************/
    public static String[] swapFirstAndLast(String[] StringArray) {
        // Assign the first and last value of the array to variables
        String first = StringArray[0];
        String last = StringArray[StringArray.length - 1];

        // Swap the first and last value in the array
        StringArray[0] = last;
        StringArray[StringArray.length - 1] = first;

        // Return the Array
        return StringArray;
    }

    /**********************************************************************************************
     *  Signature:      reverse(int[])
     *  Parameters:     intArray:   Array of integer values
     *  Return Type:    int[]
     *  Description:    Pass an array of integers and return the reverse of the array of integers.
     *********************************************************************************************/
    public static int[] reverse(int[] intArray) {
        // Create a new array of integers to hold the reverse of the input array
        int[] reverseIntArray = new int[intArray.length];

        // Index for the reverse array
        int j = 0;

        // Reverse loop through the input array and index the value into the
        // new reverseIntArray
        for(int i = intArray.length; i > 0; i--) {
            System.out.println(intArray[i - 1]);
            reverseIntArray[j] = intArray[i - 1];
            j++;
        }

        // Return the reverse of the input array
        return reverseIntArray;
    }

    /**********************************************************************************************
     *  Signature:      concatenateString(String[])
     *  Parameters:     StringArray:    An array of strings
     *  Return Type:    String
     *  Description:    Pass an array of strings and return all of the strings in the array concatenated
     *                  together into a single string.
     *********************************************************************************************/
    public static String concatenateString(String[] StringArray) {
        // Initialize a string variable for the concatenation
        String concatenated = "";

        // Add all the strings into a single string in a for loop
        for(int i = 0; i < StringArray.length; i++) {
            concatenated = concatenated + StringArray[i];
        }

        // Return the concatenated string
        return concatenated;
    }

    /**********************************************************************************************
     *  Signature:      everyThird(int[])
     *  Parameters:     intArray:   Array of integers
     *  Return Type:    int[]
     *  Description:    Passes an array of integers and returns a new array consisting only of every
     *                  3rd index in the passed array.  If the input array has a length less than e
     *                  return null.
     *********************************************************************************************/
    public static int[] everyThird(int[] intArray) {
        // Variables for everyThird method
        int[] everyThirdArray = new int[intArray.length / 3];
        int j = 0;

        // If intArray length is less than 3 return null
        if(intArray.length < 3) {
            return null;
        }
        // If intArray length is greater than 3, output every 3rd index to
        // the everyThirdArray
        else {
            for(int i = 2; i < intArray.length; i = i + 3) {
                everyThirdArray[j] = intArray[i];
                j++;
            }
        }

        // Return the new array
        return everyThirdArray;
    }

    /**********************************************************************************************
     *  Signature:      lessThanFive(int[])
     *  Parameters:     intArray:   Any array of integers
     *  Return Type:    int[]
     *  Description:    Pass in an array of integers and return a new array of integers consisting
     *                  only of values less than 5.
     *********************************************************************************************/
    public static int[] lessThanFive(int[] intArray) {
        // Initialize a counter to determine if there is a value less than 5 in the input array
        int isLessThan5Counter = 0;

        // check every element in the array for a value of 5 or less
        for(int i = 0; i < intArray.length; i++) {
            // If the index is 5 or less, increase the counter
            if(intArray[i] < 5) {
                isLessThan5Counter++;
            }
        }

        // If the counter is greater than 0, begin creating the new array
        if(isLessThan5Counter > 0) {

            // Instantiate a new array of the size of how many elements are less than 5
            // within the original array and initialize the new array counter (k)
            int[] lessThan5Array = new int[isLessThan5Counter];
            int k = 0;

            // For every element in the passed array that is less than 5, output the value to
            // the new array
            for(int j = 0; j < intArray.length; j++) {
                if(intArray[j] < 5) {
                    lessThan5Array[k] = intArray[j];
                    k++;
                }
            }
            // Return the new array
            return lessThan5Array;
        }

        // If there are no elements greater than 5 in the array, return null.
        else {
            return null;
        }
    }

    /**********************************************************************************************
     *  Signature:      splitAtFive(int[])
     *  Parameters:     intArray:   An array of integer numbers
     *  Return Type:    int[][]
     *  Description:    Pass in an array of integers and return a 2 dimensional array consisting of
     *                  the numbers in the passed array that are less than 5 in the first dimension
     *                  and the numbers passed that are greater than or equal to 5 in the second
     *                  dimension.
     *********************************************************************************************/
    public static int[][] splitAtFive(int[] intArray) {

        // Variables
        int lessThan5Counter = 0;
        int greaterOrEqualTo5Counter = 0;
        int[][] returnedArray;

        // Set counters from input array
        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] < 5) {
                lessThan5Counter++;
            }
            else if(intArray[i] >= 5) {
                greaterOrEqualTo5Counter++;
            }
        }

        // Instantiate 2D Array of different length based on counters
        returnedArray = new int[2][];
        returnedArray[0] = new int[lessThan5Counter];
        returnedArray[1] = new int[greaterOrEqualTo5Counter];

        // Reset counters to populate the 2D array
        lessThan5Counter = 0;
        greaterOrEqualTo5Counter = 0;

        // Populate the new 2D array
        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] < 5) {
                returnedArray[0][lessThan5Counter] = intArray[i];
                lessThan5Counter++;
            }
            else if(intArray[i] >= 5) {
                returnedArray[1][greaterOrEqualTo5Counter] = intArray[i];
                greaterOrEqualTo5Counter++;
            }
        }

        // Return 2D array
        return returnedArray;
    }

    /**********************************************************************************************
     *  Signature:      evensAndOdds(String[])
     *  Parameters:     stringArray:    An array of strings
     *  Return Type:    String[][]
     *  Description:    Accepts an array of Strings and creates 2 new arrays one holding the values
     *                  of the even indices and the other the value of the odd indices returned in
     *                  a 2D array with even indices first.
     *********************************************************************************************/
    public static String[][] evensAndOdds(String[] stringArray) {
        // Variables
        int evenCounter = 0;
        int oddCounter = 0;
        String[][] returnedArray = new String[2][];

        // If the input array is of even length, create a squared 2D array
        if(stringArray.length % 2 == 0) {
            returnedArray[0] = new String[stringArray.length / 2];
            returnedArray[1] = new String[stringArray.length / 2];
        }
        // If the input array is of odd length, create a 2D array of different sizes where the even sized
        // array is 1 larger than the smaller sized array
        else {
            returnedArray[0] = new String[stringArray.length / 2 + 1];
            returnedArray[1] = new String[stringArray.length /2];
        }

        // Populate the new 2D array
        for (int i = 0; i < stringArray.length; i++) {
            if (i % 2 == 0) {
                returnedArray[0][evenCounter] = stringArray[i];
                evenCounter++;
            } else {
                returnedArray[1][oddCounter] = stringArray[i];
                oddCounter++;
            }
        }

        // Return the new 2D array
       return returnedArray;
    }

    public static void main(String[] argc) {

    }
}
