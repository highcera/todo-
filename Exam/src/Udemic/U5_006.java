package Udemic;

class Fish {
    public Fish() {
        System.out.println("Fish: swims");
    }
    public void getFish() {
        System.out.println("Fish: caught");
    }
}
class Marlin extends Fish {
    public Marlin() {
        super();
    }
    public Marlin(String arg) {
        System.out.println("Marlin: swims");
    }
    public void getFish() {
        super.getFish();
    }
    public void getFish(String arg) {
        System.out.println("Marlin: caught");
    }
}
class U5_006 {  // Hemingway
    public static void main(String[] args) {
        Marlin marlin = new Marlin();       // Fish: swims
        marlin.getFish("Get the sucker!");  // Marlin: caught
        marlin.getFish();                   // Fish: caught
    }
}