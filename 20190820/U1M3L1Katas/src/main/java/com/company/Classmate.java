/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Classmate template for use in ClassmatesList.
 *************************************************************************************************/
package com.company;

public class Classmate {
    // Variables
    private String name;
    private String hairColor;

    // Constructors
    public Classmate() {

    }
    public Classmate(String name, String hairColor) {
        this.name = name;
        this.hairColor = hairColor;
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public String getHairColor() {
        return this.hairColor;
    }

    // Setters
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public void setHairColor(String hairColorIn) {
        this.hairColor = hairColorIn;
    }
}
