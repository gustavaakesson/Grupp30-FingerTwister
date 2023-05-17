package controller;

import view.View;

import javax.swing.*;
import java.util.*;

public class GameMode2 implements Runnable{

    private Controller controller;
    private View view;
    private char[] keyboardChars = {'\u001B', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '´', '\u232B',
            '\u21E5', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'Å', '¨', '\'',
            '\u21EA', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Ö', 'Ä', '\u23CE',
            '\u21E7', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '-', '\u21E7', '\u2191','\u2190', '\u2193', '\u2192'};
    private char[] randomChars1 = new char[5];
    private char[] randomChars2 = new char[5];
    private Random random = new Random();
    private int index = 0;
    private int count = 0;
    private boolean running = true;
    private List <JButton> player1 = new ArrayList<>();
    private List <JButton> player2 = new ArrayList<>();
    private int player1Counter;
    private int player2Counter;
    private boolean player1Lost = false;
    private boolean player2Lost = false;


    public GameMode2(View view) {
        this.view = view;
    }

    // Detta ÄR algoritmen som fixar att det blir random tecken

    /**
     This method generates random characters from an array of predefined keyboard characters and ensures that no duplicates are present in both randomly generated arrays.

     The keyboard characters are stored in a char array named keyboardChars.

     Two empty char arrays are created, named randomChars1 and randomChars2.

     The randomizeChar() method is used to generate random characters for the given array and compare it with another array to ensure there are no duplicates.

     The method takes the following parameters:

     @param randomChar An empty char array to store the randomly generated characters.
     @param comparisonArray The array to compare the generated characters with to ensure there are no duplicates.
     @param arrayNumber An integer value representing the number of the array being processed.

     The runRandomizer() method is used to generate 30 sets of random characters.
     It calls the randomizeChar() method twice for each set of characters and updates the index value accordingly.
     The class uses the Random class to generate random numbers.

     @author Theodor Bäckstrand.
     */
    public void runRandomizer() {

        while (count < 30) { //Detta kommer behövas ändras!!!!!!!!

            randomizeChar(randomChars1, randomChars2, 1);
            randomizeChar(randomChars2, randomChars1, 2);

            index = (index + 1) % 5;

        }
    }
    public void randomizeChar (char [] randomChar,char [] comparisonArray, int arrayNumber) {
        char newChar = keyboardChars[random.nextInt(keyboardChars.length)];
        boolean charExists = false;
        for (int i = 0; i < randomChar.length; i++) {
            if (newChar == randomChar[i] || newChar == comparisonArray[i]) {
                charExists = true;
                break;
            }
        }

        if (!charExists) {
            randomChar[index] = newChar;
            System.out.println("From Array " + arrayNumber + ": " + Arrays.toString(randomChar));
            count++;
        }
        else randomizeChar(randomChar, comparisonArray, arrayNumber);
    }
//Här slutar den //TheodorB

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
        this.startGameMode2();
    }

    public void startGameMode2(){
        if (running) {

            if (player2 == null) {
                nextButtonP1();
            } else {
                nextButtonP1();
                nextButtonP2();
            }
        }
    }
    public void nextRound(){

        if (running) {

            if (player2 == null) {
                nextButtonP1();
            } else if (checkStatus()) {
                JOptionPane.showMessageDialog(null, "A player lost");
            } else {
                nextButtonP1();
                nextButtonP2();
            }
        }

    }

    private boolean checkStatus() {
        return !player1Lost;
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
