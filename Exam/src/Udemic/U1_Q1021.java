package Udemic;

class Prime {
    int num;
    Prime (int num) {
        this.num = num;
    }
}

public class U1_Q1021 {
    public static void main(String[] args) {
        Prime obj1 = new Prime(13);
        Prime obj2 = new Prime(13);
        if (obj1 == obj2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
        if (obj1.equals(obj2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }
}
