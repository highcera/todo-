package Udemic;

public class U4_027 {  // Attendance {
    // private Boolean[] list = // value omitted
    private Boolean[] list = {true, false};
    // ArrayIndexOutOfBoundsException
    // private Boolean[] list = null;
    // NullPointerException
    // private Boolean[]list = (Boolean[]) new Object();
    // ClassCastException
    // private Boolean[] list = {true, true, true, true,
    //               true, true, true, true, true, true};
    public int printTodaysCount() {
        int count = 0;
        for(int i=0; i<10; i++) {
            if(list[i]) ++count;
        }
        return count;
    }
    public static void main(String[] roster) {
        new U4_027().printTodaysCount();
    }
  
}
