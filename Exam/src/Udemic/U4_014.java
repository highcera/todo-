package Udemic;

public final class U4_014 {
    // public final static int finish(final int score) {
    public final static int finish(int score) {
        final int win = 3;
        // final int result = score++ < 5 ? 2 : win;
        int result = score++ < 5 ? 2 : win;
        return result += win;
    }
    public static void main(final String[] v) {
        System.out.print(finish(Integer.parseInt(v[0])));
    }
}
