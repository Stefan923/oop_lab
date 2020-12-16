package me.stefan923.memorygame.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageMemoryController {

    ImageMemoryModel model;
    ImageMemoryView view;

    public ImageMemoryController(ImageMemoryModel model, ImageMemoryView view) {
        this.model = model;
        this.view = view;

        view.addCardsListener(new CardTurnListener());
    }

    class CardTurnListener implements ActionListener {

        private boolean wait = false;

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String[] indexes = command.split("\\|");

            int i = Integer.parseInt(indexes[0]);
            int j = Integer.parseInt(indexes[1]);

            Card card = model.getGameBoard()[i][j];
            JButton btnCard = view.getBtnCards().get(command);
            if (card.isSolved() || wait) {
                return;
            }
            if (card.isTurned()) {
                btnCard.setIcon(ImageMemoryModel.INITIAL_BTN_ICON);
                card.setTurned();
                model.setTurnedCard(null, null);
            } else if (model.getTurnedCard() == null) {
                btnCard.setIcon(card.getImageIcon());
                card.setTurned();
                model.setTurnedCard(card, btnCard);
            } else if (model.getTurnedCard().equals(card)) {
                btnCard.setIcon(card.getImageIcon());

                card.setTurned();
                card.setSolved();
                model.getTurnedCard().setSolved();
                model.setTurnedCard(null, null);
            } else {
                btnCard.setIcon(card.getImageIcon());

                revertChanges(btnCard, model.getBtnTurnedCard());
                model.getTurnedCard().setTurned();
                model.setTurnedCard(null, null);
            }
        }

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

}
