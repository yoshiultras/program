package cube;

public class CubeTest {
    public static void main(String[] args) {
        Cube cube = new Cube();

        Screen screen = new Screen(cube, false);
        cube.scale(100);
        cube.rotate(45,231,43);
    }
}
