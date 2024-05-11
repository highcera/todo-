package Udemic;

public class U3_169 {  // Test
    static int count = 0;
    public int count(int qty) {
        // if (qty <= 0) break;
        if (qty <= 0) ;
        else {
            for (int i = 0; i < qty; i++) {
                count += i;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        U3_169 t = new U3_169();
        System.out.print(t.count(5));
        System.out.print(t.count(3));
    }

}
