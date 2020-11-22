package me.stefan923.iterator;

import org.junit.Assert;
import org.junit.Test;

public class DeckTests {

    @Test
    public void put() {
        Deck deck = new Deck();

        Assert.assertEquals(0, deck.put(new Card('K', Suit.CLUBS)));
        Assert.assertEquals(0, deck.put(new Card('K', Suit.DIAMONDS)));
        Assert.assertEquals(2, deck.put(new Card('K', Suit.SPADES)));
        Assert.assertEquals(2, deck.put(new Card('K', Suit.HEARTS)));
        Assert.assertEquals(1, deck.put(new Card('Q', Suit.CLUBS)));
    }

    @Test
    public void putRemove() {
        Deck deck = new Deck();

        deck.put(new Card('K', Suit.CLUBS));
        deck.put(new Card('K', Suit.DIAMONDS));

        deck.remove();
        Assert.assertTrue(deck.hasNext());
        Assert.assertEquals(Suit.CLUBS, ((Card) deck.next()).getSuit());
        Assert.assertFalse(deck.hasNext());
    }

}
