package cube;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private Cube cube;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private Image img;
    private Graphics doubleBuff;
    private boolean transp;
    public Screen(Cube cube, boolean transp) {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Cube");
        this.setLocation(900, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // --> paint(g)
        this.setResizable(false);

        this.cube = cube;
        this.transp = transp;
    }

    @Override
    public void paint(Graphics g){
        img = createImage(WIDTH, HEIGHT);
        doubleBuff = img.getGraphics();
        paintComponent(doubleBuff);
        g.drawImage(img, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g.translate(WIDTH/2, HEIGHT/2);
        cube.draw(g2d, transp);

    }
}
