package me.stefan923.memorygame.game;

import javax.swing.*;

/**
 * Card class - contains an image icon and an id
 *
 * @author Popescu Stefan
 */
public class Card {

    private final int id;
    private final ImageIcon imageIcon;

    private boolean turned = false;
    private boolean solved = false;

    private int score = 100; // initial score for any card

    /**
     * Card's constructor
     *
     * @param id - card's unique id
     * @param imageIcon - card's display image
     */
    public Card(int id, ImageIcon imageIcon) {
        this.id = id;
        this.imageIcon = imageIcon;
    }

    /**
     * Returns card's id (integer)
     *
     * @return card's id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns card's image icon
     * @return image icon
     */
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    /**
     * Returns if the card is siwtched or not
     *
     * @return boolean
     */
    public boolean isTurned() {
        return turned;
    }


    /**
     * Returns if the card was matched or not
     *
     * @return boolean
     */
    public boolean isSolved() {
        return solved;
    }

    /**
     * Switches the card
     */
    public void setTurned() {
        this.turned = !turned;
    }

    /**
     * Marks the card as solved
     */
    public void setSolved() {
        this.solved = !solved;
    }

    /**
     * Returns card's current score
     *
     * @return card's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Decreases card's current score
     */
    public void decreaseScore() {
        if (score >= 10) {
            score -= 5;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        return id == ((Card) o).id;
    }

}
