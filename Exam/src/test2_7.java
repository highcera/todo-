public class test2_7 {
    protected void finalize() {
       System.out.println("Employee fired!");
    }  
    public static void main(String[] args) {
        test2_7 e1 = new test2_7(); 
        e1 = null;
        System.gc();
    }
  
}