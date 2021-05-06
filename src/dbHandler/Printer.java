package dbHandler;

import model.DTO.SaleDTO;

/**
 * Represents the printer
 *
 * @author dennishadzialic
 */
public class Printer {

    /**
     * Creates a new instance
     */
    public Printer() {
    }

    /**
     * Prints the receipt
     *
     * @param saleDTO is a DTO of class Sale
     */
    public void print(SaleDTO saleDTO) {
        System.out.println("Printing receipt...\n");
        System.out.println(saleDTO.getReceipt());
    }
}
