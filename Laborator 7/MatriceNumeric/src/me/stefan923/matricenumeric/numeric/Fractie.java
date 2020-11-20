package me.stefan923.matricenumeric.numeric;

public class Fractie implements Numeric {

    private int a;
    private int b; /* privat pentru ca vrem sa restrictionam valorile
                      lui b la [MIN_INT, 0) U (0, MAX_INT] */

    public Fractie(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
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
            throw new IllegalArgumentException("The object is not an instance of me.stefan923.matricenumeric.numeric.Fractie.");
        }

        Fractie fractie = (Fractie) numeric;
        if (b != fractie.getB()) {
            throw new IllegalArgumentException("The denominators of the two fractions are not equal.");
        }

        return new Fractie(a + fractie.a, b);
    }

    @Override
    public Numeric subtract(Numeric numeric) {
        if (!(numeric instanceof Fractie)) {
            throw new IllegalArgumentException("The object is not an instance of me.stefan923.matricenumeric.numeric.Fractie.");
        }

        Fractie fractie = (Fractie) numeric;
        if (b != fractie.getB()) {
            throw new IllegalArgumentException("The denominators of the two fractions are not equal.");
        }

        return new Fractie(a - fractie.a, b);
    }

    @Override
    public Numeric multiply(Numeric numeric) {
        if (!(numeric instanceof Fractie)) {
            throw new IllegalArgumentException("The object is not an instance of me.stefan923.matricenumeric.numeric.Fractie.");
        }

        Fractie fractie = (Fractie) numeric;
        return new Fractie(a * fractie.a, b * fractie.b);
    }
}
