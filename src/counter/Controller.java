package counter;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Controller extends JPanel implements Observer {
    private Counter counter;
    private MyPanel panel;
    public Controller(Counter counter, MyPanel panel){
        this.counter = counter;
        this.panel = panel;
        this.setLayout(new GridLayout(2, 1));
        this.add(new IncrementButton(counter, panel));
        this.add(new DecrementButton(counter, panel));
    }
    @Override
    public void update(Observable o, Object arg) {
        counter = (Counter) o;
        panel.setStr(counter.getCounter());
        panel.repaint();
    }
}
