package com.trilogyed.tasker.model;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class Task {
    // Properties
    private int id;
    private String description;
    private LocalDate createDate;
    private LocalDate dueDate;
    private String category;

    // Constructors
    public Task() {

    }

    public Task(String description, LocalDate createDate, LocalDate dueDate, String category) {
        this.description = description;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.category = category;
    }

    public Task(int id, String description, LocalDate createDate, LocalDate dueDate, String category) {
        this.id = id;
        this.description = description;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.category = category;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getCategory() {
        return category;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // equals(), hashCode(), toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                '}';
    }
}
