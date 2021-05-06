package dbHandler;

import model.DTO.ProductDTO;

/**
 * Representing a "controller" which is responsible for all communication between databases and sends
 * it to the Controller-class
 *
 * @author dennishadzialic
 */
public class DBHandler {
    private final InventorySystem inventorySystem;
    private final AccountingSystem accountingSystem;

    /**
     * Creates a new instance
     */
    public DBHandler() {
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
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
}
