/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Read and Write XML files.
 *************************************************************************************************/
package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {
    public static void main(String[] args) {
        // Set the variable of type PrintWriter to null
        PrintWriter writer = null;

        try {
        // Instantiate a new ArrayList called carList
        List<Car> carList = new ArrayList<>();

        // Add values to carList
        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        // Now let's write the carList to a XML file
        ObjectMapper mapper = new XmlMapper();
        String xmlCarList = mapper.writeValueAsString(carList);
        writer = new PrintWriter(new FileWriter("carFile.xml"));
        writer.println(xmlCarList);
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        } finally {
            // ALWAYS CLOSE THE WRITER TO ENSURE OUTPUT IS CORRECT!
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

        try {
            // Now let's read the carList from an XML file
            ObjectMapper mapper = new XmlMapper();
            List<Car> carList = mapper.readValue(new File("carFile.xml"), new TypeReference<List<Car>>(){});

            // Iterate through the carList and print out values
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
            System.out.println(" ");
        }
    }
}