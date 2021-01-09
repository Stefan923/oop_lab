package me.stefan923.memorygame.homepage;

import me.stefan923.memorygame.StyledJButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Home page's view class
 *
 * @author  Popescu Stefan
 */
public class HomePageView extends JFrame {

    JButton btnEasy = new StyledJButton("Easy").getButton();
    JButton btnMedium = new StyledJButton("Medium").getButton();
    JButton btnHard = new StyledJButton("Hard").getButton();
    JButton btnImpossible = new StyledJButton("Impossible").getButton();

    /**
     * HomePageView's constructor
     */
    public HomePageView() {
        btnEasy.setBackground(new Color(0x73E600));
        btnMedium.setBackground(new Color(0xE6E600));
        btnHard.setBackground(new Color(0xFF9900));
        btnImpossible.setBackground(new Color(0xE60000));

        JPanel content = new JPanel(new BorderLayout());
        content.add(getLogoPanel(), BorderLayout.NORTH);
        content.add(getButtonsPanel(), BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(520, 420));
        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2,
                dimension.height / 2 - this.getSize().height / 2);
        this.setTitle("Memory Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates and returns the logo panel
     *
     * @return logo panel
     */
    private JPanel getLogoPanel() {
        JPanel logoPanel = new JPanel(new FlowLayout());
        logoPanel.setBorder(new EmptyBorder(30, 0, 50, 0));
        Image image;

        try {
            image = ImageIO.read(getClass().getResource("/logo.png"))
                    .getScaledInstance(360, 200, Image.SCALE_SMOOTH);
            logoPanel.add(new JLabel(new ImageIcon(image)));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return logoPanel;
    }

    /**
     * Creates and returns the buttons panel
     *
     * @return buttons panel
     */
    private JPanel getButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(getSingleButtonPanel(btnEasy));
        buttonsPanel.add(getSingleButtonPanel(btnMedium));
        buttonsPanel.add(getSingleButtonPanel(btnHard));
        buttonsPanel.add(getSingleButtonPanel(btnImpossible));

        return buttonsPanel;
    }

    /**
     * Creates and returns a panel for a specific button
     *
     * @param button
     * @return single button panel
     */
    private JPanel getSingleButtonPanel(JButton button) {
        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(button);
        btnPanel.setBorder(new EmptyBorder(0, 3, 0, 3));

        return btnPanel;
    }

    /**
     * Adds an action listener for btnEasy variable
     *
     * @param actionListener
     */
    public void addEasyBtnListener(ActionListener actionListener) {
        btnEasy.addActionListener(actionListener);
    }

    /**
     * Adds an action listener for btnMedium variable
     *
     * @param actionListener
     */
    public void addMediumBtnListener(ActionListener actionListener) {
        btnMedium.addActionListener(actionListener);
    }

    /**
     * Adds an action listener for btnHard variable
     *
     * @param actionListener
     */
    public void addHardBtnListener(ActionListener actionListener) {
        btnHard.addActionListener(actionListener);
    }

    /**
     * Adds an action listener for btnImpossible variable
     *
     * @param actionListener
     */
    public void addImpossibleBtnListener(ActionListener actionListener) {
        btnImpossible.addActionListener(actionListener);
    }

}
