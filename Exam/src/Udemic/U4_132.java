package Udemic;

import javax.sql.rowset.Predicate;

public class U4_132 {
    public static void main(String[] args) {
        Predicate<Integer> ip1 = i -> i != 0;
        Predicate<Integer> ip2 = i -> { return i != 0; };
    }
}

// When you’re using brackets, 
// both the return keyword and semicolon are needed for the lambda to compile.