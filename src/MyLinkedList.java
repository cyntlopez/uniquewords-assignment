
public class MyLinkedList<Type extends Comparable<Type>> {
    protected class Node {
       public Type item;
       public Node next;

       public Node(Type theItem, Node theNext) {
           item = theItem;
           next = theNext;
       }

       public String toString() {
           return item.toString();
       }
    }
    public long comparisons = 0;
    protected Node first = null;
    protected Node current = null;
    protected Node previous = null;
    protected int size = 0;
    public void addBefore(Type item) {
      Node newNode = new Node(item, current);

      if (previous == null) {
          first = newNode;

      } else {

          previous.next = newNode;
      }

      previous = newNode;
      size++;
    }

    public void addAfter(Type item) {
        if (current != null) {
            current.next = new Node(item, current.next);
            size++;
        }
    }

    public Type current() {
        if (current == null) {
            return null;
        }

        return current.item;
    }

    public Type first() {
        if (first == null) {
           return null;
        }
        current = first;
        previous = null;
        return first.item;
    }

    public Type next() {
        if (current == null) {
            return null;
        }
        if (first == current) {
            previous = first;
        } else {
            previous.next = current;
            previous = previous.next;
        }

        current = current.next;

        if (current == null) {
            return null;
        }

        return current.item;
    }

    public Type remove() {
        if (current == null) {
            return null;
        }
        Type removedItem = current.item;

        if (previous != null) {
            previous.next = current.next;

        } else {
            first = current.next;
        }

        current = current.next;
        size--;
        return removedItem;
    }

    public boolean contains(Type item) {
        //upgrade to use compareTo
        Node currentNode = first;
        while (currentNode != null) {
            comparisons++;
            if (currentNode.item.compareTo(item) == 0) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder listString = new StringBuilder("[");
        Node curr = first;

        while (curr != null) {
            listString.append(curr.item);
            if (curr.next != null) {
                listString.append(", ");
            }
            curr = curr.next;
        }
        listString.append("]");
        return listString.toString();
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            boolean inversion = false;
            current = first;
            for (int j = 0; j < size-i-1; j++) {

                if (current != null && current.next != null && current.item.compareTo(current.next.item) > 0) {
                    inversion = true;

                    Type temp = current.item;
                    current.item = current.next.item;
                    current.next.item = temp;
                }
                assert current != null;
                current = current.next;
            }
            if (!inversion)
                break;
        }
    }
}

