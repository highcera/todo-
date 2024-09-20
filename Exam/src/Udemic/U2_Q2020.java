package Udemic;

class Student {}
public class U2_Q2020 {  // Test
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1);  // Student@4554617c
        Student s2 = new Student();
        System.out.println(s2);  // Student@74a14482
        Student s3 = new Student();
        System.out.println(s3);  // Student@1540e19d
        s1 = s3;
        s3 = s2;
        s2 = null;  // Line 8
        System.out.println(s1);  // Student@1540e19d
        System.out.println(s2);  // null
        System.out.println(s3);  // Student@74a14482
    }

}
