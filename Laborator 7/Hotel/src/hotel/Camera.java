package hotel;

import hotel.persoana.Client;

import java.util.ArrayList;
import java.util.List;

public class Camera {

    private int numar;
    private int capacitate;
    private double pret;
    private double pretSpecial;

    private List<Client> clienti;

    public Camera(int numar, int capacitate, double pret, double pretSpecial) {
        this.numar = numar;
        this.capacitate = capacitate;
        this.pret = pret;
        this.pretSpecial = pretSpecial;

        clienti = new ArrayList<>();
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public List<Client> getClienti() {
        return clienti;
    }

    public void addClient(Client client) {
        clienti.add(client);
    }

    public void removeClient(Client client) {
        clienti.remove(client);
    }

    // pretul pentru un numar de nopti si discount (x% - pentru 90%, punem 0.9)
    public double getPretTotal(int numarNopti, double discount, boolean regimSingle) {
        return regimSingle ? (pretSpecial * numarNopti) * discount : (pret * numarNopti) * discount;
    }

    public boolean isFull() {
        return clienti.size() == capacitate || (clienti.size() > 0) && clienti.stream().anyMatch(Client::isRegimSingle);
    }
}
