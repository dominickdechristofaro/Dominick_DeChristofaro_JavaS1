/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Try-Catch Block Examples
 *************************************************************************************************/
package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        // Try-Catch Block of code to catch exceptions
        try {
            // Run the code for the application
            System.out.println("Current saved animals file:");
            Pets.readPetsFromFile();
            int petIndex = Pets.choosePet();
            String chosenPet = Pets.retrievePet(petIndex);
            Pets.writePetToFile(chosenPet);
            System.out.println("New saved animals file:");
            Pets.readPetsFromFile();

            // If FileNotFoundException is thrown
        } catch (FileNotFoundException e) {
            System.out.println("The following file does not seem to exist: " + e.getMessage());

            // If IOException is thrown
        } catch (IOException e) {
            System.out.println("Something when wrong while writing your file.");

            // If NumberFormatException is thrown
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");

            // If ArrayIndexOutOfBoundsException is thrown
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please choose an available pet.");

            // Always run the finally block
        } finally {
            System.out.println("Have a nice day!");
        }
    }
}
