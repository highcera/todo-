package Udemic;

import java.util.ArrayList;

public class U6_149 {
  public static void main(String args[]) {
    ArrayList<String> seasons = new ArrayList<>();
    seasons.add("Spring"); seasons.add("Summer");
    seasons.add("Autumn"); seasons.add("Winter");
    seasons.add(0,"Winter");
    seasons.remove(2);
    for (String s : seasons)
      System.out.print(s + ", ");
  }
}
