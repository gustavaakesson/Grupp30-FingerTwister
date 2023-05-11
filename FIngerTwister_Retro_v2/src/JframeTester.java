import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JframeTester extends JFrame {
    private JFrame myJFrame;
    public JframeTester()  {
        this.setSize(500,500);
        this.setVisible(true);
        ImageIcon img = new ImageIcon("Images\\Transistor.jpg");
        this.setIconImage(img.getImage());
        JPanel panel = new JPanel();
        panel.add(panel,img.getImage());
        this.add(panel);
        try{
            BufferedImage myImage = ImageIO.read((ImageInputStream) img.getImage());
            myJFrame = new JFrame("Image pane");
            myJFrame.setContentPane(new ImagePanel(img.getImage()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public class ImagePanel extends Container {
        private Image img;
        public ImagePanel(Image img) {
            this.img = img;
        }

        public Image getImg() {
            return img;
        }

        public void setImg(Image img) {
            this.img = img;
        }
    }
}
