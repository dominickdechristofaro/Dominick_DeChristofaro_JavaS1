/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Calculator with addition, subtraction, multiplication, and division.
 *************************************************************************************************/
public class CalculatorObject {
    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public CalculatorObject() {

    }

    /**********************************************************************************************
     *              Add any 2 integers together and output the calculation and the result.
     * @param num1  Any integer
     * @param num2  Any integer
     *********************************************************************************************/
    public void addition(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + result);
    }

    /**********************************************************************************************
     *              Add any 2 doubles together and output the calculation and the result.
     * @param num1  Any double
     * @param num2  Any double
     *********************************************************************************************/
    public void addition(double num1, double num2) {
        double result = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + result);
    }

    /**********************************************************************************************
     *              Subtract any 2 integers and output the calculation and the result.
     * @param num1  Any integer
     * @param num2  Any integer
     *********************************************************************************************/
    public void subtraction(int num1, int num2) {
        int result = num1 - num2;
        System.out.println(num1 + " - " + num2 + " = " + result);
    }

    /**********************************************************************************************
     *              Subtract any 2 doubles and output the calculation and the result.
     * @param num1  Any double
     * @param num2  Any double
     *********************************************************************************************/
    public void subtraction(double num1, double num2) {
        double result = num1 - num2;
        System.out.println(num1 + " - " + num2 + " = " + result);
    }

    /**********************************************************************************************
     *              Multiply any 2 integers and output the calculation and the result.
     * @param num1  Any integer
     * @param num2  Any integer
     *********************************************************************************************/
    public void multiplication(int num1, int num2) {
        int result = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + result);
    }

    /**********************************************************************************************
     *              Multiply any 2 doubles and output the calculation and the result.
     * @param num1  Any double
     * @param num2  Any double
     *********************************************************************************************/
    public void multiplication(double num1, double num2) {
        double result = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + result);
    }

    /**********************************************************************************************
     *              Divide any 2 integers and output the calculation and the result. Mimics a
     *              calculator, does not perform integer division.
     * @param num1  Any integer
     * @param num2  Any integer
     *********************************************************************************************/
    public void division(int num1, int num2) {
        double result = (double)num1 / (double)num2;
        System.out.println(num1 + " / " + num2 + " = " + result);
    }

    /**********************************************************************************************
     *              Divide any 2 doubles and output the calculation and the result.
     * @param num1  Any double
     * @param num2  Any double
     *********************************************************************************************/
    public void division(double num1, double num2) {
        double result = num1 / num2;
        System.out.println(num1 + " / " + num2 + " = " + result);
    }
}
