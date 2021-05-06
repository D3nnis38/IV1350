package dbHandler;

import model.DTO.SaleDTO;
import model.Sale;

/**
 * Represents the accounting system
 *
 * @author dennishadzialic
 */
public class AccountingSystem {
    /**
     * Constructor for AccountingSystem
     */
    public AccountingSystem() {

    }

    /**
     * Should save the Sale-information to the accounting-system but only prints
     * "Saving the sale"
     *
     * @param sale contains information about the current sale
     */
    public void saveSaleInformation(Sale sale) {
        System.out.println("Saving the Sale");

    }

    public void logSaleInformation(SaleDTO saleDTO) {
        System.out.println("Logging sale-information in accounting-system...");
    }
}
