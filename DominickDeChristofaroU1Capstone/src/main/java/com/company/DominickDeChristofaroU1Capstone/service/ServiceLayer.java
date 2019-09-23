package com.company.DominickDeChristofaroU1Capstone.service;
import com.company.DominickDeChristofaroU1Capstone.model.Console;
import com.company.DominickDeChristofaroU1Capstone.model.Game;
import com.company.DominickDeChristofaroU1Capstone.model.TShirt;
import com.company.DominickDeChristofaroU1Capstone.viewmodel.OrderViewModel;
import java.util.List;

public interface ServiceLayer {
    // Console API Methods
    Console addConsole(Console console);
    void updateConsole(Console console);
    void deleteConsole(Long id);
    Console getConsole(Long id);
    List<Console> getAllConsole();
    List<Console> getConsoleByManufacturer(String manufacturer);

    // Game API Methods
    Game addGame(Game game);
    void updateGame(Game game);
    void deleteGame(Long id);
    Game getGame(Long id);
    List<Game> getAllGame();
    List<Game> getGameByStudio(String studio);
    List<Game> getGameByEsrbRating(String esrbRating);
    List<Game> getGameByTitle(String title);

    // TShirt API Methods
    TShirt addTShirt(TShirt tShirt);
    void updateTShirt(TShirt tShirt);
    void deleteTShirt(Long id);
    TShirt getTShirt(Long id);
    List<TShirt> getAllTShirt();
    List<TShirt> getTShirtByColor(String color);
    List<TShirt> getTShirtBySize(String size);

    // OrderViewModel API Methods
    OrderViewModel addOrder(OrderViewModel order);
}
