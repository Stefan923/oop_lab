import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tests {

    @Test
    public void testOfferServiceImpl() {
        OfferServiceImpl offerService = new OfferServiceImpl();

        Offer offer = new Offer(1, "Florin");

        Assert.assertEquals(0, offerService.search("Florin").size());

        try {
            offerService.create(offer);
        } catch (Exception ex) {

        }

        Assert.assertEquals(0, offerService.search("Florin").size());
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Chips", 20.5));
        offer.setProducts(products);

        try {
            offerService.create(offer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Assert.assertEquals(1, offerService.search("Florin").size());
        try {
            offerService.delete(offer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Assert.assertEquals(0, offerService.search("Florin").size());
    }

}
