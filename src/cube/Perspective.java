package cube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Perspective extends JCheckBox {
    private Screen screen;

    public Perspective(String label, Screen screen) throws HeadlessException {
        super(label);
        this.screen = screen;
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                screen.perspective = !screen.perspective;
            }
        };
        this.addActionListener(actionListener);
        this.setFocusable(false);
    }
}
