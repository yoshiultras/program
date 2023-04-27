import java.util.*;

public class Lesson4 {
    public static void main(String[] args) {
//        LinkedList<String> llist = new LinkedList<>();
//        llist.add("Red");
//        llist.add("Green");
//        llist.add("Black");
//        llist.add("White");
//        llist.add("Pink");
////        System.out.println(llist);
////        for (int i = 0; i < llist.size(); i++) {
////            System.out.println(llist.get(i));
////        }
//        Iterator<String> p = llist.listIterator();
//        while(p.hasNext()) {
//            System.out.println(p.next());
//        }
        HashSet<String> hset = new HashSet<>();
        hset.add("Red");
        hset.add("Green");
        hset.add("Black");
        hset.add("White");
        hset.add("Pink");
        hset.add("Yellow");
        System.out.println(hset);

        List<String> list = new LinkedList<>();
        List<String> res = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        while(!str.equals("ALT+DELETE")) {
            if(str.contains("ALT+TAB")) {
                int c = str.split("TAB").length % (list.size());
                String string = list.get((list.size() - c - 1));
                res.add(string);
                list.remove(string);
                list.add(string);
            } else {
                list.add(str);
                res.add(str);
            }
            str = s.nextLine();
        }
        for(String result : res) {
            System.out.println(result);
        }
    }
}
