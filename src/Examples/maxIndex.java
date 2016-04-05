package Examples;

/**
 * Created by Rick on 4/3/2016.
 */
public class maxIndex {
    public static void main(String[] args) {
        int[] a = {1,2,3,75,4,5};
        int b = getMax(a, 0, a.length-1);
        System.out.println(b);
    }

    static int getMax(int[] A, int p, int r){
        int g = getLargest(A,p,r);
        int max =0;
        for(int i = 0; i<A.length; i++){
            if(g == A[i]){
                max = i;
            }
        }
        return max;
    }

    private static int getLargest(int[] myArray, int from, int to) {
        int maxIndex = from;
        maxIndex += from;
        int middle = (from + to)  / 2;
        if (from + 1 == to) {
            return myArray[from];
        } else {
            maxIndex += middle;
            return Math.max(getLargest(myArray, from, middle), getLargest(myArray, middle, to));
        }
    }
}
