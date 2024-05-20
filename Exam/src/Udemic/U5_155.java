package Udemic;

public class U5_155 {
    public static void main(String... args) {
        double price = 10;
        String model;
        model = "";
        if (price > 10)
            model = "Smartphone";
        else if (price <= 10)
            model = "Landline";
        System.out.println(model);
        // Compile error:
        // variable model might not have been initialized
    }
}
