package cube;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Resizer implements MouseWheelListener {
    private Cube cube;

    public Resizer(Cube cube) {
        this.cube = cube;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        cube.scale((double) 100/(100+notches*3));
    }
}
