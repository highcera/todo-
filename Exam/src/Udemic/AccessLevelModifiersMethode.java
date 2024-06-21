package Udemic;

// class Student {
//     public String name = "";
//     public int age = 0;
//     public String major = "Undeclared";
//     public boolean fulltime = true;
//     public void display() {
//         System.out.println("Name: " + name + " Major: " + major);
//     }
//     public boolean isFulltime() {
//         return fulltime;
//     }
// }
// public class U4_056 {  // TestStudent
//     public static void main(String[] args) {
//         Student bob = new Student();
//         bob.name = "Bob";
//         bob.age = 18;
//         // bob.year = 1982;
//     }
// }

class Greeting{
    //public, protected, default, private
    public static void hi() {
        System.out.println("Hi");
    }

}

public class AccessLevelModifiersMethode {

    public static void main(String[] args) {
        Greeting.hi();
    }

}