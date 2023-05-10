package convex;

import java.awt.*;
import java.util.ArrayList;

//����� "�������������", ����������� ��������� ������.
public class Polygon extends Deq implements Figure{
    private double s, p;

    public Polygon(R2Point a, R2Point b, R2Point c){
        pushFront(b);

        if (b.light(a, c)){
            pushFront(a);
            pushBack(c);
        }
        else{
            pushFront(c);
            pushBack(a);
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
        //���� ���������� �����, ������������ �� ���� �� ������.
        for(i = length(); i>0 && !t.light(back(), front()); i--)
            pushBack(popFront());

        //�����������:
        //���� ����� [back(), front()] �������� �� t,
        //���� ���������� ����� ��� ������.
        if (i>0){
            R2Point x;
            grow(back(), front(), t);

            //������� ��� ���������� ����� �� ������ ����.
            for(x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t);
            pushFront(x);

            //������� ��� ���������� ����� �� ����� ����.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);

            //��������� ��������� ����������� �����.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }

        return this;
    }

    @Override
    public void draw(Graphics g) {
        int[] x = new int[length()];
        int[] y = new int[length()];
        for (int i = 0; i < length(); i++) {
            R2Point p = popBack();
            pushFront(p);
            p.draw(g);
            x[i] = p.getX();
            y[i] = p.getY();
        }
        g.setColor(new Color(0x0000FF));
        g.drawPolygon(x, y, length());

    }
}