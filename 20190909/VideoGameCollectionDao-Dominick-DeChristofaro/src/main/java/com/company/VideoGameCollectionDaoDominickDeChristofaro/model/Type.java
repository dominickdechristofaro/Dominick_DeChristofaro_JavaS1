/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Model for Type DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.model;
import java.util.Objects;

public class Type {
    // Properties
    private int type_id;
    private String name;
    private String description;

    // Getters & Setters
    public int getType_id() {
        return this.type_id;
    }
    public void setType_id(int type_idIn) {
        this.type_id = type_idIn;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String descriptionIn) {
        this.description = descriptionIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return type_id == type.type_id &&
                name.equals(type.name) &&
                description.equals(type.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(type_id, name, description);
    }
}
