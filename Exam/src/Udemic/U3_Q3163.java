package Udemic;

public class U3_Q3163 {
    public double test(double d){
        if(d > 0.5) return 1;
        try {
            if(d < 0.1) throw new Exception("Too small!");   // Line t1
        }
        catch(Exception e) {
            return 666;                                      // Line t2
        }
        finally {
            return 42;                                       // Line t3
        }
    }
    public static void main(String args[]){
        System.out.println(new U3_Q3163().test(Math.random()));
    }

}
