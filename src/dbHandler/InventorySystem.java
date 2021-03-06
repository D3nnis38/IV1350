package dbHandler;

import model.DTO.ProductDTO;

/**
 * Representing the Inventory System / Database
 *
 * @author dennishadzialic
 */
public class InventorySystem {


    //represents whole inventory
    private final ProductDTO[] inventory = new ProductDTO[5];

    /**
     * Creates a new instance
     */
    public InventorySystem() {
        this.inventory[0] = new ProductDTO("123456", 20, "Washer fluid", 0.25F, 0);
        this.inventory[1] = new ProductDTO("123457", 420, "Ipod Gen 1", 0.25F, 0);
        this.inventory[2] = new ProductDTO("123458", 90, "Selfie stick", 0.25F, 0);
        this.inventory[3] = new ProductDTO("123459", 1000, "Non dairy milk", 0.25F, 0);
        this.inventory[4] = new ProductDTO("123460", 20, "Regular milk", 0.25F, 0);

    }

    /**
     * Returns the product with the corresponing inputed producIdentifier
     *
     * @param itemIdentifier is the unique number every prouct has
     * @return the productDTO with the corresponding itemIdentifier
     */
    public ProductDTO getProduct(String itemIdentifier) throws InvalidIdentifierException, ConnectivityException {
        if (!itemIdentifier.equals("")) {
            for (ProductDTO productDTO : inventory) {
                if (productDTO.getItemIdentifier().equals(itemIdentifier))
                    return productDTO;
            }
            throw new InvalidIdentifierException("No item with identifier: " + itemIdentifier + " in inventory could be found");
        }
        throw new ConnectivityException("Could not reach the database");
    }

    /**
     * Returns the whole inventory
     *
     * @return whole inventory
     */
    public ProductDTO[] getInventory() {
        return inventory;
    }
}
