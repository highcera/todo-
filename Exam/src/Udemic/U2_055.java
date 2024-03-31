package Udemic;

public class U2_055 {
    String str = "default";
    int value = 17;
    U2_055(String s){
        str = s;
    }
    U2_055(int i) {
        value = i;
    }
    void print() {
        System.out.println(str + " " + value);
    }
    public static void main(String[] args){
        new U2_055("hello").print();  // hello 17
        new U2_055(92).print();       // default 92
    }
}
