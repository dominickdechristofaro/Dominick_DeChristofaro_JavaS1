package com.example.motoinventoryservice.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "IsThisPasswordOK?";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);
    }
}
