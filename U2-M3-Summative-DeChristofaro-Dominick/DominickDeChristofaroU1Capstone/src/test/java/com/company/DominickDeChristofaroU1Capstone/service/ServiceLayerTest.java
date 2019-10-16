package com.company.DominickDeChristofaroU1Capstone.service;
import com.company.DominickDeChristofaroU1Capstone.dao.*;
import com.company.DominickDeChristofaroU1Capstone.model.*;
import com.company.DominickDeChristofaroU1Capstone.viewmodel.OrderViewModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.times;

public class ServiceLayerTest {
    // Properties (Service)
    private ServiceLayerImpl serviceLayer;

    // Argument Captors
    private ArgumentCaptor<Console> consoleArgumentCaptor = ArgumentCaptor.forClass(Console.class);
    private ArgumentCaptor<Game> gameArgumentCaptor = ArgumentCaptor.forClass(Game.class);
    private ArgumentCaptor<TShirt> tShirtArgumentCaptor = ArgumentCaptor.forClass(TShirt.class);
    private ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);

    // Properties (DAO)
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;
    private TShirtDao tShirtDao;

    // SetUp()
    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpTShirtDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();
        serviceLayer = new ServiceLayerImpl(consoleDao, gameDao, invoiceDao, processingFeeDao, salesTaxRateDao, tShirtDao);
    }

    // Console API Tests
    @Test
    public void addConsole() {
        // Add a Console to the database
        Console console = serviceLayer.addConsole(consoleInput1());

        // Copy the Console object added to the database
        Console consoleCopy = serviceLayer.getConsole(console.getId());

        // Test the addConsole() method
        Mockito.verify(consoleDao, times(1)).getConsole(console.getId());
        TestCase.assertEquals(consoleCopy, console);
    }

    @Test
    public void updateConsole() {
        // Add a conosole to the database
        Console console = serviceLayer.addConsole(consoleInput1());

        // Update the console in the database
        serviceLayer.updateConsole(consoleResponse1());

        // Test the updateConsole() method
        Mockito.verify(consoleDao, times(1)).updateConsole(consoleArgumentCaptor.getValue());
        TestCase.assertEquals(console, consoleArgumentCaptor.getValue());
    }

    @Test
    public void deleteConsole() {
        // Add a conosole to the database
        Console console = serviceLayer.addConsole(consoleInput1());

        // Delete the console from the database
        serviceLayer.deleteConsole(console.getId());

        // Test the deleteConsole() method
        Mockito.verify(consoleDao, times(1)).deleteConsole(longArgumentCaptor.getValue());
        TestCase.assertEquals(console.getId(), longArgumentCaptor.getValue());
    }

    // Console API Getter Method Tests
    @Test
    public void getConsole() {
        // Add a Console to the database
        Console console = serviceLayer.addConsole(consoleInput1());

        // Copy the Console object added to the database
        Console consoleCopy = serviceLayer.getConsole(console.getId());

        // Test the getConsole() method
        Mockito.verify(consoleDao, times(1)).getConsole(console.getId());
        TestCase.assertEquals(consoleCopy, console);
    }

    @Test
    public void getAllConsole() {
        // Get a List of all Consoles in the database
        List<Console> allConsoleList = serviceLayer.getAllConsole();

        // Test the getAllConsole() API method
        TestCase.assertEquals(3, allConsoleList.size());
    }

    @Test
    public void getConsoleByManufacturer() {
        // Get a List of all Consoles in the database with "Sony" as the manufacturer
        List<Console> sonyConsoleList = serviceLayer.getConsoleByManufacturer("Sony");

        // Test the getAllConsole() API method
        TestCase.assertEquals(2, sonyConsoleList.size());
        TestCase.assertEquals(consoleResponse1(), sonyConsoleList.get(0));
        TestCase.assertEquals(consoleResponse3(), sonyConsoleList.get(1));
    }

    // Game API Tests
    @Test
    public void addGame() {
        // Add a Game to the database
        Game game = serviceLayer.addGame(gameInput1());

        // Copy the Game object added to the database
        Game gameCopy = serviceLayer.getGame(game.getId());

        // Test the addGame() method
        Mockito.verify(gameDao, times(1)).getGame(game.getId());
        TestCase.assertEquals(gameCopy, game);
    }

    @Test
    public void updateGame() {
        // Add a Game to the database
        Game game = serviceLayer.addGame(gameInput1());

        // Update the game in the database
        serviceLayer.updateGame(gameResponse1());

        // Test the updateGame() method
        Mockito.verify(gameDao, times(1)).updateGame(gameArgumentCaptor.getValue());
        TestCase.assertEquals(game, gameArgumentCaptor.getValue());
    }

    @Test
    public void deleteGame() {
        // Add a Game to the database
        Game game = serviceLayer.addGame(gameInput1());

        // Delete the game from the database
        serviceLayer.deleteGame(game.getId());

        // Test the deleteGame() method
        Mockito.verify(gameDao, times(1)).deleteGame(longArgumentCaptor.getValue());
        TestCase.assertEquals(game.getId(), longArgumentCaptor.getValue());
    }

    // GameApi Getter Method Tests
    @Test
    public void getGame() {
        // Add a Game to the database
        Game game = serviceLayer.addGame(gameInput1());

        // Copy the Game object added to the database
        Game gameCopy = serviceLayer.getGame(game.getId());

        // Test the getGame() method
        Mockito.verify(gameDao, times(1)).getGame(game.getId());
        TestCase.assertEquals(gameCopy, game);
    }

    @Test
    public void getAllGame() {
        // Get a List of all Games in the database
        List<Game> allGameList = serviceLayer.getAllGame();

        // Test the getAllGame() API method
        TestCase.assertEquals(3, allGameList.size());
    }

    @Test
    public void getGameByStudio() {
        // Get a List of all Game's in the database with "Insomniac" as the studio
        List<Game> insomniacGameList = serviceLayer.getGameByStudio("Insomniac");

        // Test the getGameByStudio() API method
        TestCase.assertEquals(2, insomniacGameList.size());
        TestCase.assertEquals(gameResponse1(), insomniacGameList.get(0));
        TestCase.assertEquals(gameResponse2(), insomniacGameList.get(1));
    }

    @Test
    public void getGameByEsrbRating() {
        // Get a List of all Game's in the database with "E" as the ESRB rating
        List<Game> eGameList = serviceLayer.getGameByEsrbRating("E");

        // Test the getGameByEsrbRating() API method
        TestCase.assertEquals(2, eGameList.size());
        TestCase.assertEquals(gameResponse1(), eGameList.get(0));
        TestCase.assertEquals(gameResponse3(), eGameList.get(1));
    }

    @Test
    public void getGameByTitle() {
        // Get a List of all Game's in the database with "Spyro" as the title
        List<Game> spyroGameList = serviceLayer.getGameByTitle("Spyro");

        // Test the getGameByStudio() API method
        TestCase.assertEquals(1, spyroGameList.size());
        TestCase.assertEquals(gameResponse1(), spyroGameList.get(0));
    }

    // T-Shirt API Tests
    @Test
    public void addTShirt() {
        // Add a TShirt to the database
        TShirt tShirt = serviceLayer.addTShirt(tShirtInput1());

        // Copy the TShirt object added to the database
        TShirt tShirtCopy = serviceLayer.getTShirt(tShirt.getId());

        // Test the addTShirt() method
        Mockito.verify(tShirtDao, Mockito.times(1)).getTShirt(tShirt.getId());
        TestCase.assertEquals(tShirtCopy, tShirt);
    }

    @Test
    public void updateTShirt() {
        // Add a TShirt to the database
        TShirt tShirt = serviceLayer.addTShirt(tShirtInput1());

        // Update the TShirt in the database
        serviceLayer.updateTShirt(tShirtResponse1());

        // Test the updateTShirt() method
        Mockito.verify(tShirtDao, Mockito.times(1)).updateTShirt(tShirtArgumentCaptor.getValue());
        TestCase.assertEquals(tShirt, tShirtArgumentCaptor.getValue());
    }

    @Test
    public void deleteTShirt() {
        // Add a TShirt to the database
        TShirt tShirt = serviceLayer.addTShirt(tShirtInput1());

        // Delete the TShirt from the database
        serviceLayer.deleteTShirt(tShirt.getId());

        // Test the deleteTShirt() method
        Mockito.verify(tShirtDao, Mockito.times(1)).deleteTShirt(longArgumentCaptor.getValue());
        TestCase.assertEquals(tShirt.getId(), longArgumentCaptor.getValue());
    }

    // TShirtApi Getter Method Tests
    @Test
    public void getTShirt() {
        // Add a TShirt to the database
        TShirt tShirt = serviceLayer.addTShirt(tShirtInput1());

        // Copy the TShirt object added to the database
        TShirt tShirtCopy = serviceLayer.getTShirt(tShirt.getId());

        // Test the addTShirt() method
        Mockito.verify(tShirtDao, Mockito.times(1)).getTShirt(tShirt.getId());
        TestCase.assertEquals(tShirtCopy, tShirt);
    }

    @Test
    public void getAllTShirt() {
        // Get a List of all TShirt's in the database
        List<TShirt> allTShirtList = serviceLayer.getAllTShirt();

        // Test the getAllTShirt() API method
        TestCase.assertEquals(3, allTShirtList.size());
        TestCase.assertEquals(tShirtResponse1(), allTShirtList.get(0));
        TestCase.assertEquals(tShirtResponse2(), allTShirtList.get(1));
        TestCase.assertEquals(tShirtResponse3(), allTShirtList.get(2));
    }

    @Test
    public void getTShirtByColor() {
        // Get a List of all TShirt's in the database with "Blue" as the color
        List<TShirt> blueTShirtList = serviceLayer.getTShirtByColor("Blue");

        // Test the getTShirtByColor() API method
        TestCase.assertEquals(2, blueTShirtList.size());
        TestCase.assertEquals(tShirtResponse1(), blueTShirtList.get(0));
        TestCase.assertEquals(tShirtResponse2(), blueTShirtList.get(1));
    }

    @Test
    public void getTShirtBySize() {
        // Get a List of all TShirt's in the database with "Medium" as the size
        List<TShirt> mediumTShirtList = serviceLayer.getTShirtBySize("Medium");

        // Test the getTShirtBySize() API method
        TestCase.assertEquals(2, mediumTShirtList.size());
        TestCase.assertEquals(tShirtResponse1(), mediumTShirtList.get(0));
        TestCase.assertEquals(tShirtResponse3(), mediumTShirtList.get(1));
    }

    //OrderViewModel API Tests
    @Test
    public void consoleOrder() {
        // Add a console to the database
        Console console = serviceLayer.addConsole(consoleInput1());

        // Place a console order
        OrderViewModel consoleOrder = serviceLayer.addOrder(consoleOrderInput());

        // Get a copy of the console order
        OrderViewModel consoleOrderCopy = serviceLayer.buildOrderViewModel(consoleInvoiceResponse());

        // Test the consoleOrder
        TestCase.assertEquals(consoleOrderCopy, consoleOrder);
    }

    @Test
    public void gameOrder() {
        // Add a game to the database
        Game game = serviceLayer.addGame(gameInput1());

        // Place a game Order
        OrderViewModel gameOrder = serviceLayer.addOrder(gameOrderInput());

        // Get a copy of the game order
        OrderViewModel gameOrderCopy = serviceLayer.buildOrderViewModel(gameInvoiceResponse());

        // Test the gameOrder
        TestCase.assertEquals(gameOrderCopy, gameOrder);
    }

    @Test
    public void tShirtOrder() {
        // Add a TShirt to the database
        TShirt tShirt = serviceLayer.addTShirt(tShirtInput1());

        // Place a TShirt Order
        OrderViewModel tShirtOrder = serviceLayer.addOrder(tShirtOrderInput());

        // Get a copy of the TShirt order
        OrderViewModel tShirtOrderCopy = serviceLayer.buildOrderViewModel(tShirtInvoiceResponse());

        // Test the tShirt Order
        TestCase.assertEquals(tShirtOrderCopy, tShirtOrder);
    }


    // Console DAO Mock Input/Response
    private void setUpConsoleDaoMock() {
        // Set up the Console DAO Mock
        consoleDao = Mockito.mock(ConsoleDaoJdbcTemplateImpl.class);

        // Mocking addConsole() DAO method
        Mockito.doReturn(consoleResponse1()).when(consoleDao).addConsole(consoleInput1());
        Mockito.doReturn(consoleResponse2()).when(consoleDao).addConsole(consoleInput2());
        Mockito.doReturn(consoleResponse3()).when(consoleDao).addConsole(consoleInput3());

        // Mocking updateConsole() DAO method
        Mockito.doNothing().when(consoleDao).updateConsole(consoleArgumentCaptor.capture());

        // Mocking deleteConsole() DAO method
        Mockito.doNothing().when(consoleDao).deleteConsole(longArgumentCaptor.capture());

        // Mocking getConsole() DAO method
        Mockito.doReturn(consoleResponse1()).when(consoleDao).getConsole(consoleResponse1().getId());
        Mockito.doReturn(consoleResponse2()).when(consoleDao).getConsole(consoleResponse2().getId());
        Mockito.doReturn(consoleResponse3()).when(consoleDao).getConsole(consoleResponse3().getId());

        // Mocking getAllConsole() DAO method
        Mockito.doReturn(allConsoleList()).when(consoleDao).getAllConsole();

        // Mocking getConsoleByManufacturer() DAO method
        Mockito.doReturn(sonyConsoleList()).when(consoleDao).getConsoleByManufacturer(consoleResponse3().getManufacturer());
    }

    // GameDao Mock Input/Responses
    private void setUpGameDaoMock() {
        // Set up the GameDao Mock
        gameDao = Mockito.mock(GameDaoJdbcTemplateImpl.class);

        // Mocking addGame() DAO method
        Mockito.doReturn(gameResponse1()).when(gameDao).addGame(gameInput1());
        Mockito.doReturn(gameResponse2()).when(gameDao).addGame(gameInput2());
        Mockito.doReturn(gameResponse3()).when(gameDao).addGame(gameInput3());

        // Mocking updateGame() DAO method
        Mockito.doNothing().when(gameDao).updateGame(gameArgumentCaptor.capture());

        // Mocking deleteGame() DAO method
        Mockito.doNothing().when(gameDao).deleteGame(longArgumentCaptor.capture());

        // Mocking getGame() DAO method
        Mockito.doReturn(gameResponse1()).when(gameDao).getGame(gameResponse1().getId());
        Mockito.doReturn(gameResponse2()).when(gameDao).getGame(gameResponse2().getId());
        Mockito.doReturn(gameResponse3()).when(gameDao).getGame(gameResponse3().getId());

        // Mocking getAllGame() DAO method
        Mockito.doReturn(allGameList()).when(gameDao).getAllGame();

        // Mocking getGameByStudio() DAO method
        Mockito.doReturn(insomniacGameList()).when(gameDao).getGameByStudio(gameResponse1().getStudio());

        // Mocking getGameByEsrbRating() DAO method
        Mockito.doReturn(eGameList()).when(gameDao).getGameByEsrbRating(gameResponse1().getEsrbRating());

        // Mocking getGameByTitle() DAO method
        Mockito.doReturn(spyroGameList()).when(gameDao).getGameByTitle(gameResponse1().getTitle());
    }

    // TShirtDao Mock Input/Responses
    private void setUpTShirtDaoMock() {
        // Set up the TShirtDao Mock
        tShirtDao = Mockito.mock(TShirtDaoJdbcTemplateImpl.class);

        // Mocking addTShirt() DAO method
        Mockito.doReturn(tShirtResponse1()).when(tShirtDao).addTShirt(tShirtInput1());
        Mockito.doReturn(tShirtResponse2()).when(tShirtDao).addTShirt(tShirtInput2());
        Mockito.doReturn(tShirtResponse3()).when(tShirtDao).addTShirt(tShirtInput3());

        // Mocking updateTShirt() DAO method
        Mockito.doNothing().when(tShirtDao).updateTShirt(tShirtArgumentCaptor.capture());

        // Mocking deleteTShirt() DAO method
        Mockito.doNothing().when(tShirtDao).deleteTShirt(longArgumentCaptor.capture());

        // Mocking getTShirt() DAO method
        Mockito.doReturn(tShirtResponse1()).when(tShirtDao).getTShirt(tShirtResponse1().getId());
        Mockito.doReturn(tShirtResponse2()).when(tShirtDao).getTShirt(tShirtResponse2().getId());
        Mockito.doReturn(tShirtResponse3()).when(tShirtDao).getTShirt(tShirtResponse3().getId());

        // Mocking getAllTShirt() DAO method
        Mockito.doReturn(allTShirtList()).when(tShirtDao).getAllTShirt();

        // Mocking getTShirtByColor() DAO method
        Mockito.doReturn(blueTShirtList()).when(tShirtDao).getTShirtByColor(tShirtResponse1().getColor());

        // Mocking getTShirtBySize() DAO method
        Mockito.doReturn(mediumTShirtList()).when(tShirtDao).getTShirtBySize(tShirtResponse1().getSize());
    }

    // InvoiceDao Mock Input Responses
    private void setUpInvoiceDaoMock() {
        // Set up the InvoiceDao Mock
        invoiceDao = Mockito.mock(InvoiceDaoJdbcTemplateImpl.class);

        // Mocking addInvoice() DAO method
        Mockito.doReturn(consoleInvoiceResponse()).when(invoiceDao).addInvoice(consoleInvoiceInput());
        Mockito.doReturn(gameInvoiceResponse()).when(invoiceDao).addInvoice(gameInvoiceInput());
        Mockito.doReturn(tShirtInvoiceResponse()).when(invoiceDao).addInvoice(tShirtInvoiceInput());

        // Mocking getInvoice() DAO method
        Mockito.doReturn(consoleInvoiceResponse()).when(invoiceDao).getInvoice(consoleInvoiceResponse().getId());
        Mockito.doReturn(gameInvoiceResponse()).when(invoiceDao).getInvoice(gameInvoiceResponse().getId());
        Mockito.doReturn(tShirtInvoiceResponse()).when(invoiceDao).getInvoice(tShirtInvoiceResponse().getId());
    }

    // SalesTaxRateDao Mock Input Responses
    private void setUpSalesTaxRateDaoMock() {
        // Set up the SalesTaxRateDao Mock
        salesTaxRateDao = Mockito.mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        // Mocking getSalesTaxRateByState() method
        Mockito.doReturn(nCSalesTaxRateResponse()).when(salesTaxRateDao).getSalesTaxRateByState(nCSalesTaxRateInput().getState());
        Mockito.doReturn(cASalesTaxRateResponse()).when(salesTaxRateDao).getSalesTaxRateByState(gASalesTaxRateInput().getState());
        Mockito.doReturn(gASalesTaxRateResponse()).when(salesTaxRateDao).getSalesTaxRateByState(cASalesTaxRateInput().getState());

        // Mocking getAllSalesTaxRate()
        Mockito.doReturn(allSalesTaxRateList()).when(salesTaxRateDao).getAllSalesTaxRate();
    }

    // ProcessingFeeDao Mock Input/Responses
    private void setUpProcessingFeeDaoMock() {
        // Set up the ProcessingFeeDao Mock
        processingFeeDao = Mockito.mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        // Mocking getProcessingFeeByProductType() method
        Mockito.doReturn(consoleProcessingFeeResponse()).when(processingFeeDao).getProcessingFeeByProductType(consoleProcessingFeeInput().getProductType());
        Mockito.doReturn(gameProcessingFeeResponse()).when(processingFeeDao).getProcessingFeeByProductType(gameProcessingFeeInput().getProductType());
        Mockito.doReturn(tShirtProcessingFeeResponse()).when(processingFeeDao).getProcessingFeeByProductType(tShirtProcessingFeeInput().getProductType());

        // Mocking getAllProcessingFee() method
        Mockito.doReturn(allProcessingFeeList()).when(processingFeeDao).getAllProcessingFee();
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

    // ConsoleDao Mock Input (consoleInput2)
    private Console consoleInput2() {
        Console consoleInput2 = new Console();
        consoleInput2.setModel("Switch");
        consoleInput2.setManufacturer("Nintendo");
        consoleInput2.setMemoryAmount("128Gb");
        consoleInput2.setProcessor("Quad-core Cortex-A57 1.02 GHz");
        consoleInput2.setPrice(new BigDecimal("299.00"));
        consoleInput2.setQuantity(23L);
        return consoleInput2;
    }

    // ConsoleDao Mock Input (consoleInput3)
    private Console consoleInput3() {
        Console consoleInput3 = new Console();
        consoleInput3.setModel("PlayStation Portable");
        consoleInput3.setManufacturer("Sony");
        consoleInput3.setMemoryAmount("4Gb");
        consoleInput3.setProcessor("333 MHz MIPS32 R4000");
        consoleInput3.setPrice(new BigDecimal("159.00"));
        consoleInput3.setQuantity(2L);
        return consoleInput3;
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
        consoleResponse2.setModel("Switch");
        consoleResponse2.setManufacturer("Nintendo");
        consoleResponse2.setMemoryAmount("128Gb");
        consoleResponse2.setProcessor("Quad-core Cortex-A57 1.02 GHz");
        consoleResponse2.setPrice(new BigDecimal("299.00"));
        consoleResponse2.setQuantity(23L);
        return consoleResponse2;
    }

    // ConsoleDao Mock Response (consoleResponse3)
    private Console consoleResponse3() {
        Console consoleResponse3 = new Console();
        consoleResponse3.setId(3L);
        consoleResponse3.setModel("PlayStation Portable");
        consoleResponse3.setManufacturer("Sony");
        consoleResponse3.setMemoryAmount("4Gb");
        consoleResponse3.setProcessor("333 MHz MIPS32 R4000");
        consoleResponse3.setPrice(new BigDecimal("159.00"));
        consoleResponse3.setQuantity(2L);
        return consoleResponse3;
    }

    // List of all Console's (allConsoleList)
    private List<Console> allConsoleList() {
        List<Console> allConsoleList = new ArrayList<>();
        allConsoleList.add(consoleResponse1());
        allConsoleList.add(consoleResponse2());
        allConsoleList.add(consoleResponse3());
        return allConsoleList;
    }

    // List of all Console's that is manufactured by Sony
    private List<Console> sonyConsoleList() {
        List<Console> sonyConsoleList = new ArrayList<>();
        sonyConsoleList.add(consoleResponse1());
        sonyConsoleList.add(consoleResponse3());
        return sonyConsoleList;
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

    // GameDao Mock Input (gameInput2)
    private Game gameInput2() {
        Game gameInput2 = new Game();
        gameInput2.setTitle("Ratchet & Clank");
        gameInput2.setEsrbRating("13+");
        gameInput2.setDescription("Action/Adventure");
        gameInput2.setPrice(new BigDecimal("34.99"));
        gameInput2.setStudio("Insomniac");
        gameInput2.setQuantity(12L);
        return gameInput2;
    }

    // GameDao Mock Input (gameInput3)
    private Game gameInput3() {
        Game gameInput3 = new Game();
        gameInput3.setTitle("Dance Dance Revolution");
        gameInput3.setEsrbRating("E");
        gameInput3.setDescription("Music");
        gameInput3.setPrice(new BigDecimal("14.99"));
        gameInput3.setStudio("KONAMI");
        gameInput3.setQuantity(2L);
        return gameInput3;
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

    // GameDao Mock Response (gameResponse3)
    private Game gameResponse3() {
        Game gameResponse3 = new Game();
        gameResponse3.setId(3L);
        gameResponse3.setTitle("Dance Dance Revolution");
        gameResponse3.setEsrbRating("E");
        gameResponse3.setDescription("Music");
        gameResponse3.setPrice(new BigDecimal("14.99"));
        gameResponse3.setStudio("KONAMI");
        gameResponse3.setQuantity(2L);
        return gameResponse3;
    }

    // List of all Game's
    private List<Game> allGameList() {
        List<Game> allGameList = new ArrayList<>();
        allGameList.add(gameResponse1());
        allGameList.add(gameResponse2());
        allGameList.add(gameResponse3());
        return allGameList;
    }

    // List of all Game's with the Studio "Insomniac"
    private List<Game> insomniacGameList() {
        List<Game> insomniacGameList = new ArrayList<>();
        insomniacGameList.add(gameResponse1());
        insomniacGameList.add(gameResponse2());
        return insomniacGameList;
    }

    // List of all Game's with the ESRB Rating of "E"
    private List<Game> eGameList() {
        List<Game> eGameList = new ArrayList<>();
        eGameList.add(gameResponse1());
        eGameList.add(gameResponse3());
        return eGameList;
    }

    // List of all Game's with the Title "Spyro"
    private List<Game> spyroGameList() {
        List<Game> spyroGameList = new ArrayList<>();
        spyroGameList.add(gameResponse1());
        return spyroGameList;
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

    // TShirtDao Mock Input (tShirtInput2)
    private TShirt tShirtInput2() {
        TShirt tShirtInput2 = new TShirt();
        tShirtInput2.setSize("Large");
        tShirtInput2.setColor("Blue");
        tShirtInput2.setDescription("50% Cotton, 50% Polyester");
        tShirtInput2.setPrice(new BigDecimal("12.99"));
        tShirtInput2.setQuantity(7L);
        return tShirtInput2;
    }

    // TShirtDao Mock Input (tShirtInput3)
    private TShirt tShirtInput3() {
        TShirt tShirtInput3 = new TShirt();
        tShirtInput3.setSize("Medium");
        tShirtInput3.setColor("Red");
        tShirtInput3.setDescription("25% Cotton, 75% Polyester");
        tShirtInput3.setPrice(new BigDecimal("14.99"));
        tShirtInput3.setQuantity(12L);
        return tShirtInput3;
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

    // TShirtDao Mock Response (tShirtResponse3)
    private TShirt tShirtResponse3() {
        TShirt tShirtResponse3 = new TShirt();
        tShirtResponse3.setId(3L);
        tShirtResponse3.setSize("Medium");
        tShirtResponse3.setColor("Red");
        tShirtResponse3.setDescription("25% Cotton, 75% Polyester");
        tShirtResponse3.setPrice(new BigDecimal("14.99"));
        tShirtResponse3.setQuantity(12L);
        return tShirtResponse3;
    }

    // List of all TShirt's
    private List<TShirt> allTShirtList() {
        List<TShirt> allTShirtList = new ArrayList<>();
        allTShirtList.add(tShirtResponse1());
        allTShirtList.add(tShirtResponse2());
        allTShirtList.add(tShirtResponse3());
        return allTShirtList;
    }

    // List of all TShirt's with "Blue" as the color
    private List<TShirt> blueTShirtList() {
        List<TShirt> blueTShirtList = new ArrayList<>();
        blueTShirtList.add(tShirtResponse1());
        blueTShirtList.add(tShirtResponse2());
        return blueTShirtList;
    }

    // List of all TShirt's with "Medium" as the size
    private List<TShirt> mediumTShirtList() {
        List<TShirt> mediumTShirtList = new ArrayList<>();
        mediumTShirtList.add(tShirtResponse1());
        mediumTShirtList.add(tShirtResponse3());
        return mediumTShirtList;
    }

    // Invoice Mock Input (consoleInvoiceInput)
    private Invoice consoleInvoiceInput() {
        Invoice consoleInvoiceInput = new Invoice();
        consoleInvoiceInput.setName("Dominick DeChristofaro");
        consoleInvoiceInput.setStreet("7 Rosecrest Court");
        consoleInvoiceInput.setCity("Asheville");
        consoleInvoiceInput.setState("North Carolina");
        consoleInvoiceInput.setZipcode("28804");
        consoleInvoiceInput.setItemType("Console");
        consoleInvoiceInput.setItemId(1L);
        consoleInvoiceInput.setUnitPrice(new BigDecimal("299.99"));
        consoleInvoiceInput.setQuantity(4L);
        consoleInvoiceInput.setSubtotal(new BigDecimal("1199.96"));
        consoleInvoiceInput.setTax(new BigDecimal("59.9980"));
        consoleInvoiceInput.setProcessingFee(new BigDecimal("14.99"));
        consoleInvoiceInput.setTotal(new BigDecimal("1274.9480"));
        return consoleInvoiceInput;
    }

    // Invoice Mock Response (consoleInvoiceResponse)
    private Invoice consoleInvoiceResponse() {
        Invoice consoleInvoiceResponse = new Invoice();
        consoleInvoiceResponse.setId(1L);
        consoleInvoiceResponse.setName("Dominick DeChristofaro");
        consoleInvoiceResponse.setStreet("7 Rosecrest Court");
        consoleInvoiceResponse.setCity("Asheville");
        consoleInvoiceResponse.setState("North Carolina");
        consoleInvoiceResponse.setZipcode("28804");
        consoleInvoiceResponse.setItemType("Console");
        consoleInvoiceResponse.setItemId(1L);
        consoleInvoiceResponse.setUnitPrice(new BigDecimal("299.99"));
        consoleInvoiceResponse.setQuantity(4L);
        consoleInvoiceResponse.setSubtotal(new BigDecimal("1199.96"));
        consoleInvoiceResponse.setTax(new BigDecimal("59.9980"));
        consoleInvoiceResponse.setProcessingFee(new BigDecimal("14.99"));
        consoleInvoiceResponse.setTotal(new BigDecimal("1274.9480"));
        return consoleInvoiceResponse;
    }
    
    // Invoice Mock Input (gameInvoiceInput)
    private Invoice gameInvoiceInput() {
        Invoice gameInvoiceInput = new Invoice();
        gameInvoiceInput.setName("Dominick DeChristofaro");
        gameInvoiceInput.setStreet("123 Sunny Way Drive");
        gameInvoiceInput.setCity("San Diego");
        gameInvoiceInput.setState("California");
        gameInvoiceInput.setZipcode("99999");
        gameInvoiceInput.setItemType("Game");
        gameInvoiceInput.setItemId(1L);
        gameInvoiceInput.setUnitPrice(new BigDecimal("24.99"));
        gameInvoiceInput.setQuantity(2L);
        gameInvoiceInput.setSubtotal(new BigDecimal("49.98"));
        gameInvoiceInput.setTax(new BigDecimal("2.9988"));
        gameInvoiceInput.setProcessingFee(new BigDecimal("1.49"));
        gameInvoiceInput.setTotal(new BigDecimal("54.4688"));
        return gameInvoiceInput;
    }
    
    // Invoice Mock Response (gameInvoiceResponse)
    private Invoice gameInvoiceResponse() {
        Invoice gameInvoiceResponse = new Invoice();
        gameInvoiceResponse.setId(2L);
        gameInvoiceResponse.setName("Dominick DeChristofaro");
        gameInvoiceResponse.setStreet("123 Sunny Way Drive");
        gameInvoiceResponse.setCity("San Diego");
        gameInvoiceResponse.setState("California");
        gameInvoiceResponse.setZipcode("99999");
        gameInvoiceResponse.setItemType("Game");
        gameInvoiceResponse.setItemId(1L);
        gameInvoiceResponse.setUnitPrice(new BigDecimal("24.99"));
        gameInvoiceResponse.setQuantity(2L);
        gameInvoiceResponse.setSubtotal(new BigDecimal("49.98"));
        gameInvoiceResponse.setTax(new BigDecimal("2.9988"));
        gameInvoiceResponse.setProcessingFee(new BigDecimal("1.49"));
        gameInvoiceResponse.setTotal(new BigDecimal("54.488"));
        return gameInvoiceResponse;
    }
    
    // Invoice Mock Input (tShirtInvoiceInput)
    private Invoice tShirtInvoiceInput() {
        Invoice tShirtInvoiceInput = new Invoice();
        tShirtInvoiceInput.setName("Dominick DeChristofaro");
        tShirtInvoiceInput.setStreet("999 Peach State Lane");
        tShirtInvoiceInput.setCity("Atlanta");
        tShirtInvoiceInput.setState("Georgia");
        tShirtInvoiceInput.setZipcode("22222");
        tShirtInvoiceInput.setItemType("T-Shirt");
        tShirtInvoiceInput.setItemId(1L);
        tShirtInvoiceInput.setUnitPrice(new BigDecimal("9.99"));
        tShirtInvoiceInput.setQuantity(42L);
        tShirtInvoiceInput.setSubtotal(new BigDecimal("419.58"));
        tShirtInvoiceInput.setTax(new BigDecimal("29.3706"));
        tShirtInvoiceInput.setProcessingFee(new BigDecimal("17.47"));
        tShirtInvoiceInput.setTotal(new BigDecimal("466.4206"));
        return tShirtInvoiceInput;
    }

    // Invoice Mock Response (tShirtInvoiceResponse)
    private Invoice tShirtInvoiceResponse() {
        Invoice tShirtInvoiceResponse = new Invoice();
        tShirtInvoiceResponse.setId(3L);
        tShirtInvoiceResponse.setName("Dominick DeChristofaro");
        tShirtInvoiceResponse.setStreet("999 Peach State Lane");
        tShirtInvoiceResponse.setCity("Atlanta");
        tShirtInvoiceResponse.setState("Georgia");
        tShirtInvoiceResponse.setZipcode("22222");
        tShirtInvoiceResponse.setItemType("T-Shirt");
        tShirtInvoiceResponse.setItemId(1L);
        tShirtInvoiceResponse.setUnitPrice(new BigDecimal("9.99"));
        tShirtInvoiceResponse.setQuantity(42L);
        tShirtInvoiceResponse.setSubtotal(new BigDecimal("419.58"));
        tShirtInvoiceResponse.setTax(new BigDecimal("29.3706"));
        tShirtInvoiceResponse.setProcessingFee(new BigDecimal("17.47"));
        tShirtInvoiceResponse.setTotal(new BigDecimal("466.4206"));
        return tShirtInvoiceResponse;
    }

    // SalesTaxRate Mock Input (nCSalesTaxRateInput)
    private SalesTaxRate nCSalesTaxRateInput() {
        SalesTaxRate nCSalesTaxRateInput = new SalesTaxRate();
        nCSalesTaxRateInput.setState("NC");
        return nCSalesTaxRateInput;
    }

    // SalesTaxRate Mock Response (nCSalesTaxRateResponse)
    private SalesTaxRate nCSalesTaxRateResponse() {
        SalesTaxRate nCSalesTaxRateResponse = new SalesTaxRate();
        nCSalesTaxRateResponse.setState("NC");
        nCSalesTaxRateResponse.setRate(new BigDecimal("0.05"));
        return nCSalesTaxRateResponse;
    }

    // SalesTaxRate Mock Input (cASalesTaxRateInput)
    private SalesTaxRate cASalesTaxRateInput() {
        SalesTaxRate cASalesTaxRateInput = new SalesTaxRate();
        cASalesTaxRateInput.setState("CA");
        return cASalesTaxRateInput;
    }

    // SalesTaxRate Mock Response (cASalesTaxRateResponse)
    private SalesTaxRate cASalesTaxRateResponse() {
        SalesTaxRate cASalesTaxRateResponse = new SalesTaxRate();
        cASalesTaxRateResponse.setState("CA");
        cASalesTaxRateResponse.setRate(new BigDecimal("0.06"));
        return cASalesTaxRateResponse;
    }

    // SalesTaxRate Mock Input (gASalesTaxRateInput)
    private SalesTaxRate gASalesTaxRateInput() {
        SalesTaxRate gASalesTaxRateInput = new SalesTaxRate();
        gASalesTaxRateInput.setState("GA");
        return gASalesTaxRateInput;
    }

    // SalesTaxRate Mock Response (gASalesTaxRateResponse)
    private SalesTaxRate gASalesTaxRateResponse() {
        SalesTaxRate gASalesTaxRateResponse = new SalesTaxRate();
        gASalesTaxRateResponse.setState("GA");
        gASalesTaxRateResponse.setRate(new BigDecimal("0.07"));
        return gASalesTaxRateResponse;
    }

    // ProcessingFee Mock Input (consoleProcessingFeeInput)
    private ProcessingFee consoleProcessingFeeInput() {
        ProcessingFee consoleProcessingFeeInput = new ProcessingFee();
        consoleProcessingFeeInput.setProductType("Console");
        return consoleProcessingFeeInput;
    }

    // ProcessingFee Mock Input (gameProcessingFeeInput)
    private ProcessingFee gameProcessingFeeInput() {
        ProcessingFee gameProcessingFeeInput = new ProcessingFee();
        gameProcessingFeeInput.setProductType("Game");
        return gameProcessingFeeInput;
    }

    // ProcessingFee Mock Input (tShirtProcessingFeeInput)
    private ProcessingFee tShirtProcessingFeeInput() {
        ProcessingFee tShirtProcessingFeeInput = new ProcessingFee();
        tShirtProcessingFeeInput.setProductType("T-Shirt");
        return tShirtProcessingFeeInput;
    }

    // ProcessingFee Mock Response (consoleProcessingFeeResponse)
    private ProcessingFee consoleProcessingFeeResponse() {
        ProcessingFee consoleProcessingFeeResponse = new ProcessingFee();
        consoleProcessingFeeResponse.setProductType("Console");
        consoleProcessingFeeResponse.setFee(new BigDecimal("14.99"));
        return consoleProcessingFeeResponse;
    }

    // ProcessingFee Mock Response (gameProcessingFeeResponse)
    private ProcessingFee gameProcessingFeeResponse() {
        ProcessingFee gameProcessingFeeResponse = new ProcessingFee();
        gameProcessingFeeResponse.setProductType("Game");
        gameProcessingFeeResponse.setFee(new BigDecimal("1.49"));
        return gameProcessingFeeResponse;
    }

    // ProcessingFee Mock Response (tShirtProcessingFeeResponse)
    private ProcessingFee tShirtProcessingFeeResponse() {
        ProcessingFee tShirtProcessingFeeResponse = new ProcessingFee();
        tShirtProcessingFeeResponse.setProductType("T-Shirt");
        tShirtProcessingFeeResponse.setFee(new BigDecimal("1.98"));
        return tShirtProcessingFeeResponse;
    }

    // OrderViewModel Input (consoleOrderInput)
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

    // SalesTaxRate List (allSalesTaxRateList)
    private List<SalesTaxRate> allSalesTaxRateList() {
        List<SalesTaxRate> allSalesTaxRateList = new ArrayList<>();
        allSalesTaxRateList.add(nCSalesTaxRateResponse());
        allSalesTaxRateList.add(cASalesTaxRateResponse());
        allSalesTaxRateList.add(gASalesTaxRateResponse());
        return allSalesTaxRateList;
    }

    // ProcessingFee List (allProcessingFeeList)
    private List<ProcessingFee> allProcessingFeeList() {
        List<ProcessingFee> allProcessingFeeList = new ArrayList<>();
        allProcessingFeeList.add(consoleProcessingFeeResponse());
        allProcessingFeeList.add(gameProcessingFeeResponse());
        allProcessingFeeList.add(tShirtProcessingFeeResponse());
        return allProcessingFeeList;
    }
}

