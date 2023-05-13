package cube;

public class CubeTest {
    public static void main(String[] args) {
        Cube cube = new Cube();

        Screen screen = new Screen(cube, true);
        cube.scale(100);
        cube.rotate(30,0,0);
    }
}
