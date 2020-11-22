package me.stefan923.iterator;

import java.util.Iterator;

public interface OrderedIterator extends Iterator {

    int put(Comparable<Card> comparable);

}
