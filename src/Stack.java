public class Stack {
    private static final  int DEFSIZE = 16;
    private char[] array;
    private int head;

    public Stack(int capacity) {
        array = new char[capacity];
        head = 0;
    }
    public Stack() {
        this(DEFSIZE);
    }

    public boolean empty() {
        return head == 0;
    }
    public void clear() {
        head = 0;
    }
    public void push(char val) throws Exception {
        array[head++] = val;
    }
    public char pop() throws Exception {
        return array[--head];
    }
    public char top() throws Exception {
        return array[head - 1];
    }
    public int size() {
        return head;
    }
}
