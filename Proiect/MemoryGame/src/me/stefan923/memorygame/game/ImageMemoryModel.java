package me.stefan923.memorygame.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ImageMemoryModel {

    private int score = 0;

    private int size;
    private Card[][] gameBoard;

    public ImageMemoryModel(int size) {
        this.size = size;
        generateBoard();
    }

    private void generateBoard() {
        gameBoard = new Card[size][size];
        int numCards = size * size;

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            int id = getRandomNumber(0, numCards / 2);
            if (cards.stream().noneMatch(card -> card.getId() == id)) {
                cards.add(new Card(id, null));
                cards.add(new Card(id, null));
            }
        }

        Collections.shuffle(cards);

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                gameBoard[i][j] = cards.remove(0);
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                        .findFirst()
                        .getAsInt();
    }

    public int getSize() {
        return size;
    }

    public Card[][] getGameBoard() {
        return gameBoard;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

}
