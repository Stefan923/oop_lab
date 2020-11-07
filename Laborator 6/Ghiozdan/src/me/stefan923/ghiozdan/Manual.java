package me.stefan923.ghiozdan;

public class Manual extends Rechizita {

    public Manual(String name) {
        eticheta = name;
    }

    @Override
    public String getName() {
        return "Manual: " + eticheta;
    }

}
