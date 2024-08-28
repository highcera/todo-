package Udemic;

class MissingInfoException extends Exception {}
class AgeOutofRangeException extends Exception {}

class Candidate {
    String name;
    int age;
    Candidate(String name, int age) throws Exception {
        if (name == null) {
            throw new MissingInfoException();
        } else if (age <= 10 || age >= 150) {
            throw new AgeOutofRangeException();
        } else {
            this.name = name;
            this.age = age;
        }
    }
    public String toString() {
        return name + " age: " + age;
    }
}
public class U2_Q2148 {
    public static void main(String[] args) throws Exception {  // Line 5
        Candidate c = new Candidate("James", 20);      // Line 6
        Candidate c1 = new Candidate("Williams", 32);  // Line 7
        System.out.println(c);                         // Line 8
        System.out.println(c1);                        // Line 9
    }
}