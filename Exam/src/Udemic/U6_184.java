package Udemic;

public class U6_184 {  // ExamTaker {
    private String name;
    private int score;
    private String exam;
    private boolean passed;
    U6_184(){}
    U6_184(String name, int score, String exam){
        this.name = name;
        this.score = score;
        this.exam = exam;
        this.passed = isPassed();
    }
    public void show() {
        System.out.println("Name: " + name + ", passed: " + passed);
    }
    public boolean isPassed() {
        return passed = score >= 65;
    }
    public static void main(String[] args) {
        U6_184 examTaker = new U6_184("chohy", 99, "English");
        examTaker.show();
    }
}