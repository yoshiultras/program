public class Dequeue extends Queue{
    public Dequeue(int capacity) {
        array = new int[capacity];
        clear();
    }
    public Dequeue() {
        this(DEFSIZE);
    }
    public void pushFront(int val) throws Exception {
        push(val);
    }
    private int backward(int index) {
        return --index >= 0 ? index : array.length - 1;
    }
    public void pushBack(int val) throws Exception {
        if(++size > array.length) throw new Exception();
        array[head = backward(head)] = val;
    }
    public int popFront() throws Exception {
        return pop();
    }
    public int popBack() throws Exception {
        int val = back();
        tail = backward(tail);
        size -= 1;
        return val;
    }
    public int back() throws Exception {
        if(empty()) throw new Exception();
        return array[tail];
    }
}
