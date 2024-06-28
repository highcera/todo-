package Udemic;

public class U1_Q1020 {
    private char var;
    public static void main(String[] args) {
        char var1 = 'a';
        // The assigned value is a primitive data type:
        char var2 = var1;
        var2 = 'e';
        U1_Q1020 obj1 = new U1_Q1020();
        // The assigned value is a reference:
        U1_Q1020 obj2 = obj1;
        obj1.var = 'i';
        obj2.var = 'o';
        System.out.println(var1 + ", " + var2);          // a, e
        System.out.println(obj1.var + ", " + obj2.var);  // o, o
    }
}
