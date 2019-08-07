/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Prompt the user for their favorite programming language until they input Java as their favorite.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class FavoriteProgrammingLanguage {
    public static void main(String[] args) {

        // Variables
        String userInput = " ";

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter their favorite programming language
        System.out.println("Please enter your favorite programming language.");
        userInput = scan.nextLine();

        // Continue to ask the user for their favorite programming language until they input Java
        while(!userInput.equals("Java")) {
            System.out.println("That's not your favorite programming language, enter your favorite programming language.");
            userInput = scan.nextLine();
        }

        // User input Java, output a line to the console
        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}
