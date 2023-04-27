package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownPanel extends JPanel implements ActionListener  {

    private Timer timer;
    private JLabel countdownLabel;
    private Controller controller;

    public CountdownPanel(Controller controller, View view) {
        countdownLabel = new JLabel();
        countdownLabel.setText("Countdown");

        this.setSize(300, 200);


        // Create the countdown label
        countdownLabel = new JLabel("5");
        countdownLabel.setFont(countdownLabel.getFont().deriveFont(64.0f));
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(countdownLabel);

        // Create the timer
        timer = new Timer(1000, new ActionListener() {
            int count = 1;
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count >= 1) {
                    countdownLabel.setText(Integer.toString(count));
                } else {
                    countdownLabel.setText("0");
                    timer.stop();
                    controller.startGame();
                    countdownLabel.setText("Time to play");
                }
            }
        });
        timer.start();
        setVisible(true);
    }
    /*
    public void startCountDown() {
        this.timer.start();
        this.thread = new Thread(this);
    }

     */

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
