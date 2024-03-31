package Udemic;

import java.util.Arrays;
import java.util.List;

class Examinee {
    private String name;
    private int score;
    public Examinee(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() { return name; }
    public int getScore() { return score; }
}

class U2_050 { // ReleasingResults
    public static void checkScore(List<Examinee> list, Predicate<Examinee> p){
        for (Examinee e : list) {
            if (p.test(e)) {
                System.out.print(e.getName() + ", ");
            }
        }
    }
    public static void main(String[] args) {
        List<Examinee> list = Arrays.asList(
            new Examinee("Alice", 98),
            new Examinee("Bob", 48),
            new Examinee("Charlie", 62),
            new Examinee("Doug", 88));
        System.out.print("Passed: ");
        // checkScore(list, e -> e.getScore() > 65);
        // Passed: Alice, Doug,
 
        // checkScore(list, () -> e.getScore() > 65);
        // incompatible parameter types in lambda expression
 
        // checkScore(list, Examinee e -> e.getScore() > 65);
        // ')' expected
 
        // checkScore(list, (Examinee e) -> { e.getScore() > 65; });
        // not a statement
    }
}
