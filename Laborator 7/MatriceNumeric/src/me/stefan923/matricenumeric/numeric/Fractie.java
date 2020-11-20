package me.stefan923.matricenumeric.numeric;

public class Fractie implements Numeric {

    private double a;
    private double b;

    public Fractie(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        if (b == 0) {
            throw new IllegalArgumentException("The denominator of the fraction cannot be 0.");
        }

        this.b = b;
    }

    @Override
    public Numeric add(Numeric numeric) {
        if (!(numeric instanceof Fractie)) {
            double value = a / b;
            Complex complex = (Complex) numeric;

            return new Complex(value + complex.getA(), complex.getB());
        }

        Fractie fractie = (Fractie) numeric;
        if (b != fractie.getB()) {
            return new Fractie(a * fractie.b + fractie.a * b, b * fractie.b);
        }

        return new Fractie(a + fractie.a, b);
    }

    @Override
    public Numeric subtract(Numeric numeric) {
        if (!(numeric instanceof Fractie)) {
            double value = a / b;
            Complex complex = (Complex) numeric;

            return new Complex(value - complex.getA(), - complex.getB());
        }

        Fractie fractie = (Fractie) numeric;
        if (b != fractie.getB()) {
            return new Fractie(a * fractie.b - fractie.a * b, b * fractie.b);
        }

        return new Fractie(a - fractie.a, b);
    }

    @Override
    public Numeric multiply(Numeric numeric) {
        if (!(numeric instanceof Fractie)) {
            double value = a / b;
            Complex complex = (Complex) numeric;

            return new Complex(value * complex.getA(), value * complex.getB());
        }

        Fractie fractie = (Fractie) numeric;
        return new Fractie(a * fractie.a, b * fractie.b);
    }

    @Override
    public Numeric multiply(double scalar) {
        return new Fractie(a * scalar, b);
    }

    @Override
    public String toString() {
        return a + " / " + b;
    }

}
