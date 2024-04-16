package Udemic;

class Alpha {
    public String[] main = new String[2];
    Alpha(String[] main) {
        for (int i = 0; i < main.length; i++) {
            this.main[i] = main[i] + 5;
            System.out.println(this.main[i]);
            // 15
            // 25
        }
    }
    public void main() {
        System.out.print(main[0] + main[1]);  // 1525
    }
}
public class U3_147 {
    public static void main(String[] args) {
        String[] param = {"1", "2"};
        // System.out.println(param[0] + " : " + param[1]);
        Alpha test = new Alpha(param);
        // main.main();
    }
}