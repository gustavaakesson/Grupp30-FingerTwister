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

public class CountdownView extends JFrame implements ActionListener {
    private JLabel countLabel;
    private Timer timer;
    private int count;
    private Controller controller;

    public CountdownView(Controller controller) {
        this.controller = controller;
        this.count = 5;
        this.createUI();
    }

    private void createUI() {
        this.setTitle("Countdown");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(3);
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.countLabel = new JLabel("5", 0);
        this.countLabel.setFont(new Font("Arial", 1, 72));
        mainPanel.add(this.countLabel, "Center");
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(this);
        mainPanel.add(startButton, "South");
        this.setContentPane(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
