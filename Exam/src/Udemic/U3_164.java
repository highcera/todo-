package Udemic;

class ExamTaker {
    private String name;
    private int score;
    public ExamTaker(String name) {
        // this();                             // Line E1
        setName(name);
    }
    public ExamTaker(String name, int score) {
        // ExamTaker(name);                    // Line E2
        // new ExamTaker(name);                // Line E2
        this(name);              
        // setName(name);              // Line E2
        setScore(score);
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    @Override
    public String toString() {
        return getName() + " " + getScore() + " ";
    }
}
class U3_164{  // Result
    public static void main(String[] args) {
        ExamTaker e1 = new ExamTaker("Alice");
        ExamTaker e2 = new ExamTaker("Bob",62);
        System.out.print(e1);
        System.out.println(e2);
    }
}