package me.stefan923.simulatorauto;

import java.awt.*;

public class Autovehicul {

    public final static int nrLocuri = 4;

    private String marca;
    private Color culoare;

    private Sofer sofer;

    private int viteza;
    private int treaptaViteza;
    private int vitezaMax;

    private double kmParcursi;
    private long ultimaActiune;

    public Autovehicul() {
        this.marca = "necunoscut";
        this.culoare = Color.BLACK;
        this.viteza = 0;
        this.treaptaViteza = 0;
        this.vitezaMax = 260;
        this.kmParcursi = 0;

        this.ultimaActiune = System.currentTimeMillis();
    }

    public Autovehicul(String marca, Color culoare, int vitezaMax) {
        this.marca = marca;
        this.culoare = culoare;
        this.viteza = 0;
        this.treaptaViteza = 0;
        this.vitezaMax = vitezaMax;
        this.kmParcursi = 0;

        this.ultimaActiune = System.currentTimeMillis();
    }

    public void accelerare(int viteza) {
        calcKmParcursi();
        this.viteza = Math.min(this.viteza + viteza, vitezaMax);
    }

    public void decelerare(int viteza) {
        calcKmParcursi();
        this.viteza = Math.max(this.viteza - viteza, 0);
    }

    public int getViteza() {
        return viteza;
    }

    public void oprire() {
        calcKmParcursi();
        this.viteza = 0;
    }

    public int getTreaptaViteza() {
        return treaptaViteza;
    }

    public void setTreaptaViteza(int treaptaViteza) {
        this.treaptaViteza = treaptaViteza;
    }

    public void setTreaptaViteza(short treaptaViteza) {
        this.treaptaViteza = treaptaViteza;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Color getCuloare() {
        return culoare;
    }

    public void setCuloare(Color culoare) {
        this.culoare = culoare;
    }

    public int getVitezaMax() {
        return vitezaMax;
    }

    public void setVitezaMax(int vitezaMax) {
        this.vitezaMax = vitezaMax;
    }

    public void calcKmParcursi() {
        long time = System.currentTimeMillis();

        kmParcursi += viteza * (((double)time - ultimaActiune) / 1000 / 60 / 60);
        ultimaActiune = time;
    }

    public double getKmParcursi() {
        calcKmParcursi();
        return kmParcursi;
    }

    public Sofer getSofer() {
        return sofer;
    }

    public void setSofer(Sofer sofer) {
        this.sofer = sofer;
    }
}
