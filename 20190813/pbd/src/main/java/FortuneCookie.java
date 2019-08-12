/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Simulate a random chinese fortune cookie and lotto number draw.
 *                  https://programmingbydoing.com/a/fortune-cookie.html
 *************************************************************************************************/
import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        // Variables
        Random random = new Random();
        int[] lottoNumbers = new int[6];
        String[] fortunes = new String[6];
        int randomFortune = random.nextInt(5 - 0 + 1) + 0;
        fortunes[0] = "The early bird gets the worm, but the second mouse gets the cheese.";
        fortunes[1] = "Be on the alert to recognize your prime at whatever time of your life it may occur.";
        fortunes[2] = "Your road to glory will be rocky, but fulfilling.";
        fortunes[3] = "Courage is not simply one of the virtues, but the form of every virtue at the testing point.";
        fortunes[4] = "Patience is your alley at the moment. Don't worry!";
        fortunes[5] = "Nothing is impossible to a willing heart.";

        // Populate the index's of the lotto numbers
        for(int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = random.nextInt(54 - 1 + 1) + 1;
        }

        // Print out fortune cookie and lotto numbers
        System.out.format("Fortune cookie says: ");
        System.out.println(fortunes[randomFortune]);
        System.out.format("    ");
        for(int i = 0; i < 5; i++) {
            System.out.format("%d", lottoNumbers[i]);
            System.out.format(" - ");
        }
        System.out.format("%d", lottoNumbers[5]);

    }
}
