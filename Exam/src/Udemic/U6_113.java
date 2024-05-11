package Udemic;

public class U6_113 {
    public static void main(String[] args) {
        int array[] = {0, 1, 2, 3, 4};
        int key = 3;
        int pos;
        for (pos = 0; pos < array.length; ++pos){
            if (array[pos] == key) {
                break;
            }
        }
        System.out.println("Found " + key + " at " + pos);
    }
}
