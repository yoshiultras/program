package convex;

import java.awt.*;

//Класс "Выпуклая оболочка".
class Convex{
    private Figure fig;
    private Segment line = new Segment(new R2Point(0, 0), new R2Point(0, 0));

    public Convex(Segment s){
        fig = new Void(s);
    }

    public void add(R2Point p){
        fig = fig.add(p);
    }
    public void addLine(Segment s){
        line = s;
    }

    public double area(){
        return fig.area();
    }

    public double perimeter(){
        return fig.perimeter();
    }
    public double lineDist(Segment s) {
        return fig.lineDist(s);
    }
    public void draw(Graphics g){
        line.draw(g);
        fig.draw(g);
    }
}
