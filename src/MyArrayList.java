

public class MyArrayList<Type extends Comparable<Type>> {
    protected int capacity = 16;
    protected int size = 0;
    public long comparisons = 0;
    protected Type[] list = (Type[]) new Comparable[capacity];

    public void insert(Type item, int index) {
        if (index < 0 || index > size) {
            return;
        }
        if (size == capacity) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = item;
        size++;
    }

    public Type remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Type element = list[index];

        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return element;
    }

    public boolean contains(Type item) {
        for (int i = 0; i < size; i++) {
            comparisons++;
            if (list[i].compareTo(item) == 0) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Type item) {
        for (int i = 0; i < size; i++) {
            if (list[i].compareTo(item) == 0) {
                return i;
            }
        }
        return -1;
    }

    public Type get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return list[index];
    }

    public void set(int index, Type item) {
        if (index >= 0 && index < size) {
            list[index] = item;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder listString = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            listString.append(list[i]);

            if (i < size - 1) {
                listString.append(", ");
            }
        }
        listString.append("]");

        return listString.toString();
    }
    public void sort() {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (get(j) != null && get(j + 1) != null && get(j).compareTo(get(j + 1)) > 0) {
                    Type temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }

    protected void resize() {
        capacity *= 2;
        Type[] newList = (Type[]) new Comparable[capacity];

        if (size >= 0) System.arraycopy(list, 0, newList, 0, size);

        list = newList;
    }
}
