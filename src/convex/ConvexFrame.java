package convex;

import javax.swing.*;
import java.awt.*;

public class ConvexFrame extends JFrame {
    private Convex convex;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;



    public ConvexFrame(Convex convex){
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Convex");
        this.setLocation(1000, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.convex = convex;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        g.translate(WIDTH/2, HEIGHT/2);
        g.drawLine(-WIDTH/2, 0, WIDTH/2, 0);
        g.drawLine(0, HEIGHT/2, 0, -HEIGHT/2);
        g.setColor(new Color(0x0000FF));

        convex.draw(g);

    }
}
