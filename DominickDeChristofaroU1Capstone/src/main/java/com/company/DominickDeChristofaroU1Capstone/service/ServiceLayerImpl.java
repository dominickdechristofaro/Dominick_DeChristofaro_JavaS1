package com.company.DominickDeChristofaroU1Capstone.service;
import com.company.DominickDeChristofaroU1Capstone.dao.*;
import com.company.DominickDeChristofaroU1Capstone.model.*;
import com.company.DominickDeChristofaroU1Capstone.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ServiceLayerImpl implements ServiceLayer {
    // Properties
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;
    private TShirtDao tShirtDao;

    // Constructor
    @Autowired
    public ServiceLayerImpl(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, TShirtDao tShirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tShirtDao = tShirtDao;
    }

    // Console API
    @Override
    @Transactional
    public Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    @Override
    @Transactional
    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    @Override
    @Transactional
    public void deleteConsole(Long id) {
        consoleDao.deleteConsole(id);
    }

    @Override
    public Console getConsole(Long id) {
        return consoleDao.getConsole(id);
    }

    @Override
    public List<Console> getAllConsole() {
        return consoleDao.getAllConsole();
    }

    @Override
    public List<Console> getConsoleByManufacturer(String manufacturer) {
        return consoleDao.getConsoleByManufacturer(manufacturer);
    }

    // Game API
    @Override
    @Transactional
    public Game addGame(Game game) {
        return gameDao.addGame(game);
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    @Override
    @Transactional
    public void deleteGame(Long id) {
        gameDao.deleteGame(id);
    }

    @Override
    public Game getGame(Long id) {
        return gameDao.getGame(id);
    }

    @Override
    public List<Game> getAllGame() {
        return gameDao.getAllGame();
    }

    @Override
    public List<Game> getGameByStudio(String studio) {
        return gameDao.getGameByStudio(studio);
    }

    @Override
    public List<Game> getGameByEsrbRating(String esrbRating) {
        return gameDao.getGameByEsrbRating(esrbRating);
    }

    @Override
    public List<Game> getGameByTitle(String title) {
        return gameDao.getGameByTitle(title);
    }

    // T-Shirt API
    @Override
    @Transactional
    public TShirt addTShirt(TShirt tShirt) {
        return tShirtDao.addTShirt(tShirt);
    }

    @Override
    @Transactional
    public void updateTShirt(TShirt tShirt) {
        tShirtDao.updateTShirt(tShirt);
    }

    @Override
    @Transactional
    public void deleteTShirt(Long id) {
        tShirtDao.deleteTShirt(id);
    }

    @Override
    public TShirt getTShirt(Long id) {
        return tShirtDao.getTShirt(id);
    }

    @Override
    public List<TShirt> getAllTShirt() {
        return tShirtDao.getAllTShirt();
    }

    @Override
    public List<TShirt> getTShirtByColor(String color) {
        return tShirtDao.getTShirtByColor(color);
    }

    @Override
    public List<TShirt> getTShirtBySize(String size) {
        return tShirtDao.getTShirtBySize(size);
    }

    // OrderViewModel API
    @Override
    @Transactional
    public OrderViewModel addOrder(OrderViewModel order) {
        // Instantiate a temporary invoice object
        Invoice invoice = new Invoice();
        invoice.setName(order.getName());
        invoice.setStreet(order.getStreet());
        invoice.setCity(order.getCity());
        invoice.setZipcode(order.getZipcode());

        // Put all the states and rates from the sales_tax_rate table into a hashMap (salesTaxRateHashMap)
        HashMap<String, BigDecimal> salesTaxRateHashMap = new HashMap<>();
        List<SalesTaxRate> salesTaxRateList = salesTaxRateDao.getAllSalesTaxRate();
        salesTaxRateList.forEach(salesTaxRate -> salesTaxRateHashMap.put(salesTaxRate.getState(), salesTaxRate.getRate()));

        // Check if the user input state is in stateList
        if (salesTaxRateHashMap.containsKey(order.getState())) {
            invoice.setState(order.getState());
        } else {
            throw new IllegalArgumentException("You must input a valid 2 character state code.");
        }

        // Put all the productTypes from the processing_fee table in to a List (itemTypeList)
        HashMap<String, BigDecimal> processingFeeHashMap = new HashMap<>();
        List<ProcessingFee> processingFeeList = processingFeeDao.getAllProcessingFee();
        processingFeeList.forEach(processingFee -> processingFeeHashMap.put(processingFee.getProductType(), processingFee.getFee()));

        // Check if the user input itemType is in the itemTypeList
        if (processingFeeHashMap.containsKey(order.getItemType())) {
            invoice.setItemType(order.getItemType());
        } else {
            throw new IllegalArgumentException("You must input Console, Game, or T-Shirt for itemType.");
        }

        // Business Logic (itemType = Console)
        if (invoice.getItemType().equals("Console")) {
            // Put all the itemId's from the console table into a List (consoleIdList)
            List<Long> consoleIdList = new ArrayList<>();
            List<Console> consoleList = consoleDao.getAllConsole();
            consoleList.forEach(console -> consoleIdList.add(console.getId()));

            // Check that the user input itemId is in the consoleIdList
            if (consoleIdList.contains(order.getItemId())) {
                invoice.setItemId(order.getItemId());
            } else {
                throw new IllegalArgumentException("You must input a valid itemId from the following selection Console id numbers: " + consoleIdList);
            }

            // Create a temporary Console based on the userInput itemId
            Console tempConsole = consoleDao.getConsole(order.getItemId());

            // Assign the unitPrice based on the itemId
            invoice.setUnitPrice(tempConsole.getPrice());

            // Check that the user input quantity for the itemId is valid
            if (tempConsole.getQuantity() >= order.getQuantity()) {
                tempConsole.setQuantity(tempConsole.getQuantity() - order.getQuantity());
                consoleDao.updateConsole(tempConsole);
                invoice.setQuantity(order.getQuantity());
            } else {
                throw new IllegalArgumentException("You must input a valid quantity for the item. Current stock: " + tempConsole.getQuantity());
            }

            // Calculate the subtotal based on the unitPrice * quantity
            invoice.setSubtotal(invoice.getUnitPrice().multiply(new BigDecimal(invoice.getQuantity())));
        }

        // Business Logic (itemType = Game)
        else if (invoice.getItemType().equals("Game")) {
            // Put all the itemId's from the game table into a List (gameIdList)
            List<Long> gameIdList = new ArrayList<>();
            List<Game> gameList = gameDao.getAllGame();
            gameList.forEach(game -> gameIdList.add(game.getId()));

            // Check that the user input itemId is in the gameIdList
            if (gameIdList.contains(order.getItemId())) {
                invoice.setItemId(order.getItemId());
            } else {
                throw new IllegalArgumentException("You must input a valid itemId from the following selection of Game id numbers: " + gameIdList);
            }

            // Create a temporary Game based on the userInput itemId
            Game tempGame = gameDao.getGame(order.getItemId());

            // Assign the unitPrice based on the itemId
            invoice.setUnitPrice(tempGame.getPrice());

            // Check that the user input quantity for the itemId is valid
            if (tempGame.getQuantity() >= order.getQuantity()) {
                tempGame.setQuantity(tempGame.getQuantity() - order.getQuantity());
                gameDao.updateGame(tempGame);
                invoice.setQuantity(order.getQuantity());
            } else {
                throw new IllegalArgumentException("You must input a valid quantity for the item. Current stock: " + tempGame.getQuantity());
            }

            // Calculate the subtotal based on the unitPrice * quantity
            invoice.setSubtotal(invoice.getUnitPrice().multiply(new BigDecimal(invoice.getQuantity())));
        }

        // Business Logic (itemType = T-Shirt)
        else if (invoice.getItemType().equals("T-Shirt")) {
            // Put all the itemId's from the t_shirt table into a List (tShirtIdList)
            List<Long> tShirtIdList = new ArrayList<>();
            List<TShirt> tShirtList = tShirtDao.getAllTShirt();
            tShirtList.forEach(tShirt -> tShirtIdList.add(tShirt.getId()));

            // Check that the user input itemId is in the tShirtIdList
            if (tShirtIdList.contains(order.getItemId())) {
                invoice.setItemId(order.getItemId());
            } else {
                throw new IllegalArgumentException("You must input a valid itemId from the following selection of T-Shirt id numbers: " + tShirtIdList);
            }

            // Create a temporary TShirt based on the userInput itemId
            TShirt tempTShirt = tShirtDao.getTShirt(order.getItemId());

            // Assign the unitPrice based on the itemId
            invoice.setUnitPrice(tempTShirt.getPrice());

            // Check that the user input quantity for the itemId is valid
            if (tempTShirt.getQuantity() >= order.getQuantity()) {
                tempTShirt.setQuantity(tempTShirt.getQuantity() - order.getQuantity());
                tShirtDao.updateTShirt(tempTShirt);
                invoice.setQuantity(order.getQuantity());
            } else {
                throw new IllegalArgumentException("You must input a valid quantity for the item. Current stock: " + tempTShirt.getQuantity());
            }

            // Calculate the subtotal based on the unitPrice * quantity
            invoice.setSubtotal(invoice.getUnitPrice().multiply(new BigDecimal(invoice.getQuantity())));
        }

        // Business Logic (Error)
        else {
            throw new IllegalArgumentException("There is a logic error in your program.");
        }


        // Calculate the sales tax based on the subtotal and the correct sales tax fee
        invoice.setTax(invoice.getSubtotal().multiply(salesTaxRateHashMap.get(invoice.getState())));

        // Calculate the processing fee based on the itemType and quantity
        if (invoice.getQuantity() <= 10) {
            invoice.setProcessingFee(processingFeeHashMap.get(invoice.getItemType()));
        } else {
            invoice.setProcessingFee(processingFeeHashMap.get(invoice.getItemType()).add(new BigDecimal("15.49")));
        }

        // Calculate the total amount of the order
        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()));

        // Change the state code to the state name
        invoice.setState(stateCodeToState(order.getState()));

        // Add the invoice to the database and return
        invoice = invoiceDao.addInvoice(invoice);

        // Build the OrderViewModel
        return buildOrderViewModel(invoice);
    }

    // Helper Methods
    public OrderViewModel buildOrderViewModel(Invoice invoice) {
        OrderViewModel orderViewModel = new OrderViewModel();
        orderViewModel.setId(invoice.getId());
        orderViewModel.setName(invoice.getName());
        orderViewModel.setStreet(invoice.getStreet());
        orderViewModel.setCity(invoice.getCity());
        orderViewModel.setState(invoice.getState());
        orderViewModel.setZipcode(invoice.getZipcode());
        orderViewModel.setItemType(invoice.getItemType());
        orderViewModel.setItemId(invoice.getItemId());
        orderViewModel.setUnitPrice(invoice.getUnitPrice());
        orderViewModel.setQuantity(invoice.getQuantity());
        orderViewModel.setSubtotal(invoice.getSubtotal());
        orderViewModel.setTax(invoice.getTax());
        orderViewModel.setProcessingFee(invoice.getProcessingFee());
        orderViewModel.setTotal(invoice.getTotal());
        return orderViewModel;
    }

    private String stateCodeToState(String stateCode) {
        String state;

        switch(stateCode) {
            case "AL":
                state = "Alabama";
                break;
            case "AK":
                state = "Alaska";
                break;
            case "AZ":
                state = "Arizona";
                break;
            case "AR":
                state = "Arkansas";
                break;
            case "CA":
                state = "California";
                break;
            case "CO":
                state = "Colorado";
                break;
            case "CT":
                state = "Connecticut";
                break;
            case "DE":
                state = "Delaware";
                break;
            case "FL":
                state = "Florida";
                break;
            case "GA":
                state = "Georgia";
                break;
            case "HI":
                state = "Hawaii";
                break;
            case "ID":
                state = "Idaho";
                break;
            case "IL":
                state = "Illinois";
                break;
            case "IN":
                state = "Indiana";
                break;
            case "IA":
                state = "Iowa";
                break;
            case "KS":
                state = "Kansas";
                break;
            case "KY":
                state = "Kentucky";
                break;
            case "LA":
                state = "Louisiana";
                break;
            case "ME":
                state = "Maine";
                break;
            case "MD":
                state = "Maryland";
                break;
            case "MA":
                state = "Massachusetts";
                break;
            case "MI":
                state = "Michigan";
                break;
            case "MN":
                state = "Minnesota";
                break;
            case "MS":
                state = "Mississippi";
                break;
            case "MO":
                state = "Missouri";
                break;
            case "MT":
                state = "Montana";
                break;
            case "NE":
                state = "Nebraska";
                break;
            case "NV":
                state = "Nevada";
                break;
            case "NH":
                state = "New Hampshire";
                break;
            case "NJ":
                state = "New Jersey";
                break;
            case "NM":
                state = "New Mexico";
                break;
            case "NY":
                state = "New York";
                break;
            case "NC":
                state = "North Carolina";
                break;
            case "ND":
                state = "North Dakota";
                break;
            case "OH":
                state = "Ohio";
                break;
            case "OK":
                state = "Oklahoma";
                break;
            case "OR":
                state = "Oregon";
                break;
            case "PA":
                state = "Pennsylvania";
                break;
            case "RI":
                state = "Rhode Island";
                break;
            case "SC":
                state = "South Carolina";
                break;
            case "SD":
                state = "South Dakota";
                break;
            case "TN":
                state = "Tennessee";
                break;
            case "TX":
                state = "Texas";
                break;
            case "UT":
                state = "Utah";
                break;
            case "VT":
                state = "Vermont";
                break;
            case "VA":
                state = "Virginia";
                break;
            case "WA":
                state = "Washington";
                break;
            case "WV":
                state = "West Virginia";
                break;
            case "WI":
                state = "Wisconsin";
                break;
            case "WY":
                state = "Wyoming";
                break;
            default:
                state = "Error";
                break;
        }
        return state;
    }
}
