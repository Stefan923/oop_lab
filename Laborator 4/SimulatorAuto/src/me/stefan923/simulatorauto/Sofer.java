package me.stefan923.simulatorauto;

public class Sofer {

    private String nume;
    private String prenume;

    private int varsta;
    private int nrPermis;

    public Sofer(String nume, String prenume, int varsta, int nrPermis) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.nrPermis = nrPermis;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getNrPermis() {
        return nrPermis;
    }

    public void setNrPermis(int nrPermis) {
        this.nrPermis = nrPermis;
    }
}
