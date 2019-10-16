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
public class SalesTaxRateDaoTest {
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
    public void addSalesTaxRate() {
        // Add a SalesTaxRate to the database
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("YO");
        salesTaxRate.setRate(new BigDecimal("0.09"));
        salesTaxRate = salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        // Create a copy of the newly added SalesTaxRate object
        SalesTaxRate salesTaxRateCopy = salesTaxRateDao.getSalesTaxRateByState(salesTaxRate.getState());

        // Test addSalesTaxRate() method
        TestCase.assertEquals(salesTaxRateCopy, salesTaxRate);
    }

    @Test
    public void updateSalesTaxRateByState() {
        // Add a SalesTaxRate to the database
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("YO");
        salesTaxRate.setRate(new BigDecimal("0.09"));
        salesTaxRate = salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        // Update the existing SalesTaxRate in the database
        salesTaxRate.setRate(new BigDecimal("0.08"));
        salesTaxRateDao.updateSalesTaxRateByState(salesTaxRate);

        // Create a copy of the SalesTaxRate object
        SalesTaxRate salesTaxRateCopy = salesTaxRateDao.getSalesTaxRateByState(salesTaxRate.getState());

        // Test updateSalesTaxRate() method
        TestCase.assertEquals(salesTaxRateCopy, salesTaxRate);
    }

    @Test
    public void deleteSalesTaxRateByState() {
        // Add a SalesTaxRate to the database
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("YO");
        salesTaxRate.setRate(new BigDecimal("0.09"));
        salesTaxRate = salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        // Delete the SalesTaxRate in the database
        salesTaxRateDao.deleteSalesTaxRateByState(salesTaxRate.getState());

        // Test deleteSalesTaxRate() method
        SalesTaxRate salesTaxRateCopy = salesTaxRateDao.getSalesTaxRateByState(salesTaxRate.getState());
        TestCase.assertNull(salesTaxRateCopy);
    }

    // Getter Methods
    @Test
    public void getSalesTaxRateByState() {
        // Add a SalesTaxRate to the database
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("YO");
        salesTaxRate.setRate(new BigDecimal("0.09"));
        salesTaxRate = salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        // Create a copy of the newly added SalesTaxRate object
        SalesTaxRate salesTaxRateCopy = salesTaxRateDao.getSalesTaxRateByState(salesTaxRate.getState());

        // Test addSalesTaxRate() method
        TestCase.assertEquals(salesTaxRateCopy, salesTaxRate);
    }

    @Test
    public void getAllSalesTaxRate() {
        // Add a SalesTaxRate to the database (salesTaxRate1)
        SalesTaxRate salesTaxRate1 = new SalesTaxRate();
        salesTaxRate1.setState("YO");
        salesTaxRate1.setRate(new BigDecimal("0.09"));
        salesTaxRate1 = salesTaxRateDao.addSalesTaxRate(salesTaxRate1);

        // Add a SalesTaxRate to the database (salesTaxRate2)
        SalesTaxRate salesTaxRate2 = new SalesTaxRate();
        salesTaxRate2.setState("QT");
        salesTaxRate2.setRate(new BigDecimal("0.02"));
        salesTaxRate2 = salesTaxRateDao.addSalesTaxRate(salesTaxRate2);

        // Create a List of all SalesTaxRate's in the database
        List<SalesTaxRate> salesTaxRateList = salesTaxRateDao.getAllSalesTaxRate();

        // Test getAllSalesTaxRate() method
        TestCase.assertEquals(2, salesTaxRateList.size());
        TestCase.assertEquals(salesTaxRate2, salesTaxRateList.get(0));
        TestCase.assertEquals(salesTaxRate1, salesTaxRateList.get(1));
    }
}
