package dbHandler;

import model.DTO.SaleDTO;

/**
 * Representing the register
 *
 * @author dennishadzialic
 */
public class Register {
    /**
     * Creates a new instance
     */
    private double amount = 0;

    public Register() {

    }

    /**
     * increases
     *
     * @param saleDTO is the DTO of the current sale
     */
    public void increaseAmount(SaleDTO saleDTO) {
        this.amount += saleDTO.getTotal();
        System.out.println("The total amount in the registry has increased to: " + this.amount + " SEK.");
    }
}
