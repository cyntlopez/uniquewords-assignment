import java.io.IOException;


public class UniqueWords {
    public BookReader book;
    public MyLinkedList<String> llOfUniqueWords;
    public MyArrayList<String> alOfUniqueWords;
    public MyOrderedList<String> olOfUniqueWords;

    public UniqueWords() throws IOException {
        book = new BookReader("WarAndPeace.txt");
        alOfUniqueWords = new MyArrayList<>();
        llOfUniqueWords = new MyLinkedList<>();
        olOfUniqueWords = new MyOrderedList<>();
    }

    public void addUniqueWordsToLinkedList() {
        long duration;
        long start = System.currentTimeMillis();
        System.out.print("Adding unique words to a linked list... ");

        MyLinkedList<String> list = book.words;
        list.first();

        while (list.current != null) {

            if (!llOfUniqueWords.contains(list.current.item)) {
                llOfUniqueWords.addBefore(list.current.item);
            }
            list.next();
        }

        long now = System.currentTimeMillis();
        duration = now - start;
        outputDuration(duration);

        System.out.println(book.words.size() + " words detected. ");
        System.out.println(llOfUniqueWords.size() + " unique words were found.");
        System.out.println(llOfUniqueWords.comparisons + " comparisons were made.");

        start = System.currentTimeMillis();
        System.out.print("Bubble sorting linked list... ");

        // sort
        llOfUniqueWords.sort();

        now = System.currentTimeMillis();
        duration = now - start;

        outputDuration(duration);
        System.out.println();
    }

    public void addUniqueWordsToArrayList() {
        long duration;
        long start = System.currentTimeMillis();
        System.out.print("Adding unique words to a array list... ");

        MyLinkedList<String>.Node current = book.words.first;

        int i = 0;

        while (current != null) {
            if (!alOfUniqueWords.contains(current.item)) {
                alOfUniqueWords.insert(current.item, i);
                i++;
            }
            current = current.next;
        }

        long now = System.currentTimeMillis();
        duration = now - start;
        outputDuration(duration);

        System.out.println(book.words.size() + " words detected. ");
        System.out.println(alOfUniqueWords.size() + " unique words were found.");
        System.out.println(alOfUniqueWords.comparisons + " comparisons were made.");

        start = System.currentTimeMillis();
        System.out.print("Bubble sorting array list... ");

        // sort
        alOfUniqueWords.sort();

        now = System.currentTimeMillis();
        duration = now - start;

        outputDuration(duration);
        System.out.println();
    }

    public void addUniqueWordsToOrderedList() {
        long duration;
        long start = System.currentTimeMillis();
        System.out.print("Adding unique words to an ordered list... ");

        MyLinkedList<String>.Node current = book.words.first;

        while (current != null) {
            if (!olOfUniqueWords.list.contains(current.item)) {
                olOfUniqueWords.add(current.item);
            }

            current = current.next;
        }

        long now = System.currentTimeMillis();
        duration = now - start;
        outputDuration(duration);

        System.out.println(book.words.size() + " words detected. ");
        System.out.println(olOfUniqueWords.size() + " unique words were found.");
        System.out.println(olOfUniqueWords.comparisons + " comparisons were made.");
    }

    private void outputDuration(long duration) {
        if (duration < 1000) {
            System.out.println(" in " + duration + " milliseconds.");
        } else {
            long pre = duration / 1000;
            long post = duration % 1000;
            System.out.println(" in " + pre + "." + post + " seconds.");
        }
    }
}
