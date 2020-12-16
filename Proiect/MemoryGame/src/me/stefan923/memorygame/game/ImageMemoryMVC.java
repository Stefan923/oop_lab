package me.stefan923.memorygame.game;

public class ImageMemoryMVC {

    public ImageMemoryMVC(int size) {
        ImageMemoryModel model = new ImageMemoryModel(size);
        ImageMemoryView view = new ImageMemoryView(model);
        ImageMemoryController controller = new ImageMemoryController(model, view);

        view.setVisible(true);
    }

}
