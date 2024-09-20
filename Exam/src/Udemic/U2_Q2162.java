package Udemic;

class U2_Q2162 { /* valid, customs-cleared code */ }
class CargoPlane{ // CargoPlane
    void load(U2_Q2162 cargo) throws RuntimeException {  // Line 06
        System.out.print("Cargo loaded - ");    }
    void fly() { /* valid, ICAO-cleared code */ }
    void unload(U2_Q2162 cargo) throws Exception {
        System.out.println("Cargo unloaded");
    }

    public static void main(String[] args) throws Exception {
        U2_Q2162 cargo = new U2_Q2162();
        CargoPlane plane = new CargoPlane();
        plane.load(cargo);                            // Line 14
        plane.fly();
        plane.unload(cargo);                       // Line 16
    }
    
    // public static void main(String[] args) {
    //     U2_111 cargo = new U2_111();
    //     CargoPlane plane = new CargoPlane();
    //     plane.load(cargo);                            // Line 14
    //     plane.fly();
    //     try {
    //         plane.unload(cargo);                      // Line 16
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}