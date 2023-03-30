import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.Buffer;

public class ScoreBoardViewer extends JFrame implements Runnable {

    private JPanel panel;
    private JTextArea textArea;
    private int count;

    public ScoreBoardViewer() throws HeadlessException {
        super("ScoreBoard");
        this.setSize(500,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(textArea);

        try{
            setTextArea();
        }catch(IOException e){
            e.printStackTrace();
        }

        this.setSize(300,40 * count);
        this.add(panel);
        this.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    }

    public void setTextArea() throws IOException {
        FileReader fr = null;
        String str = "";

        fr = new FileReader("ScoreBoard.txt");
        BufferedReader br = new BufferedReader(fr);

        for (int i = 0; i < br.read(); i++){

            str = str  + br.readLine()+ "\n";
            count++;

        }
        fr.close();
        textArea.setText(str);
    }

    @Override
    public void run() {
        FileReader fr = null;
        String str = "";


        try {
            fr = new FileReader("ScoreBoard.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < br.read(); i++) {

                str = str + br.readLine() + "\n";
                count++;

            }

            fr.close();
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        textArea.setText(str);
    }
}
