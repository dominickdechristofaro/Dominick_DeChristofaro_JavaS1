package com.company.DominickDeChristofaroU1Capstone.controller;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.company.DominickDeChristofaroU1Capstone.SecurityConfig;
import com.company.DominickDeChristofaroU1Capstone.model.Console;
import com.company.DominickDeChristofaroU1Capstone.model.Game;
import com.company.DominickDeChristofaroU1Capstone.model.Invoice;
import com.company.DominickDeChristofaroU1Capstone.model.TShirt;
import com.company.DominickDeChristofaroU1Capstone.service.ServiceLayer;
import com.company.DominickDeChristofaroU1Capstone.viewmodel.OrderViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
@WithMockUser(username = "admin", roles = {"STAFF", "MANAGER", "ADMIN"})
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SecurityConfig securityConfig;

    @MockBean
    private DataSource dataSource;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void addConsoleShouldReturnCreatedConsole() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(consoleInput1());

        // Object to JSON String
        String responseJson = mapper.writeValueAsString(consoleResponse1());

        // Mock DAO Input and Response
        when(serviceLayer.addConsole(consoleInput1())).thenReturn(consoleResponse1());

        // MVC Mock
        this.mockMvc.perform(post("/console")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addGameShouldReturnCreatedGame() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(gameInput1());

        // Object to JSON String
        String responseJson = mapper.writeValueAsString(gameResponse1());

        // Mock DAO Input and Response
        when(serviceLayer.addGame(gameInput1())).thenReturn(gameResponse1());

        // MVC Mock
        this.mockMvc.perform(post("/game")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addTShirtShouldReturnCreatedTShirt() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(tShirtInput1());

        // Object to JSON String
        String responseJson = mapper.writeValueAsString(tShirtResponse1());

        // Mock DAO Input and Response
        when(serviceLayer.addTShirt(tShirtInput1())).thenReturn(tShirtResponse1());

        // MVC Mock
        this.mockMvc.perform(post("/tshirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addOrderShouldReturnCreatedConsoleOrder() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(consoleOrderInput());

        // Object to JSON String
        String responseJson = mapper.writeValueAsString(consoleOrderResponse());

        // Mock DAO Input and Response
        when(serviceLayer.addOrder(consoleOrderInput())).thenReturn(consoleOrderResponse());

        // MVC Mock
        this.mockMvc.perform(post("/order")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addOrderShouldReturnCreatedGameOrder() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(gameOrderInput());

        // Object to JSON String
        String responseJson = mapper.writeValueAsString(gameOrderResponse());

        // Mock DAO Input and Response
        when(serviceLayer.addOrder(gameOrderInput())).thenReturn(gameOrderResponse());

        // MVC Mock
        this.mockMvc.perform(post("/order")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addOrderShouldReturnCreatedTShirtOrder() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(tShirtOrderInput());

        // Object to JSON String
        String responseJson = mapper.writeValueAsString(tShirtOrderResponse());

        // Mock DAO Input and Response
        when(serviceLayer.addOrder(tShirtOrderInput())).thenReturn(tShirtOrderResponse());

        // MVC Mock
        this.mockMvc.perform(post("/order")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(responseJson));
    }

    @Test
    public void addOrderShouldReturnMethodArgumentNotValidException() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(incompleteOrder());

        this.mockMvc.perform(post("/order")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addConsoleShouldReturnMethodArgumentNotValidException() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(incompleteConsole());

        // MVC Mock
        this.mockMvc.perform(post("/console")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addGameShouldReturnMethodArgumentNotValidException() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(incompleteGame());

        // MVC Mock
        this.mockMvc.perform(post("/game")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void addTShirtShouldReturnMethodArgumentNotValidException() throws Exception {
        // Object to JSON String
        String inputJson = mapper.writeValueAsString(incompleteTShirt());

        // MVC Mock
        this.mockMvc.perform(post("/tshirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void updateConsoleShouldReturnAnUpdatedConsole() throws Exception {
        // Mocking DAO response
        Mockito.when(serviceLayer.getConsole(1L)).thenReturn(consoleResponse1());

        // Input and Output JSON will be identical
        String inputJson = mapper.writeValueAsString(consoleResponse1());

        // Mock Response
        this.mockMvc.perform(put("/console")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateGameShouldReturnAnUpdatedGame() throws Exception {
        // Mocking DAO response
        Mockito.when(serviceLayer.getGame(1L)).thenReturn(gameResponse1());

        // Input and Output JSON will be identical
        String inputJson = mapper.writeValueAsString(gameResponse1());

        // Mock Response
        this.mockMvc.perform(put("/game")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateTShirtShouldReturnAnUpdatedTShirt() throws Exception {
        // Mocking DAO response
        Mockito.when(serviceLayer.getTShirt(1L)).thenReturn(tShirtResponse1());

        // Input and Output JSON will be identical
        String inputJson = mapper.writeValueAsString(tShirtResponse1());

        // Mock Response
        this.mockMvc.perform(put("/tshirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateConsoleShouldReturnA404Error() throws Exception {
        // Write ConsoleResponse to JSON
        String inputJson = mapper.writeValueAsString(consoleResponse1());

        // Mock Response
        this.mockMvc.perform(put("/console")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void updateGameShouldReturnA404Error() throws Exception {
        // Write GameResponse to JSON
        String inputJson = mapper.writeValueAsString(gameResponse1());

        // Mock Response
        this.mockMvc.perform(put("/game")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void updateTShirtShouldReturnA404Error() throws Exception {
        // Write T-Shirt Response to JSON
        String inputJson = mapper.writeValueAsString(tShirtResponse1());

        // Mock Response
        this.mockMvc.perform(put("/tshirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void deleteConsoleIsOkNoContentReturned() throws Exception {
        // Mocking DAO response
        Mockito.when(serviceLayer.getConsole(1L)).thenReturn(consoleResponse1());

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/console/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteGameIsOkNoContentReturned() throws Exception {
        // Mocking DAO response
        Mockito.when(serviceLayer.getGame(1L)).thenReturn(gameResponse1());

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteTShirtIsOkNoContentReturned() throws Exception {
        // Mocking DAO response
        Mockito.when(serviceLayer.getTShirt(1L)).thenReturn(tShirtResponse1());

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tshirt/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteConsoleIsNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/console/1"))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void deleteGameIsNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/1"))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void deleteTShirtIsNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tshirt/1"))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void getConsoleByIdShouldReturnConsoleWithIdJson() throws Exception {
        // Re-write the object as a JSON string
        String outputJson = mapper.writeValueAsString(consoleResponse1());

        // Mocking DAO response
        Mockito.when(serviceLayer.getConsole(1L)).thenReturn(consoleResponse1());
        this.mockMvc.perform(get("/console/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByIdShouldReturnGameWithIdJson() throws Exception {
        // Re-write the object as a JSON string
        String outputJson = mapper.writeValueAsString(gameResponse1());

        // Mocking DAO response
        Mockito.when(serviceLayer.getGame(1L)).thenReturn(gameResponse1());
        this.mockMvc.perform(get("/game/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtByIdShouldReturnTShirtWithIdJson() throws Exception {
        // Re-write the object as a JSON string
        String outputJson = mapper.writeValueAsString(tShirtResponse1());

        // Mocking DAO response
        Mockito.when(serviceLayer.getTShirt(1L)).thenReturn(tShirtResponse1());
        this.mockMvc.perform(get("/tshirt/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleThatDoesNotExistReturns404() throws Exception {
        // Declare a id for a Console that does not exist
        Long idForConsoleThatDoesNotExist = 100L;

        // Mocking DAO response
        Mockito.when(serviceLayer.getConsole(idForConsoleThatDoesNotExist)).thenReturn(null);

        // Status when not found
        this.mockMvc.perform(get("/console/" + idForConsoleThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getGameThatDoesNotExistReturns404() throws Exception {
        // Declare a id for a Game that does not exist
        Long idForGameThatDoesNotExist = 100L;

        // Mocking DAO response
        Mockito.when(serviceLayer.getGame(idForGameThatDoesNotExist)).thenReturn(null);

        // Status when not found
        this.mockMvc.perform(get("/game/" + idForGameThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getTShirtThatDoesNotExistReturns404() throws Exception {
        // Declare a id for a TShirt that does not exist
        Long idForTShirtThatDoesNotExist = 100L;

        // Mocking DAO response
        Mockito.when(serviceLayer.getTShirt(idForTShirtThatDoesNotExist)).thenReturn(null);

        // Status when not found
        this.mockMvc.perform(get("/tshirt/" + idForTShirtThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAllConsoleShouldReturnAListOfConsole() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(allConsoleList());

        // Object to JSON string
        when(serviceLayer.getAllConsole()).thenReturn(allConsoleList());

        // Mock the expected value
        this.mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGameShouldReturnAListOfGame() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(allGameList());

        // Object to JSON string
        when(serviceLayer.getAllGame()).thenReturn(allGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllTShirtShouldReturnAListOfTShirt() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(allTShirtList());

        // Mock service layer response
        when(serviceLayer.getAllTShirt()).thenReturn(allTShirtList());

        // Mock the expected value
        this.mockMvc.perform(get("/tshirt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllConsoleShouldReturnBlankList() throws Exception {
        // Create a new String with no items
        String outputJson = mapper.writeValueAsString(emptyConsoleList());

        // Mock service layer response
        when(serviceLayer.getAllConsole()).thenReturn(emptyConsoleList());

        // Mock the expected value
        this.mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGameShouldReturnBlankList() throws Exception {
        // Create a new String with no items
        String outputJson = mapper.writeValueAsString(emptyGameList());

        // Mock service layer response
        when(serviceLayer.getAllGame()).thenReturn(emptyGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllTshirtShouldReturnBlankList() throws Exception {
        // Create a new String with no items
        String outputJson = mapper.writeValueAsString(emptyTShirtList());

        // Mock service layer response
        when(serviceLayer.getAllTShirt()).thenReturn(emptyTShirtList());

        // Mock the expected value
        this.mockMvc.perform(get("/tshirt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleByManufacturerShouldReturnSonyConsoleList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(sonyConsoleList());

        // Object to JSON string
        when(serviceLayer.getConsoleByManufacturer("Sony")).thenReturn(sonyConsoleList());

        // Mock the expected value
        this.mockMvc.perform(get("/console/byManufacturer/Sony"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleByManufacturerShouldReturnEmptyConsoleList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(emptyConsoleList());

        // Object to JSON string
        when(serviceLayer.getConsoleByManufacturer("Nintendo")).thenReturn(emptyConsoleList());

        // Mock the expected value
        this.mockMvc.perform(get("/console/byManufacturer/Nintendo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByStudioShouldReturnInsomniacGameList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(insomniacGameList());

        // Object to JSON string
        when(serviceLayer.getGameByStudio("Insomniac")).thenReturn(insomniacGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game/byStudio/Insomniac"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByStudioShouldReturnEmptyGameList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(emptyGameList());

        // Object to JSON string
        when(serviceLayer.getGameByStudio("CrazyGame")).thenReturn(emptyGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game/byStudio/CrazyGame"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByEsrbRatingShouldReturnEGameList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(eGameList());

        // Object to JSON string
        when(serviceLayer.getGameByEsrbRating("E")).thenReturn(eGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game/byEsrbRating/E"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByEsrbRatingShouldReturnEmptyGameList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(emptyGameList());

        // Object to JSON string
        when(serviceLayer.getGameByEsrbRating("M")).thenReturn(emptyGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game/byEsrbRating/M"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtByColorShouldReturnBlueTShirtList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(blueTShirtList());

        // Object to JSON string
        when(serviceLayer.getTShirtByColor("Blue")).thenReturn(blueTShirtList());

        // Mock the expected value
        this.mockMvc.perform(get("/tshirt/byColor/Blue"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtByColorShouldReturnEmptyTShirtList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(emptyTShirtList());

        // Object to JSON string
        when(serviceLayer.getTShirtByColor("Rainbow")).thenReturn(emptyTShirtList());

        // Mock the expected value
        this.mockMvc.perform(get("/tshirt/byColor/Rainbow"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtBySizeShouldReturnMediumTShirtList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(mediumTShirtList());

        // Object to JSON string
        when(serviceLayer.getTShirtBySize("Medium")).thenReturn(mediumTShirtList());

        // Mock the expected value
        this.mockMvc.perform(get("/tshirt/bySize/Medium"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtBySizeShouldReturnEmptyTShirtList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(emptyTShirtList());

        // Object to JSON string
        when(serviceLayer.getTShirtByColor("X-Large")).thenReturn(emptyTShirtList());

        // Mock the expected value
        this.mockMvc.perform(get("/tshirt/bySize/X-Large"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByTitleShouldReturnSpyroGameList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(spyroGameList());

        // Object to JSON string
        when(serviceLayer.getGameByTitle("Spyro")).thenReturn(spyroGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game/byTitle/Spyro"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByTitleShouldReturnEmptyGameList() throws Exception {
        // Create a new String with all items
        String outputJson = mapper.writeValueAsString(emptyGameList());

        // Object to JSON string
        when(serviceLayer.getGameByTitle("Bully")).thenReturn(emptyGameList());

        // Mock the expected value
        this.mockMvc.perform(get("/game/byTitle/Bully"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    // ConsoleDao Mock Input (consoleInput1)
    private Console consoleInput1() {
        Console consoleInput1 = new Console();
        consoleInput1.setModel("PlayStation 4");
        consoleInput1.setManufacturer("Sony");
        consoleInput1.setMemoryAmount("1Tb");
        consoleInput1.setProcessor("2.13 GHz AMD CPU");
        consoleInput1.setPrice(new BigDecimal("299.99"));
        consoleInput1.setQuantity(4L);
        return consoleInput1;
    }

    // ConsoleDao Mock Response (consoleResponse1)
    private Console consoleResponse1() {
        Console consoleResponse1 = new Console();
        consoleResponse1.setId(1L);
        consoleResponse1.setModel("PlayStation 4");
        consoleResponse1.setManufacturer("Sony");
        consoleResponse1.setMemoryAmount("1Tb");
        consoleResponse1.setProcessor("2.13 GHz AMD CPU");
        consoleResponse1.setPrice(new BigDecimal("299.99"));
        consoleResponse1.setQuantity(4L);
        return consoleResponse1;
    }

    // ConsoleDao Mock Response (consoleResponse2)
    private Console consoleResponse2() {
        Console consoleResponse2 = new Console();
        consoleResponse2.setId(2L);
        consoleResponse2.setModel("XBOX");
        consoleResponse2.setManufacturer("Microsoft");
        consoleResponse2.setMemoryAmount("2Tb");
        consoleResponse2.setProcessor("4.2 Intron");
        consoleResponse2.setPrice(new BigDecimal("399.99"));
        consoleResponse2.setQuantity(6L);
        return consoleResponse2;
    }

    // GameDao Mock Input (gameInput1)
    private Game gameInput1() {
        Game gameInput1 = new Game();
        gameInput1.setTitle("Spyro");
        gameInput1.setEsrbRating("E");
        gameInput1.setDescription("Action/Adventure");
        gameInput1.setPrice(new BigDecimal("24.99"));
        gameInput1.setStudio("Insomniac");
        gameInput1.setQuantity(4L);
        return gameInput1;
    }

    // GameDao Mock Response (gameResponse1)
    private Game gameResponse1() {
        Game gameResponse1 = new Game();
        gameResponse1.setId(1L);
        gameResponse1.setTitle("Spyro");
        gameResponse1.setEsrbRating("E");
        gameResponse1.setDescription("Action/Adventure");
        gameResponse1.setPrice(new BigDecimal("24.99"));
        gameResponse1.setStudio("Insomniac");
        gameResponse1.setQuantity(4L);
        return gameResponse1;
    }

    // GameDao Mock Response (gameResponse2)
    private Game gameResponse2() {
        Game gameResponse2 = new Game();
        gameResponse2.setId(2L);
        gameResponse2.setTitle("Ratchet & Clank");
        gameResponse2.setEsrbRating("13+");
        gameResponse2.setDescription("Action/Adventure");
        gameResponse2.setPrice(new BigDecimal("34.99"));
        gameResponse2.setStudio("Insomniac");
        gameResponse2.setQuantity(12L);
        return gameResponse2;
    }

    // TShirtDao Mock Input (tShirtInput1)
    private TShirt tShirtInput1() {
        TShirt tShirtInput1 = new TShirt();
        tShirtInput1.setSize("Medium");
        tShirtInput1.setColor("Blue");
        tShirtInput1.setDescription("100% Cotton");
        tShirtInput1.setPrice(new BigDecimal("9.99"));
        tShirtInput1.setQuantity(44L);
        return tShirtInput1;
    }

    // TShirtDao Mock Response (tShirtResponse1)
    private TShirt tShirtResponse1() {
        TShirt tShirtResponse1 = new TShirt();
        tShirtResponse1.setId(1L);
        tShirtResponse1.setSize("Medium");
        tShirtResponse1.setColor("Blue");
        tShirtResponse1.setDescription("100% Cotton");
        tShirtResponse1.setPrice(new BigDecimal("9.99"));
        tShirtResponse1.setQuantity(44L);
        return tShirtResponse1;
    }

    // TShirtDao Mock Response (tShirtResponse2)
    private TShirt tShirtResponse2() {
        TShirt tShirtResponse2 = new TShirt();
        tShirtResponse2.setId(2L);
        tShirtResponse2.setSize("Large");
        tShirtResponse2.setColor("Blue");
        tShirtResponse2.setDescription("50% Cotton, 50% Polyester");
        tShirtResponse2.setPrice(new BigDecimal("12.99"));
        tShirtResponse2.setQuantity(7L);
        return tShirtResponse2;
    }

    // Console Order Input (consoleOrderInput)
    private OrderViewModel consoleOrderInput() {
        OrderViewModel consoleOrderInput = new OrderViewModel();
        consoleOrderInput.setName("Dominick DeChristofaro");
        consoleOrderInput.setStreet("7 Rosecrest Court");
        consoleOrderInput.setCity("Asheville");
        consoleOrderInput.setState("NC");
        consoleOrderInput.setZipcode("28804");
        consoleOrderInput.setItemType("Console");
        consoleOrderInput.setItemId(1L);
        consoleOrderInput.setQuantity(4L);
        return consoleOrderInput;
    }

    // Console Order Response (consoleOrderResponse)
    private OrderViewModel consoleOrderResponse() {
        OrderViewModel consoleOrderResponse = new OrderViewModel();
        consoleOrderResponse.setId(1L);
        consoleOrderResponse.setName("Dominick DeChristofaro");
        consoleOrderResponse.setStreet("7 Rosecrest Court");
        consoleOrderResponse.setCity("Asheville");
        consoleOrderResponse.setState("North Carolina");
        consoleOrderResponse.setZipcode("28804");
        consoleOrderResponse.setItemType("Console");
        consoleOrderResponse.setItemId(1L);
        consoleOrderResponse.setUnitPrice(new BigDecimal("299.99"));
        consoleOrderResponse.setQuantity(4L);
        consoleOrderResponse.setSubtotal(new BigDecimal("1199.96"));
        consoleOrderResponse.setTax(new BigDecimal("59.9980"));
        consoleOrderResponse.setProcessingFee(new BigDecimal("14.99"));
        consoleOrderResponse.setTotal(new BigDecimal("1274.9480"));
        return consoleOrderResponse;
    }

    // OrderViewModel Input (gameOrderInput)
    private OrderViewModel gameOrderInput() {
        OrderViewModel gameOrderInput = new OrderViewModel();
        gameOrderInput.setName("Dominick DeChristofaro");
        gameOrderInput.setStreet("123 Sunny Way Drive");
        gameOrderInput.setCity("San Diego");
        gameOrderInput.setState("CA");
        gameOrderInput.setZipcode("99999");
        gameOrderInput.setItemType("Game");
        gameOrderInput.setItemId(1L);
        gameOrderInput.setQuantity(2L);
        return gameOrderInput;
    }

    // Game Order Response (gameOrderResponse)
    private OrderViewModel gameOrderResponse() {
        OrderViewModel gameOrderResponse = new OrderViewModel();
        gameOrderResponse.setId(2L);
        gameOrderResponse.setName("Dominick DeChristofaro");
        gameOrderResponse.setStreet("123 Sunny Way Drive");
        gameOrderResponse.setCity("San Diego");
        gameOrderResponse.setState("California");
        gameOrderResponse.setZipcode("99999");
        gameOrderResponse.setItemType("Game");
        gameOrderResponse.setItemId(1L);
        gameOrderResponse.setUnitPrice(new BigDecimal("24.99"));
        gameOrderResponse.setQuantity(2L);
        gameOrderResponse.setSubtotal(new BigDecimal("49.98"));
        gameOrderResponse.setTax(new BigDecimal("2.9988"));
        gameOrderResponse.setProcessingFee(new BigDecimal("1.49"));
        gameOrderResponse.setTotal(new BigDecimal("54.488"));
        return gameOrderResponse;
    }

    // OrderViewModel Input (tshirtOrderInput)
    private OrderViewModel tShirtOrderInput() {
        OrderViewModel tShirtOrderInput = new OrderViewModel();
        tShirtOrderInput.setName("Dominick DeChristofaro");
        tShirtOrderInput.setStreet("999 Peach State Lane");
        tShirtOrderInput.setCity("Atlanta");
        tShirtOrderInput.setState("GA");
        tShirtOrderInput.setZipcode("22222");
        tShirtOrderInput.setItemType("T-Shirt");
        tShirtOrderInput.setItemId(1L);
        tShirtOrderInput.setQuantity(42L);
        return tShirtOrderInput;
    }

    // TShirt Order Response (tShirtOrderResponse)
    private OrderViewModel tShirtOrderResponse() {
        OrderViewModel tShirtOrderResponse = new OrderViewModel();
        tShirtOrderResponse.setId(3L);
        tShirtOrderResponse.setName("Dominick DeChristofaro");
        tShirtOrderResponse.setStreet("999 Peach State Lane");
        tShirtOrderResponse.setCity("Atlanta");
        tShirtOrderResponse.setState("Georgia");
        tShirtOrderResponse.setZipcode("22222");
        tShirtOrderResponse.setItemType("T-Shirt");
        tShirtOrderResponse.setItemId(1L);
        tShirtOrderResponse.setUnitPrice(new BigDecimal("9.99"));
        tShirtOrderResponse.setQuantity(42L);
        tShirtOrderResponse.setSubtotal(new BigDecimal("419.58"));
        tShirtOrderResponse.setTax(new BigDecimal("29.3706"));
        tShirtOrderResponse.setProcessingFee(new BigDecimal("17.47"));
        tShirtOrderResponse.setTotal(new BigDecimal("466.4206"));
        return tShirtOrderResponse;
    }

    // Incomplete Console (incompleteConsole)
    private Console incompleteConsole() {
        Console incompleteConsole = new Console();
        incompleteConsole.setManufacturer("Nintendo");
        return incompleteConsole;
    }

    // Incomplete Game (incompleteGame)
    private Game incompleteGame() {
        Game incompleteGame = new Game();
        incompleteGame.setStudio("Insomniac");
        return incompleteGame;
    }

    // Incomplete TShirt (incompleteTShirt)
    private TShirt incompleteTShirt() {
        TShirt incompleteTShirt = new TShirt();
        incompleteTShirt.setColor("Blue");
        return incompleteTShirt;
    }

    // Incomplete Order (incompleteOrder)
    private OrderViewModel incompleteOrder() {
        OrderViewModel incompleteOrder = new OrderViewModel();
        incompleteOrder.setName("Dominick DeChristofaro");
        return incompleteOrder;
    }

    // List of Console Responses
    private List<Console> allConsoleList() {
        List<Console> allConsoleList = new ArrayList<>();
        allConsoleList.add(consoleResponse1());
        allConsoleList.add(consoleResponse2());
        return allConsoleList;
    }

    // List of Game Responses
    private List<Game> allGameList() {
        List<Game> allGameList = new ArrayList<>();
        allGameList.add(gameResponse1());
        allGameList.add(gameResponse2());
        return allGameList;
    }

    // List of TShirt Responses
    private List<TShirt> allTShirtList() {
        List<TShirt> allTShirtList = new ArrayList<>();
        allTShirtList.add(tShirtResponse1());
        allTShirtList.add(tShirtResponse2());
        return allTShirtList;
    }

    // Empty Console List
    private List<Console> emptyConsoleList() {
        List<Console> emptyConsoleList = new ArrayList<>();
        return emptyConsoleList;
    }

    // Empty Game List
    private List<Game> emptyGameList() {
        List<Game> emptyGameList = new ArrayList<>();
        return emptyGameList;
    }

    // Empty TShirt List
    private List<TShirt> emptyTShirtList() {
        List<TShirt> emptyTShirtList = new ArrayList<>();
        return emptyTShirtList;
    }

    // getConsoleByManufacturer (SonyConsoleList)
    private List<Console> sonyConsoleList() {
        List<Console> sonyConsoleList = new ArrayList<>();
        sonyConsoleList.add(consoleResponse1());
        return sonyConsoleList;
    }

    // getGameByStudio (InsomniacGameList)
    private List<Game> insomniacGameList() {
        List<Game> insomniacGameList = new ArrayList<>();
        insomniacGameList.add(gameResponse1());
        insomniacGameList.add(gameResponse2());
        return insomniacGameList;
    }

    // getGameByEsrbRating (eGameList)
    private List<Game> eGameList() {
        List<Game> eGameList = new ArrayList<>();
        eGameList.add(gameResponse1());
        return eGameList;
    }

    // getGameByTitle (spyroGameList)
    private List<Game> spyroGameList() {
        List<Game> spyroGameList = new ArrayList<>();
        spyroGameList.add(gameResponse1());
        return spyroGameList;
    }

    // getTShirtByColor (blueTShirtList)
    private List<TShirt> blueTShirtList() {
        List<TShirt> blueTShirtList = new ArrayList<>();
        blueTShirtList.add(tShirtResponse1());
        blueTShirtList.add(tShirtResponse2());
        return blueTShirtList;
    }

    // getTShirtBySize (mediumTShirtList)
    private List<TShirt> mediumTShirtList() {
        List<TShirt> mediumTShirtList = new ArrayList<>();
        mediumTShirtList.add(tShirtResponse1());
        return mediumTShirtList;
    }
}
