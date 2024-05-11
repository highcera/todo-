package Udemic;

public class U6_024 {
    public static void main(String[] args) {
        String[] arr1 = new String[4];
        System.out.println(arr1.length);
        String[] arr2 = {"a", "b", "c", "d", null};
        arr1 = arr2;
        System.out.println(arr1.length);
        for (String e : arr1){
            System.out.print(e + " : ");
            // a : b : c : d : null : 
        }
    }
}
