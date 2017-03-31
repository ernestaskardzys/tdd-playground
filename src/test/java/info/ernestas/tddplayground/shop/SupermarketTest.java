package info.ernestas.tddplayground.shop;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SupermarketTest {

    private Supermarket supermarket;

    @Before
    public void setUp() {
        supermarket = new Supermarket();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Bread");

        assertTrue(supermarket.addProduct(product));
    }

    @Test
    public void testAddProduct_multipleProducts() {
        Product product = new Product(1, "Bread");
        Product product2 = new Product(2, "Ham");
        Product product3 = new Product(3, "Milk");

        assertTrue(supermarket.addProduct(Arrays.asList(product, product2, product3)));
    }

    @Test
    public void testAddProduct_withNotUniqueIds() {
        Product product = new Product(1, "Bread");
        Product product2 = new Product(2, "Ham");
        Product product3 = new Product(1, "Milk");

        assertFalse(supermarket.addProduct(Arrays.asList(product, product2, product3)));
    }

    @Test
    public void testBuyProduct_withNotUniqueIds() {
        Product product = new Product(1, "Bread");
        Product product2 = new Product(2, "Ham");
        Product product3 = new Product(3, "Milk");

        supermarket.addProduct(Arrays.asList(product, product2, product3));

        Product result = supermarket.buyProduct(3);

        assertTrue(result.getId().equals(3));
        assertEquals("Milk", result.getName());
    }
}
