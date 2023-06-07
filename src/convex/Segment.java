package convex;

import java.awt.*;

//Класс "Двуугольник", реализующий интерфейс фигуры.
class Segment implements Figure{
    public R2Point p, q;
    private Segment s;

    public Segment(R2Point p, R2Point q, Segment s){
        this.p = p;
        this.q = q;
        this.s = s;
    }
    public Segment(R2Point p, R2Point q){
        this.p = p;
        this.q = q;
    }

    public double perimeter(){
        return 2.0 * R2Point.dist(p, q);
    }

    public double area(){
        return 0.0;
    }

    public Figure add(R2Point r){
        if(R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r, s);

        if(q.inside(p, r))
            q = r;

        if(p.inside(r, q))
            p = r;

        return this;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((int) p.getX(),(int) p.getY(),(int) q.getX(),(int) q.getY());
        p.draw(g);
        q.draw(g);
    }

    @Override
    public double lineDist(Segment s) {
        return Math.min(new Point(p).lineDist(s), new Point(q).lineDist(s));
    }
}
