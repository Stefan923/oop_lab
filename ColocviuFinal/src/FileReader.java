import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    static public List<Product> readProducts(String filePath) {
        List<Product> products = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(file);

            int cntProducts = in.readInt();

            for (int i = 0; i < cntProducts; i++) {
                String[] product = in.readLine().split(", ");
                products.add(new Product(product[0], Integer.parseInt(product[1])));
            }

            in.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

}
