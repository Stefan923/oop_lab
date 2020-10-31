package me.stefan923.matricecomplex;

import java.util.Arrays;

public class Matrice {

    private final int lines;
    private final int columns;

    private Complex[][] values;

    public Matrice(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;

        values = new Complex[lines][columns];
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    public Complex[][] getValues() {
        return values;
    }

    public void setValues(Complex[][] values) {
        if (values.length != lines || values[0].length != columns) {
            System.out.println("EROARE: Matricea trimisa ca parametru trebuie sa fie de dimensiune " + lines + " x " + columns + ".");
            return;
        }

        this.values = values;
    }

    public void setValue(int i, int j, Complex value) {
        if (i < 0 || i >= lines) {
            System.out.println("EROARE: Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (lines - 1) + ".");
            return;
        }
        if (j < 0 || j >= columns) {
            System.out.println("EROARE: Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (columns - 1) + ".");
            return;
        }

        values[i][j] = value;
    }

    public Complex getValue(int i, int j) {
        if (i < 0 || i >= lines) {
            System.out.println("EROARE: Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (lines - 1) + ".");
            return null;
        }
        if (j < 0 || j >= columns) {
            System.out.println("EROARE: Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (columns - 1) + ".");
            return null;
        }

        return values[i][j];
    }

    public Matrice add(Matrice m) {
        if (m.lines != lines || m.columns != columns) {
            System.out.println("EROARE: Matricea trimisa ca parametru trebuie sa fie de dimensiune " + lines + " x " + columns + ".");
            return null;
        }

        Matrice result = new Matrice(lines, columns);

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[i][j] = values[i][j].add(m.values[i][j]);
            }
        }

        return result;
    }

    public Matrice subtract(Matrice m) {
        if (m.lines != lines || m.columns != columns) {
            System.out.println("EROARE: Matricea trimisa ca parametru trebuie sa fie de dimensiune " + lines + " x " + columns + ".");
            return null;
        }

        Matrice result = new Matrice(lines, columns);

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[i][j] = values[i][j].subtract(m.values[i][j]);
            }
        }

        return result;
    }

    public Matrice multiply(double scalar) {
        Matrice result = new Matrice(lines, columns);

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                result.values[i][j] = values[i][j].multiply(scalar);
            }
        }

        return result;
    }

    public Matrice multiply(Matrice m) {
        if (columns != m.lines) {
            System.out.println("EROARE: Matricea trimisa ca parametru trebuie sa aiba " + columns + " linii.");
            return null;
        }

        Matrice result = new Matrice(lines, m.columns);

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < m.columns; j++) {
                Complex c = new Complex(0, 0);
                for (int k = 0; k < columns; k++) {
                    c = c.add(values[i][k].multiply(m.values[k][j]));
                }

                result.values[i][j] = c;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                stringBuilder.append(values[i][j].toString()).append(", ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
