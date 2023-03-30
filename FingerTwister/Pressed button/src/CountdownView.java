import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class CountdownView extends JFrame {
    private JLabel countLabel;
    private Timer timer;
    private int count;
    private Controller controller;

    public CountdownView(Controller controller) {
        this.controller = controller;
        this.count = 5;
        this.timer = new Timer(1000, new CountdownActionListener());
        createUI();
    }

    private void createUI() {
        setTitle("Countdown");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        countLabel = new JLabel("5", SwingConstants.CENTER);
        countLabel.setFont(new Font("Arial", Font.BOLD, 72));
        mainPanel.add(countLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new StartButtonActionListener());
        mainPanel.add(startButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private class CountdownActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            count--;
            countLabel.setText(Integer.toString(count));
            if (count == 0) {
                timer.stop();
                dispose();
            }
        }
    }

    private class StartButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.start();
            controller.getThread().start();
        }
    }
}
