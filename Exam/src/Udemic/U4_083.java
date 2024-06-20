package Udemic;

public class U4_083 {  // CharToStr {
    public static void main(String[] args) {
        String str1 = "Java";
        char str2[] = {'J', 'a', 'v', 'a'};
        String str3 = null;  // "" successful
        // String str3 = "";  // This is, what you should do
        for (char c : str2) {
            str3 = str3 + c;
        }
        System.out.println(str3);  // nullJava
        if (str1.equals(str3))
            System.out.println("Successful");
        else
            System.out.println("Unsuccessful");  // Unsuccessful
 
        // null treated as a String becomes: "null"
        System.out.println(str3);            // nullJava
        System.out.println(null + "Hello");  // nullHello
    }

}
