package cube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transparent extends JCheckBox{
    private Screen screen;

    public Transparent(String label, Screen screen) throws HeadlessException {
        super(label);
        this.screen = screen;
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                screen.transp = !screen.transp;
            }
        };
        this.addActionListener(actionListener);
        this.setFocusable(false);
    }


}
