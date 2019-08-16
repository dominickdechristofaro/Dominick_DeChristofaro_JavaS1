/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.19.2019
 *  Description:    Modify the original Baby Nim program to include 2 users that take turns removing
 *                  things from the pile.  The person to remove the last object loses.
 *                  https://programmingbydoing.com/a/nim.html
 **************************************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        // Variables
        String user1;
        String user2;
        String userInputPile;
        int pileA;
        int pileB;
        int pileC;
        int userInputAmount;
        int counter = 1;

        // Instantiate Objects
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Prompt the users to enter their names
        System.out.print("Player 1, enter your name: ");
        user1 = scanner.nextLine();
        System.out.print("Player 2, enter your name: ");
        user2 = scanner.nextLine();
        System.out.println(" ");

        // Randomize the things in the piles to an integer between 5 and 10
        pileA = random.nextInt(10 - 5 + 1) + 5;
        pileB = random.nextInt(10 - 5 + 1) + 5;
        pileC = random.nextInt(10 - 5 + 1) + 5;

        //Have players remove things from piles until the piles are empty
        while(pileA > 0 || pileB > 0 || pileC > 0) {
            // Output the number of things in each pile
            System.out.println("A: " + pileA);
            System.out.println("B: " + pileB);
            System.out.println("C: " + pileC);
            System.out.println(" ");

            // Prompt the correct user to choose a pile and remove items from the pile
            if (counter % 2 != 0) {
                System.out.print(user1 + ", choose a pile: ");
                userInputPile = scanner.nextLine();
                System.out.format("How many to remove from pile ");
                System.out.print(userInputPile + ": ");
                userInputAmount = Integer.parseInt(scanner.nextLine());
                System.out.println(" ");
            } else {
                System.out.print(user2 + ", choose a pile: ");
                userInputPile = scanner.nextLine();
                System.out.format("How many to remove from pile ");
                System.out.print(userInputPile + ": ");
                userInputAmount = Integer.parseInt(scanner.nextLine());
                System.out.println(" ");
            }

            // Remove userInputAmount from userInputPile
            switch (userInputPile) {
                case "A":
                    pileA -= userInputAmount;
                    break;
                case "B":
                    pileB -= userInputAmount;
                    break;
                case "C":
                    pileC -= userInputAmount;
                    break;
            }
            counter++;
        }

        // Output the winner
        if(counter % 2 != 0) {
            System.out.println(user1 + ", there are no counters left, so you WIN!");
        }
        else {
            System.out.println(user2 + ", there are no counters left, so you WIN!");
        }
    }
}
