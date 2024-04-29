package Udemic;

public class U5_028 {  // Jump {
    private int rope = 1;
    protected boolean outside;
    public U5_028() {
        this(4);  // Line p1
        outside = true;
    }
    public U5_028(int rope) {
        this.rope = outside ? rope : rope+1;
    }
    public static void main(String[] bounce) {
        System.out.print(new U5_028().rope);  // 5
    }

}
