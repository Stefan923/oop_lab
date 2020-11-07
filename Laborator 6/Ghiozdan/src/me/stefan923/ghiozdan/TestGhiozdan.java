package me.stefan923.ghiozdan;

public class TestGhiozdan {

    public static void main(String[] args) {
        Ghiozdan ghiozdan = new Ghiozdan();
        ghiozdan.add(new Caiet("Romana"));
        ghiozdan.add(new Caiet("Matematica"));
        ghiozdan.add(new Caiet("Geografie"));
        ghiozdan.add(new Caiet("Istorie"));
        ghiozdan.add(new Manual("Romana"));
        ghiozdan.add(new Manual("Matematica"));

        System.out.println("Rechizite: " + ghiozdan.getNrRechizite());
        System.out.println("Caiete: " + ghiozdan.getNrCaiete());
        System.out.println("Manuale: " + ghiozdan.getNrManuale());

        ghiozdan.listItems();
        ghiozdan.listCaiet();
        ghiozdan.listManual();
    }

}
