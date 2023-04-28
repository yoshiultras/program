
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class Lesson4_5_1 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("input.txt");
        Scanner scanner = new Scanner(fr);
        List<String> words = new ArrayList<>();
        while(scanner.hasNextLine()) {
            words.addAll(List.of(scanner.nextLine().toLowerCase().replaceAll("[^à-ÿ[\s]]", "").split(" ")));
        }
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        fr.close();
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        res.delete(0, res.indexOf("\n") + 1);
        FileWriter fw = new FileWriter("output.txt");
        fw.write(res.toString());
        fw.close();
    }
}
