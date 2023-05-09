package view;

import controller.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

public class GamePanel extends JPanel implements KeyListener {
    private View view;
    //private String[] arr = new String [] {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a",
                     // "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};


    public GamePanel(View view){
        this.view = view;
        this.setSize(new Dimension(480, 250));
        setBounds(200,200,200,200);
        this.setBorder(new LineBorder(Color.BLACK));

        view.add(this);
        createKeyboard();
        //this.addButtons();
        this.setVisible(true);
    }

    public void createKeyboard(){
        /*
        for (int i = 0; i < arr.length; ++i) {
            String s = arr[i];
            JButton button = new JButton(s);
            button.addKeyListener(this);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setVisible(true);
            this.add(button);
        }*/
        this.setLayout(new GridBagLayout());

        JPanel pRow;
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1d;

        for (int row = 0; row < view.getController().getArr().length; ++row) {
            pRow = new JPanel(new GridBagLayout());

            c.gridy = row;

            for (int col = 0; col < view.getController().getArr()[row].length; ++col){
                JButton button = new JButton(view.getController().getArr()[row][col]);
                pRow.add(button);
                view.getController().getButtonArr().add(button);
                button.addKeyListener(this);
            }

            this.add(pRow, c);
        }
    }
    public void something(){
        System.out.println("Nu är den i gamePanel");
    }
/*
    private void addButtons() {
        String[][] arr = view.getController().getArr();

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

 */
    public void makeLitButton(JButton lightUpButton) {
        lightUpButton.setBackground(Color.YELLOW);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("You typed: "+e.getKeyChar());

    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("You pressed: "+e.getKeyChar());

        if (view.isTimesUp()) {
            String name = JOptionPane.showInputDialog(null, "Times Up! Your score = " + view.getController().getKeyCount() + " Enter your name: ");
            try {
                view.getController().setNewScore(name, view.getController().getKeyCount());
            } catch (IOException var4) {
                throw new RuntimeException(var4);
            }

        }

        System.out.println(e.getKeyChar());

        for (JButton button : view.getController().getButtonArr()) {
            if (button.getText().equalsIgnoreCase(String.valueOf(e.getKeyChar()))   ) {
                if (button == view.getController().getLitButton1()) {
                    button.setBackground(Color.GREEN);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    view.getController().setKeyCount(view.getController().getKeyCount() + 1);
                } else if (button == view.getController().getLitButton2()) {
                    button.setBackground(Color.GREEN);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    view.getController().setKeyCount(view.getController().getKeyCount() + 1);
                } else {
                    JOptionPane.showMessageDialog(null, "You missed the button, You lose!");
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
                    button.setBackground(null);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    view.getController().newButton(button);

                } else if (button == view.getController().getLitButton2()) {
                    button.setBackground(null);
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
