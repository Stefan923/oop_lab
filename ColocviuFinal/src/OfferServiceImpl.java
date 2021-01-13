import exceptions.OfferNotFoundException;
import exceptions.ValidationFailedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferServiceImpl implements OfferService {

    private List<Offer> offers = new ArrayList<>();

    public OfferServiceImpl() {

    }

    public Offer create(Offer offer) {
        if (offer.getCustomer() == null || offer.getCustomer().equals("")) {
            throw new ValidationFailedException("Customer's name is not valid.");
        }

        if (offer.getProducts().size() == 0) {
            throw new ValidationFailedException("Product list is empty.");
        }

        offers.add(offer);

        return offer;
    }

    public List<Offer> search(String name) {
        return offers.stream()
                .filter(offer -> offer.getCustomer().toLowerCase().startsWith(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean delete(Offer offer) throws OfferNotFoundException {
        if (offers.contains(offer)) {
            offers.remove(offer);
            return true;
        }

        throw new OfferNotFoundException("Couldn't find this offer.");
    }

    @Override
    public List<Offer> findAllByProductName(String name) {
        return offers.stream()
                .filter(offer -> offer.getProducts().stream().anyMatch(product -> product.getName().equals(name)))
                .collect(Collectors.toList());
    }

}
