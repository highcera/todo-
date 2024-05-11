package Udemic;

public class U6_130 {
    public static void main(String[] args) {
        U6_130 m = new U6_130();
        long result;
        result = m.myMethod1("Peter", 100, "Mary");
        result = m.myMethod5(100,"Peter", "Mary");
        result = m.myMethod7(100,"Peter", "Mary");
        // System.out.println(result);
    }
    Short myMethod1(String str1, int str2, String str3) { return 0; }
    Long myMethod5(int str2, String str3, String str1) { return 0L; }
    Short myMethod7(int val1, String... val2) { return 0; }
 
    // The return value has to be int or Integer:
    // Int myMethod2(String val1, int val2, String val3) { return 0; }
 
    // Every parameter needs its type:
    // Byte myMethod3(String str1, str2, int a) { return 0; }
    // Float myMethod4(String val1, val2, int val3) { return 0F; }
 
    // Vararg parameter must be the last in the list:
    // Long myMethod6(String... val1, int val2) { return 0L; }
}
