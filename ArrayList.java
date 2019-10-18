public class ArrayList<T> implements List<T>{
    T[] a = (T[]) new Object[10];
    int size = 0;

    public void add(T item){
        if(size == a.length){
            growArray();
        }
        a[size++]=item;
    }

    public void add(int pos, T item){
        try {
            if (pos > size || pos < 0) {
                throw new Exception();
            }
        }
        catch (Exception e){}

        if (size == a.length){
            growArray();
        }

        for(int i = size-1; i > pos; i--){
            a[i+1] = a[i];
        }
        a[pos] = item;
        ++size;
    }

    public T get(int pos){
        try {
            if (pos > size || pos < 0) {
                throw new Exception();
            }
        }
        catch (Exception e){}
        return a[pos];
    }

    public T remove(int pos){
        try {
            if (pos > size || pos < 0) {
                throw new Exception();
            }
        }
        catch (Exception e){}

        T temp = a [pos];
         for (int i = pos; i < size-1; i++){
             a[i] = a[i+1];
         }
         --size;

         return temp;
    }

    public int size(){
        return size;
    }

    public void growArray(){
        T[] var2 = (T[]) new Object[a.length*2];

        for (int i = 0; i < a.length; i++){
            var2[i] = a[i];
        }
        a = var2;
    }
}
