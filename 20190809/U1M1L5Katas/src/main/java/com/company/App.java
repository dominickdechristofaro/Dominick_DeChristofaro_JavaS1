/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/09/2019
 *  Description:    U1M1L5katas: 5 functions that demonstrate how to build methods within a Class.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class App {

    /**********************************************************************************************
     *  Function Name:  subtract(int a, int b)
     *  Parameters:     a: Any Integer value
     *                  b: Integer value to be subtracted from a
     *  Purpose:        Subtract b from a and return a.
     *  Return:         Integer
     *********************************************************************************************/
    public static int subtract(int a, int b) {
        return a - b;
    };

    /**********************************************************************************************
     *  Function Name:  subtractOrZero(int a, int b)
     *  Parameters:     a: Any Integer Value
     *                  b: Any Integer Value to be subtracted from a
     *  Purpose:        Subtract b from a and return the value computed only if > than 0. If the
     *                  computation is < 0, then return 0;
     *  Return:         Integer
     *********************************************************************************************/
    public static int subtractOrZero(int a, int b) {
        int subtract = a - b;
        if(subtract < 0) {
            return 0;
        }
        else {
            return subtract;
        }
    };

    /**********************************************************************************************
     *  Function Name:  max(int a, int b, int c)
     *  Parameters:     a: Any Integer value
     *                  b: Any Integer value
     *                  c: Any Integer value
     *  Purpose:        Takes 3 integers as parameters and returns the largest of the 3 integer values.
     *  Return:         Integer
     *********************************************************************************************/
    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }
        else if (b > a && b > c) {
            return b;
        }
        else {
            return c;
        }
    };

    /**********************************************************************************************
     *  Function Name:  min(int a, int b, int c)
     *  Parameters:     a: Any Integer Value
     *                  b: Any Integer Value
     *                  c: Any Integer Value
     *  Purpose:        Takes 3 integers as parameters and returns the smallest of the 3 integer values.
     *  Return:         Integer
     *********************************************************************************************/
    public static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }
        else if (b < a && b < c) {
            return b;
        }
        else {
            return c;
        }
    };

    /**********************************************************************************************
     *  Function Name:  isLarger(int first, int second)
     *  Parameters:     first:  Any Integer value
     *                  second: Any Integer value
     *  Purpose:        Takes 2 integer values and returns true if the first integer parameter is
     *                  larger than the second integer parameter.  Returns false if the second integer
     *                  parameter is larger than the first.
     *  Return:         boolean
     *********************************************************************************************/
    public static boolean isLarger(int first, int second) {
        if(first > second) {
            return true;
        }
        else {
            return false;
        }
    };

    public static void main(String[] argc) {
        // Test for subtract()
        System.out.println(subtract(4,2));

        // Tests for subtractOrZero()
        System.out.println(subtractOrZero(5,3));
        System.out.println(subtractOrZero(5, 7));

        // Tests for max()
        System.out.println(max(1,2,3));
        System.out.println(max(3,1,2));
        System.out.println(max(2,3,1));

        // Tests for min()
        System.out.println(min(1,2,3));
        System.out.println(min(3,1,2));
        System.out.println(min(2,3,1));

        // Tests for isLarger()
        System.out.println(isLarger(5,10));
        System.out.println(isLarger(10,5));
    }

}
