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
public class TShirtDaoTest {
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

    // Transactional Methods
    @Test
    public void addTShirt() {
        // Create a new TShirt object and add it to the database
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("90% Cotton, 10% Polyester");
        tShirt.setPrice(new BigDecimal("14.99"));
        tShirt.setQuantity(4L);
        tShirt = tShirtDao.addTShirt(tShirt);

        // Create a copy of the newly added TShirt object
        TShirt tShirtCopy = tShirtDao.getTShirt(tShirt.getId());

        // Test addTShirt() method
        TestCase.assertEquals(tShirtCopy, tShirt);
    }

    @Test
    public void updateTShirt() {
        // Create a new TShirt object and add it to the database
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("90% Cotton, 10% Polyester");
        tShirt.setPrice(new BigDecimal("14.99"));
        tShirt.setQuantity(4L);
        tShirt = tShirtDao.addTShirt(tShirt);

        // Update the TShirt object in the database
        tShirt.setSize("Large");
        tShirt.setColor("Yellow");
        tShirt.setDescription("25% Cotton, 25% Polyester, 50% Synthetic");
        tShirt.setPrice(new BigDecimal("12.99"));
        tShirt.setQuantity(8L);
        tShirtDao.updateTShirt(tShirt);

        // Make a copy of the TShirt object
        TShirt tShirtCopy = tShirtDao.getTShirt(tShirt.getId());

        // Test updateTShirt() method
        TestCase.assertEquals(tShirtCopy, tShirt);
    }

    @Test
    public void deleteTShirt() {
        // Create a new TShirt object and add it to the database
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("90% Cotton, 10% Polyester");
        tShirt.setPrice(new BigDecimal("14.99"));
        tShirt.setQuantity(4L);
        tShirt = tShirtDao.addTShirt(tShirt);

        // Delete the TShirt from the database
        tShirtDao.deleteTShirt(tShirt.getId());

        // Test deleteTShirt() method
        TShirt tShirtCopy = tShirtDao.getTShirt(tShirt.getId());
        TestCase.assertNull(tShirtCopy);
    }

    // Getter Methods
    @Test
    public void getTShirt() {
        // Create a new TShirt object and add it to the database
        TShirt tShirt = new TShirt();
        tShirt.setSize("Medium");
        tShirt.setColor("Blue");
        tShirt.setDescription("90% Cotton, 10% Polyester");
        tShirt.setPrice(new BigDecimal("14.99"));
        tShirt.setQuantity(4L);
        tShirt = tShirtDao.addTShirt(tShirt);

        // Create a copy of the newly added TShirt object
        TShirt tShirtCopy = tShirtDao.getTShirt(tShirt.getId());

        // Test getTShirt() method
        TestCase.assertEquals(tShirtCopy, tShirt);
    }

    @Test
    public void getAllTShirt() {
        // Create a new TShirt object and add it to the database (tShirt1)
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("90% Cotton, 10% Polyester");
        tShirt1.setPrice(new BigDecimal("14.99"));
        tShirt1.setQuantity(4L);
        tShirt1 = tShirtDao.addTShirt(tShirt1);

        // Create a new TShirt object and add it to the database (tShirt2)
        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Large");
        tShirt2.setColor("Yellow");
        tShirt2.setDescription("25% Cotton, 25% Polyester, 50% Synthetic");
        tShirt2.setPrice(new BigDecimal("12.99"));
        tShirt2.setQuantity(8L);
        tShirt2 = tShirtDao.addTShirt(tShirt2);

        // Create a List of all TShirt objects in the database
        List<TShirt> tShirtList = tShirtDao.getAllTShirt();

        // Test getAllTShirt() method
        TestCase.assertEquals(2, tShirtList.size());
        TestCase.assertEquals(tShirt1, tShirtList.get(0));
        TestCase.assertEquals(tShirt2, tShirtList.get(1));
    }

    @Test
    public void getTShirtByColor() {
        // Create a new TShirt object and add it to the database (tShirt1)
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("90% Cotton, 10% Polyester");
        tShirt1.setPrice(new BigDecimal("14.99"));
        tShirt1.setQuantity(4L);
        tShirt1 = tShirtDao.addTShirt(tShirt1);

        // Create a new TShirt object and add it to the database (tShirt2)
        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Large");
        tShirt2.setColor("Yellow");
        tShirt2.setDescription("25% Cotton, 25% Polyester, 50% Synthetic");
        tShirt2.setPrice(new BigDecimal("12.99"));
        tShirt2.setQuantity(8L);
        tShirt2 = tShirtDao.addTShirt(tShirt2);

        // Create a new TShirt object and add it to the database (tShirt3)
        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("Small");
        tShirt3.setColor("Yellow");
        tShirt3.setDescription("100% Synthetic");
        tShirt3.setPrice(new BigDecimal("9.99"));
        tShirt3.setQuantity(13L);
        tShirt3 = tShirtDao.addTShirt(tShirt3);

        // Create a List of all TShirt objects in the database that are Yellow in color
        List<TShirt> tShirtList = tShirtDao.getTShirtByColor("Yellow");

        // Test getTShirtByColor() method
        TestCase.assertEquals(2, tShirtList.size());
        TestCase.assertEquals(tShirt2, tShirtList.get(0));
        TestCase.assertEquals(tShirt3, tShirtList.get(1));
    }

    @Test
    public void getTShirtBySize() {
// Create a new TShirt object and add it to the database (tShirt1)
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("Medium");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("90% Cotton, 10% Polyester");
        tShirt1.setPrice(new BigDecimal("14.99"));
        tShirt1.setQuantity(4L);
        tShirt1 = tShirtDao.addTShirt(tShirt1);

        // Create a new TShirt object and add it to the database (tShirt2)
        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Medium");
        tShirt2.setColor("Yellow");
        tShirt2.setDescription("25% Cotton, 25% Polyester, 50% Synthetic");
        tShirt2.setPrice(new BigDecimal("12.99"));
        tShirt2.setQuantity(8L);
        tShirt2 = tShirtDao.addTShirt(tShirt2);

        // Create a new TShirt object and add it to the database (tShirt3)
        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("Large");
        tShirt3.setColor("Green");
        tShirt3.setDescription("100% Synthetic");
        tShirt3.setPrice(new BigDecimal("9.99"));
        tShirt3.setQuantity(13L);
        tShirt3 = tShirtDao.addTShirt(tShirt3);

        // Create a List of all TShirt objects in the database that are Medium in size
        List<TShirt> tShirtList = tShirtDao.getTShirtBySize("Medium");

        // Test getTShirtBySize() method
        TestCase.assertEquals(2, tShirtList.size());
        TestCase.assertEquals(tShirt1, tShirtList.get(0));
        TestCase.assertEquals(tShirt2, tShirtList.get(1));
    }
}
