package Udemic;

public class U5_178 {
    public static void main(String[] args) {
        "a".replace("a","b");
        "a".replace('a','b');
        // "a".replace(0,"a".length(),"b");
        "a".replace(new StringBuilder('a'),"");
        "a".replace(new StringBuilder('a'), new StringBuilder("b"));
        // new StringBuilder("a").replace("","b");
        // new StringBuilder("a").replace('a','b');
        new StringBuilder("a").replace(0,1,"b");
    }
}
