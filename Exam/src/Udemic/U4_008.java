package Udemic;

public class U4_008 {  // Student {
    public String name = "";
    public int age = 0;
    public String major = "Undeclared";
    public boolean fulltime = true;
    public void display() {
        System.out.println("Name: " + name + " Major: " + major);
    }
    public boolean isFulltime() {
        return fulltime;
    }
    public static void main(String[] args) {
        U4_008 student1 = new U4_008();
    }
}
