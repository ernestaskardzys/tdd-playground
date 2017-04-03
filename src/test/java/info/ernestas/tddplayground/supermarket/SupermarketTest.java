package info.ernestas.tddplayground.supermarket;

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
        Product product = new Product(1, "Milk");

        assertTrue(supermarket.addProduct(product));
    }

    @Test
    public void testAddProduct_multipleProducts() {
        Product product1 = new Product(1, "Milk");
        Product product2 = new Product(2, "Bread");
        Product product3 = new Product(3, "Sausage");

        assertTrue(supermarket.addProduct(product1, product2, product3));
    }

    @Test
    public void testAddProduct_productWithUniqueId() {
        Product product1 = new Product(1, "Milk");
        Product product2 = new Product(2, "Bread");
        Product product3 = new Product(1, "Ham");

        assertFalse(supermarket.addProduct(product1, product2, product3));
    }

    @Test
    public void testBuyProduct() {
        Product product = new Product(1, "Milk");
        supermarket.addProduct(product);

        Product result = supermarket.buyProduct(1);

        assertTrue(result.getId().equals(1));
        assertEquals("Milk", result.getName());
    }

    @Test
    public void testBuyProduct_itCosts1() {
        Product product = new Product(1, "Milk");
        supermarket.addProduct(product);

        Product result = supermarket.buyProduct(1);

        assertTrue(result.getId().equals(1));
        assertEquals("Milk", result.getName());
        assertEquals(1, result.getPrice(), 0.001);
    }

    @Test
    public void testBuyProduct_productCanHaveADifferentPrice() {
        Product product1 = new Product(1, "Milk", 2.0);
        Product product2 = new Product(2, "Bread", 3.0);
        Product product3 = new Product(3, "Sausage", 4.0);
        supermarket.addProduct(product1, product2, product3);

        Product result = supermarket.buyProduct(1);
        assertTrue(result.getId().equals(1));
        assertEquals("Milk", result.getName());
        assertEquals(2, result.getPrice(), 0.001);

        Product result2 = supermarket.buyProduct(2);
        assertTrue(result2.getId().equals(2));
        assertEquals("Bread", result2.getName());
        assertEquals(3, result2.getPrice(), 0.001);

        Product result3 = supermarket.buyProduct(3);
        assertTrue(result3.getId().equals(3));
        assertEquals("Sausage", result3.getName());
        assertEquals(4, result3.getPrice(), 0.001);
    }

    @Test
    public void testBuyProductsInTheCart() {
        Product product1 = new Product(1, "Milk", 2.0);
        Product product2 = new Product(2, "Bread", 3.0);
        Product product3 = new Product(3, "Sausage", 4.0);
        supermarket.addProduct(product1, product2, product3);

        Cart cart = supermarket.buyProductsInTheCart(Arrays.asList(1, 2));

        assertEquals(2, cart.getProductList().size());
    }

    @Test
    public void testBuyProductsInTheCart_withTotalPrice() {
        Product product1 = new Product(1, "Milk", 2.0);
        Product product2 = new Product(2, "Bread", 3.0);
        Product product3 = new Product(3, "Sausage", 4.0);
        supermarket.addProduct(product1, product2, product3);

        Cart cart = supermarket.buyProductsInTheCart(Arrays.asList(1, 2));

        assertEquals(2, cart.getProductList().size());
        assertEquals(5, cart.getTotalPrice(), 0.001);
    }


}
