package Udemic;

class ColorPencil {
    String color;
    ColorPencil(String color) {
        this.color = color;
    }
}

class U1_131 {
    public static void main(String[] args) {
        ColorPencil myPencil = new ColorPencil("RED");
        System.out.println(myPencil.color);
    }
}
