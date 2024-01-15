import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class BookReader {
    public String book;
    public MyLinkedList<String> words;

    public BookReader(String filename) throws IOException {
        readBook(filename);
        words = new MyLinkedList<>();
        parseWords();
    }

    public void readBook(String filename) throws IOException {
        BufferedReader inputStream = null;
        long duration = 0;
        long counter = 0;
        long start = System.currentTimeMillis();
        inputStream = new BufferedReader(new FileReader((filename)));
        StringBuffer str = new StringBuffer();
        int c;
        while((c = inputStream.read()) != -1) {
            str.append((char) c);
            counter++;
        }
        inputStream.close();
        long end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Reading input file " + filename + "... " + counter + " characters read"
                + " in " + duration + " milliseconds");
        book = str.toString();

        System.out.println();

    }

    public void parseWords() {
        StringBuilder word = new StringBuilder();
        String wordCharacters = "0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz'";
        StringBuilder finalWord = new StringBuilder();

        System.out.print("Adding words to a linked list... in ");



        long duration = 0;
        long start = System.currentTimeMillis();
        for (char c : book.toCharArray()) {
            if (wordCharacters.contains(String.valueOf(c))) {
                word.append(c);
                finalWord.append(c);

            } else {
                if (!word.isEmpty()) {
                    words.addBefore(word.toString());
                    word = new StringBuilder();
                    finalWord = new StringBuilder();
                }
            }
        }

        if (!finalWord.isEmpty()) {
            words.addBefore(finalWord.toString());
        }
    }
}
