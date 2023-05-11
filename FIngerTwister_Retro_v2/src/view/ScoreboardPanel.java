package view;

import model.Scoreboard;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ScoreboardPanel extends JPanel implements Runnable {
    private View view;
    private JTextArea textArea;
    private int count;
    Scoreboard scoreboard;

    public ScoreboardPanel(View view) throws HeadlessException {
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
        FileReader fr = new FileReader("ScoreBoard.txt");
        BufferedReader br = new BufferedReader(fr);

        for(int i = 0; i < br.read(); ++i) {
            str = str + br.readLine() + "\n";
            ++this.count;
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
