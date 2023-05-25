package model;

import java.io.*;
import java.util.ArrayList;

public class Scoreboard {
    final int scoreboardSize = 15;
    ArrayList<Score> scoreboard;




    public Scoreboard(){
        scoreboard = new ArrayList<>(scoreboardSize);
        String name;
        int score;
        try {
            BufferedReader bufferedReader = new BufferedReader((new FileReader("ScoreBoard.txt")));
            for(int i = 0; i < bufferedReader.read(); ++i) {
                name = bufferedReader.readLine();
                i++;
                score = Integer.parseInt(bufferedReader.readLine());
                Score newscore = new Score(name, score);
                scoreboard.add(newscore);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
    public void setNewScore(String name, int score) throws IOException {
        Score newscore = new Score(name, score);
        scoreboard.add(newscore);

        scoreboard.sort(scoreboard.);





        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ScoreBoard.txt", true));
        String playerNameScore = String.format("Name:  10%s Score: 3%d", name, score);
        bufferedWriter.write(playerNameScore);
        bufferedWriter.newLine();
        bufferedWriter.close();
        sortScoreBoard();



    }
    public void sortScoreBoard(){

        list.sort((o1, o2)
                -> o1.getCustomProperty().compareTo(
                o2.getCustomProperty()));
       // scoreboard.sort(scoreboard.sort(scoreboard.get(1).);

    }


}
