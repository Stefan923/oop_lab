package me.stefan923.stringparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringParser {

    public static void main(String[] args) {
        String string = "Ana are 12 mere si 2 pere.";
        System.out.println("String: " + string);
        System.out.println("Number of consonants: " + countConsonants(string));

        Scanner scanner = new Scanner(System.in);
        char vowel = scanner.next().charAt(0);
        System.out.println("'" + vowel + "' indexes: " + getVowelIndexes(string, vowel).toString());
    }

    private static int countConsonants(String string) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (isConsonant(string.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    private static List<Integer> getVowelIndexes(String string, char character) {
        string = string.toLowerCase();
        character = Character.toLowerCase(character);
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    private static boolean isConsonant(char character) {
        return Character.isLetter(character) && "aeiouAEIOU".indexOf(character) < 0;
    }

}
