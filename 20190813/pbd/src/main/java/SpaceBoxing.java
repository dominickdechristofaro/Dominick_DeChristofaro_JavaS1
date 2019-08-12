/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Calculate a persons weight on 6 different planets.
 *                  https://programmingbydoing.com/a/space-boxing.html
 *************************************************************************************************/
import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        // Variables
        String[] planets = new String[] {"Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        double[] relativeGravity = new double[] {0.78, 0.39, 2.65, 1.17, 1.05, 1.23};
        double earthWeight = 0.0;
        int visitingPlanet = 0;
        double modifiedWeight = 0.0;

        // Instantiate Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter their weight on Earth
        System.out.println("Please enter your current earth weight: ");
        earthWeight = Double.parseDouble(scan.nextLine());

        // Alert the user what planets are available
        System.out.println("I have information for the following planets: ");
        for(int i = 0; i < planets.length; i++) {
            System.out.println("   " + (i + 1) + ". " + planets[i]);
        }

        // Prompt the user to enter what planet they are visiting
        System.out.println("What planet are you visiting");
        visitingPlanet = Integer.parseInt(scan.nextLine());
        while (visitingPlanet != 1 && visitingPlanet != 2 && visitingPlanet != 3 && visitingPlanet != 4 && visitingPlanet != 5 && visitingPlanet != 6) {
            System.out.println("Please enter a valid integer");
            visitingPlanet = Integer.parseInt(scan.nextLine());
        }

        // Calculate the new weight based on the planet input
        modifiedWeight = relativeGravity[visitingPlanet - 1] * earthWeight;

        // Output the weight on the new planet
        System.out.format("Your weight would be %.2f pounds on planet ", modifiedWeight);
        System.out.println(planets[visitingPlanet - 1] + ".");
    }
}
