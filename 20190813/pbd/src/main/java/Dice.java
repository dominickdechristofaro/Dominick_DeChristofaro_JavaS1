/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Simulate a simple die rolling program.  Display the sum of the die rolls.
 *                  https://programmingbydoing.com/a/dice.html
 *************************************************************************************************/
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        //Variables
        Random random = new Random();
        int die1 = random.nextInt(6 - 1 + 1) + 1;
        int die2 = random.nextInt(6 - 1 + 1) + 1;
        int sum = die1 + die2;

        // Simulate the die rolls
        System.out.println("HERE COMES THE DICE!");
        System.out.println("");
        System.out.println("Roll #1: " + die1);
        System.out.println("Roll #2: " + die2);
        System.out.println("The total is " + sum + "!");
    }
}
