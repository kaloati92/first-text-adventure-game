import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel;
    JPanel startButtonPanel;
    JPanel mainTextPanel;
    JPanel choiceButtonPanel;
    JPanel playerPanel;
    JLabel titleNameLabel;
    JLabel hpLabel;
    JLabel hpLabelNumber;
    JLabel weaponLabel;
    JLabel weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 40);
    JButton starButton;
    JButton choice1;
    JButton choice2;
    JButton choice3;
    JButton choice4;
    JTextArea mainTextArea;
    TitleScreenHandler titleScreenHandler = new TitleScreenHandler();
    int playerHp;
    int monsterHp;
    String weapon;
    String position;
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 300, 160);
        startButtonPanel.setBackground(Color.black);

        starButton = new JButton("Start");
        starButton.setBackground(Color.black);
        starButton.setForeground(Color.white);
        starButton.setFont(normalFont);
        //Ez csiálja a startból a creategamescreen-t.
        starButton.addActionListener(titleScreenHandler);

        //a kijelölés eltűnik mikor nem vagy rajta egérrel.
        starButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(starButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen() {
        //előző panelek eltüntetése.
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Placeholder for mainTextArea");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        //Hogy egymás alatt legyenek a választási lehetőségek.
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

        window.revalidate();
        window.repaint();
    }

    public void playerSetup() {
        playerHp = 15;
        monsterHp = 20;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHp);

        townGate();
    }

    public void townGate() {
        position = "townGate";

        mainTextArea.setText("You are at the gate of the town. \nA guard standing in front of you. \n\nWhat do you do?");

        choice1.setText("Talk to the guard.");
        choice2.setText("Attack the guard.");
        choice3.setText("Leave.");
        choice4.setText("");
    }

    public void talkGuard() {
        position = "talkGuard";

        mainTextArea.setText("Guard: Hello stranger. I have never seen your face. I'm sorry but we cannot let a stranger enter our town.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard() {
        position = "attackGuard";

        mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard fought back and hit you hard\n(You receive 3 damage)");
        playerHp = playerHp - 3;
        hpLabelNumber.setText("" + playerHp);


        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad() {
        position = "crossRoads";
        mainTextArea.setText("you re at a crossroad.\nIf you go south, you will go back to the town.");

        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go West");
        choice4.setText("Go South");
    }

    public void north() {
        position = "north";
        mainTextArea.setText("There is a river.\nYou drink the water and rest at the riverside.\n\n(Your HP is recovered by 2)");
        playerHp = playerHp + 2;
        hpLabelNumber.setText("" + playerHp);

        choice1.setText("Go South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east() {
        position = "east";
        mainTextArea.setText("You walk into a forest and found a Long Sword.\n\n(You obtained a Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);

        choice1.setText("Go West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void west() {
        position = "west";
        mainTextArea.setText("You encounter a goblin!");

        choice1.setText("Fight!");
        choice2.setText("Run!");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight(){
        position = "fight";
        mainTextArea.setText("MonsterHp" + monsterHp + "\n\nWhat do you do?");

        choice1.setText("Attack");
        choice2.setText("Run!");
        choice3.setText("");
        choice4.setText("");
    }

    public class TitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            createGameScreen();

        }
    }

    public class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String yourChoice = e.getActionCommand();

            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            talkGuard();
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                        case "c4":

                            break;
                    }
                    break;
                case "talkGuard":
                    switch (yourChoice) {
                        //vissza az előző helyre
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "crossRoads":
                    switch (yourChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            west();
                            break;
                        case "c4":
                            townGate();
                            break;
                    }
                    break;
                case "north":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "west":
                    switch (yourChoice){
                        case "c1":

                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
            }
        }
    }
}