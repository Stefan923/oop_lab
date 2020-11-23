package me.stefan923.persoane;

import java.util.ArrayList;

public class Simulare {

    public static void main(String[] args) {
        ArrayList<Persoana> persoane = new ArrayList<>();

        persoane.add(new Persoana("Ionescu", "Matei", 20));
        persoane.add(new Persoana("Paduraru", "Ana", 13));
        persoane.add(new Persoana("Pop", "Dan", 20));
        persoane.add(new Persoana("Pop", "Cristian", 17));

        persoane.sort(Persoana::compareTo);

        persoane.forEach(persoana -> System.out.println(persoana.toString()));
    }

}
