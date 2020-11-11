package hotel.persoana;

import hotel.Camera;
import hotel.Hotel;

import java.util.List;
import java.util.stream.Collectors;

public class Angajat extends Persoana implements Comparable<Angajat> {

    private Hotel hotel;

    private String dataAngajarii;
    private int numarClienti;

    public Angajat(int ID, String nume, String nrTelefon, String dataAngajarii) {
        super(ID, nume, nrTelefon);
        this.dataAngajarii = dataAngajarii;
        numarClienti = 0;
    }

    public String getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(String dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public int getNumarClienti() {
        return numarClienti;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void cazeaza(Client client, int numarCamera, boolean regimSingle) {
        List<Camera> camere = hotel.getCamere().stream().filter(camera -> camera.getNumar() == numarCamera).collect(Collectors.toList());

        if (camere.size() == 0) {
            System.out.println("Camera specificata nu exista.");
            return;
        }

        Camera camera = camere.get(0);
        if (camera.isFull()) {
            System.out.println("Camera specificata este plina.");
            return;
        }

        if (camera.getClienti().size() != 0 && regimSingle) {
            System.out.println("Clientul nu poate fi cazat singur.");
            return;
        }
        numarClienti++;
        client.setNumarCamera(numarCamera);
        client.setRegimSingle(regimSingle);
        camera.addClient(client);
        hotel.addClient(client);
        System.out.println("Clientul a fost cazat.");
    }

    public void decazeaza(Client client, int numarCamera) {
        List<Camera> camere = hotel.getCamere().stream().filter(camera -> camera.getNumar() == numarCamera).collect(Collectors.toList());

        if (camere.size() == 0) {
            System.out.println("Camera specificata nu exista.");
            return;
        }

        Camera camera = camere.get(0);
        camera.removeClient(client);
        hotel.removeClient(client);
        System.out.println("Clientul a fost decazat.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Data angajarii: " + dataAngajarii + ", Numar clienti: " + numarClienti;
    }

    @Override
    public int compareTo(Angajat o) {
        if (numarClienti > o.numarClienti)
            return 1;
        else if (numarClienti < o.numarClienti)
            return -1;
        return 0;
    }
}
