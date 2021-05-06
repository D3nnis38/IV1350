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

    /**
     * Creates a new instance and saves the time of the sale
     */
    public Sale() {
        saleTime = LocalTime.now();
        receipt = new Receipt();
    }


    /**
     * Registers the product and quantity sold to the Sales-Log
     *
     * @param product  is the registered product
     * @param quantity is the quantity sold of the product
     */
    public void registerSoldProduct(ProductDTO product, int quantity) {
        System.out.println("Adding new product to Sales Log: \n" + product + "\n");
        if (productExists(product))
            incrementQuantity(product, quantity);
        else
            productList.add(new Product(product, quantity));
        runningTotal += product.getPrice() * quantity;

        System.out.println("Description: " + product.getItemDescription());
        System.out.println("Price: " + product.getPrice() + " SEK");
        System.out.println("Running total: " + runningTotal + " SEK\n");

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
