package me.stefan923.currencyconverter;

public enum Currency {
    EUR("Euro"), USD("Dolari SUA"), RON("Lei");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
