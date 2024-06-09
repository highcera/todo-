package Udemic;

class Pencil {}
class U5_152 extends Pencil {  // ColorPencil
    String color;
    U5_152(String color) {this.color = color;}
    public static void main(String[] args) {
        U5_152 var3 = new U5_152("RED");
        Pencil var4 = new U5_152("BLUE");
        // ColorPencil var1 = new ColorPencil();
        // Compile error:
        // actual and formal argument lists differ in length
    }
}