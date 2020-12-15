package me.stefan923.memorygame;

public class ImageMemoryMVC {

    public ImageMemoryMVC() {
        int size = 4;

        ImageMemoryModel model = new ImageMemoryModel(size);
        ImageMemoryView view = new ImageMemoryView(model);
        ImageMemoryController controller = new ImageMemoryController(model, view);
    }

}
