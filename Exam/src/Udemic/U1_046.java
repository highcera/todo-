package Udemic;

public class U1_046 {
    public static void main(String[] args) {
        int arr[] = new int[4];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 5;
        int sum = 0;
        try {
            for (int pos = 0; pos <= 4; pos++) {
                sum = sum + arr[pos];
            }
        } catch (Exception e) {
            System.out.println("Invalid index");  // Invalid index
            e.printStackTrace();  // ArrayIndexOutOfBoundsException
        }
        System.out.println(sum);  // 12
    }
}
