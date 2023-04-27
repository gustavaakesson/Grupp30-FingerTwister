package view;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import controller.*;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class View extends JFrame{
    private JPanel panel;

    private JPanel gamePanel;
    private gamePanelManager gamePanelManager;

    private JPanel countDownPanel;
    private JPanel scoreBoardPanel;
    private JPanel startingPanel;
    private Controller controller;
    private boolean timesUp = false;
    private BorderLayout borderLayout = new BorderLayout();
    public View(Controller controller) {
        this.controller = controller;
        this.setLayout(borderLayout);
        this.setSize(1000,600);
        createPanels();
        addPanels();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       // this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

       // addButtons();

        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

/*
    private void addButtons() {
        String[] arr = controller.getArr();

        for (int i = 0; i < arr.length; ++i) {
            String s = arr[i];
            JButton button = new JButton(s);
            button.addKeyListener(this);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setForeground(Color.BLACK);
            button.setBackground(Color.RED);
            button.setVisible(true);
            this.panel.add(button);
            controller.getButtonArr().add(button);
        }
    }

 */
    private void createPanels() {
        startingPanel = new GameModePanel(this);
        gamePanel = new GamePanel(this);
        scoreBoardPanel = new ScoreboardPanel(this);
        countDownPanel = new CountdownPanel(controller, this);
    }

    private void addPanels() {
        this.add((startingPanel),BorderLayout.NORTH);
        this.add((gamePanel),BorderLayout.CENTER);
        this.add((scoreBoardPanel),BorderLayout.WEST);
        this.add((countDownPanel),BorderLayout.EAST);
    }
/*
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    public void keyPressed(KeyEvent e) {
        if (this.timesUp) {
            String name = JOptionPane.showInputDialog(null, "Times Up! Your score = " + this.keyCount + " Enter your name: ");
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

        for (JButton button : this.controller.getButtonArr()) {
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
                    JOptionPane.showMessageDialog(null, "You're a disappointment for your parent and the world!");
                    this.dispatchEvent(new WindowEvent(this, 201));
                    controller.startCountDown();
                }
                break;
            }
        }

    }

    public void keyReleased(KeyEvent e) {

        for (JButton button : this.controller.getButtonArr()) {
            if (button.getText().equals(String.valueOf(e.getKeyChar()))) {
                button.setBackground(Color.RED);
                button.setOpaque(true);
                button.setBorderPainted(false);
            }
        }

    }

 */

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

    public String[] getKeyboardArray(){
        return controller.getArr();
    }
    public JPanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(JPanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public JPanel getCountDownPanel() {
        return countDownPanel;
    }

    public void setCountDownPanel(JPanel countDownPanel) {
        this.countDownPanel = countDownPanel;
    }

    public JPanel getScoreBoardPanel() {
        return scoreBoardPanel;
    }

    public void setScoreBoardPanel(JPanel scoreBoardPanel) {
        this.scoreBoardPanel = scoreBoardPanel;
    }

    public JPanel getStartingPanel() {
        return startingPanel;
    }

    public void setStartingPanel(JPanel startingPanel) {
        this.startingPanel = startingPanel;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
