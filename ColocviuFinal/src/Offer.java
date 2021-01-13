import java.util.ArrayList;
import java.util.List;

public class Offer extends AbstractEntity {

    private String customer;

    private List<Product> products = new ArrayList<>();

    public Offer(long id, String customer) {
        super(id);
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCustomer() {
        return customer;
    }

    /**
     * Calculates and returns offer's total price
     * @return price - double
     */
    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

}
