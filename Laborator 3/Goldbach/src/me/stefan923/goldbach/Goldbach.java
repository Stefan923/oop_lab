package me.stefan923.goldbach;

import java.util.Scanner;

public class Goldbach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = 0;
        while (m <= 1) {
            System.out.println("Introduceti m: ");
            m = scanner.nextInt();

            if (m <= 1)
                System.out.println("EROARE: m trebuie sa fie mai mare decat 1!");
        }

        int n = 0;
        while (n <= m) {
            System.out.println("Introduceti n: ");
            n = scanner.nextInt();

            if (n <= m)
                System.out.println("EROARE: n trebuie sa fie mai mare decat m!");
        }

        boolean goldbach = true;
        for (int i = (m % 2 == 0) ? m + 2 : m + 1; i < n; i += 2) {
            goldbach &= checkGoldbach(i);
        }
    }

    private static boolean checkGoldbach(int n) {
        for (int i = 2; i <= n/2; i += (i == 2) ? 1 : 2) {
            if (isPrime(i) && isPrime(n - i)) {
                System.out.println(n + " = " + i + " + " + (n - i));
                return true;
            }
        }

        return false;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
