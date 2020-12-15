package me.stefan923.memorygame;

import java.util.ArrayList;

public class ImageMemoryModel {

    private int score = 0;

    private ArrayList<Card> cards = new ArrayList<>();

    public ImageMemoryModel() {

    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

}
