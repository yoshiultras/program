public class Task {
    public static void main(String[] args) throws Exception {
        System.out.println(task("cc[cc]"));
        System.out.println(task("cc{cc[cc]cc}cc"));
        System.out.println(task("cc{cc[cc}cc]cc"));
        System.out.println(task("{cc(cc]cc}cc"));
        System.out.println(task("cc[cc{cc}cc]cc}"));
        System.out.println(task("cc{cc(cc)"));
        System.out.println(task(""));
        System.out.println(task("("));
        System.out.println(task("(]"));
    }
    public static boolean task(String str) throws Exception {
        Stack stack = new Stack(str.length());
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(') stack.push(chars[i]);
            if(chars[i] == ')') if(stack.empty()) return false;
            else if (stack.top() == '(') stack.pop();

            if(chars[i] == '[') stack.push(chars[i]);
            if(chars[i] == ']') if(stack.empty()) return false;
            else if (stack.top() == '[') stack.pop();

            if(chars[i] == '{') stack.push(chars[i]);
            if(chars[i] == '}') if(stack.empty()) return false;
            else if (stack.top() == '{') stack.pop();
        }
        if(stack.empty()) return true;
        else return false;
    }
}
