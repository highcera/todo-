package Udemic;

class Shoe {
    Shoe() {}
}
class Boot extends Shoe {
    Boot() {
        super();
    }
}

public class U3_037 { //ShoeFactory
    U3_037(Boot val) {
        System.out.println("boot");
    }
    U3_037(Shoe val) {
        System.out.println("shoe");
    }
    // private U3_037(Shoe arg) {}
    // constructor U3_037(Shoe) is already defined

    public static void main(String[] args) {}
}
