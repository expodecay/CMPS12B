package Labs.Lab2;

/**
 * Created by Rick on 4/10/2016.
 */
// FileTokens.java
// Illustrates file IO and tokenization of strings. To run, cd to users/rick/IdeaProjects/CMPS12B/out/production/CMPS12B
// Then run java Labs.Lab2.FileTokens <fileIN> <fileOUT>
// Note that the testFile must be in same directory that you call the function.
// run more testOUT to see the contents of the output file.
import java.io.*;
import java.util.Scanner;
class FileTokens{
    public static void main(String[] args) throws IOException{
        Scanner in = null;
        PrintWriter out = null;
        String line = null;
        String[] token = null;
        int i, n, lineNumber = 0;
        // check number of command line arguments is at least 2
        if(args.length < 2){
            System.out.println("Usage: FileCopy <input file> <output file>");
            System.exit(1);
        }
        // open files
        in = new Scanner(new File(args[0]));
        out = new PrintWriter(new FileWriter(args[1]));
        // read lines from in, extract and print tokens from each line
        while( in.hasNextLine() ){
            lineNumber++;
            // trim leading and trailing spaces, then add one trailing space so
            // split works on blank lines
            line = in.nextLine().trim() + " ";
            // split line around white space
            token = line.split("\\s+");
            // print out tokens
            n = token.length;
            out.println("Line " + lineNumber + " contains " + n + " tokens:");
            for(i=0; i<n; i++){
                out.println(" "+token[i]);
            }
        }
        // close files
        in.close();
        out.close();
    }
}
