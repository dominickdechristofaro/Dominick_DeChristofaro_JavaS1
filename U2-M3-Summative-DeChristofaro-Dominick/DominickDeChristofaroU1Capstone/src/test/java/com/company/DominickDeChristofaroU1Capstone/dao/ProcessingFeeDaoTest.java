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
public class ProcessingFeeDaoTest {
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
    public void addProcessingFee() {
        // Add a ProcessingFee to the database
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Phone");
        processingFee.setFee(new BigDecimal("29.99"));
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        // Create a copy of the newly added ProcessingFee object
        ProcessingFee processingFeeCopy = processingFeeDao.getProcessingFeeByProductType(processingFee.getProductType());

        // Test addProcessingFee() method
        TestCase.assertEquals(processingFeeCopy, processingFee);
    }

    @Test
    public void updateProcessingFeeByProductType() {
        // Add a ProcessingFee to the database
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Phone");
        processingFee.setFee(new BigDecimal("29.99"));
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        // Update the existing ProcessingFee object in the database
        processingFee.setFee(new BigDecimal("24.99"));
        processingFeeDao.updateProcessingFeeByProductType(processingFee);

        // Make a copy of the ProcessingFee object
        ProcessingFee processingFeeCopy = processingFeeDao.getProcessingFeeByProductType(processingFee.getProductType());

        // Test updateProcessingFeeByProductType() method
        TestCase.assertEquals(processingFeeCopy, processingFee);
    }

    @Test
    public void deleteProcessingFeeByProductType() {
        // Add a ProcessingFee to the database
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Phone");
        processingFee.setFee(new BigDecimal("29.99"));
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        // Delete the ProcessingFee in the database
        processingFeeDao.deleteProcessingFeeByProductType(processingFee.getProductType());

        // Test deleteProcessingFeeByProductType() {
        ProcessingFee processingFeeCopy = processingFeeDao.getProcessingFeeByProductType(processingFee.getProductType());
        TestCase.assertNull(processingFeeCopy);
    }

    // Getter Methods
    @Test
    public void getProcessingFeeByProductType() {
        // Add a ProcessingFee to the database
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Phone");
        processingFee.setFee(new BigDecimal("29.99"));
        processingFee = processingFeeDao.addProcessingFee(processingFee);

        // Create a copy of the newly added ProcessingFee object
        ProcessingFee processingFeeCopy = processingFeeDao.getProcessingFeeByProductType(processingFee.getProductType());

        // Test getProcessingFee() method
        TestCase.assertEquals(processingFeeCopy, processingFee);
    }

    @Test
    public void getAllProcessingFee() {
        // Add a ProcessingFee to the database (processingFee1)
        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setProductType("Phone");
        processingFee1.setFee(new BigDecimal("29.99"));
        processingFee1 = processingFeeDao.addProcessingFee(processingFee1);

        // Add a ProcessingFee to the database (processingFee2)
        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setProductType("CD");
        processingFee2.setFee(new BigDecimal("2.99"));
        processingFee2 = processingFeeDao.addProcessingFee(processingFee2);

        // Create a List of all ProcessingFee's in the database
        List<ProcessingFee> processingFeeList = processingFeeDao.getAllProcessingFee();

        // Test getAllProcessingFee() method
        TestCase.assertEquals(2, processingFeeList.size());
        TestCase.assertEquals(processingFee2, processingFeeList.get(0));
        TestCase.assertEquals(processingFee1, processingFeeList.get(1));
    }
}
