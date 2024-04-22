package refactor_classes_ver_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UIManager {
    private JFrame window;
    private JPanel titlePanel, gamePanel, controlPanel;
    private JLabel titleNameLabel;
    private JButton startButton, choice1, choice2, choice3, choice4;
    private JTextArea gameTextArea;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    public UIManager(ActionListener choiceHandler) {
        createMainWindow();
        createTitleScreen(choiceHandler);
        createGameScreen(choiceHandler);
    }

    private void createMainWindow() {
        window = new JFrame("Adventure Game");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
    }

    private void createTitleScreen(ActionListener choiceHandler) {
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titlePanel.add(titleNameLabel);

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("start");
        startButton.setFocusPainted(false);
        startButton.setBounds(300, 400, 300, 60);

        window.add(titlePanel);
        window.add(startButton);
    }

    private void createGameScreen(ActionListener choiceHandler) {
        gamePanel = new JPanel();
        gamePanel.setBounds(100, 100, 600, 250);
        gamePanel.setBackground(Color.black);
        window.add(gamePanel);

        gameTextArea = new JTextArea("Welcome to the Adventure!");
        gameTextArea.setBounds(100, 100, 600, 250);
        gameTextArea.setBackground(Color.black);
        gameTextArea.setForeground(Color.white);
        gameTextArea.setFont(normalFont);
        gameTextArea.setLineWrap(true);
        gameTextArea.setWrapStyleWord(true);
        gameTextArea.setEditable(false);
        gamePanel.add(gameTextArea);

        controlPanel = new JPanel();
        controlPanel.setBounds(100, 400, 600, 100);
        controlPanel.setLayout(new GridLayout(1, 4));
        controlPanel.setBackground(Color.black);
        createControlButtons(choiceHandler);
        window.add(controlPanel);
    }

    private void createControlButtons(ActionListener choiceHandler) {
        choice1 = new JButton("Choice 1");
        choice2 = new JButton("Choice 2");
        choice3 = new JButton("Choice 3");
        choice4 = new JButton("Choice 4");
        JButton[] buttons = {choice1, choice2, choice3, choice4};

        int i = 1;
        for (JButton button : buttons) {
            button.setActionCommand("c" + i);
            button.addActionListener(choiceHandler);
            button.setBackground(Color.black);
            button.setForeground(Color.white);
            button.setFont(normalFont);
            controlPanel.add(button);
            i++;
        }
    }

    public void showTitleScreen() {
        titlePanel.setVisible(true);
        startButton.setVisible(true);
        gamePanel.setVisible(false);
        controlPanel.setVisible(false);
    }

    public void showGameScreen() {
        titlePanel.setVisible(false);
        startButton.setVisible(false);
        gamePanel.setVisible(true);
        controlPanel.setVisible(true);
    }
}

