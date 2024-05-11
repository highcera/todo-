package Udemic;

public class U6_121 {  // Hello {
    public static void main(String[] args) {
        String str = "Hello";
        StringBuilder sb = new StringBuilder(str);
        str.replace("o", "");                              // Line 1
        // str = str.replace("o", "");
        System.out.print(str + " ");                       // Line 2
        // Hello
        System.out.print(str.replace("o","") + " ");       // Line 3
        // Hell
        System.out.print(sb.append("?")
                         .equals(sb.append("!")) + " ");   // Line 4
        // true
        System.out.println("*"+sb);
        System.out.println(str.replace("o","")
                           .equals(str.replace("o","")));  // Line 5
        // true
    }

}
