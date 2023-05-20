package counter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class DecrementButton extends JButton {
    private Counter counter;
    private MyPanel panel;

    public DecrementButton(Counter counter, MyPanel panel){
        this.setText("Subtract");

        DecrementListener listener = new DecrementListener();
        this.addActionListener(listener);

        this.counter = counter;
        this.panel = panel;
    }
    private class DecrementListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            counter.decrement();
        }
    }
}
