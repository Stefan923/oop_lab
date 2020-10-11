package me.stefan923.nameinverter;

import java.util.Scanner;

public class NameInverter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        System.out.println(getInvertedName(name));
    }

    public static String getInvertedName(String name) {
        if (name == null)
            return null;

        if (name.equals(""))
            return "";

        String[] args = name.split(" ");
        if (args.length == 1)
            return name;

        StringBuilder stringBuilder = new StringBuilder();
        boolean hasFirstName = false;
        for (String string : args) {
            if (string.equals("")) {
                continue;
            }

            if (string.equalsIgnoreCase("Mr.") || string.equalsIgnoreCase("Mrs.") || string.equalsIgnoreCase("Phd.")) {
                stringBuilder.append(stringBuilder.length() > 0 ? " " : "").append(string);
            } else if (!hasFirstName) {
                stringBuilder.insert(0, stringBuilder.length() > 0 ? " " : "").insert(0, string);
                hasFirstName = true;
            } else {
                stringBuilder.insert(0, ", ").insert(0, string);
            }
        }

        return stringBuilder.toString();
    }

}
