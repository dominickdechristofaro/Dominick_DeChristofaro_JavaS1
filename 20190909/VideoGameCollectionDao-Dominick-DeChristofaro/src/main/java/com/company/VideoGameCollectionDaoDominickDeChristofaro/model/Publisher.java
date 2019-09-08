/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Model for Publisher DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.model;
import java.util.Objects;

public class Publisher {
    // Properties
    private int publisher_id;
    private String name;
    private String website;

    // Getters & Setters
    public int getPublisher_id() {
        return this.publisher_id;
    }
    public void setPublisher_id(int publisher_idIn) {
        this.publisher_id = publisher_idIn;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public String getWebsite() {
        return this.website;
    }
    public void setWebsite(String websiteIn) {
        this.website = websiteIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisher_id == publisher.publisher_id &&
                name.equals(publisher.name) &&
                Objects.equals(website, publisher.website);
    }
    @Override
    public int hashCode() {
        return Objects.hash(publisher_id, name, website);
    }
}
