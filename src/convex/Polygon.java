package convex;

import java.awt.*;
import java.util.ArrayDeque;

//Класс "Многоугольник", реализующий интерфейс фигуры.
class Polygon extends ArrayDeque implements Figure{
    private double s, p;

    public Polygon(R2Point a, R2Point b, R2Point c){
        offerFirst(b);

        if (b.light(a, c)){
            offerFirst(a);
            offerLast(c);
        }
        else{
            offerFirst(c);
            offerLast(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c)+ R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure add(R2Point t){
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for(i = size(); i>0 && !t.light((R2Point) peekLast(), (R2Point) peekFirst()); i--)
            offerLast(pollFirst());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i>0){
            R2Point x;
            grow((R2Point) peekLast(), (R2Point) peekFirst(), t);

            //Удаляем все освещенные ребра из начала дека.
            for(x = (R2Point) pollFirst(); t.light(x, (R2Point) peekFirst()); x = (R2Point) pollFirst())
                grow(x, (R2Point) peekFirst(), t);
            offerFirst(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = (R2Point) pollLast(); t.light((R2Point) peekLast(), x); x = (R2Point) pollLast())
                grow((R2Point) peekLast(), x, t);
            offerLast(x);

            //Завершаем обработку добавляемой точки.
            p += R2Point.dist((R2Point) peekLast(), t) + R2Point.dist(t, (R2Point) peekFirst());
            offerFirst(t);
        }

        return this;
    }

    public void draw(Graphics g) {
        for(int i = 0; i < size(); i++) {
            g.setColor(Color.BLACK);
            R2Point point = (R2Point) peekLast();
            R2Point point2 = (R2Point) peekFirst();
            g.drawLine((int) point.getX(),(int) point.getY(),(int) point2.getX(),(int) point2.getY());
            point.draw(g);
            point2.draw(g);
            offerLast(pollFirst());
        }
    }

    @Override
    public double lineDist(Segment s) {
        double res = Double.MAX_VALUE;
        for(int i = 0; i < size(); i++) {
            Segment s2 = new Segment((R2Point) peekLast(), (R2Point) peekFirst());
            offerLast(pollFirst());
            res = Math.min(res, s2.lineDist(s));
        }
        return res;
    }
}