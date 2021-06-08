package tests.dbHandler;

import dbHandler.ConnectivityException;
import dbHandler.InvalidIdentifierException;
import dbHandler.InventorySystem;
import model.DTO.ProductDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author dennishadzialic
 */
public class InventorySystemTest {
    private InventorySystem instanceToTest;
    private ProductDTO[] inventory;

    @BeforeEach
    public void setUp() {
        instanceToTest = new InventorySystem();
//        inventory = InventorySystem.getInventory();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCheckIfItemInInventory() throws InvalidIdentifierException, ConnectivityException {
        ProductDTO expectedProduct = new ProductDTO("123456", 20, "Washer fluid", 0.25F, 0);
        ProductDTO result = null;
        String identifier = "123456";
        try {
            result = instanceToTest.getProduct(identifier);
            assertTrue(result.getItemDescription().contains("Washer fluid"));
        } catch (InvalidIdentifierException e) {
            assertTrue(e.getMessage().contains("No item with identifier:"), "InvalidIdentifierException was thrown");
        } catch (ConnectivityException e) {
            assertTrue(e.getMessage().contains("Could not reach the database"), "ConnectivityException was thrown");
        }
    }

    @Test
    public void testCheckIfItemInInventoryException() throws InvalidIdentifierException, ConnectivityException {
        ProductDTO result = null;
        String identifier = "9999999999";
        try {
            result = instanceToTest.getProduct(identifier);
            fail("Product that should not be found was found");
//            fail("Item not found");
        } catch (InvalidIdentifierException e) {
            assertTrue(e.getMessage().contains("No item with identifier: "), "InvalidIdentifierException not thrown");
        }
    }

    @Test
    public void testCheckIfInventorySystemIsNotConnectedException() throws InvalidIdentifierException, ConnectivityException {
        ProductDTO result = null;
        String identifier = "";
        try {
            result = instanceToTest.getProduct(identifier);
            fail("Exception was not thrown");
        } catch (ConnectivityException e) {
            assertTrue(e.getMessage().contains("Could not reach the database"), "ConnectivityException not thrown");
        }
    }
}
