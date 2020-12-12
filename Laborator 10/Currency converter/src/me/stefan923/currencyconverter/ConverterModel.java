package me.stefan923.currencyconverter;

import java.util.ArrayList;
import java.util.List;

public class ConverterModel {

    private final List<Conversion> currencies;

    public ConverterModel() {
        currencies = new ArrayList<>();
        currencies.add(new Conversion(Currency.EUR, Currency.RON, 4.87d));
        currencies.add(new Conversion(Currency.RON, Currency.EUR, 0.21d));
        currencies.add(new Conversion(Currency.EUR, Currency.USD, 1.21d));
        currencies.add(new Conversion(Currency.USD, Currency.EUR, 0.83d));;
        currencies.add(new Conversion(Currency.RON, Currency.USD, 0.25d));
        currencies.add(new Conversion(Currency.USD, Currency.RON, 4.02d));
    }

    public double getConversionValue(Currency o1, Currency o2) {
        if (o1.equals(o2)) {
            return 1;
        }

        return currencies.stream()
                .filter(conversion -> conversion.getFrom().equals(o1) && conversion.getTo().equals(o2))
                .findAny()
                .map(Conversion::getValue)
                .orElse(0d);
    }

    public double convert(Currency o1, Currency o2, double amount) {
        return amount * getConversionValue(o1, o2);
    }

}
