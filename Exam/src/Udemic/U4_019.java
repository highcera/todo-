package Udemic;

class U4_019 {  // OCAJP8
    public static void main(String[] args) {
        ExamTaker alice, bob;
        alice = bob = new ExamTaker();  // Reference!!!
        alice.name = "Alice";
        System.out.println(alice.name);
        bob.name = "Bob";
        System.out.println(bob.score);
        System.out.println(alice.name);
        bob.setScore(62);           // Bob failed the exam...
        System.out.println(bob.score);
        alice.setScore(100);        // but Alice got the perfect score!
        System.out.println(bob.score);
        bob.show();
    }
}


// class ExamTaker {
//     public String name;
//     protected int score;
//     private boolean passed;
//     public void show() {
//         System.out.println(
//             "Name: " + this.name + ", Passed: " + isPassed(score)
//         );
//         // Name: Bob, Passed: true
//     }
//     public boolean isPassed(int score) {
//         return passed = score >= 65;
//     }
//     public void setScore(int score){
//         this.score = score;
//     }
// }