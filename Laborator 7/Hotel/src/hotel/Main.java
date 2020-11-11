package hotel;

import hotel.persoana.Angajat;
import hotel.persoana.Client;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.addCamera(new Camera(1, 4, 60.5, 100.0));
        hotel.addCamera(new Camera(2, 4, 60.5, 100.0));
        hotel.addCamera(new Camera(3, 4, 60.5, 100.0));
        hotel.addCamera(new Camera(4, 4, 60.5, 100.0));
        hotel.addCamera(new Camera(5, 2, 60.5, 100.0));
        hotel.addCamera(new Camera(6, 2, 60.5, 100.0));
        hotel.addCamera(new Camera(7, 2, 60.5, 100.0));
        hotel.addCamera(new Camera(8, 2, 60.5, 100.0));

        Angajat angajat1 = new Angajat(1, "Ionescu George", "0767111111", "11.11.2020");
        Angajat angajat2 = new Angajat(1, "Popescu Ion", "0767111122", "10.11.2020");

        hotel.addAngajat(angajat1);
        hotel.addAngajat(angajat2);

        angajat1.cazeaza(new Client(1, "Dan", "0767111133"), 1, false);
        angajat1.cazeaza(new Client(1, "Dan", "0767111133"), 1, true);
        angajat1.cazeaza(new Client(1, "Dan", "0767111133"), 2, true);

        hotel.printAngajati();
        hotel.printStats();

        Client client = hotel.getClienti().get(0);
        angajat1.decazeaza(client, client.getNumarCamera());
    }
}
