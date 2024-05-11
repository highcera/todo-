package Udemic;

public class Plant {
    public void run() { System.out.println("Plant"); }
}

public class Coffee extends Plant {
    @Override
    public void run() { System.out.println("Coffee"); }
}
  
public class U6_188 extends Coffee {  // Java
    @Override
    public void run() { System.out.println("Java"); }
    
    public static void main(String[] args) {
        Plant p1 = new U6_188();
        Plant p2 = new Coffee();
        Plant p3 = new U6_188();
        p1 = (Plant) p3;
        Plant p4 = (Coffee) p3;
        p1.run();
        p4.run();
    }
}
