/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Endpoints for Video Game Store REST API.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.controller;
import com.company.DominickDeChristofaroU1Capstone.model.Console;
import com.company.DominickDeChristofaroU1Capstone.model.Game;
import com.company.DominickDeChristofaroU1Capstone.model.TShirt;
import com.company.DominickDeChristofaroU1Capstone.service.ServiceLayer;
import com.company.DominickDeChristofaroU1Capstone.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class Controller {
    // Properties
    @Autowired
    private ServiceLayer serviceLayer;

    // Constructor
    public Controller(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    /**
     * logout of the game store server
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void logout() {

    }

    /**
     * The logout has been successfully performed
     * @return A string to inform the user that the logout has been successful.
     */
    @RequestMapping(value = "/alldone", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String allDone() {
        return "You have been successfully logged out.";
    }

    /**
     * Add a Console to the database.
     * @param console The Console to add to the database.
     * @return The Console added to the database with an auto-generated id.
     */
    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console addConsole(@RequestBody @Valid Console console) {
        return serviceLayer.addConsole(console);
    }

    /**
     * Add a Game to the database.
     * @param game The Game to add to the database.
     * @return The Game added to the database with an auto-generated id.
     */
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game) {
        return serviceLayer.addGame(game);
    }

    /**
     * Add a TShirt to the database.
     * @param tShirt The TShirt to add to the database.
     * @return The TShirt added to the database with an auto-generated id.
     */
    @RequestMapping(value = "/tshirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirt addTShirt(@RequestBody @Valid TShirt tShirt) {
        return serviceLayer.addTShirt(tShirt);
    }

    /**
     * Update a Console in the database.
     * @param console The Console to be updated in the database.
     */
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateConsole(@RequestBody @Valid Console console) {
        // Get the Console from the database
        Console consoleFromDB = serviceLayer.getConsole(console.getId());

        // Update the Console if it is found in the database
        if (consoleFromDB != null) {
            serviceLayer.updateConsole(console);
        } else {
            throw new IllegalArgumentException("There is no Console with id: " + console.getId());
        }
    }

    /**
     * Update a Game in the database.
     * @param game The Game to be updated in the database.
     */
    @RequestMapping(value = "/game", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateGame(@RequestBody @Valid Game game) {
        // Get the Game from the database
        Game gameFromDB = serviceLayer.getGame(game.getId());

        // Update the Game if it is found in the database
        if (gameFromDB != null) {
            serviceLayer.updateGame(game);
        } else {
            throw new IllegalArgumentException("There is no Game with id: " + game.getId());
        }
    }

    /**
     * Update a TShirt in the database.
     * @param tShirt The TShirt to be updated in the database.
     */
    @RequestMapping(value = "/tshirt", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTShirt(@RequestBody @Valid TShirt tShirt) {
        // Get the TShirt from the database
        TShirt tShirtFromDB = serviceLayer.getTShirt(tShirt.getId());

        // Update the TShirt if it is found in the database
        if (tShirtFromDB != null) {
            serviceLayer.updateTShirt(tShirt);
        } else {
            throw new IllegalArgumentException("There is no T-Shirt with id: " + tShirt.getId());
        }
    }

    /**
     * Delete a Console in the database by id.
     * @param id The id of the Console to be deleted from the database.
     */
    @RequestMapping(value = "/console/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteConsole(@PathVariable Long id) {
        // Get the requested Console from the database
        Console console = serviceLayer.getConsole(id);

        // Delete the Console if it is found in the database
        if (console != null) {
            serviceLayer.deleteConsole(id);
        } else {
            throw new IllegalArgumentException("There is no Console with id: " + id);
        }
    }

    /**
     * Delete a Game from the database by id.
     * @param id The id of the Game to be deleted from the database.
     */
    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteGame(@PathVariable Long id) {
        // Get the requested Game from the database
        Game game = serviceLayer.getGame(id);

        // Delete the Game if it is found in the database
        if (game != null) {
            serviceLayer.deleteGame(id);
        } else {
            throw new IllegalArgumentException("There is no Game with id: " + id);
        }
    }

    /**
     * Delete a TShirt in the database by id.
     * @param id The id of the TShirt to be deleted from the database.
     */
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTShirt(@PathVariable Long id) {
        // Get the requested TShirt from the database
        TShirt tShirt = serviceLayer.getTShirt(id);

        // Delete the TShirt if it is found in the database
        if (tShirt != null) {
            serviceLayer.deleteTShirt(id);
        } else {
            throw new IllegalArgumentException("There is no T-Shirt with id: " + id);
        }
    }

    /**
     * Get a Console in the database by id.
     * @param id The id of the console to be retrieved from the database.
     * @return The Console with the id requested from the database.
     */
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable Long id) {
        // Find the Console requested in the database
        Console console = serviceLayer.getConsole(id);

        // Return the Console if it is found in the database
        if (console != null) {
            return console;
        } else {
            throw new IllegalArgumentException("There is no Console with id: " + id);
        }
    }

    /**
     * Get a Game from the database by id.
     * @param id The id of the Game to be retrieved from the database.
     * @return The Game with the id requested from the database.
     */
    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getGame(@PathVariable Long id) {
        // Find the Game requested in the database
        Game game = serviceLayer.getGame(id);

        // Return the Game if it is found in the database
        if (game != null) {
            return game;
        } else {
            throw new IllegalArgumentException("There is no Game with id: " + id);
        }
    }

    /**
     * Game a TShirt from the database by id.
     * @param id The id of the TShirt to be retrieved from the database.
     * @return The TShirt with the id requested from the database.
     */
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt getTShirt(@PathVariable Long id) {
        // Find the TShirt requested in the database
        TShirt tShirt = serviceLayer.getTShirt(id);

        // Return the TShirt if it is found in the database
        if (tShirt != null) {
            return tShirt;
        } else {
            throw new IllegalArgumentException("There is no T-Shirt with id: " + id);
        }
    }

    /**
     * A List of all Consoles in the database.
     * @return A List of all Consoles in the database.
     */
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsole() {
        return serviceLayer.getAllConsole();
    }

    /**
     * A List of all Games in the database.
     * @return A List of all Games in the database.
     */
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllGame() {
        return serviceLayer.getAllGame();
    }

    /**
     * A List of all TShirts in the database.
     * @return A List of all TShirts in the database.
     */
    @RequestMapping(value = "/tshirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTShirt() {
        return serviceLayer.getAllTShirt();
    }

    /**
     * Get a List of all Consoles in the database by a specific manufacturer.
     * @param manufacturer The manufacturer to query.
     * @return A List of all Consoles by the queried manufacturer.
     */
    @RequestMapping(value = "/console/byManufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer) {
        return serviceLayer.getConsoleByManufacturer(manufacturer);
    }

    /**
     * Get a List of all Games in the database by a specific studio.
     * @param studio The studio to query.
     * @return A List of all Games in the database by the queried studio.
     */
    @RequestMapping(value = "/game/byStudio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByStudio(@PathVariable String studio) {
        return serviceLayer.getGameByStudio(studio);
    }

    /**
     * Get a List of all Games in the database with a specific esrbRating.
     * @param esrbRating The esrbRating to query.
     * @return A List of all Games in the database by the queried esrbRating.
     */
    @RequestMapping(value = "/game/byEsrbRating/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByEsrbRating(@PathVariable String esrbRating) {
        return serviceLayer.getGameByEsrbRating(esrbRating);
    }

    /**
     * Get a List of all Games in the database with a specific title.
     * @param title The title to query.
     * @return A List of all Games in the database by a queried title.
     */
    @RequestMapping(value = "/game/byTitle/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getGameByTitle(@PathVariable String title) {
        return serviceLayer.getGameByTitle(title);
    }

    /**
     * Get a List of all TShirts in the database with a specific color.
     * @param color The color to query.
     * @return A List of all TShirts in the database by a queried color.
     */
    @RequestMapping(value = "/tshirt/byColor/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getTShirtByColor(@PathVariable String color) {
        return serviceLayer.getTShirtByColor(color);
    }

    /**
     * Get a List of all TShirts in the database with a specific size.
     * @param size The size to query.
     * @return A List of all TShirts in the database by queried size.
     */
    @RequestMapping(value = "/tshirt/bySize/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getTShirtBySize(@PathVariable String size) {
        return serviceLayer.getTShirtBySize(size);
    }

    /**
     * Place an order using the OrderViewModel.
     * @param orderViewModel The order you would like to place.
     * @return A completed OrderViewModel.
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public OrderViewModel addOrder(@RequestBody @Valid OrderViewModel orderViewModel) {
        return serviceLayer.addOrder(orderViewModel);
    }
}