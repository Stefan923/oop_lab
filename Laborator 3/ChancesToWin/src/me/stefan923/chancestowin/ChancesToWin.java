package me.stefan923.chancestowin;

import java.math.BigInteger;

public class ChancesToWin {

    public static void main(String[] args) {
        System.out.println("Sansele de castig la loto 6 din 49 sunt: 1 la " + calculate());
    }

    static BigInteger calculate() {
        BigInteger chances = new BigInteger("1");

        for (int i = 44; i <= 49; i++) {
            chances = chances.multiply(BigInteger.valueOf(i));
        }

        for (int i = 2; i <= 6; i++) {
            chances = chances.divide(BigInteger.valueOf(i));
        }

        return chances;
    }

}
