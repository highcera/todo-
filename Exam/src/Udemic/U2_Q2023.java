package Udemic;

public class U2_Q2023 { // VarScope
    public static void main(String[] args) {
        String color = "red";
        int qty = 10;
        int amount = 0;
        if (color.equals("red")) {
            // int amount = qty * 10;        // line n1
            amount = qty * 10;               // line n1
        } else if (color.equals("green")) {
            // int amount = qty * 15;        // line n2
            amount = qty * 15;               // line n2
        } else if (color.equals("blue")) {
            // int amount = qty * 5;         // line n3
            amount = qty * 5;                // line n3
        }
        System.out.print(amount);            // line n4
    }

}
