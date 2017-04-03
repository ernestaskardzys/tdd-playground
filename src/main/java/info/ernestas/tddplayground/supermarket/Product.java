package info.ernestas.tddplayground.supermarket;

public class Product {

    private Integer id;
    private String name;
    private Double price = 1.0;

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(Integer id, String name, Double price) {
        this(id, name);
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
