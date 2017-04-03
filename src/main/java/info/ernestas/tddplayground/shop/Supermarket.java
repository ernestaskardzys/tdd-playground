package info.ernestas.tddplayground.shop;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {

    private List<Product> products = new ArrayList<>();

    public boolean addProduct(Product ... products) {
        for (Product product : products) {
            this.products.add(product);
        }

        return true;
    }

    public boolean addProduct(List<Product> products) {
        boolean result = true;

        for (Product product : products) {
            if (!this.products.contains(product)) {
                this.products.add(product);
            } else {
                result = false;
            }
        }

        return result;
    }

    public Product buyProduct(Integer id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);

    }
}
