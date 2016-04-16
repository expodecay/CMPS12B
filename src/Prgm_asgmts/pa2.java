package Prgm_asgmts;

/**
 * Created by Rick on 4/13/2016.
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class pa2{
    public static void main(String[] args) throws IOException {
        Scanner input = null;
        String line = null;
        String[] token = null;
        int[] lineNumber = null;
        int i, totalLineNumber = 0;

        // check number of command line arguments is at least 2
        if(args.length < 2){
            System.out.println("Usage: Search file target1 [target2 ..]");
            System.exit(1);
        }

        // Counts number of lines in input file.
        input = new Scanner(new File(args[0]));
        while( input.hasNextLine() ){
            totalLineNumber++;
            line = input.nextLine(); // Must be here else to refresh Scanner
        }

        // Initialize token and lineNumber arrays to size of totalLineNumber.
        token = new String[totalLineNumber];
        lineNumber = new int[totalLineNumber];

        // Read through input file again
        input = new Scanner(new File(args[0]));

        // Populate lineNumber[] and token[]
        for(i = 0; i < lineNumber.length; i++){
            lineNumber[i] = i+1;
            token[i] = input.nextLine();
        }

        // Puts the string Array in order
        mergeSort(token, lineNumber, 0, token.length-1);
        // Print the result of a Binary search for target
        for(int j=1; j<args.length; j++){
            System.out.println( binarySearch(token, lineNumber, 0, token.length-1, args[j]));
        }

        input.close();
    }

    static void mergeSort(String[] word, int[] lineNumber, int p, int r){
        int q;
        if(p<r){
            q = (p+r)/2;
            mergeSort(word, lineNumber, p, q);
            mergeSort(word, lineNumber, q+1, r);
            merge(word, lineNumber, p, q, r);
        }
    }

    static void merge(String[] word, int[] lineNumber, int p, int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;
        // Left and right end of token[]
        String[] L = new String[n1];
        String[] R = new String[n2];
        // Left and right end of lineNumber[]
        int[] a = new int[n1];
        int[] b = new int[n2];
        int i, j, k;

        for(i=0; i<n1; i++){
            L[i] = word[p+i];
            a[i] = lineNumber[p+i];
        }
        for(j=0; j<n2; j++){
            R[j] = word[q+j+1];
            b[j] = lineNumber[q+j+1];
        }
        i = 0;
        j = 0;
        for(k=p; k<=r; k++){
            if( i<n1 && j<n2){
                if( L[i].compareTo(R[j])>0 ){
                    word[k] = L[i];
                    lineNumber[k] = a[i];
                    i++;
                }
                else{
                    word[k] = R[j];
                    lineNumber[k] = b[j];
                    j++;
                }
            }
            else if( i<n1){
                word[k] = L[i];
                lineNumber[k] = a[i];
                i++;
            }
            else{
                word[k] = R[j];
                lineNumber[k] = b[j];
                j++;
            }
        }
    }
    public static String binarySearch(String[] word, int[] lineNumber, int p, int r, String target) {
        int q;

        // Break case (reached end of array)
        if (p > r) {
            return target + " not found";
        } else {
            q = (p + r) / 2;

            // Base case
            if (word[q].compareTo(target) == 0) {
                return target + " found on line " + lineNumber[q];
            }
            // Search left end
            else if (word[q].compareTo(target) < 0) {
                return binarySearch(word, lineNumber, p, q, target);
            }
            // Search right end
            else {
                return binarySearch(word, lineNumber, q + 1, r, target);
            }
        }
    }
}
