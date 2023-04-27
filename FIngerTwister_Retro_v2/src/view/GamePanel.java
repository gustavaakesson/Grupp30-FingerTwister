package view;

import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

public class GamePanel extends JPanel implements KeyListener {
    private View view;
    private String[] arr = new String [] {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private int keyCount;


    public GamePanel(View view){
        this.view = view;
        this.setSize(480,250);

        view.add(this);
        this.addButtons();
        this.setVisible(true);




    }

    public void createKeyboard(){
        for (int i = 0; i < arr.length; ++i) {
            String s = arr[i];
            JButton button = new JButton(s);
            button.addKeyListener(this);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setVisible(true);
            this.add(button);
        }
    }

    private void addButtons() {
        String[] arr = view.getController().getArr();

        for (int i = 0; i < arr.length; ++i) {
            String s = arr[i];
            JButton button = new JButton(s);
            button.addKeyListener(this);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setForeground(Color.BLACK);
            button.setBackground(Color.LIGHT_GRAY);
            button.setVisible(true);
            this.add(button);
            view.getController().getButtonArr().add(button);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("You typed: "+e.getKeyChar());

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("You pressed: "+e.getKeyChar());

        if (view.isTimesUp()) {
            String name = JOptionPane.showInputDialog(null, "Times Up! Your score = " + this.keyCount + " Enter your name: ");
            try {
                view.getController().setNewScore(name, this.keyCount);
            } catch (IOException var4) {
                throw new RuntimeException(var4);
            }

        }

        System.out.println(e.getKeyChar());

        for (JButton button : view.getController().getButtonArr()) {
            if (button.getText().equalsIgnoreCase(String.valueOf(e.getKeyChar()))) {
                if (button == view.getController().getLitButton1()) {
                    button.setBackground(Color.GREEN);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    ++this.keyCount;
                } else if (button == view.getController().getLitButton2()) {
                    button.setBackground(Color.GREEN);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    ++this.keyCount;
                } else {
                    JOptionPane.showMessageDialog(null, "You lose!");
                }
                break;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You pressed "+e.getKeyChar());

        for (JButton button : view.getController().getButtonArr()) {
            if (button.getText().equalsIgnoreCase(String.valueOf(e.getKeyChar()))) {
                if (button == view.getController().getLitButton1()) {
                    button.setBackground(Color.LIGHT_GRAY);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    view.getController().newButton(button);

                } else if (button == view.getController().getLitButton2()) {
                    button.setBackground(Color.LIGHT_GRAY);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    view.getController().newButton(button);

                }/* else {
                    //   view.getController().startCountDown();
                }
                */
                break;
            }
        }
    }

}
