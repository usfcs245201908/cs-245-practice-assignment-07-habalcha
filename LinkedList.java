public class LinkedList<T> implements List<T> {

    node<T> head;
    int size = 0;

    class node <T> {
        T data;
        node<T> next;
        public node(T item){
            data = item;
            next = null;
        }
    }

    public void add(T item){
        if (head == null){
            head = new node(item);
            ++ size;
        }

        else{
            node n = new node(item);
            node prev = head;

            while(prev.next != null){
                prev = prev.next;
            }

            prev.next = n;
            ++size;
        }
    }

    public void add(int pos, T item){
        try {
            if (pos > size || pos < 0) {
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println ("Position is not valid.");
        }

        node n = new node(item);
        if (pos == 0){
            n.next = head;
            head = n;
            ++size;
            }
        else{
            node prev = head;
            for (int i = 0; i < pos-1; i++){
                prev = prev.next;
            }

            n.next = prev.next;
            prev.next = n;
            ++ size;
        }
    }

    public T get(int pos){
        try {
            if (pos > size || pos < 0) {
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println ("Position is not valid.");
        }

        if (pos == 0){
            return head.data;
        }

        node<T> val = head;
        while (val.next != null){
            val = val.next;
        }
        return val.data;
    }

    public T remove(int pos){
        try {
            if (pos > size || pos < 0) {
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println ("Position is not valid.");
        }

        if (pos == 0){
            node<T> n = head;
            head = head.next;
            -- size;
            return n.data;
        }
        else {
            node<T> prev = head;
            for (int i = 0; i < pos-1; i++) {
                prev = prev.next;
            }
            node<T> n = prev.next;
            if (n.next != null){
                prev.next = n.next;
            }
            --size;
            return n.data;
        }
    }

    public int size(){
        return size;
    }
}