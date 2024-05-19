package Udemic;

class Laptop {
    String memory = "1 GB";
}
 
class U6_175 {  // Workshop
    public static void main(String args[]) {
        Laptop life = new Laptop();
        repair(life);
        System.out.println(life.memory);  // 2 GB
    }
    public static void repair(Laptop laptop) {
        laptop.memory = "2 GB";
    }
}