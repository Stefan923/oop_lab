package hotel.persoana;

import java.util.Date;

public class Client extends Persoana {
    private int numarCamera;
    private boolean regimSingle;
    private Date dataCazare;

    public Client(int ID, String nume, String nrTelefon) {
        super(ID, nume, nrTelefon);
    }

    public int getNumarCamera() {
        return numarCamera;
    }

    public void setNumarCamera(int numarCamera) {
        this.numarCamera = numarCamera;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numar camera: " + numarCamera;
    }

    public boolean isRegimSingle() {
        return regimSingle;
    }

    public void setRegimSingle(boolean regimSingle) {
        this.regimSingle = regimSingle;
    }

    public Date getDataCazare() {
        return dataCazare;
    }

    public void setDataCazare(Date dataCazare) {
        this.dataCazare = dataCazare;
    }
}
