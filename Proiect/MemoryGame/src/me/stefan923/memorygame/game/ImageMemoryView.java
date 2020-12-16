package me.stefan923.memorygame.game;

import javax.swing.*;
import java.awt.*;

public class ImageMemoryView extends JFrame {

    ImageMemoryModel model;

    JTextField fieldScore = new JTextField(10);

    JButton btnRetry = new StyledJButton("Retry").getButton();

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

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
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
