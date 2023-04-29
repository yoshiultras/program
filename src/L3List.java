public class L3List<T> {
    private Node<T> first, last; //Ссылки на первый и последний узлы.
    private int size;
    public L3List(){
        first = last = null;
        size = 0;
    }
    //Добавить элемент в конец списка.
    public void append(Node<T> node){
        node.next = null;
        if(first == null) //Первый элемент.
            first = node;
        if(last != null)
            last.next = node;
        last = node;
        size++;
    }
    public int find(Node<T> node) {
        int res = 0;
        Node<T> temp = first;
        try {
            while (!temp.equals(node)) {
                temp = temp.next;
                res++;
            }
        } catch(NullPointerException e) {
            return -1;
        }
        return res;
    }

    public void insert(Node<T> node, int location) {
        int tempLoc = 0;
        Node<T> tempNode = first;
        int c = 0;
        while (tempLoc != location) {
            tempLoc++;
            if (c > 0) first = first.next;
            c++;
        }
        if (location != 0) {
            first.next = node;
            first = tempNode;
        } else {
            first = node;
        }
    }

    public void remove(int location) {
        int tempLoc = 0;
        Node<T> tempNode = first;
        int c = 0;
        while (tempLoc != location) {
            tempLoc++;
            if (c > 0) first = first.next;
            c++;
        }
        if (location != 0) {

            first.next = first.next.next;
            first = tempNode;
        } else {
            first = first.next;
        }
        size--;
    }

    public Node<T> get(int location) {
        int tempLoc = 0;
        Node<T> tempNode = first;
        int c = 0;
        while (tempLoc != location) {
            tempLoc++;
            if (c > 0) first = first.next;
            c++;
        }
        if (location != 0) {
            if(first.next != null) {
                Node<T> temp = first.next;
                first = tempNode;
                return temp;
            }
            return null;
        } else {
            return first;
        }
    }
    public int size() {
        return size;
    }
}
