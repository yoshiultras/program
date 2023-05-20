package cube;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Rotator implements KeyListener {
    private Cube cube;

    public Rotator(Cube cube) {
        this.cube = cube;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            cube.rotate(0,5,0);
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            cube.rotate(0,-5,0);
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            cube.rotate(-5,0,0);
        else if(e.getKeyCode()== KeyEvent.VK_UP)
            cube.rotate(5,0,0);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
