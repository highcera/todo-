package Udemic;

public class U2_Q2021 {
    String str = "default";
    int value = 17;
    U2_Q2021(String s){
        str = s;
    }
    U2_Q2021(int i) {
        value = i;
    }
    void print() {
        System.out.println(str + " " + value);
    }
    public static void main(String[] args){
        new U2_Q2021("hello").print();  // hello 17
        new U2_Q2021(92).print();       // default 92
    }
}
