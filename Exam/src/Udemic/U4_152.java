package Udemic;

class Pencil {}
class U4_152 extends Pencil {  // ColorPencil
    String color;
    U4_152(String color) {this.color = color;}
    public static void main(String[] args) {
        U4_152 var3 = new U4_152("RED");
        Pencil var4 = new U4_152("BLUE");
        // U4_152 var1 = new U4_152();
        // Compile error:
        // actual and formal argument lists differ in length
    }
}