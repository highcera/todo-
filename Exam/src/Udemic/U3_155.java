package Udemic;

public class U3_155 {  // DoCompare 
    public static void main(String[] args) {
        String[] table = {"aa", "bb", "cc"};
        for (String ss: table) {
            int ii = 0;
            while (ii < table.length) {
                System.out.println(ss + ", " + ii);
                // aa, 0
                // aa, 1
                // aa, 2
                // bb, 0
                // bb, 1
                // bb, 2
                // cc, 0
                // cc, 1
                // cc, 2
                ii++;
            }
        }
    }

}
