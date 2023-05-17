package view;

import model.Score;
import model.Scoreboard;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class ScoreboardPanel extends JPanel implements Runnable {
    private View view;
    private JTextArea textArea;
    private int count;
    private Scoreboard scoreboard;
    private ArrayList<Score> scores;


    public ScoreboardPanel(View view) throws HeadlessException, IOException {
        this.view = view;
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.add(this.textArea);
        scoreboard = new Scoreboard();


        try {
            this.setTextArea();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        this.setSize(250, 24 * this.count);
        this.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    }




    public void setTextArea() throws IOException {
        String str = "";
        String sb = "";
        FileReader fr = new FileReader("ScoreBoard.txt");
        BufferedReader br = new BufferedReader(fr);

        for(int i = 0; i < br.read(); ++i) {
            str = str + br.readLine() + "\n";
            ++this.count;
        }
        this.scores = scoreboard.getScoreboard();

        for(int i=0; i<scores.size(); i++){
            String name = scores.get(i).getName();
            int score = scores.get(i).getScore();
            sb = sb+String.format("Name: 10%s, Score: 10%s"+"\n", name, score);
        }


        fr.close();
        this.textArea.setText(str);







    }

    public void run() {
        FileReader fr = null;

        while(true) {
            String str = "";
            this.count = 0;
            try {
                fr = new FileReader("ScoreBoard.txt");
                BufferedReader br = new BufferedReader(fr);

                for (int i = 0; i < br.read(); ++i) {

                    str = str + br.readLine() + "\n";
                    ++this.count;
                }

                fr.close();
                br.close();
            } catch (IOException var5) {
                var5.printStackTrace();
            }
            this.textArea.setText(str);

        }
    }
}
