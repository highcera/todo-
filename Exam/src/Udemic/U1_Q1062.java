package Udemic;

public class U1_Q1062 {
    String color;
    U1_Q1062() {}
    U1_Q1062(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Frisbee{" +
                "color='" + color + '\'' +
                '}';
    }
    public static void toss(U1_Q1062... f) {
        U1_Q1062 first = f[0];
        System.out.println(first);  // Frisbee{color='Yellow'}
    }
    public static void main(String[] args) {
        U1_Q1062 fris1 = new U1_Q1062("Yellow");
        U1_Q1062 fris2 = new U1_Q1062("Orange");
        toss(fris1, fris2);
    }
}
