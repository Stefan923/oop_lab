package me.stefan923.matricenumeric;

import me.stefan923.matricenumeric.numeric.Complex;
import me.stefan923.matricenumeric.numeric.Fractie;
import me.stefan923.matricenumeric.numeric.Numeric;

public class MatriceNumeric {

    public static void main(String[] args) {
        Matrice a = new Matrice(2, 3);
        Matrice b = new Matrice(2, 3);
        Matrice c = new Matrice(3, 3);
        Numeric[][] mA = new Numeric[2][3];
        Numeric[][] mB = new Numeric[2][3];
        Numeric[][] mC = new Numeric[3][3];

        mA[0][0] = mB[0][0] = mC[0][0] = new Fractie(1, 2);
        mA[0][1] = mB[0][1] = mC[0][1] = new Complex(1, 1);
        mA[0][2] = mB[0][2] = mC[0][2] = new Complex(1, 1);
        mA[1][0] = mB[1][0] = mC[1][0] = new Complex(1, 1);
        mA[1][1] = mB[1][1] = mC[1][1] = new Fractie(1, 2);
        mA[1][2] = mB[1][2] = mC[1][2] = new Complex(1, 1);
        mC[2][0] = new Complex(1, 1);
        mC[2][1] = new Complex(1, 1);
        mC[2][2] = new Fractie(1, 2);

        a.setValues(mA);
        b.setValues(mB);
        c.setValues(mC);

        System.out.println("Matricea A:\n" + a.toString());
        System.out.println("Matricea B:\n" + b.toString());
        System.out.println("Matricea C:\n" + c.toString());
        System.out.println("Matricea A + B:\n" + a.add(b).toString());
        System.out.println("Matricea A - B:\n" + a.subtract(b).toString());
        System.out.println("Matricea A * 5:\n" + a.multiply(5).toString());
        System.out.println("Matricea A * C:\n" + a.multiply(c).toString());
    }

}
