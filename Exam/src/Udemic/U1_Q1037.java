package Udemic;

class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
}
    
public class U1_Q1037 {
    public static void main (String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Carol");
        System.out.println(s1); 
        System.out.println(s2); 
        System.out.println(s3); 

        s1 = s3;
        s3 = s2;
        s2 = null;               // Line 14
        System.out.println(s1.name);  // Student@4554617c
        System.out.println(s2);  // null
        System.out.println(s3.name);  // Student@74a14482
    }

}
