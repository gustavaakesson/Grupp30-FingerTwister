package view;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private GamePanel gamePanel;
    private String[] arr = new String [] {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private int keyCount;
    private View view;


    public GamePanel(View view){
        this.view = view;
        gamePanel.setSize(500,500);

        view.add(this);
        gamePanel.createKeyboard();
        gamePanel.setVisible(true);




    }

    public void createKeyboard(){
        for (int i = 0; i < arr.length; ++i) {
            String s = arr[i];
            JButton button = new JButton(s);
            button.addKeyListener(this);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setVisible(true);
            this.gamePanel.add(button);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("You typed: "+e.getKeyChar());

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("You pressed: "+e.getKeyChar());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You pressed "+e.getKeyChar());

    }

}
