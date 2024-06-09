package Udemic;

import java.io.*;
class Machine {
    public boolean turnOn() throws EOFException {return true;}
    // public boolean turnOn() throws IOException { return true; }
}
public class U5_181 extends Machine {  // Robot
    public boolean turnOn() throws IOException {return false;}
    // public boolean turnOn() throws EOFException { return false; }
    public static void main(String[] doesNotCompute) throws Exception {
        Machine m = new U5_181();
        System.out.print(m.turnOn());
    }
}