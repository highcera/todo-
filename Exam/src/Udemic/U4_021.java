package Udemic;

public class U4_021 {
    public static void main(String[] args) {
        String[] people = {"Peter", "Paul", "Mary"};
        for (int i=0; i<people.length; i++)
            System.out.println(people[i]);              // Peter Paul Mary
        for (String p : people) System.out.println(p);  // Peter Paul Mary
    }
}
