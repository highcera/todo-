package Udemic;

public class U4_105 {  // Student {
    private String fName;
    private String lName;
    public U4_105(String first, String last) {
        fName = first; lName = last;
    }
    // public String getName() { return fName + lName; }
    public String getName() {
        return fName + " " + lName;
    }

    public static void main(String[] args) {
        System.out.println(new U4_105("hy", "cho").getName());
    }
}
