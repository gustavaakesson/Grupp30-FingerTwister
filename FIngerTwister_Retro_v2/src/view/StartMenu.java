package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu {
    public StartMenu() {

        JFrame frame = new JFrame();
        frame.setLayout(null);

        JButton multiplayerButton = new JButton("Multiplayer");
        multiplayerButton.setBounds(120, 200, 600, 80);
        frame.add(multiplayerButton);

        JButton singlePlayerButton = new JButton("Single-player");
        singlePlayerButton.setBounds(120, 600, 600, 80);
        frame.add(singlePlayerButton);

        JLabel titel = new JLabel("FingerTwister");
        Font font = new Font("SansSerif", Font.PLAIN, 100);
        titel.setFont(font);
        titel.setBounds(625, 20, 800 , 100);
        frame.add(titel);

        JLabel scoreboardTitle = new JLabel("Scoreboard");
        Font scoreboardfont = new Font("SansSerif", Font.PLAIN, 50);
        scoreboardTitle.setFont(scoreboardfont);
        scoreboardTitle.setBounds(1400, 170, 400, 50);
        frame.add(scoreboardTitle);


        JTextArea scoreboard = new JTextArea();
        scoreboard.setBounds(1400, 230, 400, 700);
        frame.add(scoreboard);





        JLabel multiPlayerDescription = new JLabel(
                "<html>In this version of Twister, you will play against one opponent.<br>"
                        + "The game will prompt you to press various keys on your keyboard that correspond to different body parts and colors.<br>"
                        + "For example, you will both be instructed to place your finger on the key glowing in your color, whoever last the longest win!<br>"
                        + "So get ready to have ur fingers twisted ");

        multiPlayerDescription.setBounds(120, 290, 1000, 80);
        frame.add(multiPlayerDescription);

        JLabel singlePlayerDescription = new JLabel(
                "<html>With simple gameplay and a fast-paced soundtrack, Keyboard Rush is a fun and addictive game that will test your typing skills and reflexes.<br>"
                        + "So, get ready to hit the keys and try to top the leaderboard!");

        singlePlayerDescription.setBounds(120, 680, 900, 80);
        frame.add(singlePlayerDescription);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        multiplayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent multiPlayerPressed) {
                frame.setVisible(false);
                new VersionPanel();
            }
        });

        singlePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent singlePlayerPressed) {
                frame.setVisible(false);
                new VersionPanel();
            }
        });
    }
}
