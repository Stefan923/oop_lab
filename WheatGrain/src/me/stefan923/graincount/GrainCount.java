package me.stefan923.graincount;

import java.math.BigInteger;

public class GrainCount {

    public static void main(String[] args) {
        System.out.println("Numarul de boabe de grau: " + grainCount());
    }

    public static BigInteger grainCount() {
        BigInteger count = new BigInteger("0");
        BigInteger powerOf2 = new BigInteger("1");

        for (int i = 1; i <= 64; i++) {
            count = count.add(powerOf2);
            powerOf2 = powerOf2.shiftLeft(1);
        }

        return count;
    }

}
