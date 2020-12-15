package me.stefan923.memorygame;

public class ImageMemoryMVC {

    public ImageMemoryMVC() {
        ImageMemoryModel model = new ImageMemoryModel();
        ImageMemoryView view = new ImageMemoryView(model);
        ImageMemoryController controller = new ImageMemoryController(model, view);
    }

}
