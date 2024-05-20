package Udemic;

class Student {
    public String name = "";
    public int age = 0;
    public String major = "undeclared";
    public boolean fulltime = true;
    public void display(){
        System.out.println("Name: " + name + " Major: " + major);
    }
    public boolean isFulltime(){
        return fulltime;
    }
}
public class U5_162 {
    public static void main(String[] args) {
        Student bob = new Student();
        Student jian = new Student();
        bob.name = "Bob";
        bob.age = 19;
        jian = bob;                    // Reference!
        jian.name = "Jian";
        System.out.println("Bob's Name: " + bob.name);
        // Bob's Name: Jian
    }
}