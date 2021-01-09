package me.stefan923.memorygame.homepage;

import me.stefan923.memorygame.game.ImageMemoryMVC;

/**
 * Home page's model class
 *
 * @author  Popescu Stefan
 */
public class HomePageModel {

    /**
     * Creates a new instance of ImageMemoryMVC - game's frame
     *
     * @param size of game board
     */
    public void openGame(int size) {
        new ImageMemoryMVC(size);
    }

}
