package Udemic;

class Hamlet {
    static String word = "";
    Hamlet(String word){ this.word += word; }
    { word += "a"; }
    static { word += "i"; }
    { word += "o"; }
}
class U5_157 {  // TypingMonkey
    public static void main(String[] args) {
        System.out.print(Hamlet.word + " ");  // i
        new Hamlet("u");
        System.out.print(Hamlet.word + " ");  // iaou
        new Hamlet("e");
        System.out.print(Hamlet.word + " ");  // iaouaoe
    }
}