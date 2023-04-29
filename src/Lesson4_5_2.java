import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4_5_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Map<String,Integer> map = new HashMap<>();
        while(!str.equals("")) {
            String[] res = str.split(" ");
            if(map.containsKey(res[0])) {
                map.put(res[0], Integer.parseInt(res[1]) + map.get(res[0]));
            }
            else {
                map.put(res[0], Integer.parseInt(res[1]));
            }
            str = s.nextLine();
        }
        System.out.println(map);
    }
    class PhoneDictionary {
        private HashMap<String, String> numbers;

        public PhoneDictionary() {
        }

        public PhoneDictionary(HashMap<String, String> numbers) {
            this.numbers = numbers;
        }

        public void addNumber(String number, String name) {
            numbers.put(number, name);
        }
        public String getNameByNumber(String number) {
            return numbers.get(number);
        }
        public String eraseNumber(String number) {
            return numbers.remove(number);
        }
    }
}
