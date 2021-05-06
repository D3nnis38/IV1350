package dbHandler;

import model.DTO.ProductDTO;
import model.DTO.SaleDTO;

/**
 * Representing a "controller" which is responsible for all communication between databases and sends
 * it to the Controller-class
 *
 * @author dennishadzialic
 */
public class DBHandler {
    private final InventorySystem inventorySystem;
    private final AccountingSystem accountingSystem;
    private final Register register;
    private final Printer printer;

    /**
     * Creates a new instance
     */
    public DBHandler() {
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        register = new Register();
        printer = new Printer();
    }

    /**
     * Fetches the ProductDTO with the corresponing inputed itemIdentifier
     *
     * @param itemIdentifier uniqe item-ID
     * @return ProductDTO from the Inventory System with the corresponding itemIdentifier
     */
    public ProductDTO getProduct(String itemIdentifier) {
        System.out.println("Fetching product from the InventorySystem... \n");
        return inventorySystem.getProduct(itemIdentifier);
    }

    /**
     * Logs the sale in all external systems
     *
     * @param saleDTO is a DTO of class Sale
     */
    public void logCompletedSale(SaleDTO saleDTO) {
        accountingSystem.logSaleInformation(saleDTO);
        register.increaseAmount(saleDTO);

    }

    /**
     * Prints the receipt for current sale
     *
     * @param saleDTO is a DTO of class Sale
     */
    public void printReceipt(SaleDTO saleDTO) {
        printer.print(saleDTO);
    }
}
