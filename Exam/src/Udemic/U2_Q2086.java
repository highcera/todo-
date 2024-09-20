package Udemic;

public class U2_Q2086 {
    public static void main(String[] args) {
        String[] people = {"Peter", "Paul", "Mary"};
        for (int i=people.length-1; i>=0; i--)
            System.out.println(people[i]);  // Mary Paul Peter
        for (String p : people)
            System.out.println(p);  // Peter Paul Mary
    }
}