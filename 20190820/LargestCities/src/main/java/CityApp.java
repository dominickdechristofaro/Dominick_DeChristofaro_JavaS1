/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Prompts the user to input a number and displays state names with city whose
 *                  populations are greater than the number input.
 *************************************************************************************************/
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CityApp {
    public static void main(String[] args) {
        // Variables
        int populationInput;

        // Instantiate Scanner Object
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for population input
        System.out.println("Please input the minimum value a state needs to meet population criteria.");
        populationInput = Integer.parseInt(scanner.nextLine());

        // Create new city objects
        City city1 = new City("New York", 8654321);
        City city2 = new City("Los Angeles", 4563218);
        City city3 = new City("Chicago", 2716520);
        City city4 = new City("Denver", 704621);
        City city5 = new City("Des Moines", 217521);
        City city6 = new City("Atlanta", 486213);

        // Create a new Map object with <String (State Names), City (City Objects)>
        Map<String, City> cityMap = new HashMap<>();
        cityMap.put("New York", city1);
        cityMap.put("California", city2);
        cityMap.put("Illinois", city3);
        cityMap.put("Colorado", city4);
        cityMap.put("Iowa", city5);
        cityMap.put("Georgia", city6);

        // Iterator to parse through the Map object
        Iterator iterator = cityMap.entrySet().iterator();

        // Outputs the City Name, City Population, and State of all entries in the Map object
        System.out.println("All city names, populations, and State within the map.");
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            City cityObject = (City)entry.getValue();
            System.out.println(cityObject.getName() + ", " + entry.getKey() + " has a population of " + cityObject.getPopulation());
        }
        System.out.println(" ");

        // Reset the iterator back to the beginning
        iterator = cityMap.entrySet().iterator();

        // Output the States who have city's with populations greater than the user input
        System.out.println("All states with cities that have a population over " + populationInput + ".");
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            City cityObject = (City)entry.getValue();
            if(cityObject.getPopulation() > populationInput) {
                System.out.println(cityObject.getName() + ", " + entry.getKey());
            }
        }
    }
}
