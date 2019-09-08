/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Model for Console DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.model;
import java.util.Objects;

public class Console {
    // Properties
    private int console_id;
    private String name;
    private String year;

    // Getters & Setters
    public int getConsole_id() {
        return this.console_id;
    }
    public void setConsole_id(int console_idIn) {
        this.console_id = console_idIn;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public String getYear() {
        return this.year;
    }
    public void setYear(String yearIn) {
        this.year = yearIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return console_id == console.console_id &&
                name.equals(console.name) &&
                year.equals(console.year);
    }
    @Override
    public int hashCode() {
        return Objects.hash(console_id, name, year);
    }
}
