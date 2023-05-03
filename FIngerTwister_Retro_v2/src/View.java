//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JFrame implements KeyListener {
    private JPanel panel;
<<<<<<< Updated upstream:FIngerTwister_Retro_v2/src/View.java
=======

    private JPanel gamePanel;
    private JPanel countDownPanel;
    private JPanel scoreBoardPanel;
    private JPanel startingPanel;
>>>>>>> Stashed changes:FIngerTwister_Retro_v2/src/view/View.java
    private Controller controller;
    private boolean timesUp = false;
    private int keyCount;

    public View(Controller controller) {
        this.controller = controller;
        String[] arr = controller.getArr();
        this.setSize(500, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        for(int i = 0; i < arr.length; ++i) {
            String s = arr[i];
            JButton button = new JButton(s);
            button.addKeyListener(this);
            button.setOpaque(true);
            button.setBorderPainted(false);
            this.panel.add(button);
            controller.getButtonArr().add(button);
        }

        this.setLocationRelativeTo(null);
        this.panel.addKeyListener(this);
        this.add(this.panel);
        this.setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    public void keyPressed(KeyEvent e) {
        if (this.timesUp) {
            String name = JOptionPane.showInputDialog((Component)null, "Times Up! Your score = " + this.keyCount + " Enter your name: ");
            controller.startCountDown();
            try {
                this.controller.setNewScore(name, this.keyCount);
            } catch (IOException var4) {
                throw new RuntimeException(var4);
            }

             this.dispatchEvent(new WindowEvent(this, 201));
             controller.startCountDown();
        }

        System.out.println(e.getKeyChar());
        Iterator var5 = this.controller.getButtonArr().iterator();

        while(var5.hasNext()) {
            JButton button = (JButton)var5.next();
            if (Objects.equals(button.getText(), String.valueOf(e.getKeyChar()))) {
                if (button == this.controller.getLitButton1()) {
                    button.setBackground(Color.GREEN);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    this.controller.newButton(button);
                    ++this.keyCount;
                } else if (button == this.controller.getLitButton2()) {
                    button.setBackground(Color.GREEN);
                    button.setOpaque(true);
                    button.setBorderPainted(false);
                    this.controller.newButton(button);
                    ++this.keyCount;
                } else {
                    JOptionPane.showMessageDialog(null,"You're a dissapointment for your parent and the world!");
                    this.dispatchEvent(new WindowEvent(this, 201));
                    controller.startCountDown();
                }
                break;
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        Iterator var2 = this.controller.getButtonArr().iterator();

        while(var2.hasNext()) {
            JButton button = (JButton)var2.next();
            if (button.getText().equals(String.valueOf(e.getKeyChar()))) {
                button.setBackground((Color)null);
                button.setOpaque(true);
                button.setBorderPainted(false);
            }
        }

    }

    public void buttonLightUp(JButton lightUpButton) {
        lightUpButton.setBackground(Color.YELLOW);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public boolean isTimesUp() {
        return this.timesUp;
    }

    public void setTimesUp(boolean timesUp) {
        this.timesUp = timesUp;
    }
}
