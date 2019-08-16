/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.19.2019
 *  Description:    Simple program where the user needs to remove things from piles until all the
 *                  piles are empty.
 *                  https://programmingbydoing.com/a/baby-nim.html
 **************************************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        // Varaibles
        int pileA;
        int pileB;
        int pileC;
        String userInputPile;
        int userInputAmount;

        // Instantiate Objects
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Randomize amount of things in each pile to a random integer between 5 and 10
        pileA = random.nextInt(10 - 5 + 1) + 5;
        pileB = random.nextInt(10 - 5 + 1) + 5;
        pileC = random.nextInt(10 - 5 + 1) + 5;

        // Continue looping until all things are removed from all piles
        while(pileA > 0 || pileB > 0 || pileC > 0) {
            // Output the number of things in each pile
            System.out.println("A: " + pileA);
            System.out.println("B: " + pileB);
            System.out.println("C: " + pileC);
            System.out.println(" ");

            // Prompt the user to choose a pile
            System.out.format("Choose a pile: ");
            userInputPile = scanner.nextLine();

            // Prompt the user to choose a integer number of things to remove from the pile
            System.out.format("How many to remove from pile ");
            System.out.print(userInputPile + ": ");
            userInputAmount = Integer.parseInt(scanner.nextLine());
            System.out.println(" ");

            // Remove userInputAmount from userInputPile
            switch (userInputPile) {
                case "A":   pileA -= userInputAmount;
                            break;
                case "B":   pileB -= userInputAmount;
                            break;
                case "C":   pileC -= userInputAmount;
                            break;
            }
        }

        // Output the final amounts in the piles & alert the user the program has finished
        System.out.println("A: " + pileA);
        System.out.println("B: " + pileB);
        System.out.println("C: " + pileC);
        System.out.println(" ");
        System.out.println("All piles are empty. Good job!");
    }
}
