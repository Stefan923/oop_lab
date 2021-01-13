import exceptions.ProductNotFoundException;
import exceptions.ValidationFailedException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Simulator {

    public static void main(String[] args) {
        ProductService productService = new ProductService();

        Product product1 = new Product("Lapte", 20.5);
        Product product2 = new Product("lapte", 25.5);
        Product product3 = new Product("lapte", -25.5);
        Product product4 = new Product("lapte1", 25.5);
        Product product5 = new Product("Alune", 15.5);
        Product product6 = new Product("Paine", 40.5);
        Product product7 = new Product("Lalele", 20.5);

        productService.create(product1);
        productService.create(product2);
        try {
            productService.create(product3);
        } catch (ValidationFailedException ex) {
            System.out.println(product3.getId() + ": " + ex.getMessage());
        }

        try {
            productService.create(product4);
        } catch (ValidationFailedException ex) {
            System.out.println(product4.getId() + ": " + ex.getMessage());
        }

        productService.create(product5);
        productService.create(product6);
        productService.create(product7);

        productService.search("la").forEach(product -> System.out.println("A fost gasit produsul: " + product.toString()));

        productService.delete(product7);
        System.out.println("S-a sters produsul Lalele.");

        productService.search("la").forEach(product -> System.out.println("A fost gasit produsul: " + product.toString()));

        productService.delete(product7);

        List<Product> products = FileReader.readProducts("products.txt");
        products.forEach(product -> System.out.println(product.getName() + " " + product.getPrice()));

    }

}
