package info.ernestas.tddplayground.supermarket;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Double getTotalPrice() {
        double price = 0.0;

        for (Product product : productList) {
            price += product.getPrice();
        }

        return price;
    }
}
