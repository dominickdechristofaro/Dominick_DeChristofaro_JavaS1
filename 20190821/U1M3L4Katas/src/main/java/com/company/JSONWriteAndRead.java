/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Read and Write JSON files.
 *************************************************************************************************/
package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONWriteAndRead {
    public static void main(String[] args) {
        try {
            // Instantiate a new ArrayList called carList
            List<Car> carList = new ArrayList<>();

            // Add values to carList
            carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
            carList.add(new Car(2001, "Honda", "Civic", "Silver"));
            carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
            carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
            carList.add(new Car(1964, "Ford", "Mustang", "Red"));

            // Now let's write the carList to a JSON file
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("carFile.json"), carList);

            // Reading from the JSON file
            carList = mapper.readValue(new File("carFile.json"), new TypeReference<List<Car>>(){});

            // Iterate through the carList outputting the specifications of the car
            for (Car car : carList) {
                System.out.println("========");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println("Finally...");
        }
    }
}
