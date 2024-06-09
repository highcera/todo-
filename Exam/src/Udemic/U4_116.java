package Udemic;

import java.util.ArrayList;
import java.util.List;

public class U4_116 {
  public static void main(String[] args) {
        List colors = new ArrayList();
        colors.add("green");
        colors.add("red");
        colors.add("blue");
        colors.add("yellow");
        System.out.println(colors);  // [green, red, blue, yellow]
        colors.remove(2);
        System.out.println(colors);  // [green, red, yellow]
        colors.add(3, "cyan");
        System.out.println(colors);  // [green, red, yellow, cyan]
    }
}
