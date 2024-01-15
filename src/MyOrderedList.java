public class MyOrderedList<Type extends Comparable<Type>> {
    protected MyArrayList<Type> list = new MyArrayList<>();
    public long comparisons = 0;

    public void add(Type item) {
        comparisons++;
        list.insert(item, list.size());
        int i = list.size() - 1;

        while (i > 0 && item.compareTo(list.get(i - 1)) < 0) {
            comparisons++;
            Type temp = list.get(i);
            list.set(i, list.get(i - 1));
            list.set(i - 1, temp);
            i--;
        }
    }

    public Type remove(Type item) {
        int index = list.indexOf(item);
        if (!list.isEmpty()) {
            if (index != -1) {
                return list.remove(index);
            }
        }
        return null;
    }

    public boolean binarySearch(Type item) {
        int start = 0;
        int finish = list.size() - 1;
        int mid;

        while (start <= finish) {
            mid = (start + finish) / 2;

            int result = list.get(mid).compareTo(item);

            if (result == 0) {
                return true;
            } else if (result < 0) {
                start = mid + 1;
            } else {
                finish = mid - 1;
            }
        }
        return false;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }
}
