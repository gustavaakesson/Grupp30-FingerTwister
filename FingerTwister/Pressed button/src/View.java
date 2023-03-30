import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import javax.swing.*;


public class View extends JFrame implements KeyListener  {

    private JPanel panel;
    private Controller controller;
    private boolean timesUp = false;
    private int keyCount;

    public View(Controller controller) {
        this.controller = controller;
        this.setSize(500,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        String[] arr = controller.getArr();

        for (String s : arr) {
            JButton button = new JButton(s);
            button.addKeyListener(this);
            panel.add(button);
            controller.getButtonArr().add(button);
        }

        //addButtons();
        this.setLocationRelativeTo(null);
        panel.addKeyListener(this);

        this.add(panel);
        this.setVisible(true);
    }

    //Kod för att skapa alla JButtons separat, detta görs nu av controllern och behövs ej längre.
    /*private void addButtons() {
        buttonQ = new JButton();
        buttonQ.addKeyListener(this);
        panel.add(buttonQ);

        buttonW = new JButton();
        buttonW.addKeyListener(this);
        panel.add(buttonW);

        buttonE = new JButton();
        buttonE.addKeyListener(this);
        panel.add(buttonE);

        buttonR = new JButton();
        buttonR.addKeyListener(this);
        panel.add(buttonR);

        buttonT = new JButton();
        buttonT.addKeyListener(this);
        panel.add(buttonT);

        buttonY = new JButton();
        buttonY.addKeyListener(this);
        panel.add(buttonY);

        buttonU = new JButton();
        buttonU.addKeyListener(this);
        panel.add(buttonU);

        buttonI = new JButton();
        buttonI.addKeyListener(this);
        panel.add(buttonI);

        buttonO = new JButton();
        buttonO.addKeyListener(this);
        panel.add(buttonO);

        buttonP = new JButton();
        buttonP.addKeyListener(this);
        panel.add(buttonP);

        buttonDOWN = new JButton();
        buttonDOWN.addKeyListener(this);

        buttonRIGHT = new JButton();
        buttonRIGHT.addKeyListener(this);

        buttonUP = new JButton();
        buttonUP.addKeyListener(this);

        buttonLEFT = new JButton();
        buttonLEFT.addKeyListener(this);

        buttonDOWN = new JButton();
        buttonDOWN.addKeyListener(this);

        buttonRIGHT = new JButton();
        buttonRIGHT.addKeyListener(this);

        buttonUP = new JButton();
        buttonUP.addKeyListener(this);

        buttonLEFT = new JButton();
        buttonLEFT.addKeyListener(this);

        buttonDOWN = new JButton();
        buttonDOWN.addKeyListener(this);

        buttonRIGHT = new JButton();
        buttonRIGHT.addKeyListener(this);

        buttonUP = new JButton();
        buttonUP.addKeyListener(this);

        buttonLEFT = new JButton();
        buttonLEFT.addKeyListener(this);

        buttonDOWN = new JButton();
        buttonDOWN.addKeyListener(this);

        buttonRIGHT = new JButton();
        buttonRIGHT.addKeyListener(this);

        buttonUP = new JButton();
        buttonUP.addKeyListener(this);

        buttonQ = new JButton();
        buttonQ.addKeyListener(this);*/
    @Override
    public void keyTyped(KeyEvent e) {

        System.out.println(e.getKeyChar());
/*
        for (JButton button : controller.getButtonArr()) {

            if(Objects.equals(button.getText(), String.valueOf(e.getKeyChar()))) {

                if (button == controller.getLitButton1()) {
                    button.setBackground(Color.GREEN);
                    break;
                }

                if (button == controller.getLitButton2()) {
                    button.setBackground(Color.GREEN);
                    break;
                }
                keyCount++;
            }
        }*/
    }

    @Override
    public void keyPressed(KeyEvent e) {

    if (timesUp){
        String name = JOptionPane.showInputDialog(null, "Times Up! Your score = " + keyCount + " Enter your name: ");
        try {
            controller.setNewScore(name ,keyCount);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    System.out.println(e.getKeyChar());

        for (JButton button : controller.getButtonArr()) {

            if(Objects.equals(button.getText(), String.valueOf(e.getKeyChar()))) {


                if (button == controller.getLitButton1()) {
                    button.setBackground(Color.GREEN);
                    controller.newButton(button);
                    keyCount++;
                    break;
                }

                if (button == controller.getLitButton2()) {

                    button.setBackground(Color.GREEN);
                    controller.newButton(button);
                    keyCount++;
                    break;
                }

                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                break;
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

        for (JButton button : controller.getButtonArr()) {

            if (button.getText().equals(String.valueOf(e.getKeyChar()))) {
                button.setBackground(null);

            }
        }
    }

    public void buttonLightUp(JButton lightUpButton){
        lightUpButton.setBackground(Color.YELLOW);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public boolean isTimesUp() {
        return timesUp;
    }

    public void setTimesUp(boolean timesUp) {
        this.timesUp = timesUp;
    }
}
