package Udemic;

public class U3_050 {
    public static void main(String[] args) {
        String str = "String Beans Forever!";
        
        // System.out.println(str.delete(6, 11));
        // cannot find symbol method delete(int,int)
        
        // str = str.delete(6,11); System.out.println(str);
        // cannot find symbol method delete(int,int)
        
        str.replace(" Bean","");
        System.out.println(str);  // String Beans Forever!

        String str2 = str.replace(" Bean","");
        System.out.println(str2);  // Strings Forever!
        
        // System.out.println(
        //         new StringBuilder(str).remove(" Bean")
        //                 .toString()
        // );
        // cannot find symbol method remove(String)

        System.out.println(new StringBuilder(str).delete(6,11).toString()); // Strings Forever!
    }
}
