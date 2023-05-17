package view;

import model.Scoreboard;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ScoreboardPanel extends JPanel implements Runnable {
    private View view;
    private JLabel emptyLabel;
    private JLabel emptyLabel1;

    private JTextArea textArea;
    private int count;
    Scoreboard scoreboard;

    public ScoreboardPanel(View view) throws HeadlessException {
        this.view = view;
        this.textArea = new JTextArea();

        this.emptyLabel = new JLabel();
        this.emptyLabel1 = new JLabel();
        emptyLabel.setPreferredSize(new Dimension(100,0));
        emptyLabel1.setPreferredSize(new Dimension(100,0));



        /*
        JLabel scoreBoardText = new JLabel("Scoreboard");
        Font font = new Font("BOLD", Font.BOLD, 24);
        scoreBoardText.setFont(font);
        scoreBoardText.setBackground(null);
        this.add(scoreBoardText, BorderLayout.NORTH);*/

        textArea.setPreferredSize(new Dimension(400,1100));
        Font bigFont = new Font("Italic", Font.ITALIC, 24);
        textArea.setFont(bigFont);
        textArea.setBackground(null);

        this.textArea.setEditable(false);
        //this.add(emptyLabel1);
        this.add(this.textArea);
        this.add(emptyLabel);
        scoreboard = new Scoreboard();

        try {
            this.setTextArea();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

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
