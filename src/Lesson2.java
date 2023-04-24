import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) throws Exception {
        run();

    }

    public static void run() throws Exception {
        Scanner s = new Scanner(System.in);
        Lesson2 lesson = new Lesson2();

        System.out.println("\n1 -> Вывод односторонней очереди");
        System.out.println("2 -> Двойной вывод односторонней очереди");
        System.out.println("3 -> Двойной вывод двусторонней очереди");
        System.out.println("4 -> Проверка слова на палиндром");
        System.out.println("5 -> Выход из программы");
        System.out.print("\nВведите номер операции:");

        switch (Integer.parseInt(s.nextLine())) {
            case 1 :
                System.out.println("\nВведите размер очереди");
                lesson.task1(Integer.parseInt(s.nextLine()));
                break;
            case 2 :
                System.out.println("\nВведите размер очереди");
                lesson.task2(Integer.parseInt(s.nextLine()));
                break;
            case 3 :
                System.out.println("\nВведите размер очереди");
                lesson.task3(Integer.parseInt(s.nextLine()));
                break;
            case 4 :
                System.out.println("\nВведите слово");
                System.out.println(lesson.isPalindrome(s.nextLine()));
                break;
            case 5 :
                return;
            default:
                System.out.println("Неправильное значение");
        }
        run();
    }
    public void task1(int size) throws Exception {
        Queue q = new Queue(size);
        for (int i = 0; i < size; i++) {
            q.push(i);
        }
        while(!q.empty()) {
            System.out.println(q.pop());
        }
    }

    public void task2(int size) throws Exception {
        Queue q = new Queue(size);
        for (int i = 0; i < size; i++) {
            q.push(i);
        }
        int c = 0;
        for (int i = 0; i < size*2; i++) {
            int val = q.pop();
            System.out.println(val);
            q.push(val);
        }
    }

    public void task3(int size) throws Exception {
        Dequeue q = new Dequeue(size);
        for (int i = 0; i < size; i++) {
            q.pushFront(i);
        }
        int c = 0;
        for (int i = 0; i < size*2; i++) {
            int val = 0;
            if(i < size) {
                val = q.popFront();
                q.pushFront(val);
            }
            else {
                val = q.popBack();
                q.pushBack(val);
            }
            System.out.println(val);
        }
    }

    public boolean isPalindrome(String str) throws Exception {
        Dequeue q = new Dequeue(str.length());
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            q.pushFront(chars[i]);
        }
        for (int i = 0; i < chars.length / 2; i++) {
            if(q.popFront() != q.popBack()) {
                return false;
            }
        }
        return true;
    }
}
