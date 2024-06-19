package Udemic;

public class U4_061 {  // Equal {
    public static void main(String[] args) {
        String str1 = "Java";
        String[] str2 = {"J", "a", "v", "a"};
        String str3 = "";
        for (String str : str2) {
            str3 = str3 + str;
        }
        boolean b1 = (str1 == str3);
        System.out.println(System.identityHashCode(str1));
        // e.g. 1163157884
        System.out.println(System.identityHashCode(str3));
        // e.g. 1956725890 (different number)
        boolean b2 = (str1.equals(str3));
        System.out.print(b1 + ", " + b2);  // false, true
    }

}
