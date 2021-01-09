package me.stefan923.memorygame.homepage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Home page's controller class
 *
 * @author  Popescu Stefan
 */

public class HomePageController {

    private final HomePageModel model;

    /**
     * HomePageController's constructor
     *
     * @param model of home page
     * @param view of home page
     */
    public HomePageController(HomePageModel model, HomePageView view) {
        this.model = model;

        view.addEasyBtnListener(new LevelSelectListener(4));
        view.addMediumBtnListener(new LevelSelectListener(6));
        view.addHardBtnListener(new LevelSelectListener(8));
        view.addImpossibleBtnListener(new LevelSelectListener(10));
    }

    class LevelSelectListener implements ActionListener {

        int size = 4; // default = 4

        /**
         * LevelSelectListener's constructor
         *
         * @param size of game board
         */
        public LevelSelectListener(int size) {
            this.size = size;
        }

        /**
         * This method is being called on ActionEvent
         *
         * @param event - action event for JButton (level select buttons)
         */
        public void actionPerformed(ActionEvent event) {
            model.openGame(size);
        }

    }

}
