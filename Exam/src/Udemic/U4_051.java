package Udemic;

public class U4_051 {
    String str = "default";
    U4_051(String s) { str = s; }
    void print() { System.out.println(str); }
    public static void main(String[] args){
        new U4_051("hello").print();  // hello
    }
}
