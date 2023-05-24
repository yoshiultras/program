package cube;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

public class CubeController{
    private Cube cube;
    private Screen screen;
    public CubeController(Cube cube, Screen screen) {
        this.cube = cube;
        this.screen = screen;
        screen.addKeyListener(new Rotator(cube));
        screen.addMouseWheelListener(new Resizer(cube));

        Transparent transp = new Transparent("Transparent", screen);
        transp.setSize(100,30);
        screen.add(transp);

        Perspective persp = new Perspective("Perspective", screen);
        persp.setLocation(0,30);
        persp.setSize(100,30);
        screen.add(persp);
    }




}
