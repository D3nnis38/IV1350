package model;

import model.DTO.ProductDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents the whole Sale (Sales Log)
 *
 * @author dennishadzialic
 */
public class Sale {
    private final ArrayList<Product> productList = new ArrayList<>();
    private final LocalTime saleTime;
    private final Receipt receipt;
    private double runningTotal = 0;
    private double amountPaid = 0;
    private float VAT = 0;

    /**
     * Creates a new instance and saves the time of the sale
     */
    public Sale() {
        saleTime = LocalTime.now();
        receipt = new Receipt(this);
    }

    /**
     * Registers the product and quantity sold to the Sales-Log
     *
     * @param product  is the registered product
     * @param quantity is the quantity sold of the product
     */
    public String registerSoldProduct(ProductDTO product, int quantity) {
        System.out.println("Adding new product to Sales Log: \n" + product + "\n");
        if (productExists(product))
            incrementQuantity(product, quantity);
        else
            productList.add(new Product(product, quantity));
        runningTotal += product.getPrice() * quantity;
        VAT += product.getPrice() * quantity * product.getVAT();

        return displayUpdate(product);
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
        return this.productList;
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
     * Sets the amount customer pays
     *
     * @param amountPaid is the amount customer pays
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return amount of VAT
     */
    public float getVAT() {
        return VAT;
    }

    /**
     * @return change for the customer
     */
    public double getChange() {
        return getAmountPaid() - getTotal();
    }


    public String displayUpdate(ProductDTO product) {
        return "Description: " + product.getItemDescription() + "\nPrice: " + product.getPrice() + " SEK\n" + "Running total: " + runningTotal + " SEK\n";

    }

    private boolean productExists(ProductDTO product) {
        for (Product value : productList) {
            if (value.getItemIdentifier().equals(product.getItemIdentifier()))
                return true;
        }
        return false;
    }

    private void incrementQuantity(ProductDTO product, int quantity) {
        for (Product value : productList) {
            if (value.getItemIdentifier().equals(product.getItemIdentifier()))
                value.setSoldQuantity(value.getSoldQuantity() + quantity);
        }
    }
}
