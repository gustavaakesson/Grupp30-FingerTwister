package model;

import java.io.*;
import java.util.*;

public class Scoreboard {
    final int scoreboardSize = 15;
    String [] scoreBoard = new String[scoreboardSize];
    ArrayList<Score> scoreboardArr;





    public Scoreboard() throws IOException {
        scoreboardArr = new ArrayList<Score>();
        try {
            BufferedReader bufferedReader = new BufferedReader((new FileReader("ScoreBoard.txt")));
            for(int i = 0; i < bufferedReader.read(); ++i) {
               String line = bufferedReader.readLine();

               String name = line;

                System.out.println(name);

                char[] chars = line.toCharArray();
                StringBuilder sb = new StringBuilder();
                for(char c : chars){
                    if(Character.isDigit(c)){
                        sb.append(c);
                    }
                    else{
                         sb.delete(0,c);
                        }
                    }
                Score newScore = new Score(name.substring(0,(name.length()-sb.length())),Integer.parseInt(sb.toString()));
                scoreboardArr.add(newScore);
                }
            } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }





    public void setNewScore(String name, int score) throws IOException {
        Score newScore = new Score(name, score);
        scoreboardArr.add(newScore);
        scoreboardArr.sort(Comparator.comparingInt(Score::getScore));
        saveTxt();



       /* BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ScoreBoard.txt", true));
        String playerNameScore = String.format("Name:  10%s Score: 3%d", name, score);
        bufferedWriter.write(playerNameScore);
        bufferedWriter.newLine();
        bufferedWriter.close();

        */
    }

    public void saveTxt() throws IOException {
        new File("Scoreboard.txt");
        for(Score score : scoreboardArr) {
            String playerNameScore;
            String name = score.getName();
            String points = String.valueOf(score.getScore());
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ScoreBoard.txt", true));
            if(name.startsWith("Name:")) {
                playerNameScore = String.format("17%s 10%d", name, points);
            }else {
                playerNameScore = String.format("Name:  10%s Score: 3%d", name, points);
            }
                bufferedWriter.write(playerNameScore);
                bufferedWriter.newLine();
                bufferedWriter.close();

        }

    }

    public ArrayList getScoreboard(){
        return scoreboardArr;
    }


}
