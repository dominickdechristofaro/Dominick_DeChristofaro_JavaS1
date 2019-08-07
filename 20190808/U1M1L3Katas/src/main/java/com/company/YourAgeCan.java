/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Given a users age, output what the user can do
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class YourAgeCan {
    public static void main(String[] args) {

        // Variables
        int age = 0;

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for their age
        System.out.println("Please enter your age.");
        age = Integer.parseInt(scan.nextLine());

        // If the user is 18 or older they can vote.
        if (age >= 18) {
            System.out.println("Congratulations! You can vote.");
        }
        // If the user is 21 or older they can drink alcohol.
        if (age >= 21) {
            System.out.println("WooHoo! You can drink alcohol.");
        }
        // If the user is 35 or older they can run for president.
        if (age >= 35) {
            System.out.println("Wow! You can run for President.");
        }
        // If the user is 55 or older they are eligible for aarp.
        if (age >= 55) {
            System.out.println("Dentures Abound! You're eligible for aarp.");
        }
        // If the user is 65 or older they can retire.
        if (age >= 65) {
            System.out.println("Raking in dat money! You can retire.");
        }
        // If the user is between 80 and 89, they are an octogenarian.
        if (age >= 80 && age <= 89) {
            System.out.println("Oldie! You are an octogenarian.");
        }
        // If the user is over 100 they are a century old.
        if (age >= 100) {
            System.out.println("100+ years old! you are a century old.");
        }
    }
}
