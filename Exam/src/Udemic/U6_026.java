package Udemic;

public class U6_026 {
    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder("Passed");
        System.out.println(sb + ": ");
        System.out.println("(" + sb.replace(0,4,"Fail") + " & " + sb.delete(0,666).insert(0,"Failed") + ")"); 

        System.out.println(sb.replace(0,4,"Fail") == 
                           sb.delete(0,666).insert(0,"Failed"));
    }
}
