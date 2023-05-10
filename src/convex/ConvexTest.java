package convex;

import java.awt.*;

public class ConvexTest{
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();
        ConvexFrame frame = new ConvexFrame(convex);
        while(true){
            R2Point point = new R2Point();
            convex.add(point);
            frame.repaint();
            System.out.println("S = " + convex.area()+ ", P = " + convex.perimeter());
        }
    }
}
