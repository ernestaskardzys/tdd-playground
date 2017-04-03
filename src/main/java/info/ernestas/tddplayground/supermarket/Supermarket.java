package info.ernestas.tddplayground.supermarket;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {

    private List<Product> productList = new ArrayList<>();

    public boolean addProduct(Product ... products) {
        boolean importedSuccessfully = true;
        for (Product product : products) {
            if (!productList.contains(product)) {
                productList.add(product);
            } else {
                importedSuccessfully = false;
            }
        }

        return importedSuccessfully;
    }

    public Product buyProduct(Integer productId) {
        return productList.stream().filter(product -> product.getId().equals(productId)).findFirst().orElse(null);
    }

    public Cart buyProductsInTheCart(List<Integer> productIds) {
        Cart cart = new Cart();

        for (Integer productId : productIds) {
            for (Product product : productList) {
                if (product.getId().equals(productId)) {
                    cart.addProduct(product);
                }
            }
        }

        return cart;
    }
}
