import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelperFunctions {
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
     *              Read the States from a JSON file into a List.
     * @return      An ArrayList of States from the JSON file.
     */
    public List<State> JsonReader() {
        ObjectMapper mapper = new ObjectMapper();
        List<State> stateList = new ArrayList<>();
        try {
            stateList = mapper.readValue(new File("stateList.json"), new TypeReference<List<State>>(){});
            return stateList;
        } catch (IOException e) {
            System.err.println("stateList.json not found or is empty.");
            System.err.println("stateList.json will be initialized.");
            JSONWriter(stateList);
        } finally {
            System.out.print("");
        }
        return stateList;
    }

    /**
     *                      Write the stateList to the stateList.json file
     * @param stateList     An ArrayList of States.
     */
    public void JSONWriter(List<State> stateList) {
        PrintWriter writer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonStateList = mapper.writeValueAsString(stateList);
            writer = new PrintWriter(new FileWriter("stateList.json"));
            writer.println(jsonStateList);
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
