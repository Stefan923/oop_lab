package me.stefan923.matricenumeric;

import me.stefan923.matricenumeric.numeric.Fractie;
import me.stefan923.matricenumeric.numeric.Numeric;

public class Matrice {

    private final int lines;
    private final int columns;

    private Numeric[][] values;

    public Matrice(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;

        values = new Numeric[lines][columns];
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    public Numeric[][] getValues() {
        return values;
    }

    public void setValues(Numeric[][] values) {
        if (values.length != lines || values[0].length != columns) {
            throw new IllegalArgumentException("Matricea trimisa ca parametru trebuie sa fie de dimensiune " + lines + " x " + columns + ".");
        }

        this.values = values;
    }

    public void setValue(int i, int j, Numeric value) {
        if (i < 0 || i >= lines) {
            throw new IllegalArgumentException("Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (lines - 1) + ".");
        }
        if (j < 0 || j >= columns) {
            throw new IllegalArgumentException("Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (columns - 1) + ".");
        }

        values[i][j] = value;
    }

    public Numeric getValue(int i, int j) {
        if (i < 0 || i >= lines) {
            throw new IllegalArgumentException("Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (lines - 1) + ".");
        }
        if (j < 0 || j >= columns) {
            throw new IllegalArgumentException("Pozitia \"i\" a elementului trebuie sa fie intre 0 si " + (columns - 1) + ".");
        }

        return values[i][j];
    }

    public Matrice add(Matrice m) {
        if (m.lines != lines || m.columns != columns) {
            throw new IllegalArgumentException("Matricea trimisa ca parametru trebuie sa fie de dimensiune " + lines + " x " + columns + ".");
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
            throw new IllegalArgumentException("Matricea trimisa ca parametru trebuie sa fie de dimensiune " + lines + " x " + columns + ".");
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
            throw new IllegalArgumentException("Matricea trimisa ca parametru trebuie sa aiba " + columns + " linii.");
        }

        Matrice result = new Matrice(lines, m.columns);

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < m.columns; j++) {
                Numeric c = new Fractie(0, 1);
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
                stringBuilder.append(values[i][j].toString()).append((j < columns - 1) ? ", " : "");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
