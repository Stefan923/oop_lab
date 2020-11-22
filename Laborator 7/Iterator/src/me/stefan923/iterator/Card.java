package me.stefan923.iterator;

public class Card implements Comparable<Card> {

    char number;
    Suit suit;

    public Card(char number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    public char getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        if (suit.toInt() > o.suit.toInt())
            return 1;

        if (suit.toInt() == o.suit.toInt()) {
            if (number < o.number)
                return 1;
            return number == o.number ? 0 : -1;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", suit=" + suit +
                '}';
    }

}
