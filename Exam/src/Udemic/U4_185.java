package Udemic;

import java.io.IOException;

public class U4_185 {
  // public static void main(String args[]) throws IOException {
    public static void main(String args[]) {
        IOException ioe = null;
        // try {                                     // Line 06
        //     throw null;                           // Line 07
        // }                                         // Line 08
        // catch (NullPointerException npe) {        // Line 09
        //     System.out.print("Caught NPE ");      // Line 10
        // }                                         // Line 11
        // throw ioe;
        try {                                     // Line 12
            throw ioe;                        // Line 13
        }                                         // Line 14
        // catch (IOException ioe) {              // Line 15
        catch(IOException needsADifferentName) {  // Line 15
            System.out.print("+ Caught IOE");     // Line 16
        }                                         // Line 17
    }
}
