package Labs.Lab2;

/*
 Rick Ramirez
 riryrami
 12M
 04/11/16
 This program takes an input text file, processes the text into tokens, then reverses each token.
 The output is sent to an output file.
 reverseStrings.java
 */
public class reverseStrings {
    public static void main(String[] args) {
        String in = "Hello";
        String myName = "domanokz";
        String newName = in.substring(0,0)+'x'+in.substring(1);
        String out = reversal(in, in.length());
        System.out.println(newName);
        System.out.println(out);
    }

    public static String reversal(String s, int n){
        String output = "";
        if(n > 0){
            output = s.charAt(n-1) + reversal(s, n-1);
        }
        return output;
    }
}
