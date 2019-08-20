/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Read and output the contents of a XML file.
 *************************************************************************************************/
package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {
    public static void main(String[] args) {
        try {
            // Read the phoneList from an XML file using a mapper
            ObjectMapper mapper = new XmlMapper();
            List<Phone> phoneList = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>(){});

            // Iterate through the phoneList and print out values
            for (Phone phone : phoneList) {
                System.out.println("=================================");
                System.out.println(phone.getBrand());
                System.out.println(phone.getModel());
                System.out.println(phone.getProcessor());
                System.out.println(phone.getStorage());
                System.out.println(phone.getPrice());
            }
        } catch (IOException e) {
            System.err.println("IOException caught: " + e.getMessage());
        } finally {
            System.out.println(" ");
        }
    }
}
