package me.stefan923.memorygame.game;

import javax.swing.*;
import java.awt.*;

public class ImageMemoryView extends JFrame {

    ImageMemoryModel model;

    JTextField fieldScore = new JTextField();

    JButton btnRetry = new StyledJButton("Retry").getButton();

    public ImageMemoryView(ImageMemoryModel model) {
        this.model = model;

        int boardSize = model.getSize();
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(boardSize, boardSize));

        JPanel panelScore = new JPanel();
        panelScore.setLayout(new FlowLayout());
        panelScore.add(fieldScore);
        fieldScore.setText(String.valueOf(model.getScore()));
        fieldScore.setEditable(false);

        JPanel panelRetry = new JPanel();
        panelScore.setLayout(new FlowLayout());
        panelScore.add(btnRetry);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1));
        rightPanel.add(panelScore);
        rightPanel.add(panelRetry);

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1, 2));
        content.add(gameBoardToJPanel());
        content.add(rightPanel);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Memory Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel gameBoardToJPanel() {
        Card[][] gameBoard = model.getGameBoard();
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(gameBoard.length, gameBoard.length));

        for (int i = 0; i < gameBoard.length; ++i) {
            for (int j = 0; j < gameBoard[i].length; ++j) {
                JButton button = new JButton(gameBoard[i][j].getImageIcon());
                button.setContentAreaFilled(false);
                boardPanel.add(button);
            }
        }

        return boardPanel;
    }

}
