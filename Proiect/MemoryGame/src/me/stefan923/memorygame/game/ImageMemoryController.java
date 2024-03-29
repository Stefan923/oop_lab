package me.stefan923.memorygame.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Game window's controller
 *
 * @author Popescu Stefan
 */
public class ImageMemoryController {

    private final ImageMemoryModel model;
    private final ImageMemoryView view;

    /**
     * ImageMemoryController's constructor
     *
     * @param model of game window
     * @param view of game window
     */
    public ImageMemoryController(ImageMemoryModel model, ImageMemoryView view) {
        this.model = model;
        this.view = view;

        view.addCardsListener(new CardTurnListener());
        view.addResetListener(new ResetListener());
    }

    class CardTurnListener implements ActionListener {

        private boolean wait = false;

        /**
         * This method is being called on ActionEvent
         *
         * @param event - action event for JButton (switch cards)
         */
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            String[] indexes = command.split("\\|");

            int i = Integer.parseInt(indexes[0]);
            int j = Integer.parseInt(indexes[1]);

            Card card = model.getGameBoard()[i][j];
            Card lastCard = model.getTurnedCard();
            JButton btnCard = view.getBtnCards().get(command);
            if (card.isSolved() || wait) {
                return;
            }
            if (card.isTurned()) {
                btnCard.setIcon(ImageMemoryModel.INITIAL_BTN_ICON);
                card.setTurned();
                card.decreaseScore();
                model.setTurnedCard(null, null);
            } else if (lastCard == null) {
                btnCard.setIcon(card.getImageIcon());
                card.setTurned();
                model.setTurnedCard(card, btnCard);
            } else if (lastCard.equals(card)) {
                btnCard.setIcon(card.getImageIcon());

                card.setTurned();
                card.setSolved();
                lastCard.setSolved();
                model.setTurnedCard(null, null);
                model.addScore(card.getScore() + lastCard.getScore());
                view.setFieldScore(model.getScore());
            } else {
                btnCard.setIcon(card.getImageIcon());

                revertChanges(btnCard, model.getBtnTurnedCard());
                card.decreaseScore();
                lastCard.setTurned();
                lastCard.decreaseScore();
                model.setTurnedCard(null, null);
            }
        }

        /**
         * Automatically switches the cards back after 1 second (if they don't match)
         *
         * @param btnCard1 - first switched card
         * @param btnCard2 - second switched card
         */
        private void revertChanges(JButton btnCard1, JButton btnCard2) {
            wait = true;
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    btnCard1.setIcon(ImageMemoryModel.INITIAL_BTN_ICON);
                    btnCard2.setIcon(ImageMemoryModel.INITIAL_BTN_ICON);

                    wait = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    class ResetListener implements ActionListener {

        /**
         * This method is being called on ActionEvent - resets the game
         *
         * @param event - action event for JButton (retry button)
         */
        public void actionPerformed(ActionEvent event) {
            model.reset();
            view.reset();

            view.addCardsListener(new CardTurnListener());
        }

    }

}
