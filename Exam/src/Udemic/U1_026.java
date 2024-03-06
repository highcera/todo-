package Udemic;

public class U1_026 {
    String color;
    U1_026() {}
    U1_026(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Frisbee{" +
                "color='" + color + '\'' +
                '}';
    }
    public static void toss(U1_026... f) {
        U1_026 first = f[0];
        System.out.println(first);  // Frisbee{color='Yellow'}
    }
    public static void main(String[] args) {
        U1_026 fris1 = new U1_026("Yellow");
        U1_026 fris2 = new U1_026("Orange");
        toss(fris1, fris2);
    }
}
