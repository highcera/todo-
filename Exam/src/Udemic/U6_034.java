package Udemic;

public class U6_034 {
    private boolean flag;
    public void displayResult() {
        int result = flag ? 5 : 10;
        System.out.print("Result = " + result++);  // Result = 10
    }
    static public void main(String[] args) {
        new U6_034().displayResult();
    }
}
