/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Read and Write CSV Files.
 *************************************************************************************************/
package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriteAndRead {
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

            // Now let's write the carList to another file
            Writer writer = new FileWriter("carFile.csv");
            StatefulBeanToCsv<Car> beanToCsv = new StatefulBeanToCsvBuilder<Car>(writer).build();
            beanToCsv.write(carList);
            writer.close();

            // Instantiate a new BeanBuilder
            carList = new CsvToBeanBuilder<Car>(new FileReader("carFile.csv")).withType(Car.class).build().parse();

            // Loop through the file
            for(Car car : carList) {
                System.out.println("========");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        } catch (CsvDataTypeMismatchException e) {
            System.out.println("CsvDataTypeMismatchException caught: " + e.getMessage());
        } catch (CsvRequiredFieldEmptyException e) {
            System.out.println("CsvRequiredFieldEmptyException caught: " + e.getMessage());
        } finally {
            System.out.println(" ");
        }
    }
}
