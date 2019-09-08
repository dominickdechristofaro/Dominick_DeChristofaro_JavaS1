package com.company.reccolljdbctemplatedao.model;

import java.util.Objects;

public class Label {
    // Properties
    private int label_id;
    private String name;
    private String website;

    // Getters & Setters
    public int getLabel_id() {
        return this.label_id;
    }
    public void setLabel_id(int label_idIn) {
        this.label_id = label_idIn;
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
        Label label = (Label) o;
        return label_id == label.label_id &&
                name.equals(label.name) &&
                Objects.equals(website, label.website);
    }
    @Override
    public int hashCode() {
        return Objects.hash(label_id, name, website);
    }
}
