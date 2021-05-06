package controller;

import dbHandler.DBHandler;
import model.DTO.ProductDTO;
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

    public void enterItem(String itemIdentifier, int quantity) {
        ProductDTO product = dbHandler.getProduct(itemIdentifier);
        System.out.println("Managed to fetch: \n" + product + "\n");
        this.sale.registerSoldProduct(product, quantity);

    }

}
