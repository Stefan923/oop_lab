package me.stefan923.iterator;

import org.apache.commons.lang3.ArrayUtils;

public class Deck implements OrderedIterator {

    private final static int MAX_SIZE = 52;

    private Card[] cards;

    private int iterator;
    private int size;

    public Deck() {
        cards = new Card[MAX_SIZE];
        size = 0;
        iterator = 0;
    }

    @Override
    public Object next() {
        return cards[iterator++];
    }

    @Override
    public boolean hasNext() {
        return iterator < size;
    }

    @Override
    public void remove() {
        cards = ArrayUtils.remove(cards, iterator);
        size--;
    }

    @Override
    public int put(Comparable<Card> comparable) {
        for (int i = 0; i < size; i++) {
            int comp = comparable.compareTo(cards[i]);

            if (comp == 0)
                return i;

            if (comp < 0) {
                cards = (Card[]) ArrayUtils.add(cards, i, comparable);
                size++;
                return i;
            }
        }

        if (size < MAX_SIZE) {
            cards = (Card[]) ArrayUtils.add(cards, size++, comparable);
            return size - 1;
        }

        return -1;
    }
}
