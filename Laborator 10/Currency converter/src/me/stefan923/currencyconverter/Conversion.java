package me.stefan923.currencyconverter;

public class Conversion {

    private Currency from;
    private Currency to;
    private double value;

    public Conversion(Currency from, Currency to, double value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public double getValue() {
        return value;
    }

}
