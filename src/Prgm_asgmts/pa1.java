package Prgm_asgmts;
/**
 * Created by Rick on 4/2/2016.
 */

import java.util.Arrays;
public class pa1 {
    public static void main(String[] args) {
        int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int minIndex = minArrayIndex(A, 0, A.length-1);
        int maxIndex = maxArrayIndex(A, 0, A.length-1);

        for(int x: A) System.out.print(x+" ");
        System.out.println();

        System.out.println( "minIndex = " + minIndex );
        System.out.println( "maxIndex = " + maxIndex );
        reverseArray1(A, A.length, B);
        for(int x: B) System.out.print(x+" ");
        System.out.println();

        reverseArray2(A, A.length, C);
        for(int x: C) System.out.print(x+" ");
        System.out.println();

        reverseArray3(A, 0, A.length-1);
        for(int x: A) System.out.print(x+" ");
        System.out.println();
    }

    // copy the LEFTMOST n elements in X[] into the RIGHTMOST n positions in Y[] in reverse order.
    static void reverseArray1(int[] X, int n, int[] Y){
        // initially, n = X.length :: (initial Y position = X.length   initial X position = 0)
        if(n > 0) {                    // Iterations end when left most element of X is reached.
            Y[n-1] = X[X.length-n];    // set nth element from left in Y equal to nth element from right in X.
            reverseArray1(X, n-1, Y);  // call function for next left element in X. (next right element in Y )
        }
    }

    // copy the RIGHTMOST n elements in X[] into the LEFTMOST n positions in Y[] in reverse order.
    static void reverseArray2(int[] X, int n, int[] Y){
        // initially, n = X.length :: (initial Y position = 0   initial X position = X.length)
        if(n > 0) {
            Y[X.length-n] = X[n-1];
            reverseArray2(X, n-1, Y);
        }
    }

    // swaps the elements at positions i and j, then calls itself recursively on the subarray X[i+1,...,j-1]
    static void reverseArray3(int[] X, int i, int j){
        // initial i = 0   initial j = X.length-1
        int temp ;
        if(j>i){  // Ends of i and j cross each others position.
            temp = X[j];
            X[j] = X[i];    // Swap
            X[i] = temp;
            reverseArray3(X, i+1, j-1); // Recurse over next right position in i and left position in j.
        }
    }

    static int maxArrayIndex(int[] X, int p, int r){
        int q = (p + r) / 2;

        if (X.length == 1) {
            return X.length - 1;
        }
        return maxIndex(p, q, X);
        //max = maxIndex(q + 1, r, X);
    }
    static int minArrayIndex(int[] X, int p, int r){
        int q = (p + r) / 2;

        if (X.length == 1) {
            return X.length - 1;
        }
        return minIndex(p, q, X);
        //max = maxIndex(q + 1, r, X);
    }

    public static int maxIndex(int i, int j, int[] a) {
        if (i == a.length - 1) return a.length - 1;
        j = maxIndex(i + 1, j, a);
        if (a[i] > a[j])
            return i;
        return j;
    }

    public static int minIndex(int i, int j, int[] a) {
        if (i == a.length - 1) return a.length - 1;
        j = minIndex(i + 1, j, a);
        if (a[i] < a[j])
            return i;
        return j;
    }
}
