package model;

import model.DTO.ProductDTO;

public class Product {
    private final String itemIdentifier;
    private final double price;
    private final String itemDescription;
    private final float VAT;
    private int soldQuantity;


    public Product(String itemIdentifier, double price, String itemDescription, float vat, int soldQuantity) {
        this.itemIdentifier = itemIdentifier;
        this.price = price;
        this.itemDescription = itemDescription;
        VAT = vat;
        this.soldQuantity = soldQuantity;
    }

    public Product(ProductDTO product, int soldQuantity) {
        this.itemIdentifier = product.getItemIdentifier();
        this.price = product.getPrice();
        this.itemDescription = product.getItemDescription();
        VAT = product.getVAT();
        this.soldQuantity = soldQuantity;
    }

    public String getItemIdentifier() {
        return itemIdentifier;
    }

    public double getPrice() {
        return price;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public float getVAT() {
        return VAT;
    }


    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", itemDescription='" + itemDescription + '\'' +
                ", VAT=" + VAT +
                ", soldQuantity=" + soldQuantity +
                '}';
    }
}
