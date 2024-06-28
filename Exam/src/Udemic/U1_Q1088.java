package Udemic;

import java.util.Arrays;
import java.util.List;

public class U1_Q1088 {
    public static void main(String[] args) {
        List<String> exams = Arrays.asList("OCA", "OCP");
        for (String e1 : exams)
            for (String e2 : exams)
                System.out.println(e1 + " " + e2);
                // OCA OCA
                // OCA OCP
                // OCP OCA
                // OCP OCP
    }
}
