package cube;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CubeController{
    private Cube cube;
    private Screen screen;
    public CubeController(Cube cube, Screen screen) {
        this.cube = cube;
        this.screen = screen;
        screen.addKeyListener(new Rotator(cube));
    }




}
