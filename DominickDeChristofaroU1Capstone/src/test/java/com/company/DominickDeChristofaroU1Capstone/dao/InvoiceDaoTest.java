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
public class InvoiceDaoTest {
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
    public void addInvoice() {
        // Create a new Invoice object and add it to the database
        Invoice invoice = new Invoice();
        invoice.setName("Dominick DeChristofaro");
        invoice.setStreet("7 Rosecrest Court");
        invoice.setCity("Asheville");
        invoice.setState("NC");
        invoice.setZipcode("28804");
        invoice.setItemType("Game");
        invoice.setItemId(1L);
        invoice.setUnitPrice(new BigDecimal("9.99"));
        invoice.setQuantity(2L);
        invoice.setSubtotal(new BigDecimal("19.98"));
        invoice.setTax(new BigDecimal("0.99"));
        invoice.setProcessingFee(new BigDecimal("0.00"));
        invoice.setTotal(new BigDecimal("20.97"));
        invoice = invoiceDao.addInvoice(invoice);

        // Create a copy of the newly added Invoice object
        Invoice invoiceCopy = invoiceDao.getInvoice(invoice.getId());

        // Test addInvoice() method
        TestCase.assertEquals(invoiceCopy, invoice);
    }

    @Test
    public void updateInvoice() {
        // Create a new Invoice object and add it to the database
        Invoice invoice = new Invoice();
        invoice.setName("Dominick DeChristofaro");
        invoice.setStreet("7 Rosecrest Court");
        invoice.setCity("Asheville");
        invoice.setState("NC");
        invoice.setZipcode("28804");
        invoice.setItemType("Game");
        invoice.setItemId(1L);
        invoice.setUnitPrice(new BigDecimal("9.99"));
        invoice.setQuantity(2L);
        invoice.setSubtotal(new BigDecimal("19.98"));
        invoice.setTax(new BigDecimal("0.99"));
        invoice.setProcessingFee(new BigDecimal("0.00"));
        invoice.setTotal(new BigDecimal("20.97"));
        invoice = invoiceDao.addInvoice(invoice);

        // Update the Invoice in the database
        invoice.setName("Michael Stuckey");
        invoice.setStreet("123 Test Lane");
        invoice.setCity("Atlanta");
        invoice.setState("GA");
        invoice.setZipcode("33303");
        invoice.setItemType("T-Shirt");
        invoice.setItemId(2L);
        invoice.setUnitPrice(new BigDecimal("14.99"));
        invoice.setQuantity(15L);
        invoice.setSubtotal(new BigDecimal("224.85"));
        invoice.setTax(new BigDecimal("240.59"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("242.57"));
        invoiceDao.updateInvoice(invoice);

        // Make a copy of the Invoice object
        Invoice invoiceCopy = invoiceDao.getInvoice(invoice.getId());

        // Test updateInvoice() method
        TestCase.assertEquals(invoiceCopy, invoice);
    }

    @Test
    public void deleteInvoice() {
        // Create a new Invoice object and add it to the database
        Invoice invoice = new Invoice();
        invoice.setName("Dominick DeChristofaro");
        invoice.setStreet("7 Rosecrest Court");
        invoice.setCity("Asheville");
        invoice.setState("NC");
        invoice.setZipcode("28804");
        invoice.setItemType("Game");
        invoice.setItemId(1L);
        invoice.setUnitPrice(new BigDecimal("9.99"));
        invoice.setQuantity(2L);
        invoice.setSubtotal(new BigDecimal("19.98"));
        invoice.setTax(new BigDecimal("0.99"));
        invoice.setProcessingFee(new BigDecimal("0.00"));
        invoice.setTotal(new BigDecimal("20.97"));
        invoice = invoiceDao.addInvoice(invoice);

        // Delete the Invoice in the database
        invoiceDao.deleteInvoice(invoice.getId());

        // Test deleteInvoice() method
        Invoice invoiceCopy = invoiceDao.getInvoice(invoice.getId());
        TestCase.assertNull(invoiceCopy);
    }

    // Getter Method Tests
    @Test
    public void getInvoice() {
        // Create a new Invoice object and add it to the database
        Invoice invoice = new Invoice();
        invoice.setName("Dominick DeChristofaro");
        invoice.setStreet("7 Rosecrest Court");
        invoice.setCity("Asheville");
        invoice.setState("NC");
        invoice.setZipcode("28804");
        invoice.setItemType("Game");
        invoice.setItemId(1L);
        invoice.setUnitPrice(new BigDecimal("9.99"));
        invoice.setQuantity(2L);
        invoice.setSubtotal(new BigDecimal("19.98"));
        invoice.setTax(new BigDecimal("0.99"));
        invoice.setProcessingFee(new BigDecimal("0.00"));
        invoice.setTotal(new BigDecimal("20.97"));
        invoice = invoiceDao.addInvoice(invoice);

        // Create a copy of the newly added Invoice object
        Invoice invoiceCopy = invoiceDao.getInvoice(invoice.getId());

        // Test getInvoice() method
        TestCase.assertEquals(invoiceCopy, invoice);
    }

    @Test
    public void getAllInvoice() {
        // Create a new Invoice object and add it to the database (invoice1)
        Invoice invoice1 = new Invoice();
        invoice1.setName("Dominick DeChristofaro");
        invoice1.setStreet("7 Rosecrest Court");
        invoice1.setCity("Asheville");
        invoice1.setState("NC");
        invoice1.setZipcode("28804");
        invoice1.setItemType("Game");
        invoice1.setItemId(1L);
        invoice1.setUnitPrice(new BigDecimal("9.99"));
        invoice1.setQuantity(2L);
        invoice1.setSubtotal(new BigDecimal("19.98"));
        invoice1.setTax(new BigDecimal("0.99"));
        invoice1.setProcessingFee(new BigDecimal("0.00"));
        invoice1.setTotal(new BigDecimal("20.97"));
        invoice1 = invoiceDao.addInvoice(invoice1);

        // Create a new Invoice object and add it to the database (invoice2)
        Invoice invoice2 = new Invoice();
        invoice2.setName("Michael Stuckey");
        invoice2.setStreet("123 Test Lane");
        invoice2.setCity("Atlanta");
        invoice2.setState("GA");
        invoice2.setZipcode("33303");
        invoice2.setItemType("T-Shirt");
        invoice2.setItemId(2L);
        invoice2.setUnitPrice(new BigDecimal("14.99"));
        invoice2.setQuantity(15L);
        invoice2.setSubtotal(new BigDecimal("224.85"));
        invoice2.setTax(new BigDecimal("240.59"));
        invoice2.setProcessingFee(new BigDecimal("1.98"));
        invoice2.setTotal(new BigDecimal("242.57"));
        invoice2 = invoiceDao.addInvoice(invoice2);

        // Create a List of all Invoice objects in the database
        List<Invoice> invoiceList = invoiceDao.getAllInvoice();

        // Test getAllInvoice() method
        TestCase.assertEquals(2, invoiceList.size());
        TestCase.assertEquals(invoice1, invoiceList.get(0));
        TestCase.assertEquals(invoice2, invoiceList.get(1));
    }
}
