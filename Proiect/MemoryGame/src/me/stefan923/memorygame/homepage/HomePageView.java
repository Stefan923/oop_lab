package me.stefan923.memorygame.homepage;

import me.stefan923.memorygame.StyledJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePageView extends JFrame {

    JButton btnEasy = new StyledJButton("Easy").getButton();
    JButton btnMedium = new StyledJButton("Medium").getButton();
    JButton btnHard = new StyledJButton("Hard").getButton();
    JButton btnImpossible = new StyledJButton("Impossible").getButton();

    public HomePageView() {
        btnEasy.setBackground(new Color(0x73E600));
        btnMedium.setBackground(new Color(0xE6E600));
        btnHard.setBackground(new Color(0xFF9900));
        btnImpossible.setBackground(new Color(0xE60000));

        JPanel content = new JPanel();
        content.add(btnEasy);
        content.add(btnMedium);
        content.add(btnHard);
        content.add(btnImpossible);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Memory Game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addEasyBtnListener(ActionListener actionListener) {
        btnEasy.addActionListener(actionListener);
    }

    public void addMediumBtnListener(ActionListener actionListener) {
        btnMedium.addActionListener(actionListener);
    }

    public void addHardBtnListener(ActionListener actionListener) {
        btnHard.addActionListener(actionListener);
    }

    public void addImpossibleBtnListener(ActionListener actionListener) {
        btnImpossible.addActionListener(actionListener);
    }

}
