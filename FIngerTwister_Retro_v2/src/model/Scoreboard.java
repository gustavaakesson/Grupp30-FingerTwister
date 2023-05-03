package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Scoreboard {
    private final int scoreboardSize = 10;
    private String [] scoreBoard = new String[scoreboardSize];
    private ArrayList<String> scoreboardArr;



    public Scoreboard(){
        scoreboardArr = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader((new FileReader("ScoreBoard.txt")));
            for(int i = 0; i < bufferedReader.read(); ++i) {
                scoreboardArr.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
    public void setNewScore(String name, int score) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ScoreBoard.txt", true));
        String playerNameScore = String.format("Name:  10%s Score: 3%d", name, score);
        bufferedWriter.write(playerNameScore);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
    public boolean checkScoreBoard(int score){
        int minScore = 1000;
        int checkedScore;
        int scores[] = new int[scoreBoard.length];
        for(int i=0; i<scoreBoard.length; i++){
           checkedScore = Integer.parseInt(String.valueOf(scoreBoard[i].startsWith("Score: ")));
           scores[i] = Integer.parseInt(String.valueOf(scoreboardArr.get(i).startsWith("Score: ")));
           if(checkedScore>0 ){

           }
        }
    return false;
    }


}
