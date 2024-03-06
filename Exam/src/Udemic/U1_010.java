package Udemic;

public class U1_010 {
  public String name;
  public void parseName() {
    System.out.print("1");
    try {
      System.out.print("2");
      int x = Integer.parseInt(name);
      System.out.print("3");
    } catch (NumberFormatException e) {
      System.out.print("4");
    }
  }
  public static void main(String[] args) {
    U1_010 leroy = new U1_010(); 
    leroy.name = "Leroy";
    leroy.parseName();
    System.out.print("5");  
  }
}