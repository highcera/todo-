package Udemic;

public class U5_154 {
    public static void doChange(int[] arr) {
        for(int pos = 0; pos < arr.length; pos++) {
            arr[pos] = arr[pos] + 1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        doChange(arr);
        for (int x : arr) {
            System.out.print(x + ", ");
        }
        // doChange(arr[0], arr[1], arr[2]);
        // method doChange cannot be applied to given types;
        // required: int[]
        // found: int,int,int
        doChange(arr);
        System.out.print(arr[0] + ", " + arr[1] + ", " + arr[2]);
    }
}


