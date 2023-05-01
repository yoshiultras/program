import java.util.Scanner;

public class Lesson5 {
    public static void main(String[] args) {
//        String regex1 = "";
//        String regex2 = "a";
//        String regex3 = "ab";
//        String regex4 = "a|b";
//        String regex5 = "a*";
//        String regex6 = "a+";
//        String regex7 = "aa*"; //Ёквивалент regex6.
//        String regex8 = "\\**";
//        String regex9 = "a*b*";
//        String regex10 = "aa*bb*";
//        String regex11 = "a*|b*";
//        String regex12 = "(a|b)*";
//        String regex13 = "a|b*";
//        String regex14 = "(aab|ab)*";
//        Scanner in = new Scanner(System.in);
//        while (true) {
//            String input = in.nextLine();
//            boolean result = input.matches(regex14);
//            System.out.println(result);
//        }
        third();
    }
    public static void first() {
        Scanner s = new Scanner(System.in);
        String regex = "(1|2|3|4|5|6|7|8|9)((0|1|2|3|4|5|6|7|8|9)*)";
        while (true) {
            String input = s.nextLine();
            boolean result = input.matches(regex);
            System.out.println(result);
        }
    }
    public static void second() {
        Scanner s = new Scanner(System.in);
        String regex = "((-|)(1|2|3|4|5|6|7|8|9)((0|1|2|3|4|5|6|7|8|9)*))|" +
                        "((-|)(1|2|3|4|5|6|7|8|9)((0|1|2|3|4|5|6|7|8|9)*(\\.|,)(0|1|2|3|4|5|6|7|8|9)+))|((-|)(0|1|2|3|4|5|6|7|8|9)(\\.|,)(0|1|2|3|4|5|6|7|8|9)+)|0";
        while (true) {
            String input = s.nextLine();
            boolean result = input.matches(regex);
            System.out.println(result);
        }
    }
    public static void third() {
        Scanner s = new Scanner(System.in);
        String allChars = "(q|w|e|r|t|y|u|i|o|p|a|s|d|f|g|h|j|k|l|z|x|c|v|b|n|m|1|2|3|4|5|6|7|8|9|0|_)+";
        String comChars = "(q|w|e|r|t|y|u|i|o|p|a|s|d|f|g|h|j|k|l|z|x|c|v|b|n|m)+";
        String regex = "(" + allChars + "((\\." + allChars + ")|)+)" + "@" + "(" + allChars + "\\.)+" + comChars;
        while (true) {
            String input = s.nextLine().toLowerCase();
            boolean result = input.matches(regex);
            System.out.println(result);
        }
    }
}