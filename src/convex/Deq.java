package convex;

//Непрерывная реализация дека.
class Deq<T>{
    private final static int DEFSIZE = 16;
    private T[] array;
    private int size, head, tail;

    public Deq(int size){
        array = (T[]) new Object[size];
        this.size = head = 0;
        tail = array.length - 1;
    }

    public Deq(){
        this(DEFSIZE);
    }

    private int forward(int index){
        return ++index < array.length ? index : 0;
    }

    private int backward(int index){
        return --index >= 0 ? index : array.length - 1;
    }

    public int length(){
        return size;
    }

    public void pushFront(T p){
        array[head = backward(head)] = p;
        size += 1;
    }

    public void pushBack(T p){
        array[tail = forward(tail)] = p;
        size += 1;
    }

    public T popFront(){
        T p = front();
        head = forward(head);
        size -= 1;
        return (T) p;
    }

    public T popBack(){
        T p = back();
        tail = backward(tail);
        size -= 1;
        return p;
    }

    public T front(){
        return array[head];
    }

    public T back(){
        return array[tail];
    }

}