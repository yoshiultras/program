package convex;

import java.awt.*;
import java.util.Scanner;

//Класс, описывающий точку (Point) на плоскости (R2).
class R2Point{
    private double x, y;

    public R2Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public R2Point() throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.print("x -> ");
        x = in.nextDouble();
        System.out.print("y -> ");
        y = in.nextDouble();
    }

    public static double dist(R2Point a, R2Point b){
        return Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
    }

    public static double area(R2Point a, R2Point b, R2Point c){
        return 0.5*((a.x - c.x)*(b.y - c.y) - (a.y - c.y)*(b.x - c.x));
    }
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof R2Point)) {
            return false;
        }
        R2Point r = (R2Point) o;
        return x == r.x && y == r.y;
    }

    public static boolean isTriangle(R2Point a, R2Point b, R2Point c){
        return area(a, b, c) != 0.0;
    }

    public boolean inside(R2Point a, R2Point b){
        return(a.x <= x && x <= b.x || a.x >= x && x >= b.x)&&(a.y <= y && y <= b.y|| a.y>= y && y >= b.y);
    }

    public boolean light(R2Point a, R2Point b){
        double s = area(a, b, this);
        return s < 0.0 || (s == 0.0 && ! inside(a,b));
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval((int) getX()-2, (int) getY()-2,4,4);
    }

    @Override
    public String toString() {
        return  "(" + x +
                "," + y +
                ")\n";
    }
}