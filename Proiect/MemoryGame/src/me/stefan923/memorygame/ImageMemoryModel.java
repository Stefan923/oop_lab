package me.stefan923.memorygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ImageMemoryModel {

    private int score = 0;

    private int size;
    private Card[][] board;

    public ImageMemoryModel(int size) {
        this.size = size;
        generateBoard();
    }

    private void generateBoard() {
        board = new Card[size][size];
        int numCards = size * size;

        List<Card> cards = new ArrayList<>();
        while (numCards > 0) {
            int id = getRandomNumber(0, size / 2);
            if (cards.stream().filter(card -> card.getId() == id).count() == 0) {
                cards.add(new Card(id, null));
                cards.add(new Card(id, null));
                numCards++;
            }
        }

        Collections.shuffle(cards);

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = cards.remove(0);
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                        .findFirst()
                        .getAsInt();
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

}
