package Udemic;

public class U2_137 {  // Vars
    int z;
    public static void main(String[] args){
        U2_137 obj = new U2_137();
        int z = 3;
        System.out.print(z);      // 3
        obj.doStuff();            // 2
        System.out.print(z);      // 3
        System.out.print(obj.z);  // 1
    }
    void doStuff() {
        int z = 2;
        doStuff(z);
        System.out.print(z);
    }
    void doStuff(int zzz) {
        z = 1;
    }
}
