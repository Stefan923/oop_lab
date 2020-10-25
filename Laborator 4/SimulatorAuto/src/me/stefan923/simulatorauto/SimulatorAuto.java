package me.stefan923.simulatorauto;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SimulatorAuto {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Autovehicul autovehicul = new Autovehicul("Volvo", Color.LIGHT_GRAY, 280);

        simulare(autovehicul);
    }

    private static void simulare(Autovehicul autovehicul) {
        System.out.println("----------------------------------\n" +
                "Comenzile care pot fi folosite sunt:\n" +
                "distanta - afiseaza distanta parcursa\n" +
                "accelerare - mareste viteza curenta\n" +
                "decelerare - micsoreaza viteza curenta\n" +
                "treapta - schimba treapta de viteza\n" +
                "oprire - opreste masina (viteza 0)\n" +
                "----------------------------------\n");
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equalsIgnoreCase("exit")) {
            command = scanner.next();

            switch (command.toLowerCase()) {
                case "accelerare":
                    if (autovehicul.getTreaptaViteza() == 0) {
                        System.out.println("Masina este scoasa din viteza. Mai intai, trebuie sa schimbati viteza.");
                        break;
                    }

                    System.out.println("Introduceti viteza in km/h, care va fi adaugata la viteza curenta:");
                    int viteza1 = scanner.nextInt();
                    autovehicul.accelerare(viteza1);
                    System.out.println("Noua viteza este: " + autovehicul.getViteza() + " km/h");
                    break;
                case "decelerare":
                    if (autovehicul.getTreaptaViteza() == 0) {
                        System.out.println("Masina este scoasa din viteza. Mai intai, trebuie sa schimbati viteza.");
                        break;
                    }

                    System.out.println("Introduceti viteza in km/h, care se va scadea din viteza curenta:");
                    int viteza2 = scanner.nextInt();
                    autovehicul.decelerare(viteza2);
                    System.out.println("Noua viteza este: " + autovehicul.getViteza() + " km/h");
                    break;
                case "treapta":
                    System.out.println("Introduceti numarul treptei (0-6):");
                    int treapta = scanner.nextInt();
                    if (treapta >= 0 && treapta <= 6) {
                        autovehicul.setTreaptaViteza(treapta);
                        System.out.println("Noua treapta de viteza este: " + autovehicul.getTreaptaViteza());
                    } else {
                        System.out.println("Nu exista treapta de viteza introdusa.");
                    }
                    break;
                case "distanta":
                    System.out.println("Distanta parcursa este: " + decimalFormat.format(autovehicul.getKmParcursi()) + " km.");
                    break;
                case "oprire":
                    System.out.println("Autovehiculul a fost oprit.");
                    autovehicul.oprire();
                    break;
                case "stop":
                    System.out.println("Simularea s-a incheiat!");
                    autovehicul.oprire();
                    break;
                default:
                    System.out.println("Comanda introdusa nu exista!");
                    break;
            }
        }
    }

}
