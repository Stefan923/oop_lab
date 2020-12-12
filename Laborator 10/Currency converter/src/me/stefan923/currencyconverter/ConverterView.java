package me.stefan923.currencyconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConverterView extends JFrame {

    static final String[] currencyOptions = { "EUR", "USD", "RON" };

    private final ConverterModel model;

    private final JComboBox<String> from_userInputCb = new JComboBox<>(currencyOptions);
    private final JComboBox<String> to_userInputCb = new JComboBox<>(currencyOptions);

    private final JTextField amount_userInputTf = new JTextField(10);
    private final JTextField amount_userOutputTf = new JTextField(15);

    private final JLabel exchangeRate = new JLabel("1 Euro = 1 Euro");
    private final JLabel fromCurrency = new JLabel("");
    private final JLabel toCurrency = new JLabel("");

    private final JButton convertBtn = new JButton("Convert");

    public ConverterView(ConverterModel model) {
        this.model = model;

        JPanel content = new JPanel(new GridLayout(4, 1));

        JPanel exchangeRatePanel = new JPanel(new FlowLayout());
        exchangeRatePanel.add(exchangeRate);

        JPanel selectCurrency = new JPanel(new GridLayout(1, 3));
        selectCurrency.add(from_userInputCb);
        selectCurrency.add(convertBtn);
        selectCurrency.add(to_userInputCb);

        JPanel amountInput = new JPanel(new FlowLayout());
        amountInput.add(new JLabel("Suma:"));
        amountInput.add(amount_userInputTf);
        amountInput.add(fromCurrency);

        JPanel amountOutput = new JPanel(new FlowLayout());
        amountOutput.add(new JLabel("Rezultat:"));
        amount_userOutputTf.setEditable(false);
        amountOutput.add(amount_userOutputTf);
        amountOutput.add(toCurrency);

        content.add(exchangeRatePanel);
        content.add(selectCurrency);
        content.add(amountInput);
        content.add(amountOutput);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Currency converter");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getInputAmount() {
        return amount_userInputTf.getText();
    }

    public String getInputFromCurrency() {
        return (String) from_userInputCb.getSelectedItem();
    }

    public String getInputToCurrency() {
        return (String) to_userInputCb.getSelectedItem();
    }

    public void setOutputAmount(String output) {
        amount_userOutputTf.setText(output);
    }

    public void setExchangeRate(String string) {
        exchangeRate.setText(string);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public void addConvertListener(ActionListener actionListener) {
        convertBtn.addActionListener(actionListener);
    }

    public void addCurrencyListener(ActionListener actionListener) {
        from_userInputCb.addActionListener(actionListener);
        to_userInputCb.addActionListener(actionListener);
    }

}
