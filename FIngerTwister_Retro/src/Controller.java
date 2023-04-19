//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.Timer;

public class Controller implements ActionListener, Runnable {
    private String[] arr = new String [] {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private View view ;
    private ArrayList<JButton> buttonArr = new ArrayList();
    private JButton litButton1;
    private JButton litButton2;
    private Timer timer = new Timer(10000, this);
    private Thread thread;

    public JButton getLitButton1() {
        return this.litButton1;
    }

    public JButton getLitButton2() {
        return this.litButton2;
    }

    public Controller() {
        this.view = new View(this);
        this.timer.start();
        this.startGame();
    }

    public void startGame() {

        this.litButton1 = this.randomize_new_button();
        this.litButton2 = this.randomize_new_button();

        while(Objects.equals(this.litButton2.getText(), this.litButton1.getText())){

            this.litButton2 = this.randomize_new_button();
            this.litButton1 = this.randomize_new_button();
        }
    }


    public void startCountDown() {
        CountdownView countDown = new CountdownView(this);
        countDown.setVisible(true);
        this.thread = new Thread(this);
    }

    public Thread getThread() {
        return this.thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void nextGame() {
        this.view = new View(this);
    }

    public JButton randomize_new_button() {
        JButton jButton = null;
        Random r = new Random();
        int randomInt = r.nextInt(this.arr.length);
        String randomLetter = this.arr[randomInt];

        for (int i = 0 ; i < arr.length; i++){
            if (Objects.equals(buttonArr.get(i).getText(), randomLetter)) {
                view.buttonLightUp(buttonArr.get(i));
                jButton = buttonArr.get(i);
                break;
            }
        }

        return jButton;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void setNewScore(String name, int score) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("ScoreBoard.txt", true));
        String playerNameScore = String.format(" Name: %s Score: %d", name, score);
        bw.write(playerNameScore);
        bw.newLine();
        bw.close();
    }

    public void newButton(JButton button) {
        if (button == this.litButton1) {
            this.litButton1 = this.randomize_new_button();
        }

        if (button == this.litButton2) {
            this.litButton2 = this.randomize_new_button();
        }

    }

    public String[] getArr() {
        return this.arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public ArrayList<JButton> getButtonArr() {
        return this.buttonArr;
    }

    public void setButtonArr(ArrayList<JButton> buttonArr) {
        this.buttonArr = buttonArr;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            this.view.setTimesUp(true);
        }

    }

    public void run() {
        try {
            Thread var10000 = this.thread;
            Thread.sleep(5000L);
        } catch (InterruptedException var2) {
            throw new RuntimeException(var2);
        }

        new View(this);
    }
}