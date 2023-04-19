//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.*;


public class CountdownView extends JFrame implements ActionListener {
    private Timer timer;
    private JLabel countdownLabel;
    private Controller controller;

    public CountdownView(Controller controller) {
        super("Countdown Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create the countdown label
        countdownLabel = new JLabel("5");
        countdownLabel.setFont(countdownLabel.getFont().deriveFont(64.0f));
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(countdownLabel);

        // Create the timer
        timer = new Timer(1000, new ActionListener() {
            int count = 5;
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count >= 1) {
                    countdownLabel.setText(Integer.toString(count));
                } else {
                    countdownLabel.setText("0");
                    timer.stop();
                    controller.startGame();
                    dispose();
                }
            }
        });
        timer.start();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
