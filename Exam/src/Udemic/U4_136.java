package Udemic;

public class U4_136 {
    public static void main(String[] args) {
        int hops = 0;
        int jumps = 0;
        jumps = hops++;
        // if(jumps)  // int cannot be converted to boolean
        if(jumps != 0)  // int cannot be converted to boolean
            System.out.print("Jump!");
        else
            System.out.print("Hop!");
    }
}
