package Udemic;

public class U4_155 {  // public class Application {
    public static void main(String... args) {
        double price = 10;
        String model;
        model = "";  // local variable 초기화 필수!!
        if (price > 10)
            model = "Smartphone";
        else if (price <= 10)
            model = "Landline";
        System.out.println(model);
        // Compile error:
        // variable model might not have been initialized
    }
}