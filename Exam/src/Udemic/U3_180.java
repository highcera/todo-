package Udemic;

interface Lambdable1 {
    String run(StringBuilder sb);
}
interface Lambdable2 {
    int run(StringBuilder sb);
}
public class U3_180 {
    static void test1(Lambdable1 l) {
        System.out.println(l.run(new StringBuilder("lambda")));
    }
    static void test2(Lambdable2 l) {
        System.out.println(l.run(new StringBuilder("lambda")));
    }
    public static void main(String[] args) {
 
        test1(sb -> sb.toString());  // lambda
 
        test2((StringBuilder sb) -> {
            return sb.length();
        });   // 6
 
        // test1(StringBuilder sb -> sb.toString());
        // ')' expected
 
        // test2((StringBuilder sb) -> return sb.length()  );
        // illegal start of expression
    }
}