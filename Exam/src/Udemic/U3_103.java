package Udemic;

public class U3_103 {
    public static void main(String[] args) {
        String[] argss = {"5"};
        double discount_rate = 0;
        int quantity = Integer.parseInt(argss[0]);
 
        discount_rate = (quantity >= 5)
                                ? 0.5
                                : (quantity >= 3)
                                    ? 0.2
                                    : 0;
        System.out.println(discount_rate);  // 0.5
 
        if (quantity >= 5) { discount_rate = 0.5; }
        if (quantity == 3 || quantity == 4) { discount_rate = 0.2; }
        System.out.println(discount_rate);  // 0.5
 
        discount_rate = (quantity > 1) ? 0.2 : (quantity >= 5) ? 0.5 : 0;
        System.out.println(discount_rate);  // 0.2
 
        discount_rate = (quantity >= 5) ? 0.5 : 0;
        discount_rate = (quantity >= 3) ? 0.2 : 0;
        System.out.println(discount_rate);  // 0.2
 
        quantity = 4;
        if (quantity >= 3 && quantity < 5) {
            discount_rate = 0.2;
        } else {
            discount_rate = 0;
        }
        if (quantity >= 5) {
            discount_rate = 0.5;
        } else {
            discount_rate = 0;
        }
        System.out.println(discount_rate);  // 0.0
    }
}
