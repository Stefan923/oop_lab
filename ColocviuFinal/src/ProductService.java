import exceptions.ProductNotFoundException;
import exceptions.ValidationFailedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService implements AppService<Product> {

    private final ProductRepository productRepository = new ProductRepository();

    public Product create(Product product) {
        String productName = product.getName();
        if (!productName.chars().allMatch(Character::isLetter)) {
            throw new ValidationFailedException("Product's name is not vaild.");
        }

        if (product.getPrice() < 0) {
            throw new ValidationFailedException("Product's price is not vaild.");
        }

        productRepository.create(product);

        return product;
    }

    public List<Product> search(String name) {
        return productRepository
                .getProducts().entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(name.toLowerCase()))
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public boolean delete(Product product) {
        try {
            return productRepository.delete(product);
        } catch (ProductNotFoundException ex) {
            System.out.println("Delete product: " + ex.getMessage());
        }

        return false;
    }

}
