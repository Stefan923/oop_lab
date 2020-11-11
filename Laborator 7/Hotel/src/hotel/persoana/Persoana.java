package hotel.persoana;

public abstract class Persoana {
    private int ID;
    private String nume;
    private String nrTelefon;

    public Persoana(int ID, String nume, String nrTelefon) {
        this.ID = ID;
        this.nume = nume;
        this.nrTelefon = nrTelefon;
    }

    public int getID() {
        return ID;
    }

    public String getNume() {
        return nume;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", Nume: " + nume + ", nrTelefon: " + nrTelefon;
    }
}
