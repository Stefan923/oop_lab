package me.stefan923.interfete;

public class Main {

    public static void main(String[] args) {
        ClasaConcreta clasa = new ClasaConcreta(2);

        clasa.interfata1(new Interfata1() {
            @Override
            public void print1() {
                System.out.println("1");
            }

            @Override
            public void print2() {
                System.out.println("2");
            }
        });

        clasa.interfata2(new Interfata2() {
            @Override
            public void print3() {
                System.out.println("3");
            }

            @Override
            public void print4() {
                System.out.println("4");
            }
        });

        clasa.interfata3(new Interfata3() {
            @Override
            public void print5() {
                System.out.println("5");
            }

            @Override
            public void print6() {
                System.out.println("6");
            }
        });

        clasa.interfata4(new Interfata4() {
            @Override
            public void print7() {
                System.out.println("7");
            }

            @Override
            public void print1() {
                System.out.println("11");
            }

            @Override
            public void print2() {
                System.out.println("12");
            }

            @Override
            public void print3() {
                System.out.println("13");
            }

            @Override
            public void print4() {
                System.out.println("14");
            }

            @Override
            public void print5() {
                System.out.println("15");
            }

            @Override
            public void print6() {
                System.out.println("16");
            }
        });
    }

}
