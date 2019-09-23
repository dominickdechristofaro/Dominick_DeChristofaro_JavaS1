package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {
    // Autowired DAO's
    @Autowired
    private ConsoleDao consoleDao;
    @Autowired
    private GameDao gameDao;
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProcessingFeeDao processingFeeDao;
    @Autowired
    private SalesTaxRateDao salesTaxRateDao;
    @Autowired
    private TShirtDao tShirtDao;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the console table in the database
        List<Console> consoleList = consoleDao.getAllConsole();
        consoleList.forEach(console -> consoleDao.deleteConsole(console.getId()));

        // Clean up the game table in the database
        List<Game> gameList = gameDao.getAllGame();
        gameList.forEach(game -> gameDao.deleteGame(game.getId()));

        // Clean up the invoice table in the database
        List<Invoice> invoiceList = invoiceDao.getAllInvoice();
        invoiceList.forEach(invoice -> invoiceDao.deleteInvoice(invoice.getId()));

        // Clean up the processing_fee table in the database
        List<ProcessingFee> processingFeeList = processingFeeDao.getAllProcessingFee();
        processingFeeList.forEach(processingFee -> processingFeeDao.deleteProcessingFeeByProductType(processingFee.getProductType()));

        // Clean up the sales_tax_rate table in the database
        List<SalesTaxRate> salesTaxRateList = salesTaxRateDao.getAllSalesTaxRate();
        salesTaxRateList.forEach(salesTaxRate -> salesTaxRateDao.deleteSalesTaxRateByState(salesTaxRate.getState()));

        // Clean up the t_shirt table in the database
        List<TShirt> tShirtList = tShirtDao.getAllTShirt();
        tShirtList.forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getId()));
    }

    // Transactional Method Tests
    @Test
    public void addGame() {
        // Create a new Game object and add it to the database
        Game game = new Game();
        game.setTitle("Crash Bandicoot");
        game.setEsrbRating("E");
        game.setDescription("Action/Adventure Platformer");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Sony");
        game.setQuantity(10L);
        game = gameDao.addGame(game);

        // Create a copy of the newly added Game object
        Game gameCopy = gameDao.getGame(game.getId());

        // Test addGame() method
        TestCase.assertEquals(gameCopy, game);
    }

    @Test
    public void updateGame() {
        // Create a new Game object and add it to the database
        Game game = new Game();
        game.setTitle("Crash Bandicoot");
        game.setEsrbRating("E");
        game.setDescription("Action/Adventure Platformer");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Sony");
        game.setQuantity(10L);
        game = gameDao.addGame(game);

        // Update the Game object in the database
        game.setTitle("Tekken");
        game.setEsrbRating("13+");
        game.setDescription("Fighter");
        game.setPrice(new BigDecimal("29.99"));
        game.setStudio("KONAMI");
        game.setQuantity(7L);
        gameDao.updateGame(game);

        // Make a copy of the Game object
        Game gameCopy = gameDao.getGame(game.getId());

        // Test updateGame() method
        TestCase.assertEquals(gameCopy, game);
    }

    @Test
    public void deleteGame() {
        // Create a new Game object and add it to the database
        Game game = new Game();
        game.setTitle("Crash Bandicoot");
        game.setEsrbRating("E");
        game.setDescription("Action/Adventure Platformer");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Sony");
        game.setQuantity(10L);
        game = gameDao.addGame(game);

        // Delete the Game from the database
        gameDao.deleteGame(game.getId());

        // Test deleteGame() method
        Game gameCopy = gameDao.getGame(game.getId());
        TestCase.assertNull(gameCopy);
    }

    // Getter Method Tests
    @Test
    public void getGame() {
        // Create a new Game object and add it to the database
        Game game = new Game();
        game.setTitle("Crash Bandicoot");
        game.setEsrbRating("E");
        game.setDescription("Action/Adventure Platformer");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Sony");
        game.setQuantity(10L);
        game = gameDao.addGame(game);

        // Create a copy of the newly added Game object
        Game gameCopy = gameDao.getGame(game.getId());

        // Test addGame() method
        TestCase.assertEquals(gameCopy, game);
    }

    @Test
    public void getAllGame() {
        // Create a new Game object and add it to the database (game1)
        Game game1 = new Game();
        game1.setTitle("Crash Bandicoot");
        game1.setEsrbRating("E");
        game1.setDescription("Action/Adventure Platformer");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Sony");
        game1.setQuantity(10L);
        game1 = gameDao.addGame(game1);

        // Create a new Game object and add it to the database (game2)
        Game game2 = new Game();
        game2.setTitle("Tekken");
        game2.setEsrbRating("13+");
        game2.setDescription("Fighter");
        game2.setPrice(new BigDecimal("29.99"));
        game2.setStudio("Konami");
        game2.setQuantity(7L);
        game2 = gameDao.addGame(game2);

        // Create a List of all Game objects in the database
        List<Game> gameList = gameDao.getAllGame();

        // Test getAllGame() method
        TestCase.assertEquals(2, gameList.size());
        TestCase.assertEquals(game1, gameList.get(0));
        TestCase.assertEquals(game2, gameList.get(1));
    }

    @Test
    public void getGameByStudio() {
        // Create a new Game object and add it to the database (game1)
        Game game1 = new Game();
        game1.setTitle("Crash Bandicoot");
        game1.setEsrbRating("E");
        game1.setDescription("Action/Adventure Platformer");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Sony");
        game1.setQuantity(10L);
        game1 = gameDao.addGame(game1);

        // Create a new Game object and add it to the database (game2)
        Game game2 = new Game();
        game2.setTitle("Tekken");
        game2.setEsrbRating("13+");
        game2.setDescription("Fighter");
        game2.setPrice(new BigDecimal("29.99"));
        game2.setStudio("KONAMI");
        game2.setQuantity(7L);
        game2 = gameDao.addGame(game2);

        // Create a new Game object and add it to the database (game3)
        Game game3 = new Game();
        game3.setTitle("Dance Dance Reolution");
        game3.setEsrbRating("10+");
        game3.setDescription("Music");
        game3.setPrice(new BigDecimal("19.99"));
        game3.setStudio("KONAMI");
        game3.setQuantity(3L);
        game3 = gameDao.addGame(game3);

        // Create a List of all Games objects in the database who's studio is KONAMI
        List<Game> gameList = gameDao.getGameByStudio("KONAMI");

        // Test getGameByStudio() method
        TestCase.assertEquals(2, gameList.size());
        TestCase.assertEquals(game2, gameList.get(0));
        TestCase.assertEquals(game3, gameList.get(1));
    }

    @Test
    public void getGameByEsrbRating() {
        // Create a new Game object and add it to the database (game1)
        Game game1 = new Game();
        game1.setTitle("Crash Bandicoot");
        game1.setEsrbRating("M");
        game1.setDescription("Action/Adventure Platformer");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Sony");
        game1.setQuantity(10L);
        game1 = gameDao.addGame(game1);

        // Create a new Game object and add it to the database (game2)
        Game game2 = new Game();
        game2.setTitle("Tekken");
        game2.setEsrbRating("M");
        game2.setDescription("Fighter");
        game2.setPrice(new BigDecimal("29.99"));
        game2.setStudio("KONAMI");
        game2.setQuantity(7L);
        game2 = gameDao.addGame(game2);

        // Create a new Game object and add it to the database (game3)
        Game game3 = new Game();
        game3.setTitle("Dance Dance Reolution");
        game3.setEsrbRating("10+");
        game3.setDescription("Music");
        game3.setPrice(new BigDecimal("19.99"));
        game3.setStudio("KONAMI");
        game3.setQuantity(3L);
        game3 = gameDao.addGame(game3);

        // Create a List of all Games objects in the database who's studio is KONAMI
        List<Game> gameList = gameDao.getGameByEsrbRating("M");

        // Test getGameByStudio() method
        TestCase.assertEquals(2, gameList.size());
        TestCase.assertEquals(game1, gameList.get(0));
        TestCase.assertEquals(game2, gameList.get(1));
    }

    @Test
    public void getGameByTitle() {
        // Create a new Game object and add it to the database (game1)
        Game game1 = new Game();
        game1.setTitle("Crash Bandicoot");
        game1.setEsrbRating("E");
        game1.setDescription("Action/Adventure Platformer");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Sony");
        game1.setQuantity(10L);
        game1 = gameDao.addGame(game1);

        // Create a new Game object and add it to the database (game2)
        Game game2 = new Game();
        game2.setTitle("Tekken");
        game2.setEsrbRating("13+");
        game2.setDescription("Fighter");
        game2.setPrice(new BigDecimal("29.99"));
        game2.setStudio("KONAMI");
        game2.setQuantity(7L);
        game2 = gameDao.addGame(game2);

        // Create a new Game object and add it to the database (game3)
        Game game3 = new Game();
        game3.setTitle("Dance Dance Reolution");
        game3.setEsrbRating("10+");
        game3.setDescription("Music");
        game3.setPrice(new BigDecimal("19.99"));
        game3.setStudio("KONAMI");
        game3.setQuantity(3L);
        game3 = gameDao.addGame(game3);

        // Create a List of all Games objects in the database who's studio is KONAMI
        List<Game> gameList = gameDao.getGameByTitle("Crash Bandicoot");

        // Test getGameByStudio() method
        TestCase.assertEquals(1, gameList.size());
        TestCase.assertEquals(game1, gameList.get(0));
    }
}
