package convex;

import java.awt.*;

//Интерфейс, задающий новый тип - фигуру.
interface Figure{
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public void draw(Graphics g);
    public double lineDist(Segment s);
}