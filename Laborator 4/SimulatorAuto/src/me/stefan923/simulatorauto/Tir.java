package me.stefan923.simulatorauto;

import java.awt.*;

public class Tir extends Autovehicul {

    private String tipIncarcatura;
    private int capacitate;

    public Tir(String marca, Color culoare, int vitezaMax, String tipIncarcatura, int capacitate) {
        super(marca, culoare, vitezaMax);
        this.tipIncarcatura = tipIncarcatura;
        this.capacitate = capacitate;
    }

    public String getTipIncarcatura() {
        return tipIncarcatura;
    }

    public void setTipIncarcatura(String tipIncarcatura) {
        this.tipIncarcatura = tipIncarcatura;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }
}
