package convex;

import java.io.FileWriter;

//���� ��� �������� ��������.
class ConvexTest{
    public static void main(String[] args) throws Exception{
        Convex convex = new Convex();
        ConvexFrame frame = new ConvexFrame(convex);
        FileWriter fw = new FileWriter("output.txt");
        System.out.println("������� ���������� �������");
        R2Point p1 = new R2Point();
        R2Point p2 = new R2Point();
        Segment line = new Segment(p1, p2);
        convex.addLine(line);
        System.out.println("������� ���������� �������� ��������");
        while(true){
            try {
                R2Point p = new R2Point();
                convex.add(p);
                fw.write(p.toString());
                System.out.println("S = " + convex.area() + ", P = " + convex.perimeter());
                System.out.println("���������� �� �������� �� ������ = " + convex.lineDist(line));
            } catch (Exception e) {
                fw.close();
                break;
            }
        }
        frame.dispose();
    }
}
