package Udemic;

public class U5_038 {
    public static void main(String... data) {
        if(data.length>=1
                && (data[0].equals("sound") || data[0].equals("logic"))
                && data.length<2) {
            System.out.print(data[0]);
        }
    }
}
