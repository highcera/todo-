package Udemic;

public class U5_031 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Inequality");
        String str = "Inequality matters";
        sb.append("matters");
        System.out.println(sb);  // Inequalitymatters
        System.out.println(sb.toString());
        if (str == sb.toString()) {
            System.out.println("Same");
        }
        if (str.equals(sb.toString())) {
            System.out.println("More of the same");
        }
    }
}
