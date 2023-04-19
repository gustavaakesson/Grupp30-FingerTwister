//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ScoreBoardViewer extends JFrame implements Runnable {
    private JPanel panel;
    private JTextArea textArea;
    private int count;

    public ScoreBoardViewer() throws HeadlessException {
        super("ScoreBoard");
        this.setSize(500, 200);
        this.setDefaultCloseOperation(3);
        this.panel = new JPanel();
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.panel.add(this.textArea);

        try {
            this.setTextArea();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        this.setSize(300, 40 * this.count);
        this.add(this.panel);
        this.setVisible(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void setTextArea() throws IOException {
        FileReader fr = null;
        String str = "";
        fr = new FileReader("ScoreBoard.txt");
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
        String str = "";

        try {
            fr = new FileReader("ScoreBoard.txt");
            BufferedReader br = new BufferedReader(fr);

            for(int i = 0; i < br.read(); ++i) {
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
