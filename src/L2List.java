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
        before = next[before];
    }
    public Object before() throws Exception {
        return array[before];
    }
    public void insertFront(Object val) throws Exception {
        int nextIndex = mallocIndex();
        int prevIndex = reverseMallocIndex();

        linkNext(before, nextIndex);
        linkNext(nextIndex, after);
        linkPrev(before, prevIndex);
        linkPrev(prevIndex, after);
        after = nextIndex;
        array[nextIndex] = val;
//        System.out.println("frontInsert");
//        System.out.println(before + " " + after);
    }
    public void insertBack(Object val) throws Exception {
        int nextIndex = mallocIndex();
        int prevIndex = reverseMallocIndex();

        linkNext(before, nextIndex);
        linkNext(nextIndex, after);
        linkPrev(before, prevIndex);
        linkPrev(prevIndex, after);
        before = prevIndex;
        array[prevIndex] = val;
        System.out.println("backInsert");
        System.out.println(before + " " + after);
        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(prev));
    }
//    public Object frontErase() throws Exception {
//        Object val = array[after];
//        int index = after;
//        after = next[index];
//        linkNext(before, after);
//
//        int index1 = before;
//        before = next[index1];
//        linkPrev(before, after);
//
//        freeNextIndex(index);
//        freePrevIndex(++index1);
//        System.out.println("frontErase");
//        System.out.println(before + " " + after);
//        return val;
//    }
//    public Object backErase() throws Exception {
//        System.out.println(Arrays.toString(next));
//        System.out.println(Arrays.toString(prev));
//        Object val = array[before];
//
//
//        int index = after;
//        after = next[index];
//        linkNext(before, after);
//        linkPrev(before, after);
//
//        freePrevIndex(index);
//        freeNextIndex(index);
//        System.out.println("backErase");
//        System.out.println(before + " " + after);
//        System.out.println(Arrays.toString(next));
//        System.out.println(Arrays.toString(prev));
//        return val;
//    }

    public static void main(String[] args) throws Exception {
        L2List list = new L2List(5);
        for (int i = 0; i < 5; i++) {
            list.insertBack(i);
        }
        for (int i = 0; i < 5; i++) {
            list.backward();
            list.before();
        }
    }
}
