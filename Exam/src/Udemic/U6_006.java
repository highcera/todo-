package Udemic; // handy;     

import Udemic.handy.dandy.KeyStroke;

public class U6_006 {  // Greet
  public static void main(String[] args) {
    String greeting = "Hello";
    System.out.print(greeting);
    KeyStroke stroke = new KeyStroke();     // Line 6
    // Udemic.handy.dandy.KeyStroke stroke = new Udemic.handy.dandy.KeyStroke();     // Line 6
    stroke.typeExclamation();
  }
}
