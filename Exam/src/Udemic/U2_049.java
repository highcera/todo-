package Udemic;  // harbor

class CapsizedException extends Exception {}
class Transport {
  public int travel() throws CapsizedException { return 2; };
}

public class U2_049 { // Boat 
    public int travel() throws Exception { return 4; };             // Line 7
    public static void main(String... distance) throws Exception {
        try {
            System.out.print(new U2_049().travel());
        } catch (Exception e) {
            System.out.print(8);
        }
    }
}
