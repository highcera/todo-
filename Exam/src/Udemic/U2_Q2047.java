package Udemic;

public class U2_067 {
    public static void main(String[] args) {
        int time = 11;
        int day = 4;
        // String dinner = time > 10 ? day ? "Takeout" : "Salad" : "Leftovers";
        String dinner = time > 10
                ? day != 0
                    ? "Takeout"
                    : "Salad"
                : "Leftovers";
        System.out.println(dinner);  // Takeout
    } 
}

// String dinner = time > 10 
//                  ? Day != 0
                        ? "Takeout"
                        : "Salead"
                    : "Leftovers"