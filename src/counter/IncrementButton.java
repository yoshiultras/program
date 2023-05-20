package counter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class IncrementButton extends JButton{
    private Counter counter;
    private MyPanel panel;

    public IncrementButton(Counter counter, MyPanel panel){
        this.setText("Add");
		
        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);

        this.counter = counter;
        this.panel = panel;
    }



    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            counter.increment();
        }
    }
}
