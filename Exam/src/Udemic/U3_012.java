package Udemic;

public class U3_012 {
    public static void main(String[] args) {
        String[] people = {"Peter", "Paul", "Mary"};
        addStationName(people);  // ArrayIndexOutOfBoundsException:
 
        // Other cases from der question rext:
        // addStationName(null);  // NullPointerException
        // addStationName(new String[] {});  // ArrayIndexOutOfBoundsException
    }
 
    public static void addStationName(String[] names) {
        names[names.length] = "Times Square";
        // names[names.length-1] = "Times Square";
        // System.out.println(names[names.length-1]);
    }
}
