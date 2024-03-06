package Udemic;

interface Keys {
  String keypad(String region, int keys);
}

public class U1_035 {
    public static void main(String... args) {
        // double price;
        // String model;
        double price = 0;
        String model = "";
        Keys varKeys = (region, keys) -> {
            if (keys >= 32) return region;
             else return "default";
        };
        System.out.println(model + price + varKeys.keypad("AB", 31));
    }
}
