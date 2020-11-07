package me.stefan923.ghiozdan;

import java.util.ArrayList;

public class Ghiozdan {

    private ArrayList<Rechizita> rechizite;

    public Ghiozdan() {
        rechizite = new ArrayList<>();
    }

    public void add(Caiet caiet) {
        rechizite.add(caiet);
    }

    public void add(Manual manual) {
        rechizite.add(manual);
    }

    public void listItems() {
        System.out.println("Rechizite: " + rechizite.toString());
    }

    public void listManual() {
        System.out.println("Manuale: " + rechizite.stream().filter(rechizita -> rechizita instanceof Manual));
    }

    public void listCaiet() {
        System.out.println("Caiete: " + rechizite.stream().filter(rechizita -> rechizita instanceof Caiet));
    }

    public int getNrRechizite() {
        return rechizite.size();
    }

    public int getNrManuale() {
        return (int) rechizite.stream().filter(rechizita -> rechizita instanceof Manual).count();
    }

    public int getNrCaiete() {
        return (int) rechizite.stream().filter(rechizita -> rechizita instanceof Caiet).count();
    }

}
