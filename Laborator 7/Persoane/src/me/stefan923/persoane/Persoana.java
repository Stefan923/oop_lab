package me.stefan923.persoane;

public class Persoana implements Comparable<Persoana> {

    private String nume;
    private String prenume;

    private int varsta;

    public Persoana(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
    }


    // Comparare dupa nume, iar apoi dupa prenume
    @Override
    public int compareTo(Persoana o) {
        int comp = nume.compareTo(o.nume);
        return (comp == 0) ? prenume.compareTo(o.prenume) : comp;
    }

    // Comparare dupa varsta
    /*
    @Override
    public int compareTo(Persoana o) {
        if (varsta > o.varsta)
            return 1;
        return (varsta < o.varsta) ? -1 : 0;
    }*/

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
