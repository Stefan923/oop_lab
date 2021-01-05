package me.stefan923.memorygame.game;

import me.stefan923.memorygame.StyledJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ImageMemoryView extends JFrame {

    private final ImageMemoryModel model;

    private final JTextField fieldScore = new JTextField(10);

    private final JButton btnRetry = new StyledJButton("Retry").getButton();
    private final HashMap<String, JButton> btnCards = new HashMap<>();

    private JPanel panelBoard;

    public ImageMemoryView(ImageMemoryModel model) {
        this.model = model;

        int boardSize = model.getSize();
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(boardSize, boardSize));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1));
        rightPanel.add(fieldScore);
        rightPanel.add(btnRetry);
        rightPanel.setMinimumSize(new Dimension(40, 0));

        fieldScore.setText(String.valueOf(model.getScore()));
        fieldScore.setEditable(false);

        loadBoardGame();

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(panelBoard);
        content.add(rightPanel);

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2,
                dimension.height / 2 - this.getSize().height / 2);
        this.setTitle("Memory Game");
    }

    private void loadBoardGame() {
        Card[][] gameBoard = model.getGameBoard();

        if (panelBoard == null) {
            panelBoard = new JPanel();
            panelBoard.setLayout(new GridLayout(gameBoard.length, gameBoard.length));
        }

        for (int i = 0; i < gameBoard.length; ++i) {
            for (int j = 0; j < gameBoard[i].length; ++j) {
                JButton button = new JButton(ImageMemoryModel.INITIAL_BTN_ICON);

                button.setContentAreaFilled(false);
                button.setActionCommand(i + "|" + j);
                btnCards.put(i + "|" + j, button);

                panelBoard.add(button);
            }
        }
    }

    public void setFieldScore(int score) {
        fieldScore.setText(String.valueOf(score));
    }

    public HashMap<String, JButton> getBtnCards() {
        return btnCards;
    }

    public void addCardsListener(ActionListener actionListener) {
        for (JButton jButton : btnCards.values()) {
            jButton.addActionListener(actionListener);
        }
    }

    public void addResetListener(ActionListener actionListener) {
        btnRetry.addActionListener(actionListener);
    }

    public void reset() {
        setFieldScore(model.getScore());
        getBtnCards().clear();

        panelBoard.removeAll();
        loadBoardGame();

        this.pack();
    }

}
