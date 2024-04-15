import javax.swing.*;
import java.awt.*;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNAmePanel;
    JPanel startButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 40);
    JButton starButton;
    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNAmePanel = new JPanel();
        titleNAmePanel.setBounds(100, 100, 600,150);
        titleNAmePanel.setBackground(Color.black);

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

        titleNAmePanel.add(titleNameLabel);
        startButtonPanel.add(starButton);

        con.add(titleNAmePanel);
        con.add(startButtonPanel);
    }
}
