package me.stefan923.jocdesah;

import me.stefan923.jocdesah.piese.PiesaSah;
import me.stefan923.jocdesah.piese.Pion;
import me.stefan923.jocdesah.piese.Team;

import java.util.Scanner;

public class JocDeSah {

    /*
        Pionii se pot deplasa doar pe x (atunci cand nu este vorba de captura).
        Pionii albi: 2->8
        Pionii negri: 7->1
    */

    private static PiesaSah[][] table;

    public static void main(String[] args) {
        initTable();

        commandList();
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equalsIgnoreCase("exit")) {
            command = scanner.next();

            switch (command.toLowerCase()) {
                case "move":
                    System.out.println("Introduceti coordonatele piesei (x y):");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    if (x < 1 || x > 8 || y < 1 || y > 8) {
                        System.out.println("Coordonatele trebuie sa fie intre 1 si 8.");
                    } else if (table[x][y] == null) {
                        System.out.println("Nu exista nicio piesa la aceasta pozitie.");
                    } else {
                        System.out.println("Introduceti noile coordonate ale piesei (x y):");
                        int newX = scanner.nextInt();
                        int newY = scanner.nextInt();

                        if (newX < 1 || newX > 8 || newY < 1 || newY > 8) {
                            System.out.println("Coordonatele trebuie sa fie intre 1 si 8.");
                        }

                        if (table[x][y].move(newX, newY, table)) {
                            table[newX][newY] = table[x][y];
                            table[x][y] = null;

                            System.out.println("Piesa a fost mutata cu succes.");
                        } else {
                            System.out.println("Piesa NU a fost mutata.");
                        }
                    }
                    break;
                case "exit":
                    break;
                default:
                    commandList();
                    break;
            }
        }
    }

    // move 2 1 3 1
    // move 2 1 3 2

    private static void initTable() {
        table = new PiesaSah[8][8];
        table[2][1] = new Pion(2, 1, Team.WHITE);
        table[3][1] = new Pion(3, 1, Team.BLACK);
        table[3][2] = new Pion(3, 1, Team.BLACK);
    }

    private static void commandList() {
        System.out.println("Comenzile existente sunt urmatoarele:\n" +
                "exit - opreste simularea\n" +
                "move - muta o piesa");
    }

}
