/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Calculator with addition, subtraction, multiplication, and division.
 *************************************************************************************************/
public class CalculatorObjectApp {
    public static void main(String[] args) {
        // Instantiate new CalculatorObject
        CalculatorObject calculator = new CalculatorObject();

        // Perform required calculations
        calculator.addition(1, 1);
        calculator.subtraction(23, 52);
        calculator.multiplication(34, 2);
        calculator.division(12, 3);
        calculator.division(12, 7);
        calculator.addition(3.4, 2.3);
        calculator.multiplication(6.7, 4.4);
        calculator.subtraction(5.5, 0.5);
        calculator.division(10.8, 2.2);
    }
}
