/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.15.2019
 ** Description:    Simulate try-catch validation in a Class.
 *************************************************************************************************/
package com.company;
import com.company.interfaces.UserIO;
import java.util.Scanner;

public class BetterInput implements UserIO {
    // Instantiate Scanner for user input
    Scanner scanner = new Scanner(System.in);


    public int readInt(String prompt) {
        try {
            System.out.println(prompt);
            int userInput = Integer.parseInt(scanner.nextLine());
            return userInput;
        }
        catch (NumberFormatException e){
            System.err.println("Caught NumberFormatException: " + e.getMessage() + "\n");
            System.out.println("Please provide valid input.");
            int userInput = readInt(prompt);
            return userInput;
        }
    }

    public long readLong(String prompt) {
        try {
            System.out.println(prompt);
            long userInput = Long.parseLong(scanner.nextLine());
            return userInput;
        }
        catch (NumberFormatException e){
            System.err.println("Caught NumberFormatException: " + e.getMessage() + "\n");
            System.out.println("Please provide valid input.");
            long userInput = readLong(prompt);
            return userInput;
        }
    }

    public double readDouble(String prompt) {
        try {
            System.out.println(prompt);
            double userInput = Double.parseDouble(scanner.nextLine());
            return userInput;
        }
        catch (NumberFormatException e){
            System.err.println("Caught NumberFormatException: " + e.getMessage() + "\n");
            System.out.println("Please provide valid input.");
            double userInput = readDouble(prompt);
            return userInput;
        }
    }

    public float readFloat(String prompt) {
        try {
            System.out.println(prompt);
            float userInput = Float.parseFloat(scanner.nextLine());
            return userInput;
        }
        catch (NumberFormatException e){
            System.err.println("Caught NumberFormatException: " + e.getMessage() + "\n");
            System.out.println("Please provide valid input.");
            float userInput = readFloat(prompt);
            return userInput;
        }
    }

    public String readString(String prompt) {
            System.out.println(prompt);
            String userInput = scanner.nextLine();
            return userInput;
    }
}
