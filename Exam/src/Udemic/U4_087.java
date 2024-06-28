package Udemic;

class Student {
    private int age;
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
public class U4_087 {
    public static void main(String[] args) {
        Student std = new Student();
        std.setName("John Smith");
        System.out.println(std.getName());
    }
}