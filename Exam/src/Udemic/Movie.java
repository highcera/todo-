package Udemic;

class Cinema {
    String name;
    // private String name;
    public Cinema() {};
    public Cinema(String name) {this.name = name;}
  }
  public class Movie extends Cinema {
    public Movie(String movie) {
        super();
    }
    public static void main(String[] showing) {
      // System.out.print(new Movie("Another Trilogy").name);
      System.out.print(new Movie("Another Trilogy"));
    }
  }


// class Cinema {
//     // private String name;
//     String name;
//     public Cinema() {}
//     public Cinema(String name) {this.name = name;}
// }
// public class U5_039 extends Cinema {  // Movie
//     public U5_039(String movie) {
//         super();  // Is automatically put here by the Java compiler
//     }
//     public static void main(String[] showing) {
//         System.out.print(new U5_039("Another Trilogy").name);
//         // System.out.print(new U5_039("Another Trilogy"));
//     }
// }