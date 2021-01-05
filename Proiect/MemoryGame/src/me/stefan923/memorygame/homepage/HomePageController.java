package me.stefan923.memorygame.homepage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageController {

    private final HomePageModel model;

    public HomePageController(HomePageModel model, HomePageView view) {
        this.model = model;

        view.addEasyBtnListener(new LevelSelectListener(4));
        view.addMediumBtnListener(new LevelSelectListener(6));
        view.addHardBtnListener(new LevelSelectListener(8));
        view.addImpossibleBtnListener(new LevelSelectListener(10));
    }

    class LevelSelectListener implements ActionListener {

        int size = 4; // default = 4

        public LevelSelectListener(int size) {
            this.size = size;
        }

        public void actionPerformed(ActionEvent e) {
            model.openGame(size);
        }

    }

}
