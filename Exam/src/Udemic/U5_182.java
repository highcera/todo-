package Udemic;

public class U5_182 {
    public static void main(String[] args) {
        String[] moons = {"Luna", "Phobos", "Deimos"};
        byte b = 0;
        do while (b < moons.length)
            System.out.print(b++);  // 012
        while (b < moons.length);
    }
}
