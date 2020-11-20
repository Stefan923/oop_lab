package me.stefan923.matricenumeric.numeric;

public class Complex implements Numeric {

    private double a;
    private double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public Numeric add(Numeric numeric) {
        if (!(numeric instanceof Complex)) {
            throw new IllegalArgumentException("The object is not an instance of me.stefan923.matricenumeric.numeric.Complex.");
        }

        Complex complex = (Complex) numeric;
        return new Complex(a + complex.a, b + complex.b);
    }

    @Override
    public Numeric subtract(Numeric numeric) {
        if (!(numeric instanceof Complex)) {
            throw new IllegalArgumentException("The object is not an instance of me.stefan923.matricenumeric.numeric.Complex.");
        }

        Complex complex = (Complex) numeric;
        return new Complex(a - complex.a, b - complex.b);
    }

    @Override
    public Numeric multiply(Numeric numeric) {
        if (!(numeric instanceof Complex)) {
            throw new IllegalArgumentException("The object is not an instance of me.stefan923.matricenumeric.numeric.Complex.");
        }

        Complex complex = (Complex) numeric;
        return new Complex(a * complex.a - b * complex.b, a * complex.a + b * complex.b);
    }
}
