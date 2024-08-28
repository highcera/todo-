package Udemic;

import java.io.IOException;

public class u2_Q2160 {
    // Unresolved compilation problem: Unhandled exception type IOException
    // public static void main(String[] args) { 
    //     try { doStuff(); }
    //     catch (RuntimeException e){ System.out.println(e); }
    // }
    // static void doStuff() {
    //     if (Math.random() > 0.5) throw new IOException();
    //     throw new RuntimeException();
    // }

    // public static void main(String[] args) { 
    //     try { doStuff(); }
    //     catch (IOException e){ System.out.println(e); }
    // }
    // static void doStuff() throws IOException {
    //     if (Math.random() > 0.5) throw new IOException();
    //     throw new RuntimeException();
    // }

    public static void main(String[] args) throws IOException {
        try { doStuff(); }
        catch (RuntimeException e){ System.out.println(e); }
    }
    static void doStuff() throws IOException {
        if (Math.random() > 0.5) throw new IOException();
        throw new RuntimeException();
    }
}
