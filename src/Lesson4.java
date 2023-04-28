import java.util.*;

public class Lesson4 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        List<String> res = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        while(!str.equals("")) {
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
