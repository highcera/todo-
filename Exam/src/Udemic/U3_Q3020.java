package Udemic;

public class U3_Q3020 {
    public static void main(String[] args) {
        float flt = 100F;
        float flt1 = (float)1_11.00;
        float flt2 = 100;
 
        double y1 = 203.22;
        // float flt3 = y1;
        // incompatible types: possible lossy conversion from double to float
        float flt3 = (float)y1;
 
        int y2 = 100;
        float flt4 = (float)y2;
    }
}
