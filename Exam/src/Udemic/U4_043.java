package Udemic;

public class U4_043 {  // Phone {
    private int size;
    public U4_043(int size) {this.size=size;}
    public static void sendHome(Phone p, int newSize) {
        p = new U4_043(newSize);
        p.size = 4;
    }
    public static final void main(String... params) {
        final U4_043 phone = new U4_043(3);
        sendHome(phone,7);
        System.out.print(phone.size);  // 3
    }

}
