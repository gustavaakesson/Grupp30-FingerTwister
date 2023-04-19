import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class View extends JFrame implements KeyListener {

    private JPanel panel;
    private JButton buttonQ;
    private JButton buttonW;
    private JButton buttonE;
    private JButton buttonR;
    private JButton buttonT;
    private JButton buttonY;
    private JButton buttonU;

    private JButton buttonI;

    private JButton buttonO;
    private JButton buttonP;
    private ArrayList<JButton> buttonArr;
    private String[] arr;
    public View() {
        this.setSize(550,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
/*
        Random r = new Random();
        char c = (char)(r.nextInt(26) + ""a"");
        */
        arr = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h"
                , "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
        buttonArr = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            JButton button =  new JButton(arr[i]);
            button.setBackground(Color.GREEN);
            button.addKeyListener(this);
            panel.add(button);
            buttonArr.add(button);
        }


        //addButtons();
        this.setLocationRelativeTo(null);
        panel.addKeyListener(this);
        this.add(panel);
        this.setVisible(true);
    }

    private void addButtons() {
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
/*
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
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar());
        int keyCode = e.getKeyCode();

        for (JButton button : buttonArr){
            if (button.getText().equals(String.valueOf(e.getKeyChar()))){
                button.setBackground(Color.RED);
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        for (JButton button : buttonArr){
            if (button.getText().equals(String.valueOf(e.getKeyChar()))){
                button.setText(button.getText().toLowerCase());
                button.setBackground(Color.GREEN);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getButtonQ() {
        return buttonQ;
    }

    public void setButtonQ(JButton buttonQ) {
        this.buttonQ = buttonQ;
    }

    public JButton getButtonW() {
        return buttonW;
    }

    public void setButtonW(JButton buttonW) {
        this.buttonW = buttonW;
    }

    public JButton getButtonE() {
        return buttonE;
    }

    public void setButtonE(JButton buttonE) {
        this.buttonE = buttonE;
    }

    public JButton getButtonR() {
        return buttonR;
    }

    public void setButtonR(JButton buttonR) {
        this.buttonR = buttonR;
    }

    public JButton getButtonT() {
        return buttonT;
    }

    public void setButtonT(JButton buttonT) {
        this.buttonT = buttonT;
    }

    public JButton getButtonY() {
        return buttonY;
    }

    public void setButtonY(JButton buttonY) {
        this.buttonY = buttonY;
    }

    public JButton getButtonU() {
        return buttonU;
    }

    public void setButtonU(JButton buttonU) {
        this.buttonU = buttonU;
    }

    public JButton getButtonI() {
        return buttonI;
    }

    public void setButtonI(JButton buttonI) {
        this.buttonI = buttonI;
    }

    public JButton getButtonO() {
        return buttonO;
    }

    public void setButtonO(JButton buttonO) {
        this.buttonO = buttonO;
    }

    public JButton getButtonP() {
        return buttonP;
    }

    public void setButtonP(JButton buttonP) {
        this.buttonP = buttonP;
    }
}
