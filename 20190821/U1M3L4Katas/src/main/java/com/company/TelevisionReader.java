/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Reading and output from a JSON file.
 *************************************************************************************************/
package com.company;

import java.io.IOException;
import java.util.List;
import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TelevisionReader {
    public static void main(String[] args) {
        try {
            // Read Television properties from a JSON file using mapper to a List
            ObjectMapper mapper = new ObjectMapper();
            List<Television> televisionList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            // Iterate through the televisionList outputting the contents of the list.
            for (Television television : televisionList) {
                System.out.println("======================================");
                System.out.println(television.getBrand());
                System.out.println(television.getModel());
                System.out.println(television.getPrice());
                System.out.println(television.getScreenSize());
            }
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println(" ");
        }
    }
}
