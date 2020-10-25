package me.stefan923.simulatorauto;

import java.awt.*;

public class Masina extends Autovehicul {

    private int greutate;
    private int nrUsi;

    public Masina(String marca, Color culoare, int vitezaMax, int greutate, int nrUsi) {
        super(marca, culoare, vitezaMax);
        this.greutate = greutate;
        this.nrUsi = nrUsi;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public int getNrUsi() {
        return nrUsi;
    }

    public void setNrUsi(int nrUsi) {
        this.nrUsi = nrUsi;
    }
}
