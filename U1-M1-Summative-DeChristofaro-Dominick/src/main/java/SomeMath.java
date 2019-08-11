/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.09.2019
 ** Description:    3 methods to calculate various mathematical functions
 *************************************************************************************************/

public class SomeMath {

    /**********************************************************************************************
     *  Signature:      total5(int, int, int, int, int)
     *  Parameters:     num1:   Any integer number
     *                  num2:   Any integer number
     *                  num3:   Any integer number
     *                  num4:   Any integer number
     *                  num5:   Any integer number
     *  Return Type:    integer
     *  Description:    Accepts 5 integers and returns the summation of parameters
     *********************************************************************************************/
    public static int total5(int num1, int num2, int num3, int num4, int num5) {
        int total = 0;
        return total = num1 + num2 + num3 + num4 + num5;
    }

    /**********************************************************************************************
     *  Signature:      average5(int, int, int, int, int)
     *  Parameters:     num1:   Any integer number
     *                  num2:   Any integer number
     *                  num3:   Any integer number
     *                  num4:   Any integer number
     *                  num5:   Any integer number
     *  Return Type:    double
     *  Description:    Accepts 5 integers as parameters and returns the average of the parameters
     *                  as a double.
     *********************************************************************************************/
    public static double average5(int num1, int num2, int num3, int num4, int num5) {
        double average = 0.0;
        return average = (num1 + num2 + num3 + num4 + num5) / 5;
    }

    /**********************************************************************************************
     *  Signature:      largest5(double, double, double, double, double)
     *  Parameters:     num1:   Any double number
     *                  num2:   Any double number
     *                  num3:   Any double number
     *                  num4:   Any double number
     *                  num5:   Any double number
     *  Return Type:    double
     *  Description:    Accepts 5 doubles as parameters and returns the largest value input as a double.
     *********************************************************************************************/
    public static double largest5(double num1, double num2, double num3, double num4, double num5) {
        double[] numArray = new double[] {num1, num2, num3, num4, num5};
        double largest = num1;
        for(int i = 0; i < numArray.length; i++) {
            if(numArray[i] > largest) {
                largest = numArray[i];
            }
        }
        return largest;
    }

    public static void main(String[] argc) {
        // Tests for the methods referenced above
        System.out.println(total5(1, 2, 3, 4, 5));
        System.out.println(average5(1,3,5,7,9));
        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));
    }
}
