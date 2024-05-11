package Udemic;

public class U6_190 {
    public static int getResult(int threshold) {
        return threshold > 5 ? 1 : 0;
    }
    public static final void main(String[] days) {
        System.out.print(getResult(5)+getResult(1)
                +getResult(0)+getResult(2)+"");
    }
}
