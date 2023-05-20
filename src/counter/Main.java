package counter;

import javax.swing.*;
import java.awt.*;

//PropertyChangeListener
//PropertyChangeSupport

public class Main extends JFrame{
    public Main(){
        this.setTitle("MVC");
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(2, 1));

        Counter counter = new Counter();
        MyPanel panel = new MyPanel(counter);
        Controller controller = new Controller(counter, panel);

        pane.add(panel);
        pane.add(controller);

        this.setVisible(true);
		
		counter.addObserver(controller);
    }

    public static void main(String[] args) {
        new Main();
    }
}
