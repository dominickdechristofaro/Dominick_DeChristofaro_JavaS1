/**********************************************************************************************************************
 *  Name:           Dominick DeChristofaro
 *  Date:           08/08/2019
 *  Description:    Report to the terminal if userInput is, or is not, a Java Reserved Keyword.
 *********************************************************************************************************************/
package com.company;
import java.util.Scanner;

public class IsJavaKeyword {
    public static void main(String[] args) {

        // Variables
        String userInput = " ";

        // Create Scanner object for user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user for a word
        System.out.println("Please input a word.");
        userInput = scan.nextLine();

        // Switch statement for all the Java reserved Keywords
        switch(userInput) {
            case "abstract":
            case "assert":
            case "boolean":
            case "break":
            case "byte":
            case "case":
            case "catch":
            case "char":
            case "class":
            case "const":
            case "continue":
            case "default":
            case "do":
            case "double":
            case "else":
            case "enum":
            case "extends":
            case "final":
            case "finally":
            case "float":
            case "for":
            case "goto":
            case "if":
            case "implements":
            case "import":
            case "instanceof":
            case "int":
            case "interface":
            case "long":
            case "native":
            case "new":
            case "package":
            case "private":
            case "protected":
            case "public":
            case "return":
            case "short":
            case "static":
            case "strictfp":
            case "super":
            case "switch":
            case "syncronized":
            case "this":
            case "throw":
            case "throws":
            case "transient":
            case "try":
            case "void":
            case "volatile":
            case "while":
                // If the userInput is a java reserved keyword
                System.out.println("is a java keyword");
                break;
                // If the userInput is not a java reserved keyword
            default:
                System.out.println("is not a java keyword");
        }
    }
}
