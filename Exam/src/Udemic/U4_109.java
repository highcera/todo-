package Udemic;

public class U4_109 {  // AccountMasker {
    public static String maskAccount(String accNum) {
        String lead = "***************";  // contains 15 asterisks in a row
        // your code goes here
 
        return new StringBuilder(lead).append(accNum, 15, 20).toString();
        // ***************67541
 
        // return lead + accNum.substring(15, 20);
        // ***************67541
 
        // return new StringBuilder(accNum).insert(0, lead).toString();
        // ***************34296018534982067541
 
        // return new StringBuilder(accNum).append(lead, 15, 20).toString();
        // IndexOutOfBoundsException
 
        // return (new StringBuilder(accNum)).substring(15, 20).toString();
        // 67541
    }
    public static void main(String[] args) {
        // String accNum = args[0];
        String accNum = "34296 01853 49820 67541";
        System.out.println(maskAccount(accNum.replace(" ","")));
    }

}
