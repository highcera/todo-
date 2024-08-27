package Udemic;

import java.util.ArrayList;
import java.util.List;

class Student {
    int rollnumber;
    String name;
    List cources = new ArrayList();
 
    // private Student(int i, String n, List cs) {
    // public void Student(int i, String n, List cs) {
    // Student(int i, String n, ArrayList cs) {
 
    Student(int i, String n, List cs) {
        rollnumber = i;
        name = n;
        cources = cs;
    }
 
    public String toString() {
        return rollnumber + " : " + name + " : " + cources;
    }
}

public class U1_149 {
    public static void main(String[] args) {
        List cs = new ArrayList();
        cs.add("Java");
        cs.add("C");

        // System.out.println(cs);
        Student s = new Student(123, "Fred", cs);
        System.out.println(s);  // 123 : Fred : [Java, C]
    }
}
