package com.dechristofaro;

public class GettingIndividualDigits {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++) {
            for(int j = 0; j <= 9; j++) {
                int sum = i + j;
                System.out.println(i + "" + j + ", " + i + "+" + j + " = " + sum);
            }
        }
    }
}
