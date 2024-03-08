package Udemic;

public class U1_067 {
    public String runTest(boolean spinner, boolean roller) {
        if(spinner = roller) return "up";
        else return roller ? "down" : "middle";
    }
    public static final void main(String pieces[]) {
        final U1_067 tester = new U1_067();
        System.out.println(tester.runTest(false,true));
        // up
    }
}
