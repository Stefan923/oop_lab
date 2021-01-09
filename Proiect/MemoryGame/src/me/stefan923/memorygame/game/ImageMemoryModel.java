package me.stefan923.memorygame.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Game window's model
 *
 * @author Popescu Stefan
 */
public class ImageMemoryModel {

    private int score = 0;

    private final int size;
    private Card turnedCard;
    private JButton btnTurnedCard;
    private Card[][] gameBoard;

    public static ImageIcon INITIAL_BTN_ICON;

    /**
     * ImageMemoryModel's constructor
     *
     * @param size of game board
     */
    public ImageMemoryModel(int size) {
        this.size = size;
        generateBoard();

        try {
            INITIAL_BTN_ICON = new ImageIcon(ImageIO.read(getClass().getResource("/initial_btn_icon.png"))
                    .getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Randomly generates the game board and loads selected image icons
     */
    private void generateBoard() {
        gameBoard = new Card[size][size];
        int numCards = size * size;
        int iconsCount = getIconsCount();

        List<Card> cards = new ArrayList<>();
        while (cards.size() < numCards) {
            int id = getRandomNumber(1, iconsCount);
            if (cards.stream().noneMatch(card -> card.getId() == id)) {
                try {
                    ImageIcon buttonIcon = new ImageIcon(ImageIO.read(getClass().getResource("/cards/" + id + ".png"))
                                                            .getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH));
                    cards.add(new Card(id, buttonIcon));
                    cards.add(new Card(id, buttonIcon));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Collections.shuffle(cards);

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                gameBoard[i][j] = cards.remove(0);
    }

    /**
     * Returns the numbers of available images in resources/cards directory
     *
     * @return the count of available card icons
     */
    private int getIconsCount() {
        return Objects.requireNonNull(new File("resources/cards").listFiles()).length;
    }

    /**
     * Generates a random number between two limits
     *
     * @param min - minimum value
     * @param max - maximum value
     * @return generated number
     */
    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                        .findFirst()
                        .getAsInt();
    }

    /**
     * Returns the size of game board
     *
     * @return game board's size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the last switched card
     *
     * @return card
     */
    public Card getTurnedCard() {
        return turnedCard;
    }

    /**
     * Returns the button of the last switched card
     *
     * @return card's button
     */
    public JButton getBtnTurnedCard() {
        return btnTurnedCard;
    }

    /**
     * Sets the last switched card
     *
     * @param turnedCard - the card
     * @param btnTurnedCard - card's button
     */
    public void setTurnedCard(Card turnedCard, JButton btnTurnedCard) {
        this.turnedCard = turnedCard;
        this.btnTurnedCard = btnTurnedCard;
    }

    /**
     * Returns the game board
     *
     * @return game board's matrix
     */
    public Card[][] getGameBoard() {
        return gameBoard;
    }

    /**
     * Returns player's score
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Increments player's score with specified value
     * @param score - value to add
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * Resets model's fields (retry)
     */
    public void reset() {
        score = 0;
        gameBoard = null;
        turnedCard = null;
        btnTurnedCard = null;

        generateBoard();
    }

}
