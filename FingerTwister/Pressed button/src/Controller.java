import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Controller{

    View view;

    public Controller() {
        this.view = new View();
    }
}
