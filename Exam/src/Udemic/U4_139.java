package Udemic;

public class U4_139 {  // Egret {
    private String color;
    public U4_139() {                             // Line 03
        this("white");                           // Line 04
    }                                            // Line 05
    public U4_139(String color) {    
        // this.color = color;             // Line 06
        color = color;                           // Line 07
    }                                            // Line 08
    public static void main(String[] args) {
        U4_139 e = new U4_139();                   // Line 10
        System.out.println("Color:" + e.color);  // Line 11
        // Color:null
    }

}
