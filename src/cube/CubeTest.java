package cube;

import java.util.concurrent.TimeUnit;

public class CubeTest {
    public static void main(String[] args){
        Cube cube = new Cube();
        Screen screen = new Screen(cube, false, false, 200);

        CubeController controller = new CubeController(cube, screen);

        cube.scale(100);
        while (true) {
            screen.repaint();
        }
    }
}
