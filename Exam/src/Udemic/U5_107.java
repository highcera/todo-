package Udemic;

class ColorPack {
    static int shadeCount = 12;
    static int getShadeCount() {
        return shadeCount;
        // non-static variable shadeCount
        // cannot be referenced from a static context
        // return 100;
    }
}
class U5_107 {  // Artist
    public static void main(String args[]) {
        ColorPack pack1 = new ColorPack();
        System.out.println(pack1.getShadeCount());
    }
}

// A static method can’t access non-static instance variables of a class.
// Hence, the class ColorPack fails to compile.