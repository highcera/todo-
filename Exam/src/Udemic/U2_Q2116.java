package Udemic;

public class U2_Q2116 { // Salmon
    int count;
    public void Salmon() {
        count = 4;
    }
    public static void main(String[] args) {
        U2_Q2116 s = new U2_Q2116();
        System.out.println(s.count);  // 0
    
        // This is how you call the method:
        s.Salmon();
        System.out.println(s.count);  // 4
    }
    
}
