package me.stefan923.interfete;

public class ClasaConcreta extends SuperClasa implements Interfata4 {

    public ClasaConcreta(int numar) {
        super(numar);
    }

    public void interfata1(Interfata1 interfata) {
        interfata.print1();
        interfata.print2();
    }

    public void interfata2(Interfata2 interfata) {
        interfata.print3();
        interfata.print4();
    }

    public void interfata3(Interfata3 interfata) {
        interfata.print5();
        interfata.print6();
    }

    public void interfata4(Interfata4 interfata) {
        interfata.print1();
        interfata.print3();
        interfata.print5();
        interfata.print7();
    }

    @Override
    public void print1() {
    }

    @Override
    public void print2() {
    }

    @Override
    public void print3() {
    }

    @Override
    public void print4() {
    }

    @Override
    public void print5() {

    }

    @Override
    public void print6() {
    }

    @Override
    public void print7() {
    }

}
