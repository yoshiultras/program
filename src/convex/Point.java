package convex;

import java.awt.*;

//Класс "Одноугольник", реализующий интерфейс фигуры.
class Point implements Figure{
    private R2Point p;

    public Point(R2Point p){
        this.p = p;
    }

    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public Figure add(R2Point q){
        if(!p.equals(q))
            return new Segment(p, q);
        else
            return this;
    }

    public void draw(Graphics g) {
        p.draw(g);
    }

    @Override
    public double lineDist(Segment s) {
        return Math.min(Math.sqrt(Math.pow(s.p.getX() - p.getX(), 2) + Math.pow(s.p.getY() - p.getY(), 2)),Math.sqrt(Math.pow(s.q.getX() - p.getX(), 2) + Math.pow(s.q.getY() - p.getY(), 2)));
    }

}