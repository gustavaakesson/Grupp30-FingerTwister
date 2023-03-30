import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.TimerTask;

public class Controller implements ActionListener , Runnable{

    private View view;
    private String[] arr = {"q","w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
    private ArrayList<JButton> buttonArr = new ArrayList<>();
    private JButton litButton1;
    private JButton litButton2;
    private Timer timer;
    private Thread thread;

    public JButton getLitButton1() {
        return litButton1;
    }

    public JButton getLitButton2() {
        return litButton2;
    }

    public Controller() {
        view = new View(this);
        timer = new Timer(10000,this);
        timer.start();
        startGame();
    }

    //this.scoreboard = new ScoreBoardViewer();
    //        this.view = new View(this, startCountDown());

    public void startGame() {
        litButton1 = randomize_new_button();
        litButton2 = randomize_new_button();

        while(Objects.equals(litButton2.getText(), litButton1.getText())) {
            litButton1 = randomize_new_button();
            litButton2 = randomize_new_button();
        }
    }

    //För att lägga till en countdown (Fungerar inte)
    public void startCountDown(){
        CountdownView countDown = new CountdownView(this);
        countDown.setVisible(true);
        thread = new Thread(this);
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void nextGame(){
        view = new View(this);

    }
    public JButton randomize_new_button(){

        JButton button = null;
        Random r = new Random();
        int randomInt = (r.nextInt(arr.length));
        String randomLetter = arr[randomInt];


        for (JButton jButton : buttonArr) {
            if (Objects.equals(jButton.getText(), randomLetter)) {
                view.buttonLightUp(jButton);
                button = jButton;
                break;
            }
        }

        return button;

    }

    public Timer getTimer() {
        return timer;
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

    public void newButton(JButton button){

        if (button == litButton1){
            litButton1 = randomize_new_button();
        }

        if (button == litButton2){
            litButton2 = randomize_new_button();
        }
    }



    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public ArrayList<javax.swing.JButton> getButtonArr() {
        return buttonArr;
    }

    public void setButtonArr(ArrayList<javax.swing.JButton> buttonArr) {
        this.buttonArr = buttonArr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer){
            view.setTimesUp(true);
        }
    }

    @Override
    public void run() {
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new View(this);
    }
}
