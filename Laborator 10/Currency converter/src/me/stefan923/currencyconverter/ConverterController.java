package me.stefan923.currencyconverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterController {

    private ConverterModel model;
    private ConverterView view;

    public ConverterController(ConverterModel model, ConverterView view) {
        this.model = model;
        this.view = view;

        view.addConvertListener(new ConvertListener());
        view.addCurrencyListener(new CurrencyListener());
    }

    class ConvertListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = view.getInputAmount();
            try {
                double res = model.convert(Currency.valueOf(view.getInputFromCurrency()),
                                            Currency.valueOf(view.getInputToCurrency()),
                                            Double.parseDouble(userInput));
                view.setOutputAmount(String.valueOf(res));
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class CurrencyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Currency o1 = Currency.valueOf(view.getInputFromCurrency());
            Currency o2 = Currency.valueOf(view.getInputToCurrency());
            double value = model.getConversionValue(o1, o2);

            view.setExchangeRate("1 " + o1.toString() + " = " + value + " " + o2.toString());
        }
    }
}
