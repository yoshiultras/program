import java.util.Arrays;

public class L2List extends L1List {
    private int[] prev;

    public L2List(int capacity) {
        array = new Object[capacity];
        next = new int[capacity + 2];
        prev = new int[capacity + 2];
        nilList = capacity;
        nilFree = capacity + 1;
        linkNext(nilList, nilList);
        linkNext(nilFree, 0);
        linkPrev(nilList, nilList);
        linkPrev(nilFree, capacity - 1);
        for (int i = 0; i < capacity - 1; i++)
            linkNext(i, i + 1);
        for (int i = 1; i < capacity; i++)
            linkPrev(i, i-1);
        linkNext(capacity - 1, nilFree);
        linkPrev(0, nilFree);
        before = after = nilList;
    }

    public L2List(){
        this(DEFSIZE);
    }

    private void linkNext(int first, int second) {
        link(first, second);
    }
    private void linkPrev(int first, int second) {
        prev[first] = second;
    }
    private int reverseMallocIndex() {
        int index = prev[nilFree];
        linkPrev(nilFree, prev[index]);
        return index;
    }
    private void freeNextIndex(int index) {
        freeIndex(index);
    }
    private void freePrevIndex(int index) {
        linkPrev(index, next[nilFree]);
        linkPrev(nilFree, index);
    }
    public void toBack() {
        after = prev[nilList];
        before = nilList-1;
    }
    public boolean begin() {
        return after == 0;
    }
    public void backward() throws Exception {
        if(after == 1)
            throw new Exception();
        after = before;
        before = prev[before];
    }
    public Object before() throws Exception {
        return array[before];
    }
    public void insertFront(Object val) throws Exception {
        insert(val);
    }
    public void insertBack(Object val) throws Exception {
        int prevIndex = reverseMallocIndex();
        linkPrev(before, prevIndex);
        linkPrev(prevIndex, after);
        before = prevIndex;
        array[prevIndex] = val;
    }
    public Object frontErase() throws Exception {
        Object val = array[after];
        int index = after;
        after = next[index];
        linkNext(before, after);
        linkPrev(before, after);
        freeIndex(index);
        freePrevIndex(index);
        return val;
    }
    public Object backErase() throws Exception {
        Object val = array[before];
        int index = before;
        before = prev[index];
        linkPrev(after, before);
        linkNext(after, before);
        freePrevIndex(index);
        freeNextIndex(index);
        return val;
    }

    public static void main(String[] args) throws Exception {
        L2List list = new L2List(5);
        for (int i = 0; i < 5; i++) {
            list.insertFront(i);
        }

        list.toBack();
        list.backErase();

        for (int i = 0; i < 4; i++) {
            System.out.println(list.before());
            if(i==3) break;
            list.backward();
        }
    }
}
