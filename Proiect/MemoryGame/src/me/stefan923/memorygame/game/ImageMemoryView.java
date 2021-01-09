package me.stefan923.memorygame.game;

import me.stefan923.memorygame.StyledJButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Game window's view
 *
 * @author Popescu Stefan
 */
public class ImageMemoryView extends JFrame {

    private final ImageMemoryModel model;

    private final JTextField fieldScore = new JTextField(10);

    private final JButton btnRetry = new StyledJButton("Retry").getButton();
    private final HashMap<String, JButton> btnCards = new HashMap<>();

    private JPanel panelBoard;

    /**
     * ImageMemoryView's constructor
     *
     * @param model of game window
     */
    public ImageMemoryView(ImageMemoryModel model) {
        this.model = model;

        int boardSize = model.getSize();
        JPanel gameBoard = new JPanel();
        gameBoard.setLayout(new GridLayout(boardSize, boardSize));
        loadBoardGame();

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(panelBoard);
        content.add(getButtonsPanel());

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2,
                dimension.height / 2 - this.getSize().height / 2);
        this.setTitle("Memory Game");
    }

    /**
     * Returns the retry button and score text field panel
     *
     * @return score and retry button panel
     */
    private JPanel getButtonsPanel() {
        JPanel fieldScorePanel = new JPanel(new FlowLayout());
        fieldScorePanel.add(fieldScore);
        fieldScorePanel.setBorder(new EmptyBorder(0, 0, 5, 0));

        JPanel btnRetryPanel = new JPanel(new FlowLayout());
        btnRetryPanel.add(btnRetry);
        btnRetryPanel.setBorder(new EmptyBorder(5, 0, 0, 0));

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.add(fieldScorePanel);
        buttonsPanel.add(btnRetryPanel);
        buttonsPanel.setMinimumSize(new Dimension(40, 0));

        fieldScore.setText(String.valueOf(model.getScore()));
        fieldScore.setEditable(false);

        return buttonsPanel;
    }

    /**
     * Loads the game board - creates JButtons for each card
     */
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

    /**
     * Sets the score text field
     *
     * @param score - player's current score
     */
    public void setFieldScore(int score) {
        fieldScore.setText(String.valueOf(score));
    }

    /**
     * Returns a hashmap with all buttons and an unique key for each button
     *
     * @return buttons hashmap
     */
    public HashMap<String, JButton> getBtnCards() {
        return btnCards;
    }

    /**
     * Adds an action listener for buttons of each card
     *
     * @param actionListener
     */
    public void addCardsListener(ActionListener actionListener) {
        for (JButton jButton : btnCards.values()) {
            jButton.addActionListener(actionListener);
        }
    }

    /**
     * Adds an action listener for btnRetry variable
     *
     * @param actionListener
     */
    public void addResetListener(ActionListener actionListener) {
        btnRetry.addActionListener(actionListener);
    }

    /**
     * Resets all view fields
     */
    public void reset() {
        setFieldScore(model.getScore());
        getBtnCards().clear();

        panelBoard.removeAll();
        loadBoardGame();

        this.pack();
    }

}
