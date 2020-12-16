package me.stefan923.memorygame.homepage;

import me.stefan923.memorygame.game.ImageMemoryMVC;

public class HomePageModel {

    public void openGame(int size) {
        new ImageMemoryMVC(size);
    }

}
