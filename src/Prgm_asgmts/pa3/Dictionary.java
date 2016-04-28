package Prgm_asgmts.pa3;

// Rick Ramirez
// riryrami
// 12B
// 04/27/16
// Uses linked lists to create a dictionary class.
// Dictionary.java
public class Dictionary implements DictionaryInterface{

    /* Node class */
    private class Node{
        String key, value;
        Node next;

        // Constructor
        Node(String key, String value){
            this.value = value;
            this.key = key;
            next = null;
        }
    }

    // Fields for the Dictionary class
    private Node head; // reference to first Node in List
    private int numberOfElements; // number of items in this Dictionary

    // findKey()
    // return a reference to the Node containing its argument key
    private Node findKey(String key){
        Node N = head;
        while( N != null){
            if( N.key.equals(key)){
                return N;
            }else{
                N = N.next;
            }
        }return null;
    }
    // isEmpty()
    // pre: none
    // returns true if this Dictionary is empty, false otherwise
    public boolean isEmpty(){
        return (numberOfElements == 0);
    }

    // size()
    // pre: none
    // returns the number of entries in this Dictionary
    public int size(){
        return numberOfElements;
    }

    // lookup()
    // pre: none
    // returns value associated key, or null reference if no such key exists
    // Same form as findKey()
    public String lookup(String key){
        // Node test = findKey("2");
        // System.out.println("key: " + test.key + "---- Value: " + test.value);
        Node N = head;
        while (N != null ){
            if(N.key.equals(key)){
                return N.value; // If input value matches key, return value
            }N = N.next;
        }return null;
    }

    // insert()
    // inserts new (key,value) pair into this Dictionary
    // pre: lookup(key)==null
    public void insert(String key, String value) throws DuplicateKeyException{
        if ( lookup(key) != null ){
            throw new DuplicateKeyException("cannot insert duplicate keys");
        } else{
            if( head == null ){
                head = new Node(key, value); // Insert key and value
                numberOfElements++;
            } else{
                Node N = head;
                while ( true ){ // (N != null) is always true if this branch is entered
                    if( N.next == null ){ // Once the empty key/value pair is hit, break
                        break;
                    }
                    N = N.next; // Move N from head to empty location
                }
                N.next = new Node(key, value); // Break lands here, insert key and value
                numberOfElements++;
            }
        }
    }

    // delete()
    // deletes pair with the given key
    // pre: lookup(key)!=null
    public void delete(String key) throws KeyNotFoundException{
        if( lookup(key) == null ){
            throw new KeyNotFoundException("cannot delete non-existent key");
        }
        else{
            if( numberOfElements <= 1 ){
                Node N = head; // Assign N to head
                head = head.next; // Shift head once place over
                N.next = null; // Remove key/value pair from previous location
                numberOfElements--;
            }
            else{
                // See if match is at head
                Node N = head; // Start at head
                if( N.key.equals(key) ){ // Once the key is hit, do the same as before
                    head = head.next;
                    N.next = null;
                    numberOfElements--;
                }
                else{
                    while( !N.next.key.equals(key) ){
                        N = N.next;
                    }
                    // Cannot just set to null here
                    // Need to adjust link from N-N.next to N-N.next.next
                    N.next = N.next.next;
                    numberOfElements--;
                }
            }
        }
    }

    // makeEmpty()
    // pre: none
    public void makeEmpty(){
        head = null;
        numberOfElements = 0;
    }

    // toString()
    // returns a String representation of this Dictionary
    // overrides Object's toString() method
    // pre: none
    public String toString(){
        String s = "";
        Node N = head;
        while (N != null){
            s += N.key + " " + N.value + "\n";
            N = N.next;
        }
        return s;
    }
}
