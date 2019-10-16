/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    A Helper Method to generate a hassed password in the terminal based on the
 *                  BCryptPasswordEncoder.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {
    public static void main(String[] args) {
        // A new instantation of BCryptPasswordEncoder
        PasswordEncoder enc = new BCryptPasswordEncoder();

        // The password to convert to a hashed password
        String password = "password";

        // Converting the hashed password to a string
        String encodedPassword = enc.encode(password);

        // Print the hashed password to the terminal
        System.out.println(encodedPassword);
    }
}
