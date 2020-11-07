package me.stefan923.ghiozdan;

public class Caiet extends Rechizita {

    public Caiet(String name) {
        eticheta = name;
    }

    @Override
    public String getName() {
        return "Caiet: " + eticheta;
    }

}
