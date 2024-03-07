package Udemic;

import java.util.ArrayList;
import java.util.List;

class Exams {
    String name;
    int year;
    List exams = new ArrayList();
    Exams(String name, int year, List exams){
        this.name = name;
        this.year = year;
        this.exams = exams;
}
    public String toString() {
        return name + " in " + year + ": " + exams;
    }
}

public class U1_037 {
    public static void main (String[] args) {
        List al = new ArrayList();
        al.add("1Z0-808");
        al.add("1Z0-809");
        Exams e = new Exams("Bob", 2016, al);
        System.out.println(e);
    }
}
