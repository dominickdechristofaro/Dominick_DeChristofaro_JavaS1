package com.trilogyed.tasker.model;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {
    // Auto-Incremented by MYSQL Database
    private int id;

    @NotNull(message = "You must input a description between 1 and 255 characters long.")
    @Size(min = 1, max = 255, message = "The description must be between 1 and 255 characters long.")
    private String description;

    @NotNull(message = "You must input the present date for the creation date.")
    @FutureOrPresent(message = "The creation date must be the present date.")
    @PastOrPresent(message = "The creation date must be the present date.")
    private LocalDate createDate;

    @NotNull(message = "You must input a due date.")
    @FutureOrPresent(message = "The due date entered must be the present date or in the future.")
    private LocalDate dueDate;

    @Size(max = 50, message = "The category must not be larger than 50 characters.")
    private String category;

    // No Javax validation
    private String advertisement;

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

    public String getAdvertisement() {
        return advertisement;
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

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    // equals(), hashCode(), and toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskViewModel that = (TaskViewModel) o;
        return id == that.id &&
                description.equals(that.description) &&
                createDate.equals(that.createDate) &&
                dueDate.equals(that.dueDate) &&
                Objects.equals(category, that.category) &&
                Objects.equals(advertisement, that.advertisement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category, advertisement);
    }

    @Override
    public String toString() {
        return "TaskViewModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                ", advertisement='" + advertisement + '\'' +
                '}';
    }
}
