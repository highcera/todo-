package Udemic;

public class U2_Q2026 {
    public static void main(String[] args) {
        String title = "Weather";               // Line x1
        // int hot, double cold; // different type initialize               // Line x2
        // java: <identifier> expected
        int hot = 100; double cold;             // Line x2
        System.out.println(hot + " " + title);  // Line x3
    }

}
