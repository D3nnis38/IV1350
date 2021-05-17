package controller;

import dbHandler.DBHandler;
import dbHandler.InvalidIdentifierException;
import model.DTO.ProductDTO;
import model.DTO.SaleDTO;
import model.Sale;

/**
 * Representing a controller. Routes logic through the application.
 *
 * @author dennishadzialic
 */
public class Controller {
    private final DBHandler dbHandler;
    private Sale sale;

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
    public String enterItem(String itemIdentifier, int quantity) throws InvalidIdentifierException, OperationException {
        ProductDTO product = dbHandler.getProduct(itemIdentifier);
        System.out.println("Managed to fetch: \n" + product + "\n");
        return sale.registerSoldProduct(product, quantity);

    }

    /**
     * Retrives the roral running amount in sale including VAT
     *
     * @return total amount including VAT
     */
    public double getTotal() {
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
}
