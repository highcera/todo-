package Udemic;

public class U5_014 {  // ChooseWisely {
    public U5_014() { super(); }
    public int choose(int choice) { return 5; }
    public int choose(short choice) { return 2; }
    public int choose(long choice) { return 11; }
    public static void main(String[] path) {
        System.out.println(
            new U5_014().choose((byte) 2 + 1));  // 5
        System.out.println(((Object)((byte) 2 + 1))
                            .getClass().getSimpleName());  // Integer
 
        System.out.println(new U5_014()
                            .choose((byte) 2 + (byte) 1));  // 5
        System.out.println(((Object)((byte) 2 + (byte) 1))
                            .getClass().getSimpleName());  // Integer
 
        System.out.println(new U5_014()
                            .choose((byte) (2 + 1)));  // 2
        System.out.println(((Object)((byte) (2 + 1)))
                            .getClass().getSimpleName());  // Byte
    }

}
