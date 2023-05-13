package convex;

import javax.swing.*;
import java.awt.*;

public class ConvexFrame extends JFrame {
    private Convex convex;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private Image img;
    private Graphics doubleBuff;
    public ConvexFrame(Convex convex){
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Convex");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // --> paint(g)
        this.setResizable(false);

        this.convex = convex;
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
        g.translate(WIDTH / 2, HEIGHT / 2); //Перенос начала координат в центр окна.
        /*g.drawLine(-WIDTH/2, 0, WIDTH/2, 0);
        g.drawLine(0, HEIGHT/2, 0, -HEIGHT/2);*/
        convex.draw(g);
        super.repaint();
    }
}
