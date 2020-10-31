package me.stefan923.matricecomplex;

public class Complex {

    private double a;
    private double b;

    public Complex() {
        this.a = 0;
        this.b = 0;
    }

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

    public Complex add(Complex c) {
        return new Complex(a + c.a, b + c.b);
    }

    public Complex subtract(Complex c) {
        return new Complex(a - c.a, b - c.b);
    }

    public Complex multiply(double scalar) {
        return new Complex(a * scalar, b * scalar);
    }

    public Complex multiply(Complex c) {
        return new Complex(a * c.a - b * c.b, a * c.a + b * c.b);
    }

    public String toString() {
        return a + " + i * " + b;
    }

}
