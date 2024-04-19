package Udemic;

public class U5_007 {
    public static void main(String[] args) {
        boolean isChecked = false;
        int[] arry = {1, 3, 5, 7, 8, 9};
        int index = arry.length;
        while (index > 0) {
            if (arry[index-1] % 2 == 0) {
                isChecked = true;
            }
            index--;
        }
        System.out.print(arry[index] + ", " + isChecked);
    }
}
