/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Take a Java Quiz and report how many questions the user answered correctly.
 *                  https://programmingbydoing.com/a/a-little-quiz.html
 *************************************************************************************************/
import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        // Variables
        int answer = 0;
        int correctAnswers = 0;
        String runQuiz = "";

        // Instantiate Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Ask the user if they are ready for a quid
        System.out.println("Are you ready to take a quiz? (Y/N)");
        runQuiz = scan.nextLine();

        // If runQuiz = "Y": Run the quiz
        // If runQuiz = "N": Tell the user to study
        // Else: Notify user of input error
        if(runQuiz.equals("Y")) {

            // First Question
            System.out.println("Which of the following file extension types store the Java source code?");
            System.out.println("   1: .java");
            System.out.println("   2: .class");
            System.out.println("   3: .source");
            System.out.println("   4: .code");
            answer = Integer.parseInt(scan.nextLine());
            if(answer == 1) {
                System.out.println("That's correct!");
                correctAnswers++;
            }
            else {
                System.out.println("That's not the correct answer");
            }

            // Second Question
            System.out.println("Which of the following words is NOT a keyword in java?");
            System.out.println("   1. public");
            System.out.println("   2. void");
            System.out.println("   3. static");
            System.out.println("   4. String");
            answer = Integer.parseInt(scan.nextLine());
            if(answer == 4) {
                System.out.println("That's correct!");
                correctAnswers++;
            }
            else {
                System.out.println("That's not the correct answer");
            }

            // Third Question
            System.out.println("Which of the following class names correctly follow naming conventions?");
            System.out.println("   1. planetApp");
            System.out.println("   2. Planetapp");
            System.out.println("   3. planetapp");
            System.out.println("   4. PlanetApp");
            answer = Integer.parseInt(scan.nextLine());
            if(answer == 4) {
                System.out.println("That's correct!");
                correctAnswers++;
            }
            else {
                System.out.println("That's not the correct answer");
            }

            // Output how many answers the user got correct
            System.out.println("Overall, you got " + correctAnswers + " out of 3 correct.");
            System.out.println("Thanks for playing!");
        }
        // If the user isn't ready to take the quiz
        else if(runQuiz.equals("N")) {
            System.out.println("Wow, better study for the quiz!");
        }
        // Input error, program terminated
        else {
            System.out.println("Input Error. Program Terminated");
        }
    }
}
