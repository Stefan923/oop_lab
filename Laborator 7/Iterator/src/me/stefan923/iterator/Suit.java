package me.stefan923.iterator;

public enum Suit {
    DIAMONDS(1),
    CLUBS(2),
    HEARTS(3),
    SPADES(4);

    private final int num;

    Suit(int num) {
        this.num = num;
    }

    public int toInt() {
        return num;
    }
}
