package me.stefan923.memorygame.game;

import javax.swing.*;

public class Card {

    private final int id;
    private final ImageIcon imageIcon;

    private boolean turned = false;
    private boolean solved = false;

    public Card(int id, ImageIcon imageIcon) {
        this.id = id;
        this.imageIcon = imageIcon;
    }

    public int getId() {
        return id;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public boolean isTurned() {
        return turned;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setTurned() {
        this.turned = !turned;
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
