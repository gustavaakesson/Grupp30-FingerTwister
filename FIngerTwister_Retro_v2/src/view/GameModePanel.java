package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameModePanel extends JPanel implements ActionListener {
    private View view;
    private ArrayList<String> choices = new ArrayList<>();
    public GameModePanel(View view) {
        this.view = view;

        JButton startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setPreferredSize(new Dimension(300,100));
        this.add(startButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null ,"You started the game");
    }
}
