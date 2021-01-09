package me.stefan923.memorygame.game;

/**
 * Game window's mvc
 *
 * @author Popescu Stefan
 */
public class ImageMemoryMVC {

    /**
     * ImageMemoryMVC's constructor
     *
     * @param size of game board
     */
    public ImageMemoryMVC(int size) {
        ImageMemoryModel model = new ImageMemoryModel(size);
        ImageMemoryView view = new ImageMemoryView(model);
        ImageMemoryController controller = new ImageMemoryController(model, view);

        view.setVisible(true);
    }

}
