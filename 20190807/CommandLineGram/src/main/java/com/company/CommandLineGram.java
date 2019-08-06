/**************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08.07.2019
 *  Description:    Prompt the user for information to register for a social media service then
 *                  display the information to the user, nicely formatted.
 *************************************************************************************************/
package com.company;
import java.util.Scanner;

public class CommandLineGram {
    public static void main(String[] args) {

        // Create a new Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for information
        System.out.println("Please input your First Name.");
        String firstName = scan.nextLine();

        System.out.println("Please input your Last Name.");
        String lastName = scan.nextLine();

        System.out.println("Please input your Email.");
        String email = scan.nextLine();

        System.out.println("Please input your Twitter handle.");
        String twitterHandle = scan.nextLine();

        System.out.println("Please input your Age.");
        int age = Integer.parseInt(scan.nextLine());

        System.out.println("Please input your Country.");
        String country = scan.nextLine();

        System.out.println("Please input your Profession.");
        String profession = scan.nextLine();

        System.out.println("Please input your Favorite operating system.");
        String favoriteOperatingSystem = scan.nextLine();

        System.out.println("Please input your Favorite programming language.");
        String favoriteProgrammingLanguage = scan.nextLine();

        System.out.println("Please input your Favorite computer scientist.");
        String favoriteComputerScientist = scan.nextLine();

        System.out.println("Please input your Favorite keyboard shortcut.");
        String favoriteKeyboardShortcut = scan.nextLine();

        System.out.println("Have you ever built your own computer?");
        String builtComputer = scan.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String favoriteSuperhero = scan.nextLine();

        // Display the user information nicely formatted.
        System.out.println("First Name:                                         " + firstName);
        System.out.println("Last Name:                                          " + lastName);
        System.out.println("Email:                                              " + email);
        System.out.println("Twitter Handle:                                     " + twitterHandle);
        System.out.println("Age:                                                " + age);
        System.out.println("Country:                                            " + country);
        System.out.println("Profession:                                         " + profession);
        System.out.println("Favorite Operating System:                          " + favoriteOperatingSystem);
        System.out.println("Favorite Programming Language:                      " + favoriteProgrammingLanguage);
        System.out.println("Favorite Computer Scientist:                        " + favoriteComputerScientist);
        System.out.println("Favorite Keyboard Shortcut:                         " + favoriteKeyboardShortcut);
        System.out.println("Have you ever built your own computer?:             " + builtComputer);
        System.out.println("If you could be any superhero, who would it be?:    " + favoriteSuperhero);
    }
}
