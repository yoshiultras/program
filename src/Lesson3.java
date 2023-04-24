import java.util.*;

public class Lesson3 {
    public static void main(String[] args) throws Exception {
//        L1List list = new L1List(5);
//        for (int i = 0; i < 5; i++) {
//            list.insert(i);
//        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println(list.after());
//            list.forward();
//        }

        Scanner s = new Scanner(System.in);
        System.out.print("Введите кол-во программ для запуска: ");
        int n = Integer.parseInt(s.nextLine());
        System.out.println("Для выхода из программы введите 'ALT+DELETE'.");
        L1List list = new L1List(n);
        List<Object> res = new ArrayList<>();
        String str = s.nextLine();
        while(!str.equals("ALT+DELETE")) {
            if(str.contains("ALT+TAB")) {
                int c = str.split("TAB").length;
                for (int j = 0; j < c; j++) {
                    try {
                        list.forward();
                    } catch (Exception e) {
                        list.toFront();
                        list.forward();
                    }


                }try {
                    res.add(list.after());
                } catch (Exception e) {
                    list.toFront();
                    res.add(list.after());
                }

            }
            else {
                list.insert(str);
                res.add(list.after());
            }

            str = s.nextLine();
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}