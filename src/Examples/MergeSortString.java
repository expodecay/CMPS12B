package Examples;

/**
 * Created by Rick on 4/13/2016.
 */
public class MergeSortString{

    // mergeSort()
    // sort subarray A[p...r]
    public static void mergeSort(String[] A, int p, int r){
        int q;
        if(p < r) {
            q = (p+r)/2;
            // System.out.println(p+" "+q+" "+r);
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    // merge()
    // merges sorted subarrays A[p..q] and A[q+1..r]
    public static void merge(String[] A, int p, int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;
        String[] L = new String[n1];
        String[] R = new String[n2];
        int i, j, k;

        for(i=0; i<n1; i++) L[i] = A[p+i];
        for(j=0; j<n2; j++) R[j] = A[q+j+1];
        i = 0; j = 0;
        for(k=p; k<=r; k++){
            if( i<n1 && j<n2 ){
                if( L[i].compareTo(R[j]) < 0){
                    A[k] = L[i];
                    i++;
                }else{
                    A[k] = R[j];
                    j++;
                }
            }else if( i<n1 ){
                A[k] = L[i];
                i++;
            }else{ // j<n2
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        String[] B = {"gass", "gas", "scatter", "pion"};

        mergeSort(B, 0, B.length-1);
        for(int i=0; i<B.length; i++) System.out.print(B[i]+" ");
        System.out.println();
        for(int i=0; i<B.length; i++) System.out.print("\"" + B[i]+"\" , ");
        System.out.println();
    }
}