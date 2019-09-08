/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Model for Game DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.model;
import java.util.Objects;

public class Game {
    // Properties
    private int game_id;
    private int console_id;
    private int publisher_id;
    private int type_id;

    // Getters & Setters
    public int getGame_id() {
        return this.game_id;
    }
    public void setGame_id(int game_idIn) {
        this.game_id = game_idIn;
    }
    public int getConsole_id() {
        return this.console_id;
    }
    public void setConsole_id(int console_idIn) {
        this.console_id = console_idIn;
    }
    public int getPublisher_id() {
        return this.publisher_id;
    }
    public void setPublisher_id(int publisher_idIn) {
        this.publisher_id = publisher_idIn;
    }
    public int getType_id() {
        return this.type_id;
    }
    public void setType_id(int type_idIn) {
        this.type_id = type_idIn;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return game_id == game.game_id &&
                console_id == game.console_id &&
                publisher_id == game.publisher_id &&
                type_id == game.type_id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(game_id, console_id, publisher_id, type_id);
    }
}
