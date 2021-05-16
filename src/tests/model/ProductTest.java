package tests.model;

import model.DTO.ProductDTO;
import model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {

    private Product product;
    private ProductDTO productDTO;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        productDTO = new ProductDTO("123456", 25, "Bananer", 0.25F, 2);
        product = new Product(productDTO, 2);
    }

    @AfterEach
    void tearDown() {
        printoutBuffer = null;
        System.setOut(originalSysOut);
        productDTO = null;
        product = null;
    }

    @Test
    public void testIfAllGetters() {
        String printout = product.toString();
        String expectedOutput = "Product{" +
                "price=" + product.getPrice() +
                ", itemDescription='" + product.getItemDescription() + '\'' +
                ", VAT=" + product.getVAT() +
                ", soldQuantity=" + product.getSoldQuantity() +
                '}';
        assertTrue(printout.contains(expectedOutput), "item-toString did not print correctly.");
    }

}
