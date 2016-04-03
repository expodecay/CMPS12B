package Prgm_asgmts;
/**
 * Created by Rick on 4/2/2016.
 */

import java.util.Arrays;
public class pa1 {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        int[] b = new int[a.length];
        reverseArray1(a, a.length, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    // copy the leftmost n elements in X[] into the rightmost n positions in Y[] in reverse order.
    static void reverseArray1(int[] X, int n, int[] Y){
        // initially, n = X.length :: (initial Y position = X.length   initial X position = 0)
        if(n > 0) {                    // Iterations end when left most element of X is reached.
            Y[n-1] = X[X.length-n];    // set nth element from left in Y equal to nth element from right in X.
            reverseArray1(X, n-1, Y);  // call function for next left element in X. (next right element in Y )
        }
    }
    static void reverseArray2(int[] X, int n, int[] Y){

    }
    static void reverseArray3(int[] X, int i, int j){

    }
    static int maxArrayIndex(int[] X, int p, int r){
        return p;

    }
    static int minArrayIndex(int[] X, int p, int r){
        return p;
    }
}
