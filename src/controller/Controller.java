package controller;

import dbHandler.ConnectivityException;
import dbHandler.DBHandler;
import dbHandler.InvalidIdentifierException;
import model.DTO.ProductDTO;
import model.DTO.SaleDTO;
import model.Sale;
import model.SaleObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Representing a controller. Routes logic through the application.
 *
 * @author dennishadzialic
 */
public class Controller {
    private final DBHandler dbHandler;
    private Sale sale;
    private final List<SaleObserver> saleObserver = new ArrayList<>();

    /**
     * Creates a new instance
     *
     * @param dbHandler which handles all the database-related-request and sends to Controller
     */
    public Controller(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    /**
     * Starts a new Sale. This method must be called before doing anything else during a sale
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * Registers the item to the sale
     *
     * @param itemIdentifier is the unique item-ID the cashier enters
     * @param quantity       is the amount for the entered item
     */
    public String enterItem(String itemIdentifier, int quantity) throws InvalidIdentifierException, ConnectivityException, OperationException {
        ProductDTO product = dbHandler.getProduct(itemIdentifier);
        return sale.registerSoldProduct(product, quantity);

    }

    /**
     * Retrives the toral running amount in sale including VAT
     *
     * @return total amount including VAT
     */
    public double getTotal() {
        sale.addSaleObservers(saleObserver);
        return sale.getTotal();
    }

    /**
     * Ends the whole sale and prints receipt
     *
     * @param amountPaid is the amount customer pays
     */
    public void endSale(double amountPaid) {
        sale.setAmountPaid(amountPaid);
        SaleDTO saleDTO = new SaleDTO(sale);
        dbHandler.logCompletedSale(saleDTO);
        dbHandler.printReceipt(saleDTO);
    }

    /**
     * Adds an observer to the observer-list
     *
     * @param observer is the observer to be added in the observer-list
     */
    public void addSaleObserver(SaleObserver observer) {
        saleObserver.add(observer);
    }
}
