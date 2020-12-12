package me.stefan923.currencyconverter;

public class ConverterMVC {

    public static void main(String[] args) {
        ConverterModel model = new ConverterModel();
        ConverterView view = new ConverterView(model);
        ConverterController controller = new ConverterController(model, view);

        view.setVisible(true);
    }

}
