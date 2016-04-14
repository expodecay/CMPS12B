package Labs.Lab2;

/**
 * Created by Rick on 4/10/2016.
 *
 * CMPS12B\out\production\CMPS12B
 * java Labs.Lab2.FileReverse lab2TestIn lab2TestOut
 */
/*
 Rick Ramirez
 riryrami
 12M
 04/11/16
 This program takes an input text file, processes the text into tokens, then reverses each token.
 The result is sent to an output file.
 reverseStrings.java
 */
import java.io.*;
import java.util.Scanner;
public class FileReverse {
    public static void main(String[] args) throws IOException{
        Scanner in = null;
        PrintWriter out = null;
        String line = null;
        String[] token = null;
        int i, n, lineNumber = 0;

        // Check that number of command line arguments is at least 2
        if(args.length < 2){
            System.out.println("Usage: FileReverse <input file> <output file>");
            System.exit(1);
        }

        // Open files
        in = new Scanner(new File(args[0]));
        out = new PrintWriter(new FileWriter(args[1]));

        // read lines from in
        while(in.hasNext()){
            line = in.nextLine();
            token = line.split("\\s+"); // split(): Decompress string into tokens, returns String array containing tokens.
                                        // Note: \\s+ --> replaces 1 or more spaces.

            // Iterate over each element in token array
            for(i=0; i < token.length; i++){
                n = token[i].length();
                out.println(stringReverse(token[i],n));
            }
        }
        in.close();
        out.close();
    }
    public static String stringReverse(String s, int n){
        // n is the length of the String
        String output = "";  // Need empty string (not Null)
        if(n > 0){
            // Appends elements of input string from right to left.
            output = s.charAt(n-1) + stringReverse(s, n-1);
        }
        return output;
    }
}
/*
 Text for input file:

       abc defg
       hi
       jkl mnop q
       rstu v
       wxyz
*/
/*
Resultant output file text:

        cba
        gfed
        ih
        lkj
        ponm
        q
        utsr
        v
        zyxw
*/
