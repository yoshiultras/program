package stack.calc;

import java.util.Scanner;

//���� ��� ����������� ������.
public class CompfTest{
    public static void main(String[] args) throws Exception {
        Compf c = new Compf();

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("������� ������� -> ");
            c.compile(in.next().toCharArray());
            System.out.print("\n");
        }
    }
}