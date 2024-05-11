package Udemic;

public class U3_161 {  // Char
    char var;
    public static void main (String[] args) {
        char var1 = 'a';
        char var2 = var1;
        var2 = 'b';
        U3_161 c1 = new U3_161();
        U3_161 c2 = c1;         // Reference!!!
        c1.var = 'c';
        c2.var = 'd';
        System.out.print(var1 + ", " + var2);      // a, b
        System.out.print(c1.var + ", " + c2.var);  // d, d
    }

}
