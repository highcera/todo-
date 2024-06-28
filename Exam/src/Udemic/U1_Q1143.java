package Udemic;

public class U1_Q1143 {
    public void printName(double input) { 
        System.out.print("Arthropod"); 
    }

    public class Spider extends U1_Q1143 {
        public void printName(int input) { 
            System.out.print("Spider"); 
        }
        
        public static void main(String[] args) {
            Spider spider = new Spider();
            spider.printName(6);    // Spider    (Line 8)
            spider.printName(9.0);  // Arthropod (Line 9)
        }
    }
}
