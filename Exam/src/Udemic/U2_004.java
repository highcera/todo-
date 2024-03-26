package Udemic;

public class U2_004 {
    public static void main(String[] args) {
        // byte myByte = 128;
        byte yourByte = (byte) 128;
        // byte hisByte = (short) 128;
        // byte herByte = (int) 128;
        byte myByte = 127;           // -128
        byte hisByte = (byte)(short) 128;  // -128
        byte herByte = (byte)(int) 128;    // -128
        System.out.println( myByte + ":" + yourByte + ":" + hisByte + ":" + herByte);
    } // default : int
}
