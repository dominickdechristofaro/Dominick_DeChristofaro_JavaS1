/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.23.2019
 *  Description:    helper methods
 *************************************************************************************************/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HelperFunctions {
    public HelperFunctions() {
    }

    /**
     *              Parse and return userInput for Strings
     * @return      String
     */
    public String userInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     *              Parse and return userInput for Integers
     * @return      Integer
     */
    public int userInputInteger() {
        Scanner scanner = new Scanner(System.in);
        int userInputInteger;
        try {
            userInputInteger = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Please input a valid Integer number: ");
            return userInputInteger();
        } finally {
            System.out.print("");
        }
        return userInputInteger;
    }

    /**
     *              Read the Cars from a JSON file into a List
     * @return      An ArrayList of Cars from the JSON file.
     */
    public List<Car> JSONReader() {
        ObjectMapper mapper = new ObjectMapper();
        List<Car> carList = new ArrayList<>();
        try {
            carList = mapper.readValue(new File("carFile.json"), new TypeReference<List<Car>>(){});
            return carList;
        } catch (IOException e) {
            System.err.println("carFile.json not found or is empty.");
            System.err.println("carFile.json will be initialized.");
            JSONWriter(carList);
        } finally {
            System.out.print("");
        }
        return carList;
    }

    public void JSONWriter(List<Car> carList) {
        PrintWriter writer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);
            writer = new PrintWriter(new FileWriter("carFile.json"));
            writer.println(jsonCarList);
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        } finally {
            if(writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
