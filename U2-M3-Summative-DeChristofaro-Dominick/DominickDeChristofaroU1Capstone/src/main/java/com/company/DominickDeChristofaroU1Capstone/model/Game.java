/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Model for the Game object.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.model;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Game {
    // Properties

    // No Javax Validation
    private Long id;

    @NotNull(message = "You must input a title.")
    @Size(min = 1, max = 50, message = "The title must be between 1 and 50 characters.")
    private String title;

    @NotNull(message = "You must input a esrbRating")
    @Size(min = 1, max = 50, message = "The esrbRating must be between 1 and 50 characters.")
    private String esrbRating;

    @NotNull(message = "You must input a description.")
    @Size(min = 1, max = 255, message = "The description must be between 1 and 255 characters.")
    private String description;

    @NotNull(message = "You must input a positive number for price.")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    private BigDecimal price;

    @NotNull(message = "You must input a studio")
    @Size(min = 1, max = 50, message = "The studio must be between 1 and 50 characters.")
    private String studio;

    @NotNull(message = "You must input a quantity.")
    @PositiveOrZero(message = "The quantity must be zero or greater.")
    @Digits(integer = 11, fraction = 0)
    private Long quantity;

    // Getters & Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long idIn) {
        this.id = idIn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String titleIn) {
        this.title = titleIn;
    }

    public String getEsrbRating() {
        return this.esrbRating;
    }

    public void setEsrbRating(String esrbRatingIn) {
        this.esrbRating = esrbRatingIn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String descriptionIn) {
        this.description = descriptionIn;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal priceIn) {
        this.price = priceIn;
    }

    public String getStudio() {
        return this.studio;
    }

    public void setStudio(String studioIn) {
        this.studio = studioIn;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantityIn) {
        this.quantity = quantityIn;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                title.equals(game.title) &&
                esrbRating.equals(game.esrbRating) &&
                description.equals(game.description) &&
                price.equals(game.price) &&
                studio.equals(game.studio) &&
                quantity.equals(game.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrbRating, description, price, studio, quantity);
    }
}
