/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Asks for the user's age and displays a series of questions based on the value.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class AgeAgain {
    public static void main(String[] args) {

        // Variables
        int age = 0;
        String grade = " ";
        String goingToCollege = " ";
        String college = " ";
        String afterHighSchool = " ";
        String job = " ";

        // Create a Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for their age
        System.out.println("Please enter your age as an integer value.");
        age = Integer.parseInt(scan.nextLine());

        // If age is less than 14
        if(age < 14) {
            // Prompt the user for the grade they are in
            System.out.println("Please enter your grade as an integer value.");
            grade = scan.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        }

        // If age is between 14 and 18 inclusive
        else if(age >= 14 && age <= 18) {
            // Ask the user if they are going to college
            System.out.println("Are you planning to go to college? (yes/no)");
            goingToCollege = scan.nextLine();

            // If the user is going to college, ask what college.
            if(goingToCollege.equals("yes")) {
                System.out.println("What college are you planning to attend?");
                college = scan.nextLine();
                System.out.println(college + " is a great school!");
            }
            // If the user is not going to college, as what they would like to do after high school
            else if(goingToCollege.equals("no")) {
                System.out.println("What would you like to do after High School?");
                afterHighSchool = scan.nextLine();
                System.out.println("Wow, " + afterHighSchool + " sounds like a plan!");
            }
            // If input is incorrect
            else {
                System.out.println("Invalid Input");
            }
        }

        // If age is greater than 18
        else if(age > 18) {
            // Ask the user what their job is
            System.out.println("What is your job?");
            job = scan.nextLine();
            System.out.println(job + " sounds like a great job!");
        }
    }
}
