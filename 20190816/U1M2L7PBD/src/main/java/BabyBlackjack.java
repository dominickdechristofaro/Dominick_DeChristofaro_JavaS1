/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.16.2019
 ** Description:    https://programmingbydoing.com/a/baby-blackjack.html
 *************************************************************************************************/
import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        // Variables
        int userCard1 = 0;
        int userCard2 = 0;
        int userTotal = 0;
        int dealerCard1 = 0;
        int dealerCard2 = 0;
        int dealerTotal = 0;
        int test = 0;

        // Object Instantiation
        Random random = new Random();

        // Output program name
        System.out.println("Baby Blackjack!");
        System.out.println(" ");

        // Randomize Card Values for user and dealer
        userCard1 = random.nextInt(10 - 1 + 1) + 1;
        userCard2 = random.nextInt(10 - 1 + 1) + 1;
        dealerCard1 = random.nextInt(10 - 1 + 1) + 1;
        dealerCard2 = random.nextInt(10 - 1 + 1) + 1;

        // Calculate totals
        userTotal = userCard1 + userCard2;
        dealerTotal = dealerCard1 + dealerCard2;

        // Output User Card Draws
        System.out.println("You drew " + userCard1 + " and " + userCard2 + ".");
        System.out.println("Your total is " + userTotal + ".");
        System.out.println(" ");

        // Output Dealer Card Draws
        System.out.println("The dealer has " + dealerCard1 + " and " + dealerCard2 + ".");
        System.out.println("Dealer's total is " + dealerTotal + ".");
        System.out.println(" ");

        // Output the winner
        // Note: In blackjack you only win if your card total is greater than the dealer.
        if(userTotal > dealerTotal) {
            System.out.println("YOU WIN!");
        }
        else {
            System.out.println("Dealer wins.");
        }
    }
}
