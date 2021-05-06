package model.DTO;

import model.Product;
import model.Receipt;
import model.Sale;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * A Data Transfer Object of class Sale
 *
 * @author dennishadzialic
 */
public class SaleDTO {
    private final ArrayList<Product> productList;
    private final LocalTime saleTime;
    private final Receipt receipt;
    private final double runningTotal;
    private final double amountPaid;
    private final float VAT;

    /**
     * Creates a new instance
     *
     * @param sale is the current Sale object
     */
    public SaleDTO(Sale sale) {
        this.productList = sale.getProductList();
        this.saleTime = sale.getSaleTime();
        this.receipt = sale.getReceipt();
        this.runningTotal = sale.getRunningTotal();
        this.amountPaid = sale.getAmountPaid();
        this.VAT = sale.getVAT();
    }

    /**
     * @return returns the running total + VAT
     */
    public double getTotal() {
        return this.runningTotal + this.VAT;
    }

    /**
     * @return all the products in the sale
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }

    /**
     * @return time sale is started
     */
    public LocalTime getSaleTime() {
        return saleTime;
    }

    /**
     * @return the current receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }

    /**
     * @return running total
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * @return amount paid by customer
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * @return amount of VAT
     */
    public float getVAT() {
        return VAT;
    }
}
