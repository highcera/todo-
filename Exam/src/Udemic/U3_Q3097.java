package Udemic;

public class U3_Q3097 {
    public static void main(String[] args) {
        String[] letters = {"A", "B", "C", "D"};
        for (String e : letters) {
          if (e.equals(letters[1])) {
            continue;
          }
          System.out.print(e + " ");
          if (e.equals(letters[3])) {
            break;
          }
        }
      }
}
