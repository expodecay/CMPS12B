package Prgm_asgmts.pa3;

// Rick Ramirez
// riryrami
// 12B
// 04/27/16
// Test program for Dictionary.java
// DictionaryTest.java
public class DictionaryTest {
    public static void main(String[] args) {

        Dictionary test = new Dictionary();
        System.out.println("New dictionary created.");
        System.out.println("isEmpty(): " + test.isEmpty());
        System.out.println("size(): " + test.size());
        System.out.println();

        System.out.println("Inserting 3 keys (a, b, and c) and 3 values");
        test.insert("a", "apple");
        test.insert("b", "banana");
        test.insert("c", "cat");

        System.out.println("isEmpty(): " + test.isEmpty());
        System.out.println("size(): " + test.size());

        System.out.println("test.lookup(\"a\"): " + test.lookup("a"));
        System.out.println("test.lookup(\"b\"): " + test.lookup("b"));
        System.out.println("test.lookup(\"c\"): " + test.lookup("c"));

        System.out.println();
        System.out.println("Deleting key: b");
        test.delete("b");
        System.out.println("isEmpty(): " + test.isEmpty());
        System.out.println("size(): " + test.size());
        System.out.println("test.lookup(\"a\"): " + test.lookup("a"));
        System.out.println("test.lookup(\"b\"): " + test.lookup("b"));
        System.out.println("test.lookup(\"c\"): " + test.lookup("c"));

        /*
        System.out.println();
        System.out.println("Inserting duplicate a");
        test.insert("a", "err");
        */
        System.out.println();
        System.out.println("Dictionary's current state, test.toString()");
        System.out.println(test);

        System.out.println();
        System.out.println("Deleting all contents, test.makeEmpty()");
        test.makeEmpty();
        System.out.println("isEmpty(): " + test.isEmpty());
        System.out.println("size(): " + test.size());
    }
}
