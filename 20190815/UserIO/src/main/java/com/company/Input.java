/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.15.2019
 ** Description:    Simplistic example of userIO interfaces without try-catch blocks.
 *************************************************************************************************/
package com.company;
import com.company.interfaces.UserIO;
import java.util.Scanner;

public class Input implements UserIO {
    Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt) {
        System.out.println(prompt);
        int userInput = Integer.parseInt(scanner.nextLine());
        return userInput;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        long userInput = Long.parseLong(scanner.nextLine());
        return userInput;
    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        double userInput = Double.parseDouble(scanner.nextLine());
        return userInput;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        float userInput = Float.parseFloat(scanner.nextLine());
        return userInput;
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
