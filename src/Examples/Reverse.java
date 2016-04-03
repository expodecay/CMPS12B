package Examples;

/**
 * Created by Rick on 4/2/2016.
 */
//-----------------------------------------------------------------------------
// Reverse.java
//-----------------------------------------------------------------------------

public class Reverse {

    // print out the reversal of the leftmost n elements in A
    public static void reverseArray1(int[] A, int n) {
        // if n==0 do nothing
        if(n > 0) {
            System.out.print(A[n-1] + " "); // print nth element from left
            reverseArray1(A, n-1);       // print leftmost n-1 elements, reversed
        }
    }

    // print out the reversal of the rightmost n elements in A
    public static void reverseArray2(int[] A, int n) {
        // if n==0 do nothing
        if( n>0 ){
            reverseArray2(A, n-1);       // print the rightmost n-1 elements, reversed
            System.out.print(A[A.length-n] + " ");  // print the nth element from right
        }
    }

    public static void main(String[] args) {
        int[] B = {1,2,3,4,5,6,7,8,9,10};
        int[] C = {1,2,3,4,5,6,7,8,9,10};
        reverseArray1(C, C.length);
        System.out.println();
        reverseArray2(B, B.length);
        System.out.println();
    }
}