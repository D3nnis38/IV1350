package model.DTO;

import model.Product;

/**
 * Respresents a Data Transfer Object of the class Product
 *
 * @author dennishadzialic
 */
public class ProductDTO {
    private final String itemIdentifier;
    private final double price;
    private final String itemDescription;
    private final float VAT;
    private final int soldQuantity;

    /**
     * Constructor for ProductDTO
     *
     * @param itemIdentifier  identifies the item with a uniqe comibantion of numbers
     * @param price           is the set price of the product
     * @param itemDescription is a description of the product
     * @param VAT             is the VAT rate based on the product
     * @param soldQuantity    is the quantaty sold of the product
     */
    public ProductDTO(String itemIdentifier, double price, String itemDescription, float VAT, int soldQuantity) {
        this.itemIdentifier = itemIdentifier;
        this.price = price;
        this.itemDescription = itemDescription;
        this.VAT = VAT;
        this.soldQuantity = soldQuantity;
    }

    public ProductDTO(Product product) {
        this.itemIdentifier = product.getItemIdentifier();
        this.price = product.getPrice();
        this.itemDescription = product.getItemDescription();
        this.VAT = product.getVAT();
        this.soldQuantity = product.getSoldQuantity();
    }

    /**
     * @return the unique itemIdentifier
     */
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * @return the specific price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the itemDescription
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * @return the VAT-rate for the item
     */
    public float getVAT() {
        return VAT;
    }

    /**
     * @return the quantity sold
     */
    public int getSoldQuantity() {
        return soldQuantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "itemIdentifier='" + itemIdentifier + '\'' +
                ", price=" + price +
                ", itemDescription='" + itemDescription + '\'' +
                ", VAT=" + VAT +
                ", soldQuantity=" + soldQuantity +
                '}';
    }
}
