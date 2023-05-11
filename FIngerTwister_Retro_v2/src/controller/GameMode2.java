package controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GameMode2 implements Runnable{

    private Controller controller;
    private boolean running = false;
    private List <JButton> player1 = new ArrayList<>();
    private int player1Counter;
    private int player2Counter;
    private List <JButton> player2 = new ArrayList<>();
    private boolean player1Lost = false;
    private boolean player2Lost = false;


    public GameMode2(Controller controller) {
        this.controller = controller;
    }

    public void nextButtonP1(){

        if (player1.size() == 4){
            player2.remove(0);
        }
        player1.add(controller.randomize_new_button());
    }

    public void nextButtonP2(){

        if (player1.size() == 4){
            player1.remove(0);
        }
        player1.add(controller.randomize_new_button());
    }

    @Override
    public void run() {

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public List<JButton> getPlayer1() {
        return player1;
    }

    public void setPlayer1(List<JButton> player1) {
        this.player1 = player1;
    }

    public int getPlayer1Counter() {
        return player1Counter;
    }

    public void setPlayer1Counter(int player1Counter) {
        this.player1Counter = player1Counter;
    }

    public int getPlayer2Counter() {
        return player2Counter;
    }

    public void setPlayer2Counter(int player2Counter) {
        this.player2Counter = player2Counter;
    }

    public List<JButton> getPlayer2() {
        return player2;
    }

    public void setPlayer2(List<JButton> player2) {
        this.player2 = player2;
    }

    public boolean isPlayer1Lost() {
        return player1Lost;
    }

    public void setPlayer1Lost(boolean player1Lost) {
        this.player1Lost = player1Lost;
    }

    public boolean isPlayer2lost() {
        return player2Lost;
    }

    public void setPlayer2Lost(boolean player2Lost) {
        this.player2Lost = player2Lost;
    }
}
