package Udemic;

public class U3_Q3179 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        String str = null;
        for(int e : arr) { str += e; }
        System.out.println(str);  // null12345
 
        System.out.println(null + "Test");  // nullTest
    }
}
