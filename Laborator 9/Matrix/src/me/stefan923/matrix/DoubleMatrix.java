package me.stefan923.matrix;

public class DoubleMatrix extends GenericMatrix<Double> {
    @Override
    /** Aduna doua numere cu vigrula */
    protected Double add(Double o1, Double o2) {
        return o1 + o2;
    }

    @Override
    /** Inmulteste doua numere cu virgula */
    protected Double multiply(Double o1, Double o2) {
        return o1 * o2;
    }

    @Override
    /** Specifica zero pentru un numar cu virgula */
    protected Double zero() {
        return 0.0d;
    }
}
