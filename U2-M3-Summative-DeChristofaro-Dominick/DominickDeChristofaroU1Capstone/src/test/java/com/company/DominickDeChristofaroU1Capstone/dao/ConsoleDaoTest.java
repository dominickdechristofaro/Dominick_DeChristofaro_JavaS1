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
public class ConsoleDaoTest {
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
    public void addConsole() {
        // Create a new Console object and add it to the database
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8 Gb");
        console.setProcessor("Pentium V");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(10L);
        console = consoleDao.addConsole(console);

        // Create a copy of the newly added Console object
        Console consoleCopy = consoleDao.getConsole(console.getId());

        // Test addConsole() method
        TestCase.assertEquals(consoleCopy, console);
    }

    @Test
    public void updateConsole() {
        // Create and add a new Console to the database
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8 Gb");
        console.setProcessor("Pentium V");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(10L);
        console = consoleDao.addConsole(console);

        // Update the Console in the database
        console.setModel("XBOX");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("16 Gb");
        console.setProcessor("IBM");
        console.setPrice(new BigDecimal("399.99"));
        console.setQuantity(14L);
        consoleDao.updateConsole(console);

        // Make a copy of the Console object
        Console consoleCopy = consoleDao.getConsole(console.getId());

        // Test updateConsole() method
        TestCase.assertEquals(consoleCopy, console);
    }

    @Test
    public void deleteConsole() {
        // Create and add a new Console to the database
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8 Gb");
        console.setProcessor("Pentium V");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(10L);
        console = consoleDao.addConsole(console);

        // Delete the Console in the database
        consoleDao.deleteConsole(console.getId());

        // Test deleteConsole() method
        Console consoleCopy = consoleDao.getConsole(console.getId());
        TestCase.assertNull(consoleCopy);
    }

    // Getter Method Tests
    @Test
    public void getConsole() {
        // Create a new Console object and add it to the database
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8 Gb");
        console.setProcessor("Pentium V");
        console.setPrice(new BigDecimal("499.99"));
        console.setQuantity(10L);
        console = consoleDao.addConsole(console);

        // Create a copy of the newly added Console object
        Console consoleCopy = consoleDao.getConsole(console.getId());

        // Test addConsole() method
        TestCase.assertEquals(consoleCopy, console);
    }

    @Test
    public void getAllConsole() {
        // Create a new Console object and add it to the database (console1)
        Console console1 = new Console();
        console1.setModel("PlayStation 4");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("8 Gb");
        console1.setProcessor("Pentium V");
        console1.setPrice(new BigDecimal("499.99"));
        console1.setQuantity(10L);
        console1 = consoleDao.addConsole(console1);

        // Create a new Console object and add it to the database (console2)
        Console console2 = new Console();
        console2.setModel("XBOX");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("16 Gb");
        console2.setProcessor("IBM");
        console2.setPrice(new BigDecimal("399.99"));
        console2.setQuantity(14L);
        console2 = consoleDao.addConsole(console2);

        // Create a List of all Console objects in the database
        List<Console> consoleList = consoleDao.getAllConsole();

        // Test getAllConsole() method
        TestCase.assertEquals(2, consoleList.size());
        TestCase.assertEquals(console1, consoleList.get(0));
        TestCase.assertEquals(console2, consoleList.get(1));
    }

    @Test
    public void getConsoleByManufacturer() {
        // Create a new Console object and add it to the database (console1)
        Console console1 = new Console();
        console1.setModel("PlayStation 4");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("8 Gb");
        console1.setProcessor("Pentium V");
        console1.setPrice(new BigDecimal("499.99"));
        console1.setQuantity(10L);
        console1 = consoleDao.addConsole(console1);

        // Create a new Console object and add it to the database (console2)
        Console console2 = new Console();
        console2.setModel("XBOX");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("16 Gb");
        console2.setProcessor("IBM");
        console2.setPrice(new BigDecimal("399.99"));
        console2.setQuantity(14L);
        console2 = consoleDao.addConsole(console2);

        // Create a new Console object and add it to the database (console3)
        Console console3 = new Console();
        console3.setModel("XBOX");
        console3.setManufacturer("Microsoft");
        console3.setMemoryAmount("4 Gb");
        console3.setProcessor("IBM");
        console3.setPrice(new BigDecimal("199.99"));
        console3.setQuantity(5L);
        console3 = consoleDao.addConsole(console3);

        // Create a list of all Console's in the database with Microsoft as a manufacturer
        List<Console> consoleList = consoleDao.getConsoleByManufacturer("Microsoft");

        // Test getConsoleByManufacturer() method
        TestCase.assertEquals(2, consoleList.size());
        TestCase.assertEquals(console2, consoleList.get(0));
        TestCase.assertEquals(console3, consoleList.get(1));
    }
}
