package RecursCompf;
import java.util.Scanner;
//���� ��� ������������ ����������� ������.
public class RecursCompfTest{
    public static void main(String[] args) throws Exception{
        RecursCompf c = new RecursCompf();
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("������� ������� -> ");
            c.compile(in.next().toCharArray());
        }
    }
}