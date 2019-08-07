/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Displays the monthly mortgage payment amount given:
 *                      The total amount of the mortgage
 *                      The total term of the mortgage in months
 *                      The annual interest rate of the mortgage
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {

        // Variables
        double totalMortgage = 0.00;
        double mortgageTerm = 0.00;
        double interestRate = 0.00;
        double monthlyPayment = 0.00;

        // Instantiate a Scanner object for user Input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for the following information:
        //      The total amount of the mortgage
        //      The term of the mortgage
        //      The annual interest rate of the mortgage
        System.out.println("Please input the total amount of the mortgage (integer value with no $ or ,).");
        totalMortgage = Double.parseDouble(scan.nextLine());
        System.out.println("Please input the term of the mortgage in months (integer value with no ,).");
        mortgageTerm = Double.parseDouble(scan.nextLine());
        System.out.println("Please input the interest rate of the mortgage (integer 0 - 100).");
        interestRate = Double.parseDouble(scan.nextLine());

        // Convert the interest rate to a decimal value over 12 months
        interestRate = (interestRate / 100.0) / 12.0;

        // Calculate and display the monthly mortgage payment
        monthlyPayment = ((totalMortgage * ((interestRate * (Math.pow((1.0 + interestRate), mortgageTerm))) / ((Math.pow((1.0 + interestRate), mortgageTerm)) - 1.0))) - 0.005);
        System.out.format("Your monthly mortgage payment will be $%.2f%n", monthlyPayment);
        System.out.println(" ");
    }
}
