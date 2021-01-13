import java.util.List;

public interface OfferService extends AppService<Offer> {

    public List<Offer> findAllByProductName(String name);

}
