package stack.calc;

import java.util.Scanner;

//���� ��� ������������ ������.
public class CalcTest{
    public static void main(String[] args) throws Exception{
        Calc c = new Calc();

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("������� ������� -> ");
            c.compile(in.next().toCharArray());
            System.out.print("\n");
        }
    }
}
