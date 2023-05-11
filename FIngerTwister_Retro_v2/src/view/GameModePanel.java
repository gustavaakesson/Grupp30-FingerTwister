package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameModePanel extends JPanel implements ActionListener {
    private View view;
    private ArrayList<String> choices = new ArrayList<>();
    private JButton startButton;
    private int count = 5;
    private Timer secTimer;
    public GameModePanel(View view) {
        this.view = view;

        startButton = new JButton("Start");
        startButton.setFont(new Font("Font.ITALIC",Font.ITALIC,54));
        startButton.addActionListener(this);
        startButton.setPreferredSize(new Dimension(300,100));
        this.add(startButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton){
            startButton.setText("5");
            secTimer = new Timer(1000,this);
            secTimer.start();
        }
        if (e.getSource() instanceof Timer){
            count--;
            startButton.setText(String.valueOf(count));
            if (count == 0 || count < 0){
                secTimer.stop();
                startButton.setText("STOP");
                // TODO: Istället för att starta ett nytt spel ska man skickas tillbaka till GameModePanel
                // transferFocus används för att ge fokus till GamePanel i fönstret för att den ska lyssna efter keystrokes.
                view.getGamePanel().transferFocus();
                //view.getGamePanel().createKeyboard();
                //view.setGamePanel(new GamePanel(view));
                view.getController().startGame();


            }
        }
    }
}
