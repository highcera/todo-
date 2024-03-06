package Udemic;

class MarksOutOfBoundsException extends IndexOutOfBoundsException { }
  
public class U1_008 {
    void verify(int marks) throws IndexOutOfBoundsException {
      if (marks > 100) {
        throw new MarksOutOfBoundsException();
      }
      if (marks > 50) {
        System.out.print("Pass");
      } else {
        System.out.print("Fail");
      }
    }
  public static void main(String[] args) {
    // int marks = Integer.parseInt(args[2]);
    int marks = 104;
    try {
      U1_008 grade = new U1_008();
      grade.verify(marks);
    } catch (Exception e) {
      System.out.print(e.getClass());
    }
  }
}
