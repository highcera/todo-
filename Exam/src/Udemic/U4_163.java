package Udemic;

public class U4_163 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("radical ");
        sb = new StringBuilder("radical ")
                .insert(sb.length(), "robots");
        System.out.println(sb);  // radical robots
        sb = new StringBuilder("radical ").append("robots");
        System.out.println(sb);  // radical robots
        sb = new StringBuilder("radical ")
                .delete(1, 100)
                .append("obots")
                .insert(1, "adical r");
        System.out.println(sb);  // radical robots
        sb = new StringBuilder("radical ")
                .insert(7, "robots");
        System.out.println(sb);  // radicalrobots
    }
}
