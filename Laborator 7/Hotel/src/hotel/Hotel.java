package hotel;

import hotel.persoana.Angajat;
import hotel.persoana.Client;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private ArrayList<Angajat> angajati;
    private ArrayList<Client> clienti;
    private ArrayList<Camera> camere;

    public Hotel() {
        angajati = new ArrayList<>();
        clienti = new ArrayList<>();
        camere = new ArrayList<>();
    }

    public ArrayList<Angajat> getAngajati() {
        return angajati;
    }

    public ArrayList<Client> getClienti() {
        return clienti;
    }

    public ArrayList<Camera> getCamere() {
        return camere;
    }

    public void addCamera(Camera camera) {
        camere.add(camera);
    }

    public void removeCamera(Camera camera) {
        camere.remove(camera);
    }

    public void addAngajat(Angajat angajat) {
        angajati.add(angajat);
        angajat.setHotel(this);
    }

    public void removeAngajat(Angajat angajat) {
        angajati.remove(angajati);
    }

    public void addClient(Client client) {
        clienti.add(client);
    }

    public void removeClient(Client client) {
        clienti.remove(client);
    }

    public void printAngajati() {
        List<Angajat> temp = new ArrayList<>(angajati);
        temp.sort(Angajat::compareTo);
        System.out.println("Angajati:");
        temp.forEach(angajat -> System.out.println(angajat.toString()));
    }

    public void printStats() {
        System.out.println("Camere libere: " + camere.stream().filter(camera -> !camera.isFull()).count());
        System.out.println("Camere ocupate: " + camere.stream().filter(Camera::isFull).count());
    }
}
