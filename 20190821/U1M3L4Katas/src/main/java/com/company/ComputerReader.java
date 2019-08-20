/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Read and output the contents of a CSV file.
 *************************************************************************************************/
package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {
        try {
            // Create a new computerList from the computers.csv file
            List<Computer> computerList = new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();

            // Iterate through the CSV file outputting the specifications of the computer
            for (Computer computer : computerList) {
                System.out.println("=======================================");
                System.out.println(computer.getBrand());
                System.out.println(computer.getModel());
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
                System.out.println(computer.getStorageSize());
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        } finally {
            System.out.println(" ");
        }
    }
}
