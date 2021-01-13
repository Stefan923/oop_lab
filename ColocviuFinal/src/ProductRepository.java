import exceptions.ProductNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<String, Product> products = new HashMap<>();

    public ProductRepository() { }

    public Map<String, Product> getProducts() {
        return products;
    }

    public Product create(Product product) {
        products.put(product.getName().toLowerCase(), product);

        return product;
    }

    public boolean delete(Product product) throws ProductNotFoundException {
        String productName = product.getName().toLowerCase();
        if (products.containsKey(productName)) {
            products.remove(productName);
            return true;
        }

        throw new ProductNotFoundException("Couldn't find this product: \"" + productName + "\"");
    }

}
