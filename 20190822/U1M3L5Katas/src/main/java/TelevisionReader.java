/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.22.2019
 *  Description:
 *************************************************************************************************/
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.transformation.SortedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TelevisionReader {
    public static void main(String[] args) {
        try {
            // Instantiate a mapper to read JSON entries
            ObjectMapper mapper = new ObjectMapper();

            // Reading entries from the JSON file into televisionList
            List<Television> televisionList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            // Print the information for all Televisions with a screen size larger than 60
            int largeTelevision = 60;
            televisionList
                    .stream()
                    .filter(televisionFilter -> televisionFilter.getScreenSize() > largeTelevision)
                    .forEach(television -> {
                        System.out.println("===============================");
                        System.out.println("Brand: " + television.getBrand());
                        System.out.println("Model: " + television.getModel());
                        System.out.println("Price: " + television.getPrice());
                        System.out.println("Screen Size: " + television.getScreenSize());
            });

            // Whitespace
            System.out.println("===============================");

            // Place all of the televisions with a screen size larger than 60 into a new list
            List<Television> largeTelevisions =
                    televisionList
                        .stream()
                        .filter(television -> television.getScreenSize() > largeTelevision)
                        .collect(Collectors.toList());

            // Group all the televisions into a map using the brand as the key
            Map<String, List<Television>> groupedTelevisions =
                    televisionList
                        .stream()
                        .collect(Collectors.groupingBy(television -> television.getBrand()));

            // Header for the section
            System.out.println("All the brands of televisions available:");

            // Output all the brands of televisions in the JSON file
            Set<String> keys = groupedTelevisions.keySet();
            for(String key : keys) {
                System.out.println(key);
            }

            // Whitespace
            System.out.println("===============================");

            // Calculate the average screenSize across all televisions
            double averageScreenSize =
                    televisionList
                        .stream()
                        .mapToInt(television -> television.getScreenSize())
                        .average()
                        .getAsDouble();

            // Display the average screenSize across all televisions
            System.out.println("Average Screen Size: " + averageScreenSize);

            // Whitespace
            System.out.println("===============================");

            // Find the largest screenSize across all televisions
            int maxScreenSize =
                    televisionList
                        .stream()
                        .mapToInt(television -> television.getScreenSize())
                        .max()
                        .getAsInt()
                        ;

            // Display the largest screen size across all televisions
            System.out.println("Max Screen Size: " + maxScreenSize);

            // Whitespace
            System.out.println("===============================");

            // Sort the televisions by screen size and print out the sorted list

        } catch (FileNotFoundException e) {
            System.err.println("Could not find JSON file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println(" ");
        }
    }
}
