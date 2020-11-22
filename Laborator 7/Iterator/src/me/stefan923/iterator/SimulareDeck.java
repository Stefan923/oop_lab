package me.stefan923.iterator;

public class SimulareDeck {

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.put(new Card('3', Suit.DIAMONDS));
        deck.put(new Card('3', Suit.HEARTS));
        deck.put(new Card('A', Suit.DIAMONDS));

        while (deck.hasNext()) {
            System.out.println(deck.next().toString());
        }
    }

}
