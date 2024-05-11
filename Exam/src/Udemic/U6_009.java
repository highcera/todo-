package Udemic;

public abstract class U6_009 {  // Eat2GetFit                    // Line 1
    static double caloriesPerNight = 0f;                     // Line 2
    public static void main(String[] args) {
      int weight=0, height=0, age=0;
      // local variable must be inited before being used
      
      if (  !(args.length < 3) ) {                           // Line 3
         weight = Integer.parseInt(args[0]);
         height = Integer.parseInt(args[1]);
         age = Integer.parseInt(args[2]);
      } else {
         System.out.println(
           "State patient's weight, height and age!\n" +
           "(use metric units: kg and cm)");
      }
      caloriesPerNight = weight * height / age * (int) 100;  // Line 4
      System.out.println(
        "Stay below " + caloriesPerNight + " cals per night!");
    }
}